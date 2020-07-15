package com.hero.poetry.controller;

import com.hero.poetry.common.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 用于测试项目是否正常运行
 */
@CrossOrigin
@Api(description ="测试swagger显示")
@RequestMapping("/poetry")
@RestController
public class TestController {
    @GetMapping("test1")
    @ApiOperation("获取一组数据")
    public R getList(){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        return R.ok().data("list",list);//所有Controller返回R类型即可
    }

    @GetMapping("test2")
    @ApiOperation("传递参数")
    public R passParameter(String name){
        return R.ok().data("param","你传递的参数是:" + name);
    }

    @GetMapping("test3/{id}")
    @ApiOperation("通过路径传递参数")
    public R passParameter2(@PathVariable String id){
        return R.ok().data("param","你传递的参数是:" + id);
    }
}
