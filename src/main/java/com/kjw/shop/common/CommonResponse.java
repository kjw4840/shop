package com.kjw.shop.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author jinwook.kim
 * @since 2022/02/02
 */
@Getter
@AllArgsConstructor
public enum CommonResponse {
    SUCCESS(0, "성공하였습니다."),
    FAIL(-1, "실패하였습니다.");

    private int code;
    private String msg;
}
