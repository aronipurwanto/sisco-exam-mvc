package com.sisko.exam.master.question.controller;

import com.sisko.exam.base.BaseController;
import com.sisko.exam.base.Response;
import com.sisko.exam.exception.SiskoExamException;
import com.sisko.exam.master.question.model.QuestionRes;
import com.sisko.exam.master.question.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;

@Controller
@RequiredArgsConstructor
@RequestMapping("/master/questions")
public class QuestionController extends BaseController<QuestionRes> {
    private final QuestionService questionService;

    @GetMapping("/data")
    public ResponseEntity<Response> getData() {
        try {
            return super.getResponse(questionService.get());
        } catch (SiskoExamException ex) {
            return super.getResponse(Collections.emptyList());
        }
    }
}
