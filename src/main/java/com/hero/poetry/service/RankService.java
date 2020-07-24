package com.hero.poetry.service;

import com.hero.poetry.entity.dto.RankLadderDTO;
import com.hero.poetry.entity.dto.RankServiceDTO;

import java.util.List;

public interface RankService {
    RankServiceDTO getRank(String userId);

    List<RankLadderDTO> getRankLadderByGradeAndUserId(Integer gradeId);
}
