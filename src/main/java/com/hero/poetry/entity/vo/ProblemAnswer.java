package com.hero.poetry.entity.vo;

import io.swagger.models.auth.In;

public class ProblemAnswer {
    private String userId;
    private Integer checkpointId;
    private Integer problemOrder;
    private String problemAnswer;

    public ProblemAnswer() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getCheckpointId() {
        return checkpointId;
    }

    public void setCheckpointId(Integer checkpointId) {
        this.checkpointId = checkpointId;
    }

    public Integer getProblemOrder() {
        return problemOrder;
    }

    public void setProblemOrder(Integer problemOrder) {
        this.problemOrder = problemOrder;
    }

    public String getProblemAnswer() {
        return problemAnswer;
    }

    public void setProblemAnswer(String problemAnswer) {
        this.problemAnswer = problemAnswer;
    }

    @Override
    public String toString() {
        return "ProblemAnswer{" +
                "userId='" + userId + '\'' +
                ", checkpointId=" + checkpointId +
                ", problemOrder=" + problemOrder +
                ", problemAnswer='" + problemAnswer + '\'' +
                '}';
    }
}
