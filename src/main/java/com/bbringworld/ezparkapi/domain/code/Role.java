package com.bbringworld.ezparkapi.domain.code;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Role {

    SUPER_ADMIN("super admin"),
    ADMIN("admin");

    private final String displayName;

}
