package com.kjw.shop.common;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author jinwook.kim
 * @since 2022/02/02
 */
@Getter
@Setter
public class ListResult<T> extends CommonResult {
    private List<T> list;
}
