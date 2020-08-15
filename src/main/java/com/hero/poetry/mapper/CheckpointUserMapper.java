package com.hero.poetry.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckpointUserMapper {
    void passCheckpoint(@Param("checkpointId") Integer checkpointId, @Param("userId") String userId);
}
