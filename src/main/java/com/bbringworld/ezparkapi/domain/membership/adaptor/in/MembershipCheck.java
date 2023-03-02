package com.bbringworld.ezparkapi.domain.membership.adaptor.in;

import org.springframework.security.crypto.password.PasswordEncoder;

public record MembershipCheck(
        String carNumber,
        String mobile
) {
}
