package com.bbringworld.ezparkapi.domain.review.dao.entity;

import com.bbringworld.ezparkapi.global.domain.dao.Registration;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@Entity
@AllArgsConstructor
@Table(name = "review")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Review extends Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "car_number")
    private String carNumber;

    @Column
    private String content;

    @Column
    private Integer score;

    @Column(columnDefinition = "TINYINT(1)")
    private boolean recommend;

    @OneToMany(mappedBy = "review")
    private List<ReviewImage> reviewImageList;

    @OneToMany(mappedBy = "review")
    private List<ReviewSub> reviewSubList;

}
