package com.kjw.shop.member.controller;

import com.kjw.shop.common.Response.GenericResponse;
import com.kjw.shop.config.jwt.model.TokenDto;
import com.kjw.shop.config.jwt.model.TokenRequestDto;
import com.kjw.shop.member.dto.MemberJoinDto;
import com.kjw.shop.member.model.Member;
import com.kjw.shop.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jinwook.kim
 * @since 2022/01/29
 */

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/member")
public class MemberController {

    private final MemberService memberService;

    // 회원가입
    @PostMapping("/join")
    public ResponseEntity<GenericResponse<Long>> join(@RequestBody MemberJoinDto member) {
        return GenericResponse.ok(memberService.join(member));
    }

    @PostMapping("/login")
    public ResponseEntity<GenericResponse<TokenDto>> login(@RequestBody Member member) {
        TokenDto token = memberService.login(member);
        return GenericResponse.ok(token);
    }

    @PostMapping("/reissue")
    public ResponseEntity<GenericResponse<TokenDto>> reissue(@RequestBody TokenRequestDto tokenRequestDto) {
        return GenericResponse.ok(memberService.reissue(tokenRequestDto));
    }
}
