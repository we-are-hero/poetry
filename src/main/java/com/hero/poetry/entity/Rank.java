package com.hero.poetry.entity;

public class Rank {
    private Integer id;
    private Integer score;
    private Integer gradeId;
    private String userId;

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

    public Integer getGradeId() {
        return gradeId;
    }

    public void setGradeId(Integer gradeId) {
        this.gradeId = gradeId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Rank{" +
                "id=" + id +
                ", score=" + score +
                ", gradeId=" + gradeId +
                ", userId='" + userId + '\'' +
                '}';
    }
}
