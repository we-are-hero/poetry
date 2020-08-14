package com.hero.poetry.entity.dto;

public class PoetryIntroductionDTO {
    Integer id;
    String poetryTitle;
    String poetryDynasty;
    String poetryAuthor;

    public PoetryIntroductionDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPoetryTitle() {
        return poetryTitle;
    }

    public void setPoetryTitle(String poetryTitle) {
        this.poetryTitle = poetryTitle;
    }

    public String getPoetryDynasty() {
        return poetryDynasty;
    }

    public void setPoetryDynasty(String poetryDynasty) {
        this.poetryDynasty = poetryDynasty;
    }

    public String getPoetryAuthor() {
        return poetryAuthor;
    }

    public void setPoetryAuthor(String poetryAuthor) {
        this.poetryAuthor = poetryAuthor;
    }
}
