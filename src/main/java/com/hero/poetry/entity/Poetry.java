package com.hero.poetry.entity;

public class Poetry {
    private Integer id;
    private String poetryTitle;
    private String poetryDynasty;
    private String poetryAuthor;
    private String poetryContent;
    private String poetryKeywords;
    private String poetryTranslation;

    public Poetry() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getPoetryContent() {
        return poetryContent;
    }

    public void setPoetryContent(String poetryContent) {
        this.poetryContent = poetryContent;
    }

    public String getPoetryKeywords() {
        return poetryKeywords;
    }

    public void setPoetryKeywords(String poetryKeywords) {
        this.poetryKeywords = poetryKeywords;
    }

    public String getPoetryTranslation() {
        return poetryTranslation;
    }

    public void setPoetryTranslation(String poetryTranslation) {
        this.poetryTranslation = poetryTranslation;
    }

    @Override
    public String toString() {
        return "Poerty{" +
                "id=" + id +
                ", poetryTitle='" + poetryTitle + '\'' +
                ", poetryDynasty='" + poetryDynasty + '\'' +
                ", poetryAuthor='" + poetryAuthor + '\'' +
                ", poetryContent='" + poetryContent + '\'' +
                ", poetryKeywords='" + poetryKeywords + '\'' +
                ", poetryTranslation='" + poetryTranslation + '\'' +
                '}';
    }
}
