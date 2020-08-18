package com.hero.poetry.controller;

import com.hero.poetry.common.utils.R;
import com.hero.poetry.entity.dto.AllCheckpointWithUserPassDTO;
import com.hero.poetry.entity.dto.ProblemDTO;
import com.hero.poetry.entity.vo.ProblemAnswer;
import com.hero.poetry.service.CheckpointService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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

    @GetMapping("getAllCheckpointById/{userId}")
    @ApiOperation("根据user id获取全部关卡")
    public R getAllCheckpointByUserId(@PathVariable String userId){
        List<AllCheckpointWithUserPassDTO> result = checkpointService.getAllCheckpoint(userId);
        return R.ok().data("checkpointList",result);
    }

    @GetMapping("getProblemById/{checkpointId}/{problemOrder}")
    @ApiOperation("根据关卡id 和 问题序号 获取问题")
    public R getProblemById(@PathVariable Integer checkpointId,@PathVariable Integer problemOrder){
        ProblemDTO problemDTO = checkpointService.getCheckpointProblemByCheckpointIdAndProblemOrder(checkpointId,problemOrder);
        return R.ok().data("problem",problemDTO);
    }

    @PostMapping("checkProblemAnswer")
    @ApiOperation("检查答案")
    public R checkProblemAnswer(@RequestBody ProblemAnswer problemOrder){
        boolean result = checkpointService.checkProblemAnswer(problemOrder);
        return R.ok().data("isAnswerCorrect",result);
    }
}
