package com.hero.poetry.mapper;


import com.hero.poetry.entity.Poetry;
import com.hero.poetry.entity.dto.PoetryIntroductionDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PoetryMapper {
    List<PoetryIntroductionDTO> getPoetryIntroductionByGradeId(@Param("gradeId") Integer gradeId,@Param("msg") String msg);

    Poetry getPoetryById(@Param("poetryId") Integer poetryId);

    List<Poetry> getAllPoetry(@Param("m") Integer m,@Param("n") Integer n,@Param("msg") String msg);

    Integer getAllPoetryTotal(@Param("msg") String msg);

    List<Poetry> getAllPoetryByGradeId(@Param("gradeId")Integer gradeId,@Param("m") Integer m,@Param("n") Integer n,@Param("msg") String msg);

    Integer getAllPoetryByGradeIdTotal(@Param("msg") String msg);

    Integer addPoetry(@Param("poetry")Poetry poetry);

    Integer updatePoetryById(@Param("poetry") Poetry poetry);

    Integer deletePoetryById(@Param("id") Integer id);
}
