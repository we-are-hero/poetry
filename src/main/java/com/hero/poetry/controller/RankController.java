package com.hero.poetry.controller;

import com.hero.poetry.common.utils.R;
import com.hero.poetry.entity.dto.RankLadderDTO;
import com.hero.poetry.entity.dto.RankServiceDTO;
import com.hero.poetry.service.RankService;
import com.hero.poetry.service.config.RankConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Api(description ="排名管理")
@RequestMapping("/poetry/rank")
@RestController
public class RankController {
    private final RankService rankService;
    private final RankConfigService rankConfigService;

    public RankController(RankService rankService, RankConfigService rankConfigService) {
        this.rankService = rankService;
        this.rankConfigService = rankConfigService;
    }

    @ApiOperation("根据用户id获取当前段位")
    @GetMapping("/getRankByUserId/{userId}")
    public R getRankByUserId(@PathVariable String userId){
        RankServiceDTO rankServiceDTO = rankService.getRank(userId);
        return R.ok().data("name",rankServiceDTO.getLevel()).data("url",rankServiceDTO.getIcon());
    }

    @ApiOperation("根据年级id获取段位信息")
    @GetMapping("/getRankLadderByGradeAndUserId/{gradeId}")
    public R getRankLadderByGradeAndUserId(@PathVariable Integer gradeId){
        List<RankLadderDTO> rankLadder = rankService.getRankLadderByGradeAndUserId(gradeId);
        List<RankServiceDTO> allRankLadder = rankConfigService.getAllRankLadder();
        return R.ok().data("rankData",rankLadder).data("rank",allRankLadder);
    }
}
