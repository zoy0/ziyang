package com.liziyang.www.controller;

import com.liziyang.www.annotation.FuzzyValues;
import com.liziyang.www.service.impl.QuestionBankServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@FuzzyValues(2)
@WebServlet("/questionBank/{questionId}")
public class QuestionBankServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        QuestionBankServiceImpl service = new QuestionBankServiceImpl();
        service.showQuestionBank(req,resp);
    }
}
