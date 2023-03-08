package com.bbringworld.ezparkapi.domain.review.dao.entity;

import com.bbringworld.ezparkapi.global.domain.dao.Registration;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "review_sub")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReviewSub extends Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JoinColumn(name = "review_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Review review;

    @JoinColumn(name = "list_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private ReviewList reviewList;

}
