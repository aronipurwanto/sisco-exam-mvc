package com.sisko.exam.exception;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Map;

@Getter
public class SiskoExamException extends RuntimeException {
    private final HttpStatus status;
    private final Map<String, List<String>> errors;

    public SiskoExamException(String message, HttpStatus status, Map<String, List<String>> errors) {
        super(message);
        this.status = status;
        this.errors = errors;
    }

    public SiskoExamException(String message, HttpStatus status) {
        super(message);
        this.status = status;
        this.errors = null;
    }
}
