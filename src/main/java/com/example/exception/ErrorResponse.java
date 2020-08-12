package com.example.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class ErrorResponse {
    private String errorMessage;
    private String logCode;
    private int status;
    private LocalDateTime time;
}
