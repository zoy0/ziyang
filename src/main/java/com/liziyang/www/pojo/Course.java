package com.liziyang.www.pojo;

import com.liziyang.www.annotation.TableField;
import com.liziyang.www.annotation.TableName;

@TableName("course")
public class Course {

    @TableField("id")
    private int id;

    @TableField("course_name")
    private String courseName;

    @TableField("aprofiles")
    private String aProfiles;

    @TableField("count_subject")
    private int countSubject;

    @TableField("count_question")
    private int countQuestion;



    public Course() {
    }

    public Course(int id, String courseName, String aProfiles, int countSubject, int countQuestion) {
        this.id = id;
        this.courseName = courseName;
        this.aProfiles = aProfiles;
        this.countSubject = countSubject;
        this.countQuestion = countQuestion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getAProfiles() {
        return aProfiles;
    }

    public void setAProfiles(String aProfiles) {
        this.aProfiles = aProfiles;
    }

    public int getCountSubject() {
        return countSubject;
    }

    public void setCountSubject(int countSubject) {
        this.countSubject = countSubject;
    }

    public int getCountQuestion() {
        return countQuestion;
    }

    public void setCountQuestion(int countQuestion) {
        this.countQuestion = countQuestion;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", aProfiles='" + aProfiles + '\'' +
                ", countSubject=" + countSubject +
                ", countQuestion=" + countQuestion +
                '}';
    }
}
