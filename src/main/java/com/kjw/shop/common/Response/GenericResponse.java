package com.kjw.shop.common.Response;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * @author jinwook.kim
 * @since 2022/03/16
 */
@Getter
public class GenericResponse<T> {
    private MetaData meta;
    private T data;

    public GenericResponse(MetaData meta, T data) {
        this.meta = meta;
        this.data = data;
    }

    public static <T> ResponseEntity<GenericResponse<T>> of(final HttpStatus status,
                                                            final MetaData meta,
                                                            final T data) {
        return ResponseEntity.status(status).body(new GenericResponse<>(meta, data));
    }

    public static <T> ResponseEntity<GenericResponse<T>> ok(T data) {
        return of(HttpStatus.OK, MetaData.EMPTY, data);
    }
}
