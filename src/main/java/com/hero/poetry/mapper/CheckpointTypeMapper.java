package com.hero.poetry.mapper;

import com.hero.poetry.entity.CheckpointType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CheckpointTypeMapper {
    List<CheckpointType> getAllCheckpointType();
}
