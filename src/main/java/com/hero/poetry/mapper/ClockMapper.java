package com.hero.poetry.mapper;


import com.hero.poetry.entity.Clock;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClockMapper {

    public void insertClock(Clock clock);

    public List<Clock> getClock();
}
