package com.hero.poetry.service.impl;

import com.hero.poetry.entity.AdminUser;
import com.hero.poetry.entity.Grade;
import com.hero.poetry.entity.Rank;
import com.hero.poetry.entity.User;
import com.hero.poetry.entity.dto.PageDTO;
import com.hero.poetry.mapper.AdminUserMapper;
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
    private final AdminUserMapper adminUserMapper;

    public UserServiceImpl(UserMapper userMapper, GradeMapper gradeMapper, RankMapper rankMapper, AdminUserMapper adminUserMapper) {
        this.userMapper = userMapper;
        this.gradeMapper = gradeMapper;
        this.rankMapper = rankMapper;
        this.adminUserMapper = adminUserMapper;
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
        Rank rank = new Rank();
        rank.setGradeId(user.getGradeId());
        rank.setUserId(user.getId());
        rank.setScore(0);
        rankMapper.insetRank(rank);
    }

    @Override
    public PageDTO<User> getAllUser(PageDTO<User> pageDTO,String msg) {
        Integer current = pageDTO.getCurrent();
        Integer limit = pageDTO.getLimit();
        pageDTO.setRecords(userMapper.getAllUser((current-1)*limit,limit,msg));
        pageDTO.setTotal(userMapper.getAllUserTotal());
        return pageDTO;
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

    @Override
    public User getUser(String userId) {
        return userMapper.getUserById(userId);
    }

    @Override
    public boolean checkUserExist(String userId) {
        Integer result = userMapper.checkUserExistById(userId);
        return result != null;
    }

    @Override
    public AdminUser getAdminUserById(Integer id) {
        return adminUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageDTO<AdminUser> getAllAdminUser(PageDTO<AdminUser> pageDTO,String msg) {
        Integer current = pageDTO.getCurrent();
        Integer limit = pageDTO.getLimit();
        pageDTO.setRecords(adminUserMapper.selectAll((current-1)*limit,limit,msg));
        pageDTO.setTotal(adminUserMapper.selectAllTotal());
        return pageDTO;
    }

    @Override
    public void updateAdminUser(AdminUser adminUser) {
        adminUserMapper.updateByPrimaryKey(adminUser);
    }

    @Override
    public void deleteAdminUser(Integer id) {
        adminUserMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void addAdminUser(AdminUser adminUser) {
        adminUserMapper.insert(adminUser);
    }

    @Override
    public boolean loginAdmin(AdminUser adminUser) {
        return adminUserMapper.login(adminUser) == 1;
    }
}
