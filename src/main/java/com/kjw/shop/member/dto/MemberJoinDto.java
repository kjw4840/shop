package com.kjw.shop.member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * @author jinwook.kim
 * @since 2022/02/27
 */

@Getter
@Builder
@AllArgsConstructor
public class MemberJoinDto {

    private String email;
    private String password;
}
