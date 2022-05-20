package com.liziyang.www.dao;

import com.liziyang.www.pojo.TaskDetail;

import java.util.List;

public interface TaskDetailDao {
    List<TaskDetail> findAllTasks();

    List<TaskDetail> findFuzzy(String semester, String fuzzy);
}
