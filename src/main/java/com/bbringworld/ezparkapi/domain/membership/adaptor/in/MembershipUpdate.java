package com.bbringworld.ezparkapi.domain.membership.adaptor.in;

import jakarta.annotation.Nullable;

public record MembershipUpdate (
        @Nullable String nickname,
        @Nullable String carNumber,
        @Nullable String mobile,
        @Nullable String cardNumber,
        @Nullable String bod,
        @Nullable String gender
){
}
