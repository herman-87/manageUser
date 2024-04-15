package com.h87.manageUser.domain.tokens;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Embeddable
public class TokenExpiredDate {
    @Column(name = "c_expired_date")
    private LocalDateTime value;
}
