package com.kjw.shop;

import com.kjw.shop.member.model.Authority;
import com.kjw.shop.member.model.Role;
import com.kjw.shop.member.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author jinwook.kim
 * @since 2022/01/29
 */
@Component
@RequiredArgsConstructor
public class InitDb {

    private final RoleRepository roleRepository;

    @PostConstruct
    public void initRole() {
        Role roleAdmin = new Role(Authority.ADMIN);
        Role roleUser = new Role(Authority.USER);

        roleRepository.save(roleAdmin);
        roleRepository.save(roleUser);
    }

}
