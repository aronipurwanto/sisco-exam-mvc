package com.sisko.exam.master.question_option.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sisko.exam.base.BaseApiUrl;
import com.sisko.exam.base.service.BaseService;
import com.sisko.exam.master.question_option.model.QuestionOptionReq;
import com.sisko.exam.master.question_option.model.QuestionOptionRes;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionOptionServiceImpl extends BaseService<QuestionOptionRes, QuestionOptionReq> implements QuestionOptionService {
    public QuestionOptionServiceImpl(String backEndUrl, RestTemplate restTemplate, ObjectMapper objectMapper) {
        super(backEndUrl + BaseApiUrl.QUESTION_OPTION_URL, restTemplate, objectMapper);
    }

    @Override
    public List<QuestionOptionRes> get() {
        return super.getAll(QuestionOptionRes.class);
    }

    @Override
    public Optional<QuestionOptionRes> getById(String id) {
        return super.getById(id, QuestionOptionRes.class);
    }

    @Override
    public Optional<QuestionOptionRes> save(QuestionOptionReq request) {
        return super.save(request, QuestionOptionRes.class);
    }

    @Override
    public Optional<QuestionOptionRes> update(QuestionOptionReq request, String id) {
        return super.update(id, request, QuestionOptionRes.class);
    }

    @Override
    public Optional<QuestionOptionRes> delete(String id) {
        return super.delete(id, QuestionOptionRes.class);
    }
}
