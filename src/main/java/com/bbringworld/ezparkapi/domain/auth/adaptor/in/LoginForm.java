package com.bbringworld.ezparkapi.domain.auth.adaptor.in;

import jakarta.validation.constraints.NotBlank;

public record LoginForm(@NotBlank String nickname, @NotBlank String password) {
}
