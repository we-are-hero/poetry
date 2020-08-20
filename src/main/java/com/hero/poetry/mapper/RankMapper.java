package com.hero.poetry.mapper;

import com.hero.poetry.entity.Rank;
import com.hero.poetry.entity.dto.RankLadderDTO;
import com.hero.poetry.entity.vo.RankDataVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RankMapper {
    Integer getScoreByUserId(@Param("userId") String userId);

    List<RankLadderDTO> getAllScoreByGradeIdLimitPage(@Param("gradeId") Integer gradeId,@Param("m") Integer m,@Param("n") Integer n,@Param("msg") String msg);

    List<RankLadderDTO> getAllScoreByGradeId(@Param("gradeId") Integer gradeId);

    RankLadderDTO getRankLadderById(@Param("id") Integer id);

    Integer updateRankById(@Param("rankDataVo") RankDataVo rankDataVo);

    Integer deleteRankByUserId(@Param("id") String id);

    Integer updateScoreByUserId(@Param("userId") String userId,@Param("score") Integer score);

    Integer insetRank(@Param("rank") Rank rank);

    Integer getAllScoreByGradeIdLimitPageTotal(@Param("gradeId") Integer gradeId, @Param("msg") String msg);
}
