package com.hero.poetry.mapper;

import com.hero.poetry.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    Integer getGradeById(@Param("userId") String userId);

    Integer modifyGradeByUserId(@Param("userId") String userId, @Param("gradeId") Integer gradeId);

    Integer addUser(@Param("user") User user);

    Integer modifyUserById(@Param("user") User user);

    Integer deleteUserById(@Param("id") String id);

    List<User> getAllUser();
}