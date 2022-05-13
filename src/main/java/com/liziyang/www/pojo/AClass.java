package com.liziyang.www.pojo;

import com.liziyang.www.annotation.TableField;
import com.liziyang.www.annotation.TableName;

@TableName("class")
public class AClass {
    @TableField("class_name")
    private String className;

    @TableField("course_id")
    private int courseId;

    public AClass() {
    }

    public AClass(String className, int courseId) {
        this.className = className;
        this.courseId = courseId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    @Override
    public String toString() {
        return "AClass{" +
                "className='" + className + '\'' +
                ", courseId=" + courseId +
                '}';
    }
}
