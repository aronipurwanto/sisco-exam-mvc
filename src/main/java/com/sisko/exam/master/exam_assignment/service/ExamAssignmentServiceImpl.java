package com.sisko.exam.master.exam_assignment.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sisko.exam.base.BaseApiUrl;
import com.sisko.exam.base.service.BaseService;
import com.sisko.exam.master.exam_assignment.model.ExamAssignmentReq;
import com.sisko.exam.master.exam_assignment.model.ExamAssignmentRes;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class ExamAssignmentServiceImpl extends BaseService<ExamAssignmentRes, ExamAssignmentReq> implements ExamAssignmentService {
    public ExamAssignmentServiceImpl(String backEndUrl, RestTemplate restTemplate, ObjectMapper objectMapper) {
        super(backEndUrl + BaseApiUrl.EXAM_ASSIGNMENT_URL, restTemplate, objectMapper);
    }

    @Override
    public List<ExamAssignmentRes> get() {
        return super.getAll(ExamAssignmentRes.class);
    }

    @Override
    public Optional<ExamAssignmentRes> getById(String id) {
        return super.getById(id, ExamAssignmentRes.class);
    }

    @Override
    public Optional<ExamAssignmentRes> save(ExamAssignmentReq request) {
        return super.save(request, ExamAssignmentRes.class);
    }

    @Override
    public Optional<ExamAssignmentRes> update(ExamAssignmentReq request, String id) {
        return super.update(id, request, ExamAssignmentRes.class);
    }

    @Override
    public Optional<ExamAssignmentRes> delete(String id) {
        return super.delete(id, ExamAssignmentRes.class);
    }
}
