package com.hero.poetry.mapper;

import org.springframework.stereotype.Repository;

@Repository
public interface RankMapper {
    Integer getScoreByUserId(String userId);
}
