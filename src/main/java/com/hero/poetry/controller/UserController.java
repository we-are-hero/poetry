package com.hero.poetry.controller;

import com.hero.poetry.common.utils.R;
import com.hero.poetry.entity.Grade;
import com.hero.poetry.entity.User;
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

    @PostMapping("/grade")
    @ApiOperation("添加年级")
    public R addGrade(@RequestBody Grade grade){
        userService.addGrade(grade);
        return R.ok();
    }

    @DeleteMapping("/grade/{id}")
    @ApiOperation("删除年级")
    public R deleteGrade(@PathVariable String id){
        userService.deleteGrade(id);
        return R.ok();
    }

    @PutMapping("/grade")
    @ApiOperation("修改年级")
    public R deleteGrade(@RequestBody Grade grade){
        userService.updateGrade(grade);
        return R.ok();
    }

    @PostMapping("/user")
    @ApiOperation("添加用户")
    public R addUser(@RequestBody User user){
        userService.addUser(user);
        return R.ok();
    }

    @GetMapping("/user/{userId}")
    @ApiOperation("获取用户信息")
    public R getUser(@PathVariable String userId){
        User user = userService.getUser(userId);
        return R.ok().data("user",user);
    }

    @GetMapping("/exist/{userId}")
    @ApiOperation("是否存在该用户")
    public R checkUserExist(@PathVariable String userId){
        boolean result = userService.checkUserExist(userId);
        return R.ok().data("isExist",result);
    }

    @GetMapping("/users")
    @ApiOperation("获取全部用户")
    public R getAllUser(){
        List<User> list = userService.getAllUser();
        return R.ok().data("list",list);
    }

    @PutMapping("/user")
    @ApiOperation("修改用户信息")
    public R updateUser(@RequestBody User user){
        userService.updateUser(user);
        return R.ok();
    }

    @DeleteMapping("/user/{id}")
    @ApiOperation("删除用户信息")
    public R deleteUser(@PathVariable String id){
        userService.deleteUser(id);
        return R.ok();
    }
}
