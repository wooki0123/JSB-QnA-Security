package com.back.sbb.global.entity;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Id;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
public abstract class BaseEntity {
    @Id // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
    private int id; // INT
    @CreatedDate
    private LocalDateTime createDate; // 최초 INSERT 시 자동으로 현재 시간으로 설정됨
    @LastModifiedDate
    private LocalDateTime modifyDate; // INSERT/UPDATE 시 자동으로 현재 시간으로 설정됨
}
