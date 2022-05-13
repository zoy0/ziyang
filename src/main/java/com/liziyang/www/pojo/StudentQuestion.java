package com.liziyang.www.pojo;

import com.liziyang.www.annotation.TableField;
import com.liziyang.www.annotation.TableName;

@TableName("student_question")
public class StudentQuestion {

    @TableField("student_task_id")
    private int studentTaskId;

    @TableField("question_id")
    private int questionId;

    @TableField("student_answer")
    private String studentAnswer;

    @TableField("score")
    private int score;



    public StudentQuestion() {
    }

    public StudentQuestion(int studentTaskId, int questionId, String studentAnswer, int score) {
        this.studentTaskId = studentTaskId;
        this.questionId = questionId;
        this.studentAnswer = studentAnswer;
        this.score = score;
    }

    public int getStudentTaskId() {
        return studentTaskId;
    }

    public void setStudentTaskId(int studentTaskId) {
        this.studentTaskId = studentTaskId;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
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

    @Override
    public String toString() {
        return "StudentQuestion{" +
                "studentTaskId=" + studentTaskId +
                ", questionId=" + questionId +
                ", studentAnswer='" + studentAnswer + '\'' +
                ", score=" + score +
                '}';
    }
}
