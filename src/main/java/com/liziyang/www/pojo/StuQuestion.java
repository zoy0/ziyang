package com.liziyang.www.pojo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liziyang.www.annotation.TableField;

public class StuQuestion {

    @TableField("question_id")
    private int questionId;

    @TableField("task_id")
    private int taskId;

    @TableField("question_content")
    private String questionContent;

    @TableField("question_option")
    private String questionOption;

    @TableField("full_score")
    private int fullScore;

    @TableField("question_type")
    private Question.questionType questionType;

    @TableField("right_answer")
    private String rightAnswer;


    @TableField("student_task_id")
    private int studentTaskId;

    @TableField("student_answer")
    private String studentAnswer;

    @TableField("score")
    private int score;





    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }


    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    public int getFullScore() {
        return fullScore;
    }

    public void setFullScore(int fullScore) {
        this.fullScore = fullScore;
    }

    public Question.questionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(Question.questionType questionType) {
        this.questionType = questionType;
    }

    public String getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(String rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    public int getStudentTaskId() {
        return studentTaskId;
    }

    public void setStudentTaskId(int studentTaskId) {
        this.studentTaskId = studentTaskId;
    }

    public String getStudentAnswer() {
        return studentAnswer;
    }

    public void setStudentAnswer(String studentAnswer) {
        this.studentAnswer = studentAnswer;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getQuestionOption() {
        return questionOption;
    }

    public void setQuestionOption(String questionOption) {
        this.questionOption = questionOption;
    }
}
