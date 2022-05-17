package com.liziyang.www.pojo;

import com.liziyang.www.annotation.TableField;

public class StuQuestion {

    @TableField("question_id")
    private int questionId;

    @TableField("task_id")
    private int taskId;

    @TableField("question_content")
    private String questionContent;

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

    public StuQuestion() {
    }

    public StuQuestion(int questionId, int taskId, String questionContent, int fullScore, Question.questionType questionType, String rightAnswer, int studentTaskId, String studentAnswer, int score) {
        this.questionId = questionId;
        this.taskId = taskId;
        this.questionContent = questionContent;
        this.fullScore = fullScore;
        this.questionType = questionType;
        this.rightAnswer = rightAnswer;
        this.studentTaskId = studentTaskId;
        this.studentAnswer = studentAnswer;
        this.score = score;
    }

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

}
