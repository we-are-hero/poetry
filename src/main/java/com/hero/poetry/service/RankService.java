package com.hero.poetry.service;

import com.hero.poetry.entity.Rank;
import com.hero.poetry.entity.dto.PageDTO;
import com.hero.poetry.entity.dto.RankLadderDTO;
import com.hero.poetry.entity.dto.RankServiceDTO;
import com.hero.poetry.entity.vo.RankDataVo;

import java.util.List;

public interface RankService {
    RankServiceDTO getRank(String userId);

    List<RankLadderDTO> getRankLadderByGradeAndUserId(Integer gradeId);

    void updateRank(RankDataVo rankDataVo);

    PageDTO<RankLadderDTO> getAllRank(Integer gradeId, PageDTO<RankLadderDTO> pageDTO,String msg);

    void updateScoreByUserId(String userId,Integer score);

    RankLadderDTO getRankById(Integer id);
}
