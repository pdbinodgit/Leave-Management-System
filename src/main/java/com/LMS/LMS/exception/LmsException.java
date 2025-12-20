package com.LMS.LMS.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
@Getter
@Setter
public class LmsException extends RuntimeException{
    private String message;

    private HttpStatus status;

    private int code;


    /**
     * Constructs a new runtime exception with {@code null} as its
     * detail message.  The cause is not initialized, and may subsequently be
     * initialized by a call to {@link #initCause}.
     */
    public LmsException(String message, HttpStatus status, int code) {
        this.message = message;
        this.status = status;
        this.code = code;
    }
}
