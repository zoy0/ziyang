package com.liziyang.www.pojo;

import com.liziyang.www.annotation.TableField;

import java.sql.Timestamp;

public class StuTasks {
    @TableField("taskid")
    private int taskId;

    @TableField("course_id")
    private int courseId;

    @TableField("subjectname")
    private String subjectName;

    @TableField("problemnumber")
    private int problemNumber;

    @TableField("totalscore")
    private int totalScore;

    @TableField("endtime")
    private Timestamp endTime;

    @TableField("state")
    private StudentTask.State state= StudentTask.State.UNFINISH;

    @TableField("finish_number")
    private int finishNumber;

    public StuTasks() {
    }

    public StuTasks(int taskId, int courseId, String subjectName, int problemNumber, int totalScore, Timestamp endTime, StudentTask.State state, int finishNumber) {
        this.taskId = taskId;
        this.courseId = courseId;
        this.subjectName = subjectName;
        this.problemNumber = problemNumber;
        this.totalScore = totalScore;
        this.endTime = endTime;
        this.state = state;
        this.finishNumber = finishNumber;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
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

    public StudentTask.State getState() {
        return state;
    }

    public void setState(StudentTask.State state) {
        this.state = state;
    }

    public int getFinishNumber() {
        return finishNumber;
    }

    public void setFinishNumber(int finishNumber) {
        this.finishNumber = finishNumber;
    }
}
