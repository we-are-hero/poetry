package com.hero.poetry.service.impl;

import com.hero.poetry.entity.Poetry;
import com.hero.poetry.entity.User;
import com.hero.poetry.entity.dto.PageDTO;
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
        list = poetryMapper.getPoetryIntroductionByGradeId(gradeId,msg);
        return list;
    }

    @Override
    public Poetry getPoetryById(Integer poetryId) {
        Poetry poetry = poetryMapper.getPoetryById(poetryId);
        return poetry;
    }

    @Override
    public void addPoetry(Poetry poetry) {
        poetryMapper.addPoetry(poetry);
    }

    @Override
    public void deletePoetry(Integer id) {
        poetryMapper.deletePoetryById(id);
    }

    @Override
    public void updatePoetry(Poetry poetry) {
        poetryMapper.updatePoetryById(poetry);
    }

    @Override
    public PageDTO<Poetry> getAllPoetry(PageDTO<Poetry> pageDTO,String msg) {
        Integer current = pageDTO.getCurrent();
        Integer limit = pageDTO.getLimit();
        pageDTO.setRecords(poetryMapper.getAllPoetry((current-1)*limit,limit,msg));
        pageDTO.setTotal(poetryMapper.getAllPoetryTotal(msg));
        return pageDTO;
    }

    @Override
    public PageDTO<Poetry> getAllPoetryByGradeId(Integer gradeId, PageDTO<Poetry> pageDTO,String msg) {
        Integer current = pageDTO.getCurrent();
        Integer limit = pageDTO.getLimit();
        pageDTO.setRecords(poetryMapper.getAllPoetryByGradeId(gradeId,(current-1)*limit,limit,msg));
        pageDTO.setTotal(poetryMapper.getAllPoetryByGradeIdTotal(msg));
        return pageDTO;
    }
}
