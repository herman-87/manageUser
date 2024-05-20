package com.h87.manageUser.domain.tokens;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Embeddable
public class TokenCreatedAt {
    @Column(name = "c_created_at")
    private LocalDateTime value;
}
