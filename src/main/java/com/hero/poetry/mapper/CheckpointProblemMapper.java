package com.hero.poetry.mapper;

import com.hero.poetry.entity.CheckpointProblem;
import com.hero.poetry.entity.dto.ProblemDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CheckpointProblemMapper {
    int checkProblemAnswer(@Param("checkpointId")Integer checkpointId, @Param("problemOrder")Integer problemOrder, @Param("problemAnswer")String problemAnswer);

    ProblemDTO getCheckpointProblemByCheckpointIdAndProblemOrder(@Param("checkpointId")Integer checkpointId, @Param("problemOrder")Integer problemOrder);

    List<ProblemDTO> getCheckpointProblemByCheckpointId(@Param("checkpointId") Integer checkpointId);

    Integer addCheckpointProblem(@Param("checkpointProblem")CheckpointProblem checkpointProblem);

    Integer updateCheckpointProblem(@Param("checkpointProblem")CheckpointProblem checkpointProblem);

    Integer deleteCheckpointProblemById(@Param("id") Integer id);

    Integer deleteCheckpointProblemByCheckpointId(@Param("checkpointId") Integer checkpointId);

    Integer checkOrderByCheckpointIdAndOrderId(@Param("checkpointId")Integer checkpointId,@Param("orderId")Integer orderId);
}