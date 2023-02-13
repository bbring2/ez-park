package com.bbringworld.ezparkapi.global.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.MODULE)
public abstract class Registration {

    @Column(nullable = false, updatable = false, name = "created_at")
    @CreatedDate
    private LocalDateTime createdAt;

    @Column(nullable = false, name = "updated_at")
    @LastModifiedDate
    private LocalDateTime updatedAt;

    protected Registration(LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

}