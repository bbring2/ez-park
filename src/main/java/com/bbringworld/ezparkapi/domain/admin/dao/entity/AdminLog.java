package com.bbringworld.ezparkapi.domain.admin.dao.entity;

import com.bbringworld.ezparkapi.global.domain.dao.Registration;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Builder
@Document("admin_log")
public class AdminLog extends Registration {

    private String id;

    private Admin admin;

}
