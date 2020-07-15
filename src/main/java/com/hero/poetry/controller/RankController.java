package com.hero.poetry.controller;

import com.hero.poetry.common.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@Api(description ="排名管理")
@RequestMapping("/poetry/rank")
@RestController
public class RankController {
    @ApiOperation("获取当前段位")
    @GetMapping("/getRank")
    public R getRank(){

        return R.ok();
    }
}
