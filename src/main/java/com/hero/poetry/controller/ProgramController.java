package com.hero.poetry.controller;

import com.hero.poetry.common.utils.R;
import com.hero.poetry.entity.Feedback;
import com.hero.poetry.service.ProgramService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@Api(description = "程序自身管理")
@RequestMapping("program")
public class ProgramController {
    private final ProgramService programService;

    public ProgramController(ProgramService programService) {
        this.programService = programService;
    }

    @PostMapping("feedback")
    @ApiOperation("添加反馈")
    public R addFeedback(@RequestBody Feedback feedback){
        programService.addFeedback(feedback);
        return R.ok();
    }

    @DeleteMapping("feedback/{id}")
    @ApiOperation("删除反馈")
    public R deleteFeedback(@PathVariable Integer id){
        programService.deleteFeedback(id);
        return R.ok();
    }

    @GetMapping("feedbacks")
    @ApiOperation("获取全部反馈")
    public R getAllFeedback(){
        List<Feedback> feedbackList = programService.getAllFeedback();
        return R.ok().data("list",feedbackList);
    }
}
