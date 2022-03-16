package com.kjw.shop.member.service.impl;

import com.kjw.shop.common.exception.CustomException;
import com.kjw.shop.common.exception.HttpErrorType;
import com.kjw.shop.config.jwt.JwtTokenProvider;
import com.kjw.shop.config.jwt.model.TokenDto;
import com.kjw.shop.config.jwt.model.TokenRequestDto;
import com.kjw.shop.config.redis.service.RedisService;
import com.kjw.shop.member.dto.MemberJoinDto;
import com.kjw.shop.member.mapper.MemberMapper;
import com.kjw.shop.member.model.Authority;
import com.kjw.shop.member.model.Member;
import com.kjw.shop.member.model.Role;
import com.kjw.shop.member.repository.MemberRepository;
import com.kjw.shop.member.repository.RoleRepository;
import com.kjw.shop.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author jinwook.kim
 * @since 2022/01/29
 */
@Service
@Transactional
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final MemberRepository memberRepository;
    private final RoleRepository roleRepository;
    private final RedisService redisService;

    @Override
    public Long join(MemberJoinDto member) {
        Optional<Member> find = memberRepository.findByEmail(member.getEmail());

        if (find.isPresent()) {
            throw new CustomException(HttpErrorType.ALREADY_EXISTS);
        }

        Role role = roleRepository.findByName(Authority.ADMIN).orElseThrow(() -> new IllegalArgumentException("not found Roll"));

        Member memberEntity = MemberMapper.INSTANCE.toEntity(member, role);

        return memberRepository.save(memberEntity).getId();
    }

    @Override
    @Transactional
    public TokenDto login(Member member) {
        Member findMember = memberRepository.findByEmail(member.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("가입되지 않은 E-MAIL 입니다."));

        if (!passwordEncoder.matches(member.getPassword(), findMember.getPassword())) {
            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
        }

        TokenDto token = jwtTokenProvider.createToken(member.getEmail(), member.getRoles());

        redisService.put(token.getRefreshToken(), findMember);

        return token;
    }

    @Override
    @Transactional
    public TokenDto reissue(TokenRequestDto tokenRequestDto) {
        if (!jwtTokenProvider.validateToken(tokenRequestDto.getRefreshToken())) {
            throw new IllegalArgumentException("not availed");
        }

        String accessToken = tokenRequestDto.getAccessToken();
        Authentication authentication = jwtTokenProvider.getAuthentication(accessToken);

        Member findMember = memberRepository.findByEmail(authentication.getName())
                .orElseThrow(() -> new IllegalArgumentException("not found member"));

        Object refreshToken = redisService.get(findMember);

        if (refreshToken == null) {
            throw new IllegalArgumentException("not found refresh token");
        }

        if (!refreshToken.equals(tokenRequestDto.getRefreshToken())) {
            throw new IllegalArgumentException("not match refreshToken");
        }


        TokenDto token = jwtTokenProvider.createToken(findMember.getEmail(), findMember.getRoles());
        redisService.put(token.getRefreshToken(), findMember);
        return token;
    }
}
