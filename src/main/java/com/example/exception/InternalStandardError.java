package com.example.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum InternalStandardError {

    MOBILE_NOT_EXIST("Mobile number not exist","E1001", HttpStatus.NOT_FOUND),
    INPUT_ERROR("input error", "E1002", HttpStatus.BAD_REQUEST);

    private String errorMessage;
    private String logCode;
    private HttpStatus httpStatus;
}
