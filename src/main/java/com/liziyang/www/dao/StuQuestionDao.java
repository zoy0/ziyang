package com.liziyang.www.dao;

import com.liziyang.www.pojo.StuQuestion;

import java.util.List;

public interface StuQuestionDao {
    List<StuQuestion> findStuQuestions(int studentId, int taskId);
}
