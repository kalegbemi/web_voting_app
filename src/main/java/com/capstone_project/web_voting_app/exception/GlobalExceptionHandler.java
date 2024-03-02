package com.capstone_project.web_voting_app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;
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

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public Map<String, String> sqlExceptionHandler(SQLIntegrityConstraintViolationException exception){
        Map<String, String> errorMap = new HashMap<>();

        exception.forEach(e->{
            errorMap.put(e.getMessage(),"this email has been taken please enter another");
        });

        return errorMap;
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(ElectionNotFoundException.class)
    public String electionExceptionHandler(ElectionNotFoundException exception){

        return exception.getMessage();
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(VoteNotFoundException.class)
    public String voteExceptionHandler(VoteNotFoundException exception){

        return exception.getMessage();
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(VoterNotFoundException.class)
    public String voterExceptionHandler(VoterNotFoundException exception){

        return exception.getMessage();
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(AdminNotFoundException.class)
    public String adminExceptionHandler(AdminNotFoundException exception){

        return exception.toString()+exception.getMessage();
    }

}
