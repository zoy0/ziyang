package com.liziyang.www.controller;

import com.liziyang.www.annotation.FuzzyValues;
import com.liziyang.www.service.impl.TaskServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@FuzzyValues({3,5})
@WebServlet("/task/semester/{semester}/fuzzy/{fuzzy}")
public class TaskServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        new TaskServiceImpl().showTask(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        new TaskServiceImpl().addTask(req,resp);

    }
}
