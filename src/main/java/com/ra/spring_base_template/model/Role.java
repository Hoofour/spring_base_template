package com.ra.spring_base_template.model;

import com.ra.spring_base_template.model.base.BaseObject;
import com.ra.spring_base_template.model.constants.RoleName;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "roles")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Role extends BaseObject
{
    @Enumerated(EnumType.STRING)
    @Column(name = "role_name")
    private RoleName roleName;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;
}
