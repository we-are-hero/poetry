package com.hero.poetry.mapper;

import com.hero.poetry.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    Integer getGradeById(@Param("userId") String userId);

    void modifyGradeByUserId(@Param("userId") String userId, @Param("gradeId") Integer gradeId);
}