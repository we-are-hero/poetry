package com.hero.poetry.mapper;

import org.springframework.stereotype.Repository;

@Repository
public interface CheckpointUserMapper {
    void passCheckpoint(Integer checkpointId, String userId);
}
