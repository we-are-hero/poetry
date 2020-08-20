package com.hero.poetry.controller;

import com.hero.poetry.common.utils.R;
import com.hero.poetry.entity.Feedback;
import com.hero.poetry.entity.dto.PageDTO;
import com.hero.poetry.entity.vo.QueryVO;
import com.hero.poetry.service.ProgramService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@Api(description = "程序自身管理")
@RequestMapping("/poetry/program")
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

    @PostMapping("feedbacks/{current}/{limit}")
    @ApiOperation("获取全部反馈")
    public R getAllFeedback(@PathVariable Integer current,@PathVariable Integer limit,@RequestBody(required = false) QueryVO queryVO){
        PageDTO<Feedback> pageDTO = programService.getAllFeedback(new PageDTO<>(current, limit),queryVO.getMsg());
        return R.ok().data("total",pageDTO.getTotal()).data("list",pageDTO.getRecords());
    }
}
