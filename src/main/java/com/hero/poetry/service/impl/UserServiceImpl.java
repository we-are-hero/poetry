package com.hero.poetry.service.impl;

import com.hero.poetry.entity.Grade;
import com.hero.poetry.entity.User;
import com.hero.poetry.mapper.GradeMapper;
import com.hero.poetry.mapper.RankMapper;
import com.hero.poetry.mapper.UserMapper;
import com.hero.poetry.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;
    private final GradeMapper gradeMapper;
    private final RankMapper rankMapper;

    public UserServiceImpl(UserMapper userMapper, GradeMapper gradeMapper, RankMapper rankMapper) {
        this.userMapper = userMapper;
        this.gradeMapper = gradeMapper;
        this.rankMapper = rankMapper;
    }

    @Override
    public Integer getGradeIdById(String userId) {
        return userMapper.getGradeById(userId);
    }

    @Override
    public List<Grade> getAllGrade() {
        return gradeMapper.getAllGrade();
    }

    @Override
    public Grade getGradeById(String userId) {
        Integer gradeId = userMapper.getGradeById(userId);
        Grade grade = gradeMapper.getGradeById(gradeId);
        return grade;
    }

    @Override
    public void modifyGradeByUserId(String userId, Integer gradeId) {
        userMapper.modifyGradeByUserId(userId,gradeId);
    }

    @Override
    public void addGrade(Grade grade) {
        gradeMapper.addGrade(grade);
    }

    @Override
    public void deleteGrade(String id) {
        gradeMapper.deleteGradeById(id);
    }

    @Override
    public void updateGrade(Grade grade) {
        gradeMapper.updateGradeById(grade);
    }

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }

    @Override
    public List<User> getAllUser() {
        List<User> allUser = userMapper.getAllUser();
        return allUser;
    }

    @Override
    public void updateUser(User user) {
        userMapper.modifyUserById(user);
    }

    @Override
    public void deleteUser(String id) {
        userMapper.deleteUserById(id);
        rankMapper.deleteRankByUserId(id);
    }
}
