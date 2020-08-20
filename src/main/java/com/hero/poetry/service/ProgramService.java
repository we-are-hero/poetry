package com.hero.poetry.service;

import com.hero.poetry.entity.Feedback;
import com.hero.poetry.entity.dto.PageDTO;

import java.util.List;

public interface ProgramService {
    void addFeedback(Feedback feedback);

    void deleteFeedback(Integer id);

    PageDTO<Feedback> getAllFeedback(PageDTO<Feedback> pageDTO, String msg);
}
