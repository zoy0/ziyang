package com.liziyang.www.pojo;

import com.liziyang.www.annotation.TableField;
import com.liziyang.www.annotation.TableName;

import java.sql.Timestamp;

@TableName("tasks")
public class Tasks {

    @TableField("taskid")
    private int taskId;

    @TableField("subjectname")
    private String subjectName;

    @TableField("problemnumber")
    private int problemNumber;

    @TableField("totalscore")
    private int totalScore;

    @TableField("endtime")
    private Timestamp endTime;

    @TableField("right_answer")
    private String rightAnswer;

    public Tasks() {
    }

    public Tasks(int taskId, String subjectName, int problemNumber, int totalScore, Timestamp endTime, String rightAnswer) {
        this.taskId = taskId;
        this.subjectName = subjectName;
        this.problemNumber = problemNumber;
        this.totalScore = totalScore;
        this.endTime = endTime;
        this.rightAnswer = rightAnswer;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getProblemNumber() {
        return problemNumber;
    }

    public void setProblemNumber(int problemNumber) {
        this.problemNumber = problemNumber;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public String getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(String rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    @Override
    public String toString() {
        return "Tasks{" +
                "taskId=" + taskId +
                ", subjectName='" + subjectName + '\'' +
                ", problemNumber=" + problemNumber +
                ", totalScore=" + totalScore +
                ", endTime=" + endTime +
                ", rightAnswer='" + rightAnswer + '\'' +
                '}';
    }
}
