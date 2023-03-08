package com.bbringworld.ezparkapi.domain.review.dao.entity;

import com.bbringworld.ezparkapi.global.domain.dao.Registration;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@Entity
@AllArgsConstructor
@Table(name = "review_list")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReviewList extends Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    @Column
    private String icon;

    @Column(columnDefinition = "TINYINT(1)")
    private boolean positive;

    @Column(columnDefinition = "TINYINT(1)")
    private boolean active;

}
