package com.hero.poetry.mapper.config;

import com.hero.poetry.entity.RankLevel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.logging.Level;

@Repository
public interface RankConfigMapper {
    List<RankLevel> getRankLevel();

    Integer addRankLevel(@Param("rankLevel") RankLevel rankLevel);

    Integer deleteLevel(@Param("id") Integer id);

    Integer updateLevel(@Param("rankLevel") RankLevel rankLevel);
}
