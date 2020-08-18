package com.hero.poetry.service;

import com.hero.poetry.entity.Rank;
import com.hero.poetry.entity.dto.RankLadderDTO;
import com.hero.poetry.entity.dto.RankServiceDTO;
import com.hero.poetry.entity.vo.RankDataVo;

import java.util.List;

public interface RankService {
    RankServiceDTO getRank(String userId);

    List<RankLadderDTO> getRankLadderByGradeAndUserId(Integer gradeId);

    void updateRank(RankDataVo rankDataVo);

    List<RankLadderDTO> getAllRank(Integer gradeId);
}
