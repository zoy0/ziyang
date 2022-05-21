package com.liziyang.www.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liziyang.www.dao.impl.StuQuestionDaoImpl;
import com.liziyang.www.dao.impl.StudentTaskDaoImpl;
import com.liziyang.www.pojo.StuQuestion;
import com.liziyang.www.pojo.Student;
import com.liziyang.www.pojo.StudentQuestion;
import com.liziyang.www.pojo.StudentTask;
import com.liziyang.www.service.StudentQuestionService;
import com.liziyang.www.utils.ServletUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

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

    @Override
    public void submitAnswer(HttpServletRequest req, HttpServletResponse resp) {
//        Map<String, String[]> map = req.getParameterMap();
//        Set<String> set = map.keySet();
//        ObjectMapper mapper=new ObjectMapper();
//        int cnt=0;
//        for (String s:
//             set) {
//            if ("".equals(map.get(s)[0])) continue;
//            StudentQuestion studentQuestion=new StudentQuestion();
//            try {
//                studentQuestion.setStudentAnswer(mapper.writeValueAsString(map.get(s)));
//            } catch (JsonProcessingException e) {
//                e.printStackTrace();
//            }
//            String s1 = s.replace("question", "").trim();
//            int questionId = Integer.parseInt(s1);
//            studentQuestion.setQuestionId(questionId);
//            studentQuestion.setStudentTaskId(Integer.parseInt((String) req.getAttribute("{studentTaskId}")));
//            int i = new StudentTaskDaoImpl().updateAnswer(studentQuestion);
//            cnt+=i;
//        }
//        try {
//            if (cnt==set.size()) {
//                ServletUtils.write(resp,true);
//            }else {
//                ServletUtils.write(resp,false);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
