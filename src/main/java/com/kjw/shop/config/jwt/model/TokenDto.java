package com.kjw.shop.config.jwt.model;

import lombok.*;

/**
 * @author jinwook.kim
 * @since 2022/02/02
 */
@Getter
@Setter
@Builder
@AllArgsConstructor @NoArgsConstructor
public class TokenDto {
    private String type;
    private String accessToken;
    private String refreshToken;
    private Long accessTokenExpireDate;
}
