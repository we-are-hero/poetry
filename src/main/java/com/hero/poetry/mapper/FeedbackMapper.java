package com.hero.poetry.mapper;

import com.hero.poetry.entity.Feedback;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedbackMapper {
    int deleteById(Integer id);

    Integer addFeedback(Feedback record);

    List<Feedback> getAllFeedback();
}