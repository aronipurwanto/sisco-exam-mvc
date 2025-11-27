package com.sisko.exam.base.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sisko.exam.base.BackendErrorResponse;
import com.sisko.exam.base.Response;
import com.sisko.exam.exception.SiskoExamException;
import org.springframework.http.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class BaseService<T, R> {
    private final String backEndUrl;
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public BaseService(String backEndUrl, RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.backEndUrl = backEndUrl;
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    private String getToken() {
        DefaultOidcUser user = (DefaultOidcUser) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();

        if (user.getIdToken() == null) {
            return "";
        }

        return user.getIdToken().getTokenValue();
    }

    private HttpHeaders buildHeaders() {
        String token = getToken();

        if (token == null || token.isBlank()) {
            throw new SiskoExamException("Token missing", HttpStatus.UNAUTHORIZED);
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(token);

        return headers;
    }

    private <X> X sendRequest(String endpoint, HttpMethod method, Object body, Class<X> responseType) {
        String url = backEndUrl + endpoint;

        try {
            HttpEntity<?> entity = new HttpEntity<>(body, buildHeaders());
            ResponseEntity<Response> response = restTemplate.exchange(url, method, entity, Response.class);

            // Backend selalu return data di field "data"
            Object rawData = response.getBody().getData();

            // mapping single object
            return objectMapper.convertValue(rawData, responseType);

        } catch (RestClientResponseException ex) {
            throw handleApiException(ex);

        } catch (Exception e) {
            throw new SiskoExamException("Unexpected error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private <X> List<X> sendListRequest(String endpoint, HttpMethod method, Class<X> clazz) {
        String url = backEndUrl + endpoint;

        try {
            HttpEntity<?> entity = new HttpEntity<>(null, buildHeaders());
            ResponseEntity<Response> response = restTemplate.exchange(url, method, entity, Response.class);

            Object rawData = response.getBody().getData();

            return objectMapper.convertValue(
                    rawData,
                    objectMapper.getTypeFactory().constructCollectionType(List.class, clazz)
            );

        } catch (RestClientResponseException ex) {
            throw handleApiException(ex);

        } catch (Exception e) {
            throw new SiskoExamException("Unexpected error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private SiskoExamException handleApiException(RestClientResponseException ex) {
        try {
            BackendErrorResponse backendError = objectMapper.readValue(ex.getResponseBodyAsString(), BackendErrorResponse.class);

            return new SiskoExamException(
                    backendError.getMessage(),
                    HttpStatus.valueOf(backendError.getStatus()),
                    backendError.getErrors()
            );
        } catch (Exception e) {
            return new SiskoExamException("Unexpected error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public List<T> getAll(Class<T> clazz) {
        return sendListRequest("", HttpMethod.GET, clazz);
    }

    // GET BY ID
    public T getById(String id, Class<T> clazz) {
        return sendRequest("/" + id, HttpMethod.GET, null, clazz);
    }

    // POST
    public T save(R request, Class<T> clazz) {
        return sendRequest("", HttpMethod.POST, request, clazz);
    }

    // PUT
    public T update(String id, R request, Class<T> clazz) {
        return sendRequest("/" + id, HttpMethod.PATCH, request, clazz);
    }

    // DELETE
    public T delete(String id, Class<T> clazz) {
        return sendRequest("/" + id, HttpMethod.DELETE, null, clazz);
    }
}

