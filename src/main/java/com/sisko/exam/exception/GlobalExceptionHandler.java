package com.sisko.exam.exception;

import com.sisko.exam.base.BackendErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//@RestControllerAdvice
public class GlobalExceptionHandler {

//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<BackendErrorResponse> methodArgumentNotValidException(MethodArgumentNotValidException ex) {
//        Map<String, List<String >> errors = ex.getBindingResult()
//                .getFieldErrors()
//                .stream()
//                .collect(Collectors.groupingBy(
//                        FieldError::getField,
//                        Collectors.mapping(FieldError::getDefaultMessage, Collectors.toList())
//                ));
//
//        return ResponseEntity
//                .status(HttpStatus.BAD_REQUEST)
//                .body(new BackendErrorResponse(
//                        HttpStatus.BAD_REQUEST.value(),
//                        HttpStatus.BAD_REQUEST.name(),
//                        errors
//                ));
//    }
//
//    @ExceptionHandler(BadRequestException.class)
//    public ResponseEntity<BackendErrorResponse> handleBadRequestException(BadRequestException ex) {
//        return ResponseEntity
//                .status(HttpStatus.BAD_REQUEST)
//                .body(new BackendErrorResponse(
//                        HttpStatus.BAD_REQUEST.value(),
//                        HttpStatus.BAD_REQUEST.name(),
//                        ex.getMessage()
//                ));
//    }
//
//    @ExceptionHandler(NotFoundException.class)
//    public ResponseEntity<BackendErrorResponse> handleNotFoundException(NotFoundException ex) {
//        return ResponseEntity
//                .status(HttpStatus.NOT_FOUND)
//                .body(new BackendErrorResponse(
//                        HttpStatus.NOT_FOUND.value(),
//                        HttpStatus.NOT_FOUND.name(),
//                        ex.getMessage()
//                ));
//    }
//
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<BackendErrorResponse> handleException(Exception ex) {
//        return ResponseEntity
//                .status(HttpStatus.INTERNAL_SERVER_ERROR)
//                .body(new BackendErrorResponse(
//                        HttpStatus.INTERNAL_SERVER_ERROR.value(),
//                        HttpStatus.INTERNAL_SERVER_ERROR.name(),
//                        ex.getMessage()
//                ));
//    }
}