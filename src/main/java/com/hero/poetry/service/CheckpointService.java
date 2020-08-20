package com.hero.poetry.service;

import com.hero.poetry.entity.Checkpoint;
import com.hero.poetry.entity.CheckpointProblem;
import com.hero.poetry.entity.CheckpointType;
import com.hero.poetry.entity.dto.AllCheckpointWithUserPassDTO;
import com.hero.poetry.entity.dto.PageDTO;
import com.hero.poetry.entity.dto.ProblemDTO;
import com.hero.poetry.entity.vo.CheckpointVO;
import com.hero.poetry.entity.vo.ProblemAnswerVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.parsing.Problem;

import java.util.List;

public interface CheckpointService {

    List<AllCheckpointWithUserPassDTO> getAllCheckpointByUserId(String userId);

    ProblemDTO getCheckpointProblemByCheckpointIdAndProblemOrder(Integer checkpointId, Integer problemOrder);

    boolean checkProblemAnswer(ProblemAnswerVO problemOrder);

    void addCheckpoint(CheckpointVO checkpointVO);

    Integer getProblemNum(Integer checkpointId);

    void deleteCheckpoint(Integer id);

    void updateCheckpoint(CheckpointVO checkpointVO);

    List<CheckpointProblem> getCheckpointProblemByCheckpointId(Integer checkpointId);

    PageDTO<Checkpoint> getAllCheckpointByGradeId(Integer gradeId, PageDTO<Checkpoint> pageDTO);

    PageDTO<Checkpoint> getAllCheckpoint(PageDTO<Checkpoint> pageDTO);

    void addProblem(CheckpointProblem checkpointProblem);

    void deleteProblem(Integer id);

    void updateProblem(CheckpointProblem checkpointProblem);

    Checkpoint getCheckpointById(Integer id);

    List<CheckpointType> getAllCheckpointType();

    CheckpointProblem getProblemById(Integer id);
}
