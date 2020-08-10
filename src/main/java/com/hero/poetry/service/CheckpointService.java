package com.hero.poetry.service;

import com.hero.poetry.entity.dto.AllCheckpointWithUserPassDTO;

import java.util.List;

public interface CheckpointService {

    List<AllCheckpointWithUserPassDTO> getAllCheckpoint(String userId);
}
