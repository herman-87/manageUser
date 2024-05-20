package com.h87.manageUser.domain.roles;

import com.h87.manageUser.domain.commons.EntityBase;
import com.h87.manageUser.domain.users.User;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "t_scope")
public class Role extends EntityBase {
    @Embedded
    private RoleName name;
    @Embedded
    private RoleDescription description;

    @Builder.Default
    @ManyToMany(mappedBy = "roles")
    private List<User> users = new ArrayList<>();
}
