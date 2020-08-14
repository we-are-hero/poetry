package com.hero.poetry.service.impl;

import com.hero.poetry.entity.Poerty;
import com.hero.poetry.mapper.PoertyMapper;
import com.hero.poetry.service.PoertyService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PoertyServiceImpl implements PoertyService {

    @Autowired
    private PoertyMapper poertyMapper;

    @Override
    public List<Poerty> getPoertys() {
        List<Poerty> list = poertyMapper.getPoerty();
        if(list.size()<=0) {
            throw new RuntimeException("数据获取异常");
        }
        return list;
    }
}
