package com.hero.poetry.service.impl;

import com.hero.poetry.entity.Grade;
import com.hero.poetry.mapper.GradeMapper;
import com.hero.poetry.mapper.UserMapper;
import com.hero.poetry.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;
    private final GradeMapper gradeMapper;

    public UserServiceImpl(UserMapper userMapper, GradeMapper gradeMapper) {
        this.userMapper = userMapper;
        this.gradeMapper = gradeMapper;
    }

    @Override
    public Integer getGradeById(String userId) {
        return userMapper.getGradeById(userId);
    }

    @Override
    public List<Grade> getAllGrade() {
        return null;
    }
}
