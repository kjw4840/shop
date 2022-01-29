package com.kjw.shop.member.controller;

import com.kjw.shop.config.jwt.JwtTokenProvider;
import com.kjw.shop.member.model.Member;
import com.kjw.shop.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

/**
 * @author jinwook.kim
 * @since 2022/01/29
 */

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/member")
public class MemberController {


    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final MemberService memberService;

    // 회원가입
    @PostMapping("/join")
    public Long join(@RequestBody Member member) {
        return memberService.join(member);
    }

    @PostMapping("/login")
    public String login(@RequestBody Member member) {
        return memberService.login(member);
    }


}
