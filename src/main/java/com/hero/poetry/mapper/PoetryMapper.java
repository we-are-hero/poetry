package com.hero.poetry.mapper;


import com.hero.poetry.entity.Poetry;
import com.hero.poetry.entity.dto.PoetryIntroductionDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PoetryMapper {
    List<PoetryIntroductionDTO> getPoetryIntroductionByGradeIdCondition(@Param("gradeId") Integer gradeId, @Param("msg") String msg);

    List<PoetryIntroductionDTO> getPoetryIntroductionByGradeId(@Param("gradeId") Integer gradeId);

    Poetry getPoetryById(@Param("poetryId") Integer poetryId);
}
