package com.kjw.shop.common.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author jinwook.kim
 * @since 2022/03/16
 */
@Getter
@NoArgsConstructor
public class CustomException extends RuntimeException{
    private int errorCode;

    public CustomException(HttpErrorType type) {
        super(type.getErrorMsg());
        this.errorCode = type.getErrorCode();
    }
}
