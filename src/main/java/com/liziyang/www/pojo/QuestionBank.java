package com.liziyang.www.pojo;

import com.liziyang.www.annotation.TableField;
import com.liziyang.www.annotation.TableName;

@TableName("questionbank")
public class QuestionBank {

    @TableField("questionid")
    private int questionId;

    @TableField("question_type")
    private Question.questionType questionType;

    @TableField("question_content")
    private String questionContent;
    @TableField("question_option")
    private String questionOption;

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public Question.questionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(Question.questionType questionType) {
        this.questionType = questionType;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    public String getQuestionOption() {
        return questionOption;
    }

    public void setQuestionOption(String questionOption) {
        this.questionOption = questionOption;
    }
}
