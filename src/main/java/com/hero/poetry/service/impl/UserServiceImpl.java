package com.hero.poetry.service.impl;

import com.hero.poetry.mapper.UserMapper;
import com.hero.poetry.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public Integer getGradeById(String userId) {
        return userMapper.getGradeById(userId);
    }
}
