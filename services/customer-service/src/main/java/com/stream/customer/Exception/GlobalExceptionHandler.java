package com.stream.customer.Exception;

import org.apache.http.MethodNotSupportedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.method.MethodValidationException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<String> handle(CustomerNotFoundException exception){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(exception.getMsg());
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handle(MethodArgumentNotValidException exception){
        var erros = new HashMap<String,String>();
        exception.getBindingResult().getAllErrors()
                .forEach(error ->{
                    var fieldname = ((FieldError)error).getField();
                    var errorMessage = error.getDefaultMessage();
                    erros.put(fieldname,errorMessage);
                });



        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse(erros));
    }
}
