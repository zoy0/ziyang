package com.liziyang.www.service.impl;

import com.liziyang.www.dao.impl.StuQuestionDaoImpl;
import com.liziyang.www.pojo.StuQuestion;
import com.liziyang.www.service.StudentQuestionService;
import com.liziyang.www.utils.ServletUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class StudentQuestionServiceImpl implements StudentQuestionService {
    @Override
    public void showQuestions(HttpServletRequest req, HttpServletResponse resp) {
        String studentTaskId =(String) req.getAttribute("{studentTaskId}");
        String taskId =(String) req.getAttribute("{taskId}");
        List<StuQuestion> list = new StuQuestionDaoImpl().findStuQuestions(Integer.parseInt(studentTaskId),Integer.parseInt(taskId));
        try {
            ServletUtils.write(resp,list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
