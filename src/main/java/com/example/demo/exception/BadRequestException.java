package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Id Not Found")
public class BadRequestException extends Exception{
    @Serial
    private static final long serialVersionUID = 1L;

    public BadRequestException(String errorMessage){
        super(errorMessage);
    }
}
