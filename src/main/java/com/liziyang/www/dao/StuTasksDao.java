package com.liziyang.www.dao;

import com.liziyang.www.pojo.StuTasks;

import java.util.List;

public interface StuTasksDao {

    List<StuTasks> findOnesTasks(int studentId,int courseId);

}
