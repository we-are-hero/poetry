package com.hero.poetry.controller;

import com.hero.poetry.common.utils.R;
import com.hero.poetry.entity.dto.AllCheckpointWithUserPassDTO;
import com.hero.poetry.service.CheckpointService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(description = "关卡管理")
@CrossOrigin
@RequestMapping("/poetry/checkpoint")
public class CheckPointController {
    private final CheckpointService checkpointService;

    public CheckPointController(CheckpointService checkpointService) {
        this.checkpointService = checkpointService;
    }

    @GetMapping("getAllCheckpointByUserId/{userId}")
    public R getAllCheckpointByUserId(@PathVariable String userId){
        List<AllCheckpointWithUserPassDTO> result = checkpointService.getAllCheckpoint(userId);
        return R.ok().data("checkpointList",result);
    }
}
