package com.bbringworld.ezparkapi.global.exception.output;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatusCode;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ErrorInfo {

    private LocalDateTime occurred;
    private String message;
    private String details;

    public ErrorInfo(String message, String details) {
        super();
        this.occurred = LocalDateTime.now();
        this.message = message;
        this.details = details;
    }

}
