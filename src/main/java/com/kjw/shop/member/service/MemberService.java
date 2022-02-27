package com.kjw.shop.member.service;

import com.kjw.shop.config.jwt.model.TokenDto;
import com.kjw.shop.config.jwt.model.TokenRequestDto;
import com.kjw.shop.member.dto.MemberJoinDto;
import com.kjw.shop.member.model.Member;

/**
 * @author jinwook.kim
 * @since 2022/01/29
 */
public interface MemberService {
    Long join(MemberJoinDto member);

    TokenDto login(Member member);

    TokenDto reissue(TokenRequestDto tokenRequestDto);


}
