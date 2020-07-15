package com.hero.poetry.service;

import com.hero.poetry.entity.dto.RankServiceDTO;

public interface RankService {
    RankServiceDTO getRank(String userId);
}
