package com.hero.poetry.controller;

import com.hero.poetry.common.utils.R;
import com.hero.poetry.entity.dto.RankServiceDTO;
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
        RankServiceDTO rankServiceDTO = rankService.getRank(userId);
        return R.ok().data("name",rankServiceDTO.getRank()).data("url",rankServiceDTO.getIcon());
    }
}
