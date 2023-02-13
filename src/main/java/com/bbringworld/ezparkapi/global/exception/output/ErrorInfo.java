package com.bbringworld.ezparkapi.global.exception.output;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ErrorInfo {

    private String code;
    private String message;

    public ErrorInfo(String code, String message) {
        super();
        this.code = code;
        this.message = message;
    }
}
