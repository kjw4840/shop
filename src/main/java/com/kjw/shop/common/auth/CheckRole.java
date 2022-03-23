package com.kjw.shop.common.auth;

import com.kjw.shop.member.model.Authority;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author jinwook.kim
 * @since 2022/03/17
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface CheckRole {
    Authority auth();
}
