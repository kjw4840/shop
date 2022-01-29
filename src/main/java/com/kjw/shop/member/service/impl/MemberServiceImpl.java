package com.kjw.shop.member.service.impl;

import com.kjw.shop.config.jwt.JwtTokenProvider;
import com.kjw.shop.member.model.Authority;
import com.kjw.shop.member.model.Member;
import com.kjw.shop.member.model.Role;
import com.kjw.shop.member.repository.MemberRepository;
import com.kjw.shop.member.repository.RoleRepository;
import com.kjw.shop.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

/**
 * @author jinwook.kim
 * @since 2022/01/29
 */
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final MemberRepository memberRepository;
    private final RoleRepository roleRepository;

    @Override
    public Long join(Member member) {
        Optional<Role> role = roleRepository.findByName(Authority.ADMIN);
        Member buildMember = Member.builder()
                .email(member.getEmail())
                .password(passwordEncoder.encode(member.getPassword()))
                .roles(Collections.singletonList(role.get()))
                .build();

        return memberRepository.save(buildMember).getId();
    }

    @Override
    public String login(Member member) {
        Member findMember = memberRepository.findByEmail(member.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("가입되지 않은 E-MAIL 입니다."));
        if (!passwordEncoder.matches(member.getPassword(), findMember.getPassword())) {
            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
        }
        return jwtTokenProvider.createToken(member.getEmail(), member.getRoles());
    }

    private String getEncodedPassword(String password) {
        return "{noop}" + password;
    }

}
