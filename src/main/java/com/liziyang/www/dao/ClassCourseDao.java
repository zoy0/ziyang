package com.liziyang.www.dao;

import com.liziyang.www.pojo.ClassCourse;

import java.util.List;

public interface ClassCourseDao {
    List<ClassCourse> selectByClassId(int classId);
}
