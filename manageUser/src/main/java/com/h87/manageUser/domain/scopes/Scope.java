package com.h87.manageUser.domain.scopes;

import com.h87.userManagementMonolithicApi.domain.commons.EntityBase;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Table(name = "t_scope")
@AllArgsConstructor
public class Scope extends EntityBase {
    @Embedded
    private ScopeName name;
    @Embedded
    private ScopeDescription description;
}
