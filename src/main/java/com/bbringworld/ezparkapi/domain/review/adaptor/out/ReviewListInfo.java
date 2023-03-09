package com.bbringworld.ezparkapi.domain.review.adaptor.out;

import com.bbringworld.ezparkapi.domain.review.dao.entity.ReviewList;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ReviewListInfo(
        long id,
        String name,
        String icon,
        Boolean positive,
        Boolean active,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    public static ReviewListInfo of(ReviewList reviewList) {
        return ReviewListInfo.builder()
                .id(reviewList.getId())
                .name(reviewList.getName())
                .icon(reviewList.getIcon())
                .positive(reviewList.isPositive())
                .active(reviewList.isActive())
                .createdAt(reviewList.getCreatedAt())
                .updatedAt(reviewList.getUpdatedAt())
                .build();
    }
}
