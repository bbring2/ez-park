package com.bbringworld.ezparkapi.domain.admin.adaptor.in;

import jakarta.annotation.Nullable;

public record AdminUpdate (
        @Nullable String firstName,

        @Nullable String lastName,

        @Nullable String mobile
) {
}
