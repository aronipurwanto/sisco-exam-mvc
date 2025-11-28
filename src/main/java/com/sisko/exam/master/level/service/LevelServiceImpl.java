package com.sisko.exam.master.level.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sisko.exam.base.BaseApiUrl;
import com.sisko.exam.base.service.BaseService;
import com.sisko.exam.exception.SiskoExamException;
import com.sisko.exam.master.level.model.LevelReq;
import com.sisko.exam.master.level.model.LevelRes;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class LevelServiceImpl extends BaseService<LevelRes, LevelReq> implements LevelService {

    public LevelServiceImpl(String backEndUrl, RestTemplate restTemplate, ObjectMapper objectMapper) {
        super(backEndUrl + BaseApiUrl.LEVEL_URL, restTemplate, objectMapper);
    }

    @Override
    public List<LevelRes> getAll() {
        return super.getAll(LevelRes.class);
    }

    @Override
    public Optional<LevelRes> getById(String id) {
        return super.getById(id, LevelRes.class);
    }

    @Override
    public Optional<LevelRes> save(LevelReq request) {
        return super.save(request, LevelRes.class);
    }

    @Override
    public Optional<LevelRes> update(LevelReq request, String id) {
        return super.update(id, request, LevelRes.class);
    }

    @Override
    public Optional<LevelRes> delete(String id) {
        return super.delete(id, LevelRes.class);
    }
}
