package com.hero.poetry.entity;

public class Poerty {
    private int id;
    private int grade_id;
    private String poetry_title;
    private String poetry_dynasty;
    private String poetry_author;
    private String poetry_content;
    private String poetry_keywords;
    private String poetry_translation;

    public Poerty() {
    }

    public Poerty(int grade_id, String poetry_title, String poetry_dynasty, String poetry_author, String poetry_content, String poetry_keywords, String poetry_translation) {
        this.grade_id = grade_id;
        this.poetry_title = poetry_title;
        this.poetry_dynasty = poetry_dynasty;
        this.poetry_author = poetry_author;
        this.poetry_content = poetry_content;
        this.poetry_keywords = poetry_keywords;
        this.poetry_translation = poetry_translation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGrade_id() {
        return grade_id;
    }

    public void setGrade_id(int grade_id) {
        this.grade_id = grade_id;
    }

    public String getPoetry_title() {
        return poetry_title;
    }

    public void setPoetry_title(String poetry_title) {
        this.poetry_title = poetry_title;
    }

    public String getPoetry_dynasty() {
        return poetry_dynasty;
    }

    public void setPoetry_dynasty(String poetry_dynasty) {
        this.poetry_dynasty = poetry_dynasty;
    }

    public String getPoetry_author() {
        return poetry_author;
    }

    public void setPoetry_author(String poetry_author) {
        this.poetry_author = poetry_author;
    }

    public String getPoetry_content() {
        return poetry_content;
    }

    public void setPoetry_content(String poetry_content) {
        this.poetry_content = poetry_content;
    }

    public String getPoetry_keywords() {
        return poetry_keywords;
    }

    public void setPoetry_keywords(String poetry_keywords) {
        this.poetry_keywords = poetry_keywords;
    }

    public String getPoetry_translation() {
        return poetry_translation;
    }

    public void setPoetry_translation(String poetry_translation) {
        this.poetry_translation = poetry_translation;
    }

    @Override
    public String toString() {
        return "Poerty{" +
                "id=" + id +
                ", grade_id=" + grade_id +
                ", poetry_title='" + poetry_title + '\'' +
                ", poetry_dynasty='" + poetry_dynasty + '\'' +
                ", poetry_author='" + poetry_author + '\'' +
                ", poetry_content='" + poetry_content + '\'' +
                ", poetry_keywords='" + poetry_keywords + '\'' +
                ", poetry_translation='" + poetry_translation + '\'' +
                '}';
    }
}
