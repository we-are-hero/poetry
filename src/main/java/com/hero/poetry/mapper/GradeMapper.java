package com.hero.poetry.mapper;

import com.hero.poetry.entity.Grade;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GradeMapper {
    List<Grade> getAllGrade();

    Grade getGradeById(@Param("gradeId")Integer gradeId);
}