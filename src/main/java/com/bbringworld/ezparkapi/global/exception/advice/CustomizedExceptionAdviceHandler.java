package com.bbringworld.ezparkapi.global.exception.advice;

import com.bbringworld.ezparkapi.domain.admin.exception.AdminNotFoundException;
import com.bbringworld.ezparkapi.global.exception.output.ErrorInfo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class CustomizedExceptionAdviceHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorInfo> handleAllExceptions(Exception e, WebRequest request) {
        ErrorInfo errorInfo = new ErrorInfo(e.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorInfo, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(AdminNotFoundException.class)
    public final ResponseEntity<ErrorInfo> handleAdminNotFoundException(Exception e, WebRequest request) {
        ErrorInfo errorInfo = new ErrorInfo(e.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorInfo, HttpStatus.NOT_FOUND);
    }

}
