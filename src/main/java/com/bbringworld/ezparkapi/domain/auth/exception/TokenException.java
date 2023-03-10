package com.bbringworld.ezparkapi.domain.auth.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class TokenException extends RuntimeException {

    public TokenException(String message) {
        super(message);
    }

    public TokenException(String message, Throwable cause) {
        super(message, cause);
    }

}
