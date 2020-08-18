package com.hero.poetry.common.exception;

import com.hero.poetry.common.utils.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    //日志
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)//指定出现什么异常执行这个方法
    @ResponseBody//为了返回数据
    public R error(Exception e){
        log.error(e.getMessage());
        e.printStackTrace();
        return R.error().message("执行了全局异常处理");
    }

    @ExceptionHandler(CustomException.class)//指定出现什么异常执行这个方法
    @ResponseBody//为了返回数据
    public R error(CustomException e){
        log.error(e.getMessage());
        e.printStackTrace();
        return R.error().code(e.getResultCode()).message(e.getMessage());
    }
}
