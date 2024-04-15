package com.h87.manageUser.domain.tokens;

import com.h87.manageUser.domain.commons.EntityBase;
import com.h87.manageUser.domain.users.User;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
    @Embedded
    private TokenExpiredDate expiredDate;

    @OneToOne
    @JoinColumn(name = "c_user", nullable = false)
    private User user;
}
