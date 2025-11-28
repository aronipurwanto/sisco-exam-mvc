package com.sisko.exam.master.attempt_answer.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sisko.exam.base.BaseApiUrl;
import com.sisko.exam.base.service.BaseService;
import com.sisko.exam.master.attempt_answer.model.AttemptAnswerReq;
import com.sisko.exam.master.attempt_answer.model.AttemptAnswerRes;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class AttemptAnswerServiceImpl extends BaseService<AttemptAnswerRes, AttemptAnswerReq> implements AttemptAnswerService {
    public AttemptAnswerServiceImpl(String backEndUrl, RestTemplate restTemplate, ObjectMapper objectMapper) {
        super(backEndUrl + BaseApiUrl.ATTEMPT_ANSWER_URL, restTemplate, objectMapper);
    }

    @Override
    public List<AttemptAnswerRes> get() {
        return super.getAll(AttemptAnswerRes.class);
    }

    @Override
    public Optional<AttemptAnswerRes> getById(String id) {
        return super.getById(id, AttemptAnswerRes.class);
    }

    @Override
    public Optional<AttemptAnswerRes> save(AttemptAnswerReq request) {
        return super.save(request, AttemptAnswerRes.class);
    }

    @Override
    public Optional<AttemptAnswerRes> update(AttemptAnswerReq request, String id) {
        return super.update(id, request, AttemptAnswerRes.class);
    }

    @Override
    public Optional<AttemptAnswerRes> delete(String id) {
        return super.delete(id, AttemptAnswerRes.class);
    }
}
