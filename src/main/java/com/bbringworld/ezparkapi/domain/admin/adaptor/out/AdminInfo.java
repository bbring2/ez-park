package com.bbringworld.ezparkapi.domain.admin.adaptor.out;

import com.bbringworld.ezparkapi.domain.admin.dao.entity.Admin;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdminInfo {

    private long id;
    private String firstName;
    private String lastName;
    private String nickname;
    private String role;
    private String mobile;
    private boolean mobileVerified;
    private boolean status;
    private LocalDateTime lastLoginAt;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

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
