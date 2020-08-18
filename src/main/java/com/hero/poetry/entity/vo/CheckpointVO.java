package com.hero.poetry.entity.vo;

public class CheckpointVO {
    private Integer id;
    private Integer checkpointOrder;
    private String checkpointName;
    private Integer gradeId;

    public CheckpointVO() {
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

    public Integer getGradeId() {
        return gradeId;
    }

    public void setGradeId(Integer gradeId) {
        this.gradeId = gradeId;
    }
}
