package com.bbringworld.ezparkapi.domain.auth.adaptor.out;

import com.bbringworld.ezparkapi.domain.admin.dao.entity.Admin;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record TokenInfo (
        String accessToken,
        String refreshToken,
        long id,
        String nickname,
        String firstName,
        String lastName,
        String mobile,
        Boolean mobileVerified,
        String role,
        boolean status,
        LocalDateTime lastLoginAt,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    public static TokenInfo of(Admin admin, String accessToken, String refreshToken) {
        return TokenInfo.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .id(admin.getId())
                .nickname(admin.getNickname())
                .firstName(admin.getFirstName())
                .lastName(admin.getLastName())
                .mobile(admin.getMobile())
                .mobileVerified(admin.isMobileVerified())
                .role(admin.getRole().getDisplayName())
                .status(admin.isStatus())
                .lastLoginAt(admin.getLastLoginAt())
                .createdAt(admin.getCreatedAt())
                .updatedAt(admin.getUpdatedAt())
                .build();
    }
}