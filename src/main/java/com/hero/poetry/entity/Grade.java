package com.hero.poetry.entity;

import java.io.Serializable;

/**
 * grade
 * @author 
 */
public class Grade implements Serializable {
    private Integer id;

    private String gradeName;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }
}