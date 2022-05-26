package com.liziyang.www.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.liziyang.www.dao.impl.StuQuestionDaoImpl;
import com.liziyang.www.dao.impl.StudentQuestionDaoImpl;
import com.liziyang.www.dao.impl.StudentTaskDaoImpl;
import com.liziyang.www.pojo.StuQuestion;
import com.liziyang.www.pojo.Student;
import com.liziyang.www.pojo.StudentQuestion;
import com.liziyang.www.pojo.StudentTask;
import com.liziyang.www.service.StudentQuestionService;
import com.liziyang.www.utils.ServletUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

public class StudentQuestionServiceImpl implements StudentQuestionService {
    @Override
    public void showQuestions(HttpServletRequest req, HttpServletResponse resp) {
        String studentId =(String) req.getAttribute("{studentId}");
        String taskId = (String) req.getAttribute("{taskId}");
        List<StuQuestion> list = new StuQuestionDaoImpl().findStuQuestions(Integer.parseInt(studentId), Integer.parseInt(taskId));
        try {
            ServletUtils.write(resp,list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void submitAnswer(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String studentId = (String) req.getAttribute("{studentId}");
        String taskId = (String) req.getAttribute("{taskId}");
        int finishNumber=0;
        BufferedReader br = req.getReader();
        String params = br.readLine();
        JsonParser parse = new JsonParser();
        JsonArray asJsonArray = parse.parse(params).getAsJsonArray();
        List<Object> list=new LinkedList<>();
        for ( JsonElement jsonElement:
                asJsonArray) {
            int questionId = jsonElement.getAsJsonObject().get("questionId").getAsInt();
            String answer = jsonElement.getAsJsonObject().get("studentAnswer").toString();
            if (!"null".equals(answer)) {
                finishNumber+=1;
            }
            System.out.println(answer);
            list.add(answer);
            list.add(questionId);
        }
        System.out.println(finishNumber);
        int i = new StudentQuestionDaoImpl().updateById(list.toArray(),Integer.parseInt(taskId),Integer.parseInt(studentId),asJsonArray.size());
        new StudentTaskDaoImpl().updateFinishedTask(Integer.parseInt(studentId),Integer.parseInt(taskId),finishNumber);
        ServletUtils.write(resp,i!=0);
    }
}
