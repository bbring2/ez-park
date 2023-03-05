package com.bbringworld.ezparkapi.domain.membership.adaptor.in;

import jakarta.annotation.Nullable;

public record MembershipSearch(
        @Nullable String carNumber,
        @Nullable String nickname,
        @Nullable String mobile,
        @Nullable Boolean mobileVerified,
        @Nullable Boolean status,
        @Nullable String gender,
        @Nullable String startDate,
        @Nullable String endDate
) {
}
