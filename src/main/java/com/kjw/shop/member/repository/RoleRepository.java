package com.kjw.shop.member.repository;

import com.kjw.shop.member.model.Authority;
import com.kjw.shop.member.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author jinwook.kim
 * @since 2022/01/29
 */
public interface RoleRepository extends JpaRepository<Role, Long> , RoleCustomRepository{
    Optional<Role> findByName(Authority authority);
}
