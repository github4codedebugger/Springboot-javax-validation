package com.example.exception;

import lombok.Getter;

@Getter
public class AppException extends RuntimeException {
    private InternalStandardError standardError;

    public AppException(InternalStandardError error) {
        super(error.getErrorMessage());
        this.standardError = error;
    }
}
