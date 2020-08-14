package com.hero.poetry.service;

import com.hero.poetry.entity.Grade;

import java.util.List;

public interface UserService {
    Integer getGradeById(String userId);

    List<Grade> getAllGrade();
}
