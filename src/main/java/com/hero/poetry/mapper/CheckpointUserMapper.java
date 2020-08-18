package com.hero.poetry.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckpointUserMapper {
    Integer passCheckpoint(@Param("checkpointId") Integer checkpointId, @Param("userId") String userId);

    Integer deletePassByCheckpointId(@Param("checkpointId") Integer checkpointId);

    Integer checkPassCheckpointByUserIdAndCheckpointId(@Param("userId")String userId,@Param("checkpointId")Integer checkpointId);
}
