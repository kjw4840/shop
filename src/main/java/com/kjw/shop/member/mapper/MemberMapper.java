package com.kjw.shop.member.mapper;

import com.kjw.shop.member.dto.MemberDto;
import com.kjw.shop.member.dto.MemberJoinDto;
import com.kjw.shop.member.model.Member;
import com.kjw.shop.member.model.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Collections;
import java.util.List;

/**
 * @author jinwook.kim
 * @since 2022/02/26
 */
@Mapper(componentModel = "spring")
public interface MemberMapper {

    MemberMapper INSTANCE = Mappers.getMapper(MemberMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "dto.password", target = "password", qualifiedByName = "encryptPassword")
    @Mapping(source = "role", target = "roles", qualifiedByName = "adminRole")
    Member toEntity(MemberJoinDto dto, Role role);

    @Mapping(source = "email", target = "name")
    MemberDto toDto(Member member);

    @Named("encryptPassword")
    default String encryptPassword(String password) {
        return new BCryptPasswordEncoder().encode(password);
    }

    @Named("adminRole")
    default List<Role> adminRole(Role role) {
        return Collections.singletonList(role);
    }

}
