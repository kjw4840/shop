package com.kjw.shop.member.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author jinwook.kim
 * @since 2022/01/29
 */
@AllArgsConstructor
@Getter
public enum Authority {
    ADMIN("ROLE_ADMIN"),
    USER("ROLE_USER");

    private String value;

}
