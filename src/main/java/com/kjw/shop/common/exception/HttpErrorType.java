package com.kjw.shop.common.exception;

import lombok.Getter;

/**
 * @author jinwook.kim
 * @since 2022/03/16
 */
@Getter
public enum HttpErrorType {

    ALREADY_EXISTS(400, "이미 존재하는 회원입니다.");

    private int errorCode;
    private String errorMsg;

    HttpErrorType(final int errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

}
