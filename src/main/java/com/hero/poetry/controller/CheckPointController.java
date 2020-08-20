package com.hero.poetry.controller;

import com.hero.poetry.common.utils.R;
import com.hero.poetry.entity.Checkpoint;
import com.hero.poetry.entity.CheckpointProblem;
import com.hero.poetry.entity.CheckpointType;
import com.hero.poetry.entity.dto.AllCheckpointWithUserPassDTO;
import com.hero.poetry.entity.dto.PageDTO;
import com.hero.poetry.entity.dto.ProblemDTO;
import com.hero.poetry.entity.vo.CheckpointVO;
import com.hero.poetry.entity.vo.ProblemAnswerVO;
import com.hero.poetry.service.CheckpointService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.parsing.Problem;
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
        List<AllCheckpointWithUserPassDTO> result = checkpointService.getAllCheckpointByUserId(userId);
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
    public R checkProblemAnswer(@RequestBody ProblemAnswerVO problemOrder){
        boolean result = checkpointService.checkProblemAnswer(problemOrder);
        return R.ok().data("isAnswerCorrect",result);
    }

    @GetMapping("getProblemById/{checkpointId}/")
    @ApiOperation("根据关卡id 获取问题数量")
    public R getProblemNum(@PathVariable Integer checkpointId){
        int n = checkpointService.getProblemNum(checkpointId);
        return R.ok().data("problemNum",n);
    }

    @PostMapping("checkpoint")
    @ApiOperation("添加关卡")
    public R addCheckpoint(@RequestBody CheckpointVO checkpointVO){
        checkpointService.addCheckpoint(checkpointVO);
        return R.ok();
    }

    @DeleteMapping("checkpoint/{id}")
    @ApiOperation("删除关卡")
    public R deleteCheckpoint(@PathVariable Integer id){
        checkpointService.deleteCheckpoint(id);
        return R.ok();
    }

    @PutMapping("checkpoint")
    @ApiOperation("修改关卡")
    public R updateCheckpoint(@RequestBody CheckpointVO checkpointVO){
        checkpointService.updateCheckpoint(checkpointVO);
        return R.ok();
    }

    @GetMapping("checkpoints/{gradeId}/{current}/{limit}")
    @ApiOperation("根据年级获取全部关卡")
    public R getAllCheckpointByGradeId(@PathVariable Integer gradeId,@PathVariable Integer current,@PathVariable Integer limit){
        PageDTO<Checkpoint> pageDTO = checkpointService.getAllCheckpointByGradeId(gradeId,new PageDTO<Checkpoint>(current,limit));
        return R.ok().data("total",pageDTO.getTotal()).data("list",pageDTO.getRecords());
    }

    @GetMapping("checkpoints/{current}/{limit}")
    @ApiOperation("获取全部关卡")
    public R getAllCheckpointByGradeId(@PathVariable Integer current,@PathVariable Integer limit){
        PageDTO<Checkpoint> pageDTO = checkpointService.getAllCheckpoint(new PageDTO<Checkpoint>(current,limit));
        return R.ok().data("total",pageDTO.getTotal()).data("list",pageDTO.getRecords());
    }

    @GetMapping("checkpoint/{id}")
    @ApiOperation("根据id获取关卡")
    public R getCheckpointById(@PathVariable Integer id){
        Checkpoint checkpoint = checkpointService.getCheckpointById(id);
        return R.ok().data("checkpoint",checkpoint);
    }

    @GetMapping("problems/{checkpointId}")
    @ApiOperation("根据关卡获取全部问题")
    public R getProblemByCheckpointId(@PathVariable Integer checkpointId){
        List<CheckpointProblem> list = checkpointService.getCheckpointProblemByCheckpointId(checkpointId);
        return R.ok().data("list",list);
    }

    @PostMapping("problem")
    @ApiOperation("添加问题")
    public R addProblem(@RequestBody CheckpointProblem checkpointProblem){
        checkpointService.addProblem(checkpointProblem);
        return R.ok();
    }

    @DeleteMapping("problem/{id}")
    @ApiOperation("根据id删除问题")
    public R deleteProblemById(@PathVariable Integer id){
        checkpointService.deleteProblem(id);
        return R.ok();
    }

    @PutMapping("problem")
    @ApiOperation("修改问题")
    public R updateProblem(@RequestBody CheckpointProblem checkpointProblem){
        checkpointService.updateProblem(checkpointProblem);
        return R.ok();
    }

    @GetMapping("problem/{id}")
    @ApiOperation("根据id获取问题")
    public R getProblemById(@PathVariable Integer id){
        CheckpointProblem checkpointProblem = checkpointService.getProblemById(id);
        return R.ok().data("problem",checkpointProblem);
    }

    @GetMapping("problem/type")
    @ApiOperation("获取所有问题类型")
    public R getAllCheckpointType(){
        List<CheckpointType> allCheckpointType = checkpointService.getAllCheckpointType();
        return R.ok().data("list",allCheckpointType);
    }
}
