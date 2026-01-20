package com.ra.spring_base_template.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ra.spring_base_template.model.base.BaseObject;
import com.ra.spring_base_template.model.constants.UserStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class User extends BaseObject {
    @Column(name = "password")
    @JsonIgnore
    private String password;

    @Column(name = "email", unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private UserStatus status;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;
}
