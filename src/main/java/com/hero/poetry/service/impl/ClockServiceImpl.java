package com.hero.poetry.service.impl;

import com.hero.poetry.entity.Clock;
import com.hero.poetry.mapper.ClockMapper;
import com.hero.poetry.service.ClockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClockServiceImpl implements ClockService {

    @Autowired
    private ClockMapper clockMapper;

    @Override
    public void insertClock(Clock clock) {
        clockMapper.insertClock(clock);
    }

    @Override
    public List<Clock> getClock() {
        List<Clock> list = clockMapper.getClock();
        if(list.size()<=0) {
            throw new RuntimeException("数据获取异常");
        }
        return list;
    }
}
