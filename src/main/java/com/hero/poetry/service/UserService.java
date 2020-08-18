package com.hero.poetry.service;

import com.hero.poetry.entity.Grade;
import com.hero.poetry.entity.User;

import java.util.List;

public interface UserService {
    Integer getGradeIdById(String userId);

    List<Grade> getAllGrade();

    Grade getGradeById(String userId);

    void modifyGradeByUserId(String userId, Integer gradeId);

    void addGrade(Grade grade);

    void deleteGrade(String id);

    void updateGrade(Grade grade);

    void addUser(User user);

    List<User> getAllUser();

    void updateUser(User user);

    void deleteUser(String id);
}
