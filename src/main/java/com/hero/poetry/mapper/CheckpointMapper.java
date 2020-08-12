package com.hero.poetry.mapper;

import com.hero.poetry.entity.dto.AllCheckpointWithUserPassDTO;
import com.hero.poetry.entity.dto.ProblemDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CheckpointMapper {
    List<AllCheckpointWithUserPassDTO> getAllCheckpointByGradeId(Integer gradeId, String userId);

    ProblemDTO getCheckpointProblemByCheckpointIdAndProblemOrder(Integer checkpointId, Integer problemOrder);

    int checkProblemAnswer(Integer checkpointId, Integer problemOrder, String problemAnswer);

    Integer getProblemNum(Integer checkpointId);


}
