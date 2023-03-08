package com.bbringworld.ezparkapi.domain.review.adaptor.in;

import com.bbringworld.ezparkapi.domain.review.dao.entity.Review;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record ReviewRegistry(
        @NotEmpty String carNumber,
        @NotEmpty String content,
        @Nullable List<String> imageList,
        @Nullable List<Integer> reviewList,
        @NotNull Integer score,
        @NotNull Boolean recommend
        ) {

    public static Review toEntity(ReviewRegistry registry) {
        return Review.builder()
                .carNumber(registry.carNumber)
                .content(registry.content)
                .score(registry.score)
                .recommend(registry.recommend)
                .build();
    }
}
