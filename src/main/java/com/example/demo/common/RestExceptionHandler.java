package com.example.demo.common;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler{
	
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) {
    	ErrorResponse er = new ErrorResponse();
    	er.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
    	er.setMessage("予期せぬエラーです。");
        return super.handleExceptionInternal(ex, er, null, HttpStatus.INTERNAL_SERVER_ERROR, request);
    }
}
