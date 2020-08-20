package com.hero.poetry.mapper;

import com.hero.poetry.entity.Checkpoint;
import com.hero.poetry.entity.CheckpointProblem;
import com.hero.poetry.entity.dto.AllCheckpointWithUserPassDTO;
import com.hero.poetry.entity.dto.ProblemDTO;
import com.hero.poetry.entity.vo.CheckpointVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CheckpointMapper {
    List<AllCheckpointWithUserPassDTO> getAllCheckpointByGradeIdAndUserId(@Param("gradeId") Integer gradeId,@Param("userId") String userId);

    Integer getProblemNum(@Param("checkpointId")Integer checkpointId);

    Integer updateProblemNum(@Param("problemNum") Integer problemNum);

    Integer addCheckpoint(@Param("checkpoint") Checkpoint checkpoint);

    Integer updateCheckpoint(@Param("checkpoint") CheckpointVO checkpoint);

    Integer deleteCheckpoint(@Param("id")Integer id);

    List<Checkpoint> getAllCheckpointByGradeId(@Param("gradeId") Integer gradeId,@Param("m") Integer m,@Param("n") Integer n);

    Integer getAllCheckpointByGradeIdTotal(@Param("gradeId") Integer gradeId);

    List<Checkpoint> getAllCheckpoint(@Param("m") Integer m,@Param("n") Integer n);

    Integer getAllCheckpointTotal();

    Integer checkOrderByGradeIdAndOrderId(@Param("gradeId")Integer gradeId,@Param("orderId")Integer orderId);

    Checkpoint getCheckpointById(Integer id);
}
