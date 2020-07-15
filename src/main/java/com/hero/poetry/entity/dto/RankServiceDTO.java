package com.hero.poetry.entity.dto;

public class RankServiceDTO {
    private String rank;
    private String icon;

    public RankServiceDTO() {
    }

    public RankServiceDTO(String rank, String url) {
        this.rank = rank;
        this.icon = url;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
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
                "rank='" + rank + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}
