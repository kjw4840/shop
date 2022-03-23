package com.kjw.shop.member.repository;

import com.kjw.shop.member.model.Authority;

/**
 * @author jinwook.kim
 * @since 2022/03/17
 */
public interface RoleCustomRepository {
    boolean exist(Long memberId, Authority... authorities);
}
