package com.kjw.shop;

import com.kjw.shop.member.model.Authority;
import com.kjw.shop.member.model.Member;
import com.kjw.shop.member.model.Role;
import com.kjw.shop.member.repository.MemberRepository;
import com.kjw.shop.member.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.Optional;

/**
 * @author jinwook.kim
 * @since 2022/01/29
 */
@Component
@RequiredArgsConstructor
public class InitDb {

    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final MemberRepository memberRepository;

    @PostConstruct
    public void initRole() {
        Role roleAdmin = new Role(Authority.ADMIN);
        Role roleUser = new Role(Authority.USER);

        roleRepository.save(roleAdmin);
        roleRepository.save(roleUser);
    }

    @PostConstruct
    public void initMember() {
        Member member = new Member();
        member.setEmail("k@k.k");
        member.setPassword("asdf");


        Optional<Role> role = roleRepository.findByName(Authority.ADMIN);
        Member buildMember = Member.builder()
                .email(member.getEmail())
                .password(passwordEncoder.encode(member.getPassword()))
                .roles(Collections.singletonList(role.get()))
                .build();

        memberRepository.save(buildMember);
    }

}
