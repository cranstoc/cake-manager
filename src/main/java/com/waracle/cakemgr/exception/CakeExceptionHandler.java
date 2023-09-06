package com.waracle.cakemgr.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CakeExceptionHandler {

    @ResponseBody
    @ExceptionHandler(CakeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String cakeNotFoundExceptionHandler(CakeNotFoundException e) {
        return e.getMessage();
    }

}
