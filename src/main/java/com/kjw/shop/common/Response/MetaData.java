package com.kjw.shop.common.Response;

import lombok.Getter;

import java.util.Collections;
import java.util.Map;

/**
 * @author jinwook.kim
 * @since 2022/03/16
 */
@Getter
public class MetaData {
    public static final MetaData EMPTY = new MetaData(0, "", Collections.emptyMap());

    private int errCode;

    private String errMsg;

    private Map<String, Object> data;

    public MetaData(int errCode, String errMsg, Map<String, Object> data) {
        this.errCode = errCode;
        this.errMsg = errMsg;
        this.data = data;
    }

    public MetaData(final int errCode, final String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }
}
