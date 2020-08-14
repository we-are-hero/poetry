package com.hero.poetry.service.impl;

import com.hero.poetry.entity.Poetry;
import com.hero.poetry.entity.dto.PoetryIntroductionDTO;
import com.hero.poetry.mapper.PoetryMapper;
import com.hero.poetry.service.PoetryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PoetryServiceImpl implements PoetryService {
    private final PoetryMapper poetryMapper;

    public PoetryServiceImpl(PoetryMapper poetryMapper) {
        this.poetryMapper = poetryMapper;
    }

    @Override
    public List<PoetryIntroductionDTO> getPoetryIntroductionByGradeId(Integer gradeId,String msg) {
        List<PoetryIntroductionDTO> list;
        if (msg != null){
            list = poetryMapper.getPoetryIntroductionByGradeIdCondition(gradeId,msg);

        }else {
            list = poetryMapper.getPoetryIntroductionByGradeId(gradeId);
        }

        return list;
    }

    @Override
    public Poetry getPoetryById(Integer poetryId) {
        Poetry poetry = poetryMapper.getPoetryById(poetryId);
        return poetry;
    }
}
