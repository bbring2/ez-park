package com.bbringworld.ezparkapi.domain.code;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Role {

    SUPER_ADMIN("super admin", "super_admin"),
    ADMIN("admin","admin");

    private final String displayName;

    private final String code;

}
