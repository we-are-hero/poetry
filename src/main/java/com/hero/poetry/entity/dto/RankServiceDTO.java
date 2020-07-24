package com.hero.poetry.entity.dto;

public class RankServiceDTO {
    private String level;
    private String icon;

    public RankServiceDTO() {
    }

    public RankServiceDTO(String rank, String url) {
        this.level = rank;
        this.icon = url;
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
        return "RankServiceDTO{" +
                "level='" + level + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}
