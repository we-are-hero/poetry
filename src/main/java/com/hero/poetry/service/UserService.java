package com.hero.poetry.service;

import com.hero.poetry.entity.AdminUser;
import com.hero.poetry.entity.Grade;
import com.hero.poetry.entity.User;
import com.hero.poetry.entity.dto.PageDTO;

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

    PageDTO<User> getAllUser(PageDTO<User> pageDTO,String msg);

    void updateUser(User user);

    void deleteUser(String id);

    User getUser(String userId);

    boolean checkUserExist(String userId);

    AdminUser getAdminUserById(Integer id);

    PageDTO<AdminUser> getAllAdminUser(PageDTO<AdminUser> pageDTO,String msg);

    void updateAdminUser(AdminUser adminUser);

    void deleteAdminUser(Integer id);

    void addAdminUser(AdminUser adminUser);

    boolean loginAdmin(AdminUser adminUser);
}
