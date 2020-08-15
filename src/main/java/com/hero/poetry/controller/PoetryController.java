package com.hero.poetry.controller;

import com.hero.poetry.common.utils.R;
import com.hero.poetry.entity.Poetry;
import com.hero.poetry.entity.dto.PoetryIntroductionDTO;
import com.hero.poetry.service.PoetryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@Api(description = "古诗管理")
@RequestMapping("/poetry/poetry")
public class PoetryController {
    private final PoetryService poetryService;

    public PoetryController(PoetryService poetryService) {
        this.poetryService = poetryService;
    }

    @ApiOperation("根据年级id获取古诗")
    @PostMapping("/getPoetryIntroduction/{gradeId}")
    public R getPoetryIntroduction(@PathVariable Integer gradeId, @RequestParam(required = false) String msg) {
        List<PoetryIntroductionDTO> poetryIntroductionByGradeId = poetryService.getPoetryIntroductionByGradeId(gradeId, msg);
        return R.ok().data("poetryIntroduction",poetryIntroductionByGradeId);
    }

    @ApiOperation("根据古诗id获取古诗全部信息")
    @GetMapping("/getPoetryById/{poetryId}")
    public R getPoetryById(@PathVariable Integer poetryId) {
        Poetry poetry = poetryService.getPoetryById(poetryId);
        return R.ok().data("poetry",poetry);
    }
}
