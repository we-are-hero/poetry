package com.hero.poetry.controller;

import com.hero.poetry.common.utils.R;
import com.hero.poetry.service.RankService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@Api(description ="排名管理")
@RequestMapping("/poetry/rank")
@RestController
public class RankController {
    private final RankService rankService;

    public RankController(RankService rankService) {
        this.rankService = rankService;
    }

    @ApiOperation("根据用户id获取当前段位")
    @GetMapping("/getRankByUserId/{userId}")
    public R getRankByUserId(@PathVariable String userId){
        String rank = rankService.getRank(userId);
        return R.ok().data("list",rank);
    }
}
