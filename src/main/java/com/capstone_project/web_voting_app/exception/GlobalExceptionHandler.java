package com.capstone_project.web_voting_app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> fieldErrorHandler(MethodArgumentNotValidException exception){
        Map<String, String> errorMap = new HashMap<>();
        List<FieldError> errorList = exception.getFieldErrors();

      for (FieldError v : errorList){
          errorMap.put(v.getField(), v.getDefaultMessage());
      }
      return errorMap;
    }

}
