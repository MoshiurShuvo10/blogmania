package com.rmslab.blogmania.exceptionHandlers;

import com.rmslab.blogmania.dtos.ApiResponseDto;
import com.rmslab.blogmania.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponseDto> resourceNotFoundExceptionHandler
            (ResourceNotFoundException resourceNotFoundException) {
        ApiResponseDto apiResponseDto = new ApiResponseDto(resourceNotFoundException.getMessage(), false) ;
        return new ResponseEntity<>(apiResponseDto, HttpStatus.NOT_FOUND) ;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> MethodArgumentNotValidExceptionHandler
            (MethodArgumentNotValidException methodArgumentNotValidException) {
        Map<String, String> errResp = new HashMap<>() ;
        methodArgumentNotValidException
                .getBindingResult()
                .getAllErrors()
                .forEach(error -> {
                    String fieldName = ((FieldError)error).getField();
                    String message = error.getDefaultMessage() ;
                    errResp.put(fieldName, message) ;
                });
        return new ResponseEntity<Map<String, String>>(errResp, HttpStatus.BAD_REQUEST) ;
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Object> handleMethodArgumentTypeMismatchException(
            MethodArgumentTypeMismatchException ex, WebRequest request) {
        String error = "Invalid argument: " + ex.getName() + " with value " + ex.getValue();
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
