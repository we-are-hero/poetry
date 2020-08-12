package com.hero.poetry.entity.dto;

public class ProblemDTO {
    private Integer id;
    private Integer problemOrder;
    private String question;
    private String checkpointType;

    public ProblemDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProblemOrder() {
        return problemOrder;
    }

    public void setProblemOrder(Integer problemOrder) {
        this.problemOrder = problemOrder;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCheckpointType() {
        return checkpointType;
    }

    public void setCheckpointType(String checkpointType) {
        this.checkpointType = checkpointType;
    }

    @Override
    public String toString() {
        return "ProblemDTO{" +
                "id=" + id +
                ", problemOrder=" + problemOrder +
                ", question='" + question + '\'' +
                ", checkpointType='" + checkpointType + '\'' +
                '}';
    }
}
