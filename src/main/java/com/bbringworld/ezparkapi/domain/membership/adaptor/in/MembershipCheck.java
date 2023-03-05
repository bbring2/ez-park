package com.bbringworld.ezparkapi.domain.membership.adaptor.in;

import jakarta.validation.constraints.NotBlank;
import org.springframework.security.crypto.password.PasswordEncoder;

public record MembershipCheck(
        @NotBlank String carNumber,
        @NotBlank String mobile
) {
}
