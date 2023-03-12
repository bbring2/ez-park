package com.bbringworld.ezparkapi.domain.review.adaptor.in;

import jakarta.annotation.Nullable;

public record ReviewListUpdate (
        @Nullable String name,
        @Nullable String icon,
        @Nullable Boolean active
) {
}
