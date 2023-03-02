package com.bbringworld.ezparkapi.domain.admin.adaptor.out;

import com.bbringworld.ezparkapi.domain.admin.dao.entity.Admin;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record AdminInfo (
        long id,
        String firstName,
        String lastName,
        String nickname,
        String role,
        String mobile,
        boolean mobileVerified,
        boolean status,
        LocalDateTime lastLoginAt,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    public static AdminInfo of(Admin admin) {
        return AdminInfo.builder()
                .id(admin.getId())
                .firstName(admin.getFirstName())
                .lastName(admin.getLastName())
                .nickname(admin.getNickname())
                .role(admin.getRole().getDisplayName())
                .mobile(admin.getMobile())
                .mobileVerified(admin.isMobileVerified())
                .status(admin.isStatus())
                .lastLoginAt(admin.getLastLoginAt())
                .createdAt(admin.getCreatedAt())
                .updatedAt(admin.getUpdatedAt())
                .build();
    }
}
