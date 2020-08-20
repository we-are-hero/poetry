package com.hero.poetry.controller;

import com.hero.poetry.common.utils.R;
import com.hero.poetry.entity.Poetry;
import com.hero.poetry.entity.dto.PageDTO;
import com.hero.poetry.entity.dto.PoetryIntroductionDTO;
import com.hero.poetry.entity.vo.QueryVO;
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

    @ApiOperation("根据年级id获取古诗介绍")
    @PostMapping("/getPoetryIntroduction/{gradeId}")
    public R getPoetryIntroduction(@PathVariable Integer gradeId, @RequestBody(required = false) String msg) {
        List<PoetryIntroductionDTO> poetryIntroductionByGradeId = poetryService.getPoetryIntroductionByGradeId(gradeId, msg);
        return R.ok().data("poetryIntroduction",poetryIntroductionByGradeId);
    }

    @ApiOperation("根据古诗id获取古诗全部信息")
    @GetMapping("/getPoetryById/{poetryId}")
    public R getPoetryById(@PathVariable Integer poetryId) {
        Poetry poetry = poetryService.getPoetryById(poetryId);
        return R.ok().data("poetry",poetry);
    }

    @ApiOperation("增加古诗")
    @PostMapping("/poetry")
    public R addPoetry(@RequestBody Poetry poetry) {
        poetryService.addPoetry(poetry);
        return R.ok();
    }

    @ApiOperation("删除古诗")
    @DeleteMapping("/poetry/{id}")
    public R deletePoetry(@PathVariable Integer id) {
        poetryService.deletePoetry(id);
        return R.ok();
    }

    @ApiOperation("修改古诗")
    @PutMapping("/poetry")
    public R updatePoetry(@RequestBody Poetry poetry) {
        poetryService.updatePoetry(poetry);
        return R.ok();
    }

    @ApiOperation("查询古诗")
    @PostMapping("/poetrys/{current}/{limit}")
    public R getAllPoetry(@PathVariable Integer current,@PathVariable Integer limit,@RequestBody(required = false) QueryVO queryVO) {
        PageDTO<Poetry> pageDTO = poetryService.getAllPoetry(new PageDTO<>(current, limit),queryVO.getMsg());
        return R.ok().data("total",pageDTO.getTotal()).data("list",pageDTO.getRecords());
    }

    @ApiOperation("根据gradeId查询古诗")
    @PostMapping("/poetrys/{id}/{current}/{limit}")
    public R getAllPoetry(@PathVariable Integer id,@PathVariable Integer current,@PathVariable Integer limit,@RequestBody(required = false) QueryVO queryVO) {
        PageDTO<Poetry> pageDTO = poetryService.getAllPoetryByGradeId(id,new PageDTO<>(current, limit),queryVO.getMsg());
        return R.ok().data("total",pageDTO.getTotal()).data("list",pageDTO.getRecords());
    }
}
