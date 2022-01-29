package com.kjw.shop.member.model;

import lombok.*;

import javax.persistence.*;

/**
 * @author jinwook.kim
 * @since 2022/01/29
 */
@Entity
@Table(name = "MEMBERSHIP_MEMBER_ROLES")
@AllArgsConstructor
@NoArgsConstructor
@Setter(AccessLevel.PRIVATE)
@Getter
public class MemberRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ROLE_ID")
    private Role role;

}
