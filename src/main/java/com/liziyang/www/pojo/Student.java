package com.liziyang.www.pojo;

import com.liziyang.www.annotation.TableField;
import com.liziyang.www.annotation.TableName;

@TableName("student")
public class Student {
    @TableField("id")
    private int id;

    @TableField("name")
    private String name;

    public Student() {
    }

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
