package com.bbringworld.ezparkapi.domain.admin.adaptor.out;

import com.bbringworld.ezparkapi.domain.admin.dao.entity.AdminLog;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdminLogInfo {

    private String id;

    private long adminId;

    private String nickname;

    private String requestUrl;

    private Integer requestTtl;

    private String requestMethod;

    private Integer responseCode;

    private String responseBody;

    private String ipAddress;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

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
