package com.hero.poetry.entity;

import java.io.Serializable;

/**
 * feedback
 * @author 
 */
public class Feedback {
    private Integer id;

    private String content;

    private String phone;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}