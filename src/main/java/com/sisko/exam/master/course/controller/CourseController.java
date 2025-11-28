package com.sisko.exam.master.course.controller;

import com.sisko.exam.base.BaseController;
import com.sisko.exam.base.Response;
import com.sisko.exam.exception.SiskoExamException;
import com.sisko.exam.master.course.model.CourseRes;
import com.sisko.exam.master.course.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;

@Controller
@RequiredArgsConstructor
@RequestMapping("/master/courses")
public class CourseController extends BaseController<CourseRes> {
    private final CourseService courseService;

    @GetMapping
    public String index() {
        return "master/courses/index";
    }

    @GetMapping("/data")
    public ResponseEntity<Response> data() {
        try {
            return super.getResponse(courseService.getAll());
        } catch (SiskoExamException e) {
            return super.getResponse(Collections.emptyList());
        }
    }
}
