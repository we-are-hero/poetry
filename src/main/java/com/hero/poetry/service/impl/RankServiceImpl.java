package com.hero.poetry.service.impl;

import com.hero.poetry.entity.Rank;
import com.hero.poetry.entity.dto.RankLadderDTO;
import com.hero.poetry.entity.dto.RankServiceDTO;
import com.hero.poetry.mapper.RankMapper;
import com.hero.poetry.service.RankService;
import com.hero.poetry.service.config.RankConfigService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
    public RankServiceDTO getRank(String userId) {
        int score = rankMapper.getScoreByUserId(userId);
        RankServiceDTO rankServiceDTO = rankConfigService.getRankByScore(score);
        if (rankServiceDTO == null){
            throw new RuntimeException("段位系统异常");
        }
        return rankServiceDTO;
    }

    @Override
    public List<RankLadderDTO> getRankLadderByGradeAndUserId(Integer gradeId) {
        List<Rank> allScore = rankMapper.getAllScoreByGradeId(gradeId);
        System.out.println(allScore);
        List<RankLadderDTO> rankServiceDTOList = new ArrayList<>();
        for (Rank rank : allScore) {
            RankLadderDTO rankLadderDTO = new RankLadderDTO();
            BeanUtils.copyProperties(rank,rankLadderDTO);
            String rankName = rankConfigService.getRankByScore(rankLadderDTO.getScore()).getLevel();
            rankLadderDTO.setRankName(rankName);
            rankServiceDTOList.add(rankLadderDTO);
        }
        return rankServiceDTOList;
    }
}
