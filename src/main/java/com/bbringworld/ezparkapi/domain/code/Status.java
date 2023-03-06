package com.bbringworld.ezparkapi.domain.code;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Status {

    PROCESS("process"),
    FAIL("fail"),
    SUCCESS("success");

    private final String displayName;

}
