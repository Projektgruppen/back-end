package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Not Found")
public class NotFoundException extends Exception{
    @Serial
    private static final long serialVersionUID = 1L;

    public NotFoundException(String errormessage){
        super(errormessage);
    }
}
