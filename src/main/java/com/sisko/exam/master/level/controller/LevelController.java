package com.sisko.exam.master.level.controller;

import com.sisko.exam.base.BaseController;
import com.sisko.exam.base.Response;
import com.sisko.exam.exception.SiskoExamException;
import com.sisko.exam.master.level.model.LevelRes;
import com.sisko.exam.master.level.service.LevelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/master/levels")
public class LevelController extends BaseController<LevelRes> {
    private final LevelService levelService;

    @GetMapping
    public String index() {
        return "master/level/index";
    }

    @GetMapping("/data")
    public ResponseEntity<Response> getData() {
        try {
            return getResponse(levelService.getAll());
        } catch (SiskoExamException ex) {
            return getResponse(Collections.emptyList());
        }
    }
}
