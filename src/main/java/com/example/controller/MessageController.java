package com.example.controller;

import com.example.exception.AppException;
import com.example.exception.InternalStandardError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Pattern;

@RestController
@Validated
public class MessageController {

    //inject service

    @GetMapping("/send-otp")
    public String sendOtp(@Pattern(regexp = "^\\d{10}$", message = "mobileNumber should be 10 digit")
                          @RequestParam String mobileNumber) {

        boolean isMobileExist = false;
        if (!isMobileExist) {
            throw new AppException(InternalStandardError.MOBILE_NOT_EXIST);
        }

        return "OTP sent successfully!!!";
    }
}
