package com.hero.poetry.entity;


/**
 * checkpoint_problem
 * @author 
 */
public class CheckpointProblem {
    private Integer id;

    /**
     * 序号
     */
    private Integer problemOrder;

    /**
     * 问题
     */
    private String question;

    /**
     * 答案
     */
    private String answer;

    /**
     * 关卡名称
     */
    private Integer checkpointId;

    /**
     * 关卡类型
     */
    private Integer checkpointType;

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

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Integer getCheckpointId() {
        return checkpointId;
    }

    public void setCheckpointId(Integer checkpointId) {
        this.checkpointId = checkpointId;
    }

    public Integer getCheckpointType() {
        return checkpointType;
    }

    public void setCheckpointType(Integer checkpointType) {
        this.checkpointType = checkpointType;
    }
}