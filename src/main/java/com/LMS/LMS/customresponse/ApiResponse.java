package com.LMS.LMS.customresponse;

import org.springframework.http.HttpStatus;

public class ApiResponse<T> {

    private HttpStatus status;

    private String message;

    private T data;

    public ApiResponse(HttpStatus status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public ApiResponse(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }
}
