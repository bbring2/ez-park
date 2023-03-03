package com.bbringworld.ezparkapi.domain.spot.adaptor.in;

import jakarta.annotation.Nullable;

public record SpotUpdate(
        @Nullable String name,
        @Nullable String floor,
        @Nullable Boolean status
) {
}
