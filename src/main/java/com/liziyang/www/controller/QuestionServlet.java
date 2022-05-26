package com.liziyang.www.controller;

import com.liziyang.www.annotation.FuzzyValues;
import com.liziyang.www.service.impl.QuestionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@FuzzyValues({2,4})
@WebServlet("/task/{taskId}/question/{questionId}")
public class QuestionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        new QuestionServiceImpl().showTaskQuestions(req,resp);
    }
}
