package com.sisko.exam.master.course.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sisko.exam.base.BaseApiUrl;
import com.sisko.exam.base.service.BaseService;
import com.sisko.exam.master.course.model.CourseReq;
import com.sisko.exam.master.course.model.CourseRes;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl extends BaseService<CourseRes, CourseReq> implements CourseService {
    public CourseServiceImpl(String backEndUrl, RestTemplate restTemplate, ObjectMapper objectMapper) {
        super(backEndUrl + BaseApiUrl.COURSE_URL, restTemplate, objectMapper);
    }

    @Override
    public List<CourseRes> getAll() {
        return super.getAll(CourseRes.class);
    }

    @Override
    public Optional<CourseRes> getById(String id) {
        return super.getById(id, CourseRes.class);
    }

    @Override
    public Optional<CourseRes> save(CourseReq request) {
        return super.save(request, CourseRes.class);
    }

    @Override
    public Optional<CourseRes> update(CourseReq request, String id) {
        return super.update(id, request, CourseRes.class);
    }

    @Override
    public Optional<CourseRes> delete(String id) {
        return super.delete(id, CourseRes.class);
    }
}
