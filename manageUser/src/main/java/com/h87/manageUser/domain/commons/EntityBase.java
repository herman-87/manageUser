package com.h87.manageUser.domain.commons;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class EntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "c_id")
    private String id;

    @Version
    @Column(name = "c_version")
    private int version;

    @Column(name = "c_tenant_id")
    private String tenantId;

    @Column(name = "c_creation_date")
    private LocalDateTime creationDate = LocalDateTime.now();
}
