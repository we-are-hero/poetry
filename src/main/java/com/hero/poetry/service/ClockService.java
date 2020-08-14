package com.hero.poetry.service;

import com.hero.poetry.entity.Clock;

import java.util.List;

public interface ClockService {

    public void insertClock(Clock clock);

    public List<Clock> getClock();
}
