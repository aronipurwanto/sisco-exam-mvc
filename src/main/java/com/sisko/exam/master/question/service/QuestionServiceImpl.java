package com.sisko.exam.master.question.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sisko.exam.base.BaseApiUrl;
import com.sisko.exam.base.service.BaseService;
import com.sisko.exam.master.question.model.QuestionReq;
import com.sisko.exam.master.question.model.QuestionRes;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionServiceImpl extends BaseService<QuestionRes, QuestionReq> implements QuestionService {
    public QuestionServiceImpl(String backEndUrl, RestTemplate restTemplate, ObjectMapper objectMapper) {
        super(backEndUrl + BaseApiUrl.QUESTION_URL, restTemplate, objectMapper);
    }

    @Override
    public List<QuestionRes> get() {
        return super.getAll(QuestionRes.class);
    }

    @Override
    public Optional<QuestionRes> getById(String id) {
        return super.getById(id, QuestionRes.class);
    }

    @Override
    public Optional<QuestionRes> save(QuestionReq request) {
        return super.save(request, QuestionRes.class);
    }

    @Override
    public Optional<QuestionRes> update(QuestionReq request, String id) {
        return super.update(id, request, QuestionRes.class);
    }

    @Override
    public Optional<QuestionRes> delete(String id) {
        return super.delete(id, QuestionRes.class);
    }
}
