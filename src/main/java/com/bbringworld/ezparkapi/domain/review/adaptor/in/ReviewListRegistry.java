package com.bbringworld.ezparkapi.domain.review.adaptor.in;

import com.bbringworld.ezparkapi.domain.review.dao.entity.ReviewList;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record ReviewListRegistry (
        @NotNull long adminId,

        @NotEmpty String name,

        @NotEmpty String icon,

        @NotNull Boolean positive,

        @NotNull Boolean active
) {
    public static ReviewList toEntity(ReviewListRegistry registry) {
        return ReviewList.builder()
                .name(registry.name)
                .icon(registry.icon)
                .positive(registry.positive)
                .active(registry.active)
                .build();
    }
}
