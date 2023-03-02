package com.bbringworld.ezparkapi.domain.admin.adaptor.out;

import com.bbringworld.ezparkapi.domain.admin.dao.entity.AdminLog;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record AdminLogInfo (
        String id,
        long adminId,
        String nickname,
        String requestUrl,
        Integer requestTtl,
        String requestMethod,
        Integer responseCode,
        String responseBody,
        String ipAddress,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {

    public static AdminLogInfo of(AdminLog adminLog) {
        return AdminLogInfo.builder()
                .id(adminLog.getId())
                .adminId(adminLog.getAdmin().getId())
                .nickname(adminLog.getAdmin().getNickname())
                .requestUrl(adminLog.getRequestUrl())
                .requestTtl(adminLog.getRequestTtl())
                .requestMethod(adminLog.getRequestMethod())
                .responseCode(adminLog.getResponseCode())
                .responseBody(adminLog.getResponseBody())
                .ipAddress(adminLog.getIpAddress())
                .createdAt(adminLog.getCreatedAt())
                .updatedAt(adminLog.getUpdatedAt())
                .build();
    }

}
