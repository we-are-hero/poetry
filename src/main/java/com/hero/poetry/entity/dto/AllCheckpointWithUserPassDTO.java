package com.hero.poetry.entity.dto;

public class AllCheckpointWithUserPassDTO {
    private Integer id;
    private Integer checkpointOrder;
    private String checkpointName;
    private String checkpointType;
    private String question;
    private String answer;
    private Integer pass;

    public AllCheckpointWithUserPassDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCheckpointOrder() {
        return checkpointOrder;
    }

    public void setCheckpointOrder(Integer checkpointOrder) {
        this.checkpointOrder = checkpointOrder;
    }

    public String getCheckpointName() {
        return checkpointName;
    }

    public void setCheckpointName(String checkpointName) {
        this.checkpointName = checkpointName;
    }

    public String getCheckpointType() {
        return checkpointType;
    }

    public void setCheckpointType(String checkpointType) {
        this.checkpointType = checkpointType;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Integer getPass() {
        return pass;
    }

    public void setPass(Integer pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "AllCheckpointWithUserPassDTO{" +
                "id=" + id +
                ", checkpointOrder=" + checkpointOrder +
                ", checkpointName='" + checkpointName + '\'' +
                ", checkpointType='" + checkpointType + '\'' +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", pass=" + pass +
                '}';
    }
}
