package com.hero.poetry.mapper;

import com.hero.poetry.entity.Rank;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RankMapper {
    Integer getScoreByUserId(String userId);

    List<Rank> getAllScoreByGradeId(Integer gradeId);
}
