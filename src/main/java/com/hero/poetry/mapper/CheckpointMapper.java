package com.hero.poetry.mapper;

import com.hero.poetry.entity.dto.AllCheckpointWithUserPassDTO;
import com.hero.poetry.entity.dto.ProblemDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CheckpointMapper {
    List<AllCheckpointWithUserPassDTO> getAllCheckpointByGradeId(@Param("gradeId") Integer gradeId, @Param("userId")String userId);

    ProblemDTO getCheckpointProblemByCheckpointIdAndProblemOrder(@Param("checkpointId")Integer checkpointId, @Param("problemOrder")Integer problemOrder);

    int checkProblemAnswer(@Param("checkpointId")Integer checkpointId, @Param("problemOrder")Integer problemOrder, @Param("problemAnswer")String problemAnswer);

    Integer getProblemNum(@Param("checkpointId")Integer checkpointId);


}
