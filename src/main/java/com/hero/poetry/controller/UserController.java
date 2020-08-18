package com.hero.poetry.controller;

import com.hero.poetry.common.utils.R;
import com.hero.poetry.entity.Grade;
import com.hero.poetry.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(description = "用户管理")
@CrossOrigin
@RequestMapping("/poetry/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/allGrade")
    @ApiOperation("获取全部年级")
    public R getAllGrade(){
        List<Grade> allGrade = userService.getAllGrade();
        return R.ok().data("allGrade",allGrade);
    }

    @GetMapping("/grade/{userId}")
    @ApiOperation("根据用户id获取年级")
    public R getGradeByUserId(@PathVariable String userId){
        Grade grade = userService.getGradeById(userId);
        return R.ok().data("grade",grade);
    }

    @PutMapping("/modifyGradeById/{userId}/{gradeId}")
    @ApiOperation("更改用户的年级")
    public R modifyGradeByUserId(@PathVariable String userId,@PathVariable Integer gradeId){
        userService.modifyGradeByUserId(userId,gradeId);
        return R.ok();
    }
}
