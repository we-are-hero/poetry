package com.hero.poetry.entity;

public class RankLevel {
    private Integer id;
    private Integer score;
    private String level;
    private String icon;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return "RankLevel{" +
                "id=" + id +
                ", score=" + score +
                ", level='" + level + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}
