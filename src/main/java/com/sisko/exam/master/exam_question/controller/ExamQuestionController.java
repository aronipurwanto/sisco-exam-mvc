package com.sisko.exam.master.exam_question.controller;

import com.sisko.exam.base.BaseController;
import com.sisko.exam.base.Response;
import com.sisko.exam.exception.SiskoExamException;
import com.sisko.exam.master.exam_question.model.ExamQuestionRes;
import com.sisko.exam.master.exam_question.service.ExamQuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;

@Controller
@RequiredArgsConstructor
@RequestMapping("/master/exam-questions")
public class ExamQuestionController extends BaseController<ExamQuestionRes> {
    private final ExamQuestionService examQuestionService;

    @GetMapping("/data")
    public ResponseEntity<Response> getData() {
        try {
            return super.getResponse(examQuestionService.get());
        } catch (SiskoExamException ex) {
            return super.getResponse(Collections.emptyList());
        }
    }
}
