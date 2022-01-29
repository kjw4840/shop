package com.kjw.shop.member.service;

import com.kjw.shop.member.model.Member;

/**
 * @author jinwook.kim
 * @since 2022/01/29
 */
public interface MemberService {
    Long join(Member member);

    String login(Member member);
}
