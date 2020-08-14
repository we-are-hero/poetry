package com.hero.poetry.controller;

import com.hero.poetry.common.utils.R;
import com.hero.poetry.entity.Grade;
import com.hero.poetry.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
