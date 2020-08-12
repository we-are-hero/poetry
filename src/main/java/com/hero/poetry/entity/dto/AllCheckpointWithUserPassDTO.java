package com.hero.poetry.entity.dto;

public class AllCheckpointWithUserPassDTO {
    private Integer id;
    private Integer checkpointOrder;
    private String checkpointName;
    private Integer pass;
    private Integer problemNum;

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

    public Integer getPass() {
        return pass;
    }

    public void setPass(Integer pass) {
        this.pass = pass;
    }

    public Integer getProblemNum() {
        return problemNum;
    }

    public void setProblemNum(Integer problemNum) {
        this.problemNum = problemNum;
    }

    @Override
    public String toString() {
        return "AllCheckpointWithUserPassDTO{" +
                "id=" + id +
                ", checkpointOrder=" + checkpointOrder +
                ", checkpointName='" + checkpointName + '\'' +
                ", pass=" + pass +
                ", problemNum=" + problemNum +
                '}';
    }
}
