package com.hero.poetry.mapper;


import com.hero.poetry.entity.Poetry;
import com.hero.poetry.entity.dto.PoetryIntroductionDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PoetryMapper {
    List<PoetryIntroductionDTO> getPoetryIntroductionByGradeIdCondition(Integer gradeId, String msg);

    List<PoetryIntroductionDTO> getPoetryIntroductionByGradeId(Integer gradeId);

    Poetry getPoetryById(Integer poetryId);
}
