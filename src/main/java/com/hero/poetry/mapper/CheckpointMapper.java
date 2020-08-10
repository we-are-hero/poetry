package com.hero.poetry.mapper;

import com.hero.poetry.entity.dto.AllCheckpointWithUserPassDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CheckpointMapper {
    List<AllCheckpointWithUserPassDTO> getAllCheckpointByGradeId(Integer gradeId, String userId);
}
