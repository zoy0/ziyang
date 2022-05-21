package com.liziyang.www.pojo;


import com.liziyang.www.annotation.TableField;
import com.liziyang.www.annotation.TableName;

@TableName("class_course")
public class ClassCourse {
    @TableField("class_id")
    private int classId;

    @TableField("course_id")
    private int courseId;

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
}
