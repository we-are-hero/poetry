package com.hero.poetry.service;

import com.hero.poetry.entity.Grade;

import java.util.List;

public interface UserService {
    Integer getGradeIdById(String userId);

    List<Grade> getAllGrade();

    Grade getGradeById(String userId);

    void modifyGradeByUserId(String userId, Integer gradeId);
}
