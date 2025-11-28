package com.sisko.exam.master.exam_question.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sisko.exam.base.BaseApiUrl;
import com.sisko.exam.base.service.BaseService;
import com.sisko.exam.master.exam_question.model.ExamQuestionReq;
import com.sisko.exam.master.exam_question.model.ExamQuestionRes;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class ExamQuestionServiceImpl extends BaseService<ExamQuestionRes, ExamQuestionReq> implements ExamQuestionService {
    public ExamQuestionServiceImpl(String backEndUrl, RestTemplate restTemplate, ObjectMapper objectMapper) {
        super(backEndUrl + BaseApiUrl.EXAM_QUESTION_URL, restTemplate, objectMapper);
    }

    @Override
    public List<ExamQuestionRes> get() {
        return super.getAll(ExamQuestionRes.class);
    }

    @Override
    public Optional<ExamQuestionRes> getById(String id) {
        return super.getById(id, ExamQuestionRes.class);
    }

    @Override
    public Optional<ExamQuestionRes> save(ExamQuestionReq request) {
        return super.save(request, ExamQuestionRes.class);
    }

    @Override
    public Optional<ExamQuestionRes> update(ExamQuestionReq request, String id) {
        return super.update(id, request, ExamQuestionRes.class);
    }

    @Override
    public Optional<ExamQuestionRes> delete(String id) {
        return super.delete(id, ExamQuestionRes.class);
    }
}
