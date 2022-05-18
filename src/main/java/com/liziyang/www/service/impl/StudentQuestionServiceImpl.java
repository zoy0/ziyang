package com.liziyang.www.service.impl;

import com.liziyang.www.dao.impl.StuQuestionDaoImpl;
import com.liziyang.www.dao.impl.StudentTaskDaoImpl;
import com.liziyang.www.pojo.StuQuestion;
import com.liziyang.www.pojo.StudentTask;
import com.liziyang.www.service.StudentQuestionService;
import com.liziyang.www.utils.ServletUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentQuestionServiceImpl implements StudentQuestionService {
    @Override
    public void showQuestions(HttpServletRequest req, HttpServletResponse resp) {
        String studentTaskId =(String) req.getAttribute("{studentTaskId}");
        Map<String,Object> map=new HashMap<>();
        map.put("student_task_id",studentTaskId);
        int taskId =new StudentTaskDaoImpl().select(map).get(0).getTasksId();
        List<StuQuestion> list = new StuQuestionDaoImpl().findStuQuestions(Integer.parseInt(studentTaskId),taskId);
        try {
            ServletUtils.write(resp,list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
