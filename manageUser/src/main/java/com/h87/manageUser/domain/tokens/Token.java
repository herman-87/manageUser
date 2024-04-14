package com.h87.manageUser.domain.tokens;

import com.h87.manageUser.domain.commons.EntityBase;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Token extends EntityBase {
    @Embedded
    private TokenValue value;
}
