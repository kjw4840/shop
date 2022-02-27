package com.kjw.shop.member.dto;

import com.kjw.shop.member.model.Role;
import lombok.*;

import java.util.List;

/**
 * @author jinwook.kim
 * @since 2022/02/26
 */
@Getter
@Builder
@AllArgsConstructor
public class MemberDto {
    private String name;
    private List<Role> roles;
}
