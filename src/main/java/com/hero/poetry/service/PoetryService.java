package com.hero.poetry.service;

import com.hero.poetry.entity.Poetry;
import com.hero.poetry.entity.dto.PoetryIntroductionDTO;

import java.util.List;

public interface PoetryService {

    List<PoetryIntroductionDTO> getPoetryIntroductionByGradeId(Integer gradeId,String msg);

    Poetry getPoetryById(Integer poetryId);
}
