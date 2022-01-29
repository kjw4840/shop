package com.kjw.shop.member.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author jinwook.kim
 * @since 2022/01/29
 */
@Entity
@Table(name = "AUTH_ROLE")
@Data
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROLE_ID")
    private Long id;

    @Column(name = "ROLE_NAME", length = 50)
    @Enumerated(EnumType.STRING)
    private Authority name;

    public Role(Authority name) {
        this.name = name;
    }
}
