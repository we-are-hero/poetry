package com.hero.poetry.entity.dto;

public class RankLadderDTO {
    private Integer id;
    private Integer score;
    private String userId;
    private String username;
    private String rankName;

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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRankName() {
        return rankName;
    }

    public void setRankName(String rankName) {
        this.rankName = rankName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "RankLadderDTO{" +
                "id=" + id +
                ", score=" + score +
                ", userId='" + userId + '\'' +
                ", rankName='" + rankName + '\'' +
                '}';
    }
}
