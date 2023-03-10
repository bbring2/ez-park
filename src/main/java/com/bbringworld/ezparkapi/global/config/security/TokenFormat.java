package com.bbringworld.ezparkapi.global.config.security;

import com.bbringworld.ezparkapi.domain.code.Role;
import lombok.Builder;

@Builder
public record TokenFormat(
        long id,
        String nickname,
        Role role
) {
}
