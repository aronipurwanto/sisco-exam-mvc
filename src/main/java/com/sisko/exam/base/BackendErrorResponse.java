package com.sisko.exam.base;

import lombok.Builder;
import lombok.Getter;

import java.time.Instant;
import java.util.List;
import java.util.Map;

@Getter
public class BackendErrorResponse {
    String timestamp;
    int status;
    String message;
    Map<String, List<String>> errors;
}

