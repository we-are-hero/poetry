package com.hero.poetry.service;

import com.hero.poetry.entity.Feedback;

import java.util.List;

public interface ProgramService {
    void addFeedback(Feedback feedback);

    void deleteFeedback(Integer id);

    List<Feedback> getAllFeedback();
}
