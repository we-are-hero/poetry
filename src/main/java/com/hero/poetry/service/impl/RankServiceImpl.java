package com.hero.poetry.service.impl;

import com.hero.poetry.mapper.RankMapper;
import com.hero.poetry.service.RankService;
import com.hero.poetry.service.config.RankConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RankServiceImpl implements RankService {
    private final RankConfigService rankConfigService;

    private final RankMapper rankMapper;

    @Autowired
    public RankServiceImpl(RankConfigService rankConfigService, RankMapper rankMapper) {
        this.rankConfigService = rankConfigService;
        this.rankMapper = rankMapper;
    }

    @Override
    public String getRank(String userId) {
        int score = rankMapper.getScoreByUserId(userId);
        String rank = rankConfigService.getRankByScore(score);
        if (rank.equals(RankConfigService.RANK_ERROR)){
            throw new RuntimeException("段位系统异常");
        }
        return rank;
    }
}
