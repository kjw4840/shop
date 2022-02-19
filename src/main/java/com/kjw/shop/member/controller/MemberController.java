package com.kjw.shop.member.controller;

import com.kjw.shop.common.ResponseService;
import com.kjw.shop.common.SingleResult;
import com.kjw.shop.config.jwt.model.TokenDto;
import com.kjw.shop.config.jwt.model.TokenRequestDto;
import com.kjw.shop.member.model.Member;
import com.kjw.shop.member.service.MemberService;
import lombok.RequiredArgsConstructor;
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
    private final ResponseService responseService;

    // 회원가입
    @PostMapping("/join")
    public Long join(@RequestBody Member member) {
        return memberService.join(member);
    }

    @PostMapping("/login")
    public SingleResult<TokenDto> login(@RequestBody Member member) {
        TokenDto token = memberService.login(member);
        return responseService.getSingleResult(token);
    }

    @PostMapping("/reissue")
    public SingleResult<TokenDto> reissue(@RequestBody TokenRequestDto tokenRequestDto) {
        return responseService.getSingleResult(memberService.reissue(tokenRequestDto));
    }
}
