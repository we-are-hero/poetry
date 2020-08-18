package com.hero.poetry.entity;

import java.io.Serializable;

/**
 * feedback
 * @author 
 */
public class Feedback implements Serializable {
    private Integer id;

    private String content;

    private Integer phone;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }
}