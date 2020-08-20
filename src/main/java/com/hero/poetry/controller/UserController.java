package com.hero.poetry.controller;

import com.fasterxml.jackson.databind.node.TextNode;
import com.hero.poetry.common.utils.R;
import com.hero.poetry.entity.AdminUser;
import com.hero.poetry.entity.Grade;
import com.hero.poetry.entity.User;
import com.hero.poetry.entity.dto.PageDTO;
import com.hero.poetry.entity.vo.QueryVO;
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

    @PostMapping("/users/{current}/{limit}")
    @ApiOperation("获取全部用户")
    public R getAllUser(@PathVariable Integer current,@PathVariable Integer limit,@RequestBody(required = false) QueryVO queryVO){
        PageDTO<User> pageDTO = userService.getAllUser(new PageDTO<>(current, limit),queryVO.getMsg());
        return R.ok().data("total",pageDTO.getTotal()).data("list",pageDTO.getRecords());
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

    @PostMapping("/login")
    @ApiOperation("管理员登陆验证")
    public R loginAdmin(@RequestBody AdminUser adminUser){
        boolean r = userService.loginAdmin(adminUser);
        return r ? R.ok() : R.error();
    }

    @PostMapping("/admin")
    @ApiOperation("新增管理员信息")
    public R addAdminUser(@RequestBody AdminUser adminUser){
        userService.addAdminUser(adminUser);
        return R.ok();
    }

    @DeleteMapping("/admin/{id}")
    @ApiOperation("删除管理员信息")
    public R deleteAdminUser(@PathVariable Integer id){
        userService.deleteAdminUser(id);
        return R.ok();
    }

    @PutMapping("/admin")
    @ApiOperation("修改管理员信息")
    public R updateAdminUser(@RequestBody AdminUser adminUser){
        userService.updateAdminUser(adminUser);
        return R.ok();
    }

    @PostMapping("/admins/{current}/{limit}")
    @ApiOperation("获取所有管理员信息")
    public R getAllAdminUser(@PathVariable Integer current,@PathVariable Integer limit,@RequestBody(required = false) QueryVO queryVO){
        PageDTO<AdminUser> pageDTO = userService.getAllAdminUser(new PageDTO<>(current, limit),queryVO.getMsg());
        return R.ok().data("total",pageDTO.getTotal()).data("list",pageDTO.getRecords());
    }

    @GetMapping("/admin/{id}")
    @ApiOperation("根据获取管理员信息")
    public R getAdminUserById(@PathVariable Integer id){
        AdminUser adminUser = userService.getAdminUserById(id);
        return R.ok().data("adminUser",adminUser);
    }
}
