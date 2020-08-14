package com.hero.poetry.controller;


import com.hero.poetry.common.utils.R;
import com.hero.poetry.entity.Clock;
import com.hero.poetry.service.ClockService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;

@CrossOrigin
@Api(description ="圈子")
@RequestMapping("/poetry")
@RestController
@Controller
public class ClockController {

    @Autowired
    private final ClockService clockService;

    public ClockController(ClockService clockService) {
        this.clockService = clockService;
    }

    @ApiOperation("打卡数据")
    @RequestMapping(value = "/insertClock",method = RequestMethod.POST)
    public R insertClock(Clock clock){
        if(clock != null) {
            clockService.insertClock(clock);
            return R.ok().data("param", "你传递的参数是:" + clock);
        }
        return R.error().data("内容为空", "内容为空");
    }
    @ApiOperation("打卡数据查询")
    @GetMapping("/getClock")
    @ResponseBody
    public R getClock(){
        System.out.println("h'h'h");
        List<Clock> list = clockService.getClock();
        Clock clock = null;
        if(list.size()<=0){
            return R.error().data("结果:","很抱歉，没有数据！");
        }else{
            Iterator<Clock> it = list.iterator();
            while(it.hasNext()){
                clock = it.next();
            }
        }
        return R.ok().data("result",list);
    }
}
