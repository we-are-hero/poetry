package com.hero.poetry.mapper.config;

import com.hero.poetry.entity.config.RankLevel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RankConfigMapper {
    List<RankLevel> getRankLevel();
}
