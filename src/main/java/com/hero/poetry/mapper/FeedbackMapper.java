package com.hero.poetry.mapper;

import com.hero.poetry.entity.Feedback;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedbackMapper {
    int deleteById(@Param("id") Integer id);

    Integer addFeedback(@Param("record") Feedback record);

    List<Feedback> getAllFeedback();
}