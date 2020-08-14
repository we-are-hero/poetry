package com.hero.poetry.mapper;


import com.hero.poetry.entity.Poerty;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PoertyMapper {

    public List<Poerty> getPoerty();
}
