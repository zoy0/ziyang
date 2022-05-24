package com.liziyang.www.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.liziyang.www.annotation.FuzzyValues;
import com.liziyang.www.pojo.StuQuestion;
import com.liziyang.www.service.StudentQuestionService;
import com.liziyang.www.service.impl.StudentQuestionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;

@FuzzyValues({2,4,6})
@WebServlet("/student/{studentId}/task/{taskId}/question/{questionId}")
public class StudentQuestionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StudentQuestionService service = new StudentQuestionServiceImpl();
        service.showQuestions(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StudentQuestionService service = new StudentQuestionServiceImpl();
        service.submitAnswer(req,resp);
    }

}
