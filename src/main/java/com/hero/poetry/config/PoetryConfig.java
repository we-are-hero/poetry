package com.hero.poetry.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * 项目注解配置
 */
@Configuration
@MapperScan("com.hero.poetry")
public class PoetryConfig {
}
