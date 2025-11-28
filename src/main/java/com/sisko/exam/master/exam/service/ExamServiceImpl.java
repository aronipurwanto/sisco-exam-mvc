package com.sisko.exam.master.exam.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sisko.exam.base.BaseApiUrl;
import com.sisko.exam.base.service.BaseService;
import com.sisko.exam.master.exam.model.ExamReq;
import com.sisko.exam.master.exam.model.ExamRes;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class ExamServiceImpl extends BaseService<ExamRes, ExamReq> implements ExamService {
    public ExamServiceImpl(String backEndUrl, RestTemplate restTemplate, ObjectMapper objectMapper) {
        super(backEndUrl + BaseApiUrl.EXAM_URL, restTemplate, objectMapper);
    }

    @Override
    public List<ExamRes> get() {
        return super.getAll(ExamRes.class);
    }

    @Override
    public List<ExamRes> getByCourseId(String courseId) {
        return super.getExamByCourse(courseId, ExamRes.class);
    }

    @Override
    public List<ExamRes> getByLevelId(String levelId) {
        return super.getExamByLevel(levelId, ExamRes.class);
    }

    @Override
    public Optional<ExamRes> getById(String id) {
        return super.getById(id, ExamRes.class);
    }

    @Override
    public Optional<ExamRes> save(ExamReq request) {
        return super.save(request, ExamRes.class);
    }

    @Override
    public Optional<ExamRes> update(ExamReq request, String id) {
        return super.update(id, request, ExamRes.class);
    }

    @Override
    public Optional<ExamRes> delete(String id) {
        return super.delete(id, ExamRes.class);
    }
}
