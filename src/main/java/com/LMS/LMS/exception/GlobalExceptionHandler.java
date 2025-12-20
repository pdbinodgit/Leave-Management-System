package com.LMS.LMS.exception;

import com.LMS.LMS.customresponse.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(LmsException.class)
    public ResponseEntity<ApiResponse<?>> lmsException(LmsException lmsException, WebRequest webRequest){
        return ResponseEntity.status(lmsException.getStatus()).body(new ApiResponse<>(lmsException.getStatus(), lmsException.getMessage()));
    }
}
