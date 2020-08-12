package com.hero.poetry.service;

import com.hero.poetry.entity.dto.AllCheckpointWithUserPassDTO;
import com.hero.poetry.entity.dto.ProblemDTO;
import com.hero.poetry.entity.vo.ProblemAnswer;

import java.util.List;

public interface CheckpointService {

    List<AllCheckpointWithUserPassDTO> getAllCheckpoint(String userId);

    ProblemDTO getCheckpointProblemByCheckpointIdAndProblemOrder(Integer checkpointId, Integer problemOrder);

    boolean checkProblemAnswer(ProblemAnswer problemOrder);
}
