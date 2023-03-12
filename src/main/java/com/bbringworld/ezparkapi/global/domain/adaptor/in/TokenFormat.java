package com.bbringworld.ezparkapi.global.domain.adaptor.in;

import com.bbringworld.ezparkapi.domain.admin.dao.entity.Admin;
import com.bbringworld.ezparkapi.domain.code.Role;
import lombok.Builder;

@Builder
public record TokenFormat(
        long id,
        String nickname,
        Role role
) {
    public static TokenFormat of(Admin admin) {
        return TokenFormat.builder()
                .id(admin.getId())
                .nickname(admin.getNickname())
                .role(admin.getRole())
                .build();
    }
}
