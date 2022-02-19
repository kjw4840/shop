package com.kjw.shop.config.redis;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author jinwook.kim
 * @since 2022/02/02
 */
@AllArgsConstructor
@Getter
public enum RedisKeyTypes {
    LOGIN(0, "LOGIN::MEMBER::");

    private int key;
    private String value;

}
