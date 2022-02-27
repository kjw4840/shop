package com.kjw.shop.member.mapper;

import com.kjw.shop.member.dto.MemberDto;
import com.kjw.shop.member.dto.MemberJoinDto;
import com.kjw.shop.member.model.Member;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author jinwook.kim
 * @since 2022/02/26
 */
@Mapper(componentModel = "spring")
public interface MemberMapper {

    MemberMapper INSTANCE = Mappers.getMapper(MemberMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "password", target = "password", qualifiedByName = "encryptPassword")
    Member toEntity(MemberJoinDto dto);

    @Mapping(source = "email", target = "name")
    MemberDto toDto(Member member);

    @Named("encryptPassword")
    default String encryptPassword(String password) {
        return new BCryptPasswordEncoder().encode(password);
    }
}
