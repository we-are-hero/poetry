package com.hero.poetry.service.impl;

import com.hero.poetry.entity.dto.AllCheckpointWithUserPassDTO;
import com.hero.poetry.mapper.CheckpointMapper;
import com.hero.poetry.service.CheckpointService;
import com.hero.poetry.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckpointServiceImpl implements CheckpointService {
    private final UserService userService;

    private final CheckpointMapper checkpointMapper;

    public CheckpointServiceImpl(UserService userService, CheckpointMapper checkpointMapper) {
        this.userService = userService;
        this.checkpointMapper = checkpointMapper;
    }

    @Override
    public List<AllCheckpointWithUserPassDTO> getAllCheckpoint(String userId) {
        Integer gradeId = userService.getGradeById(userId);
        List<AllCheckpointWithUserPassDTO> allCheckpointByGradeId = checkpointMapper.getAllCheckpointByGradeId(gradeId, userId);
        return allCheckpointByGradeId;
    }
}
