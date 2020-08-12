package com.example.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.time.LocalDateTime;

@RestControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> handleConstraintViolationException(ConstraintViolationException exception) {
        InternalStandardError standardError = InternalStandardError.INPUT_ERROR;

        return ResponseEntity.status(standardError.getHttpStatus())
                .body(ErrorResponse.builder()
                        .time(LocalDateTime.now())
                        .errorMessage(exception.getConstraintViolations().iterator().next().getMessage())
                        .logCode(standardError.getLogCode())
                        .status(standardError.getHttpStatus().value())
                        .build());
    }

    @ExceptionHandler(AppException.class)
    public ResponseEntity<ErrorResponse> handleAppException(AppException exception) {
        InternalStandardError standardError = exception.getStandardError();

        ErrorResponse errorResponse = ErrorResponse.builder()
                .time(LocalDateTime.now())
                .errorMessage(standardError.getErrorMessage())
                .logCode(standardError.getLogCode())
                .status(standardError.getHttpStatus().value())
                .build();

        return ResponseEntity.status(standardError.getHttpStatus()).body(errorResponse);
    }

}
