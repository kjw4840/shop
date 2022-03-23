package com.kjw.shop.member.repository.impl;

import com.kjw.shop.member.model.*;
import com.kjw.shop.member.repository.RoleCustomRepository;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

/**
 * @author jinwook.kim
 * @since 2022/03/17
 */
@Repository
public class RoleRepositoryImpl extends QuerydslRepositorySupport implements RoleCustomRepository {
    private final QRole ROLE = QRole.role;
    private final QMember MEMBER = QMember.member;
    private final QMemberRole MEMBER_ROLE = QMemberRole.memberRole;

    public RoleRepositoryImpl() {
        super(Role.class);
    }


    @Override
    public boolean exist(Long memberId, Authority... authorities) {
        MemberRole memberRole = from(MEMBER_ROLE)
                .join(MEMBER_ROLE.member, MEMBER)
                .join(MEMBER_ROLE.role, ROLE)
                .where(MEMBER.id.eq(memberId).and(ROLE.name.in(authorities)))
                .fetchFirst();

        return memberRole != null;
    }
}
