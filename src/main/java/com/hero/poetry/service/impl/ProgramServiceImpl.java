package com.hero.poetry.service.impl;

import com.hero.poetry.entity.Feedback;
import com.hero.poetry.entity.dto.PageDTO;
import com.hero.poetry.mapper.FeedbackMapper;
import com.hero.poetry.service.ProgramService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgramServiceImpl implements ProgramService {
    private final FeedbackMapper feedbackMapper;

    public ProgramServiceImpl(FeedbackMapper feedbackMapper) {
        this.feedbackMapper = feedbackMapper;
    }

    @Override
    public void addFeedback(Feedback feedback) {
        feedbackMapper.addFeedback(feedback);
    }

    @Override
    public void deleteFeedback(Integer id) {
        feedbackMapper.deleteById(id);
    }

    @Override
    public PageDTO<Feedback> getAllFeedback(PageDTO<Feedback> pageDTO,String msg) {
        Integer current = pageDTO.getCurrent();
        Integer limit = pageDTO.getLimit();
        pageDTO.setRecords(feedbackMapper.getAllFeedback((current-1)*limit,limit,msg));
        pageDTO.setTotal(feedbackMapper.getAllFeedbackTotal(msg));
        return pageDTO;
    }
}
