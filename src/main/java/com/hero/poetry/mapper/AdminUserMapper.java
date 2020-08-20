package com.hero.poetry.mapper;

import com.hero.poetry.entity.AdminUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminUserMapper {
    Integer deleteByPrimaryKey(@Param("id") Integer id);

    Integer insert(@Param("record") AdminUser record);

    AdminUser selectByPrimaryKey(@Param("id") Integer id);

    List<AdminUser> selectAll(@Param("m") Integer m,@Param("n") Integer n,@Param("msg") String msg);

    Integer selectAllTotal();

    Integer updateByPrimaryKey(@Param("record") AdminUser record);

    Integer login(@Param("adminUser") AdminUser adminUser);
}