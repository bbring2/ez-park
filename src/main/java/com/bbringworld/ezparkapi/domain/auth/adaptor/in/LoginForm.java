package com.bbringworld.ezparkapi.domain.auth.adaptor.in;

import jakarta.validation.constraints.NotBlank;
import org.springframework.security.core.Authentication;

public record LoginForm(@NotBlank String nickname, @NotBlank String password) {
}
