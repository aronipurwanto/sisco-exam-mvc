package com.sisko.exam.master.attempt_answer_option.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sisko.exam.base.BaseApiUrl;
import com.sisko.exam.base.service.BaseService;
import com.sisko.exam.master.attempt_answer_option.model.AttemptAnswerOptionReq;
import com.sisko.exam.master.attempt_answer_option.model.AttemptAnswerOptionRes;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class AttemptAnswerOptionServiceImpl extends BaseService<AttemptAnswerOptionRes, AttemptAnswerOptionReq> implements AttemptAnswerOptionService {
    public AttemptAnswerOptionServiceImpl(String backEndUrl, RestTemplate restTemplate, ObjectMapper objectMapper) {
        super(backEndUrl + BaseApiUrl.ATTEMPT_ANSWER_OPTION_URL, restTemplate, objectMapper);
    }

    @Override
    public List<AttemptAnswerOptionRes> get() {
        return super.getAll(AttemptAnswerOptionRes.class);
    }

    @Override
    public Optional<AttemptAnswerOptionRes> getById(String id) {
        return super.getById(id, AttemptAnswerOptionRes.class);
    }

    @Override
    public Optional<AttemptAnswerOptionRes> save(AttemptAnswerOptionReq request) {
        return super.save(request, AttemptAnswerOptionRes.class);
    }

    @Override
    public Optional<AttemptAnswerOptionRes> update(AttemptAnswerOptionReq request, String id) {
        return super.update(id, request, AttemptAnswerOptionRes.class);
    }

    @Override
    public Optional<AttemptAnswerOptionRes> delete(String id) {
        return super.delete(id, AttemptAnswerOptionRes.class);
    }
}
