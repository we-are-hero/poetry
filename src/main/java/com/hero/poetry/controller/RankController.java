package com.hero.poetry.controller;

import com.hero.poetry.common.utils.R;
import com.hero.poetry.entity.RankLevel;
import com.hero.poetry.entity.dto.PageDTO;
import com.hero.poetry.entity.dto.RankLadderDTO;
import com.hero.poetry.entity.dto.RankServiceDTO;
import com.hero.poetry.entity.vo.QueryVO;
import com.hero.poetry.entity.vo.RankDataVo;
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
    @GetMapping("/getRankById/{userId}")
    public R getRankByUserId(@PathVariable String userId){
        RankServiceDTO rankServiceDTO = rankService.getRank(userId);
        return R.ok().data("name",rankServiceDTO.getLevel()).data("url",rankServiceDTO.getIcon());
    }

    @ApiOperation("根据年级id获取段位信息")
    @GetMapping("/getRankLadderById/{gradeId}")
    public R getRankLadderByGradeAndUserId(@PathVariable Integer gradeId){
        List<RankLadderDTO> rankLadder = rankService.getRankLadderByGradeAndUserId(gradeId);
        List<RankServiceDTO> allRankLadder = rankConfigService.getAllRankLadder();
        return R.ok().data("rankData",rankLadder).data("rank",allRankLadder);
    }

    @ApiOperation("增加段位水平")
    @PostMapping("/rankLevel")
    public R addRankLevel(@RequestBody RankLevel rankLevel){
        rankConfigService.addRankLevel(rankLevel);
        return R.ok();
    }

    @ApiOperation("删除段位水平")
    @DeleteMapping("/rankLevel/{id}")
    public R deleteRankLevel(@PathVariable Integer id){
        rankConfigService.deleteRankLevel(id);
        return R.ok();
    }

    @ApiOperation("修改段位水平")
    @PutMapping("/rankLevel")
    public R updateRankLevel(@RequestBody RankLevel rankLevel){
        rankConfigService.updateRankLevel(rankLevel);
        return R.ok();
    }

    @ApiOperation("获取全部段位水平")
    @GetMapping("/rankLevels")
    public R getAllRankLevel(){
        List<RankLevel> allRankLevel = rankConfigService.getAllRankLevel();
        return R.ok().data("list",allRankLevel);
    }

    @ApiOperation("根据id获取段位水平")
    @GetMapping("/rankLevel/{id}")
    public R getRankLevelById(@PathVariable Integer id){
        RankLevel rankLevel = rankConfigService.getRankLevelById(id);
        return R.ok().data("rankLevel",rankLevel);
    }

    @ApiOperation("修改排名")
    @PutMapping("/rank")
    public R updateRankLevel(@RequestBody RankDataVo rankDataVo){
        rankService.updateRank(rankDataVo);
        return R.ok();
    }

    @ApiOperation("根据年级获取全部排名")
    @PostMapping("/ranks/{gradeId}/{current}/{limit}")
    public R getAllRank(@PathVariable Integer gradeId,@PathVariable Integer current,@PathVariable Integer limit,@RequestBody(required = false) QueryVO queryVO){
        PageDTO<RankLadderDTO> pageDTO = rankService.getAllRank(gradeId,new PageDTO<>(current, limit),queryVO.getMsg());
        return R.ok().data("total",pageDTO.getTotal()).data("list",pageDTO.getRecords());
    }

    @ApiOperation("根据id获取排名")
    @GetMapping("/rank/{id}")
    public R getRankById(@PathVariable Integer id){
        RankLadderDTO rankLadderDTO = rankService.getRankById(id);
        return R.ok().data("rank",rankLadderDTO);
    }
}
