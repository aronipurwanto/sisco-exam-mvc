package com.sisko.exam.master.exam_attempt.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sisko.exam.base.BaseApiUrl;
import com.sisko.exam.base.service.BaseService;
import com.sisko.exam.master.exam_attempt.model.ExamAttemptReq;
import com.sisko.exam.master.exam_attempt.model.ExamAttemptRes;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class ExamAttemptServiceImpl extends BaseService<ExamAttemptRes, ExamAttemptReq> implements ExamAttemptService {
    public ExamAttemptServiceImpl(String backEndUrl, RestTemplate restTemplate, ObjectMapper objectMapper) {
        super(backEndUrl + BaseApiUrl.EXAM_ATTEMPT_URL, restTemplate, objectMapper);
    }

    @Override
    public List<ExamAttemptRes> get() {
        return super.getAll(ExamAttemptRes.class);
    }

    @Override
    public Optional<ExamAttemptRes> getById(String id) {
        return super.getById(id, ExamAttemptRes.class);
    }

    @Override
    public Optional<ExamAttemptRes> save(ExamAttemptReq request) {
        return super.save(request, ExamAttemptRes.class);
    }

    @Override
    public Optional<ExamAttemptRes> update(ExamAttemptReq request, String id) {
        return super.update(id, request, ExamAttemptRes.class);
    }

    @Override
    public Optional<ExamAttemptRes> delete(String id) {
        return super.delete(id, ExamAttemptRes.class);
    }
}
