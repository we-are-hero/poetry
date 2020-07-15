package com.hero.poetry.mapper.config;

import com.hero.poetry.entity.RankLevel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RankConfigMapper {
    List<RankLevel> getRankLevel();
}
