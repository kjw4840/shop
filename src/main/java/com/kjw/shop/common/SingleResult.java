package com.kjw.shop.common;

import lombok.Getter;
import lombok.Setter;

/**
 * @author jinwook.kim
 * @since 2022/02/02
 */
@Getter
@Setter
public class SingleResult<T> extends CommonResult{
    private T data;

}
