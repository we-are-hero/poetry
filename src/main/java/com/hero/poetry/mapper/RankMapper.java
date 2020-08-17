package com.hero.poetry.mapper;

import com.hero.poetry.entity.Rank;
import com.hero.poetry.entity.dto.RankLadderDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RankMapper {
    Integer getScoreByUserId(@Param("userId") String userId);

    List<RankLadderDTO> getAllScoreByGradeId(@Param("gradeId") Integer gradeId);
}
