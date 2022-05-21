package com.liziyang.www.pojo;

import com.liziyang.www.annotation.TableField;
import com.liziyang.www.annotation.TableName;

@TableName("question")
public class Question {

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
    private questionType questionType;

    @TableField("right_answer")
    private String rightAnswer;


    public enum questionType{

        /**
         *
         */
        SINGLECHOICE("单选题"),
        MULTIPLECHOICE("多选题"),
        EXPLAINQUESTION("解答题");

        private String mean;

        questionType(String mean) {
            this.mean = mean;
        }

        @Override
        public String toString() {
            return "questionType{" +
                    "mean='" + mean + '\'' +
                    '}';
        }
    }

    public Question() {
    }

    public Question(int questionId, int taskId, String questionContent, int fullScore, Question.questionType questionType, String rightAnswer) {
        this.questionId = questionId;
        this.taskId = taskId;
        this.questionContent = questionContent;
        this.fullScore = fullScore;
        this.questionType = questionType;
        this.rightAnswer = rightAnswer;
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

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    @Override
    public String toString() {
        return "Question{" +
                "questionId=" + questionId +
                ", taskId=" + taskId +
                ", questionContent='" + questionContent + '\'' +
                ", fullScore=" + fullScore +
                ", questionType=" + questionType +
                ", rightAnswer='" + rightAnswer + '\'' +
                '}';
    }

    public String getQuestionOption() {
        return questionOption;
    }

    public void setQuestionOption(String questionOption) {
        this.questionOption = questionOption;
    }
}
