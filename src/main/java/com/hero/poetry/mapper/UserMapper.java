package com.hero.poetry.mapper;

import com.hero.poetry.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    Integer getGradeById(String userId);

    void modifyGradeByUserId(String userId, Integer gradeId);
}