package com.sisko.exam.master.exam.controller;

import com.sisko.exam.base.BaseController;
import com.sisko.exam.base.Response;
import com.sisko.exam.exception.SiskoExamException;
import com.sisko.exam.master.exam.model.ExamRes;
import com.sisko.exam.master.exam.service.ExamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;

@Controller
@RequiredArgsConstructor
@RequestMapping("/master/exams")
public class ExamController extends BaseController<ExamRes> {
    private final ExamService examService;

    @GetMapping
    public String index() {
        return "master/exam/index";
    }

    @GetMapping("/data")
    public ResponseEntity<Response> getData() {
        try {
            return super.getResponse(examService.get());
        } catch (SiskoExamException ex) {
            return super.getResponse(Collections.emptyList());
        }
    }

}
