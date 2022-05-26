package com.liziyang.www.controller;

import com.google.gson.JsonParser;
import com.liziyang.www.annotation.FuzzyValues;
import com.liziyang.www.service.impl.TaskServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;


@FuzzyValues({2,4,6})
@WebServlet("/task/{taskId}/semester/{semester}/fuzzy/{fuzzy}")
public class TaskServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        new TaskServiceImpl().showTask(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        new TaskServiceImpl().addTask(req,resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        new TaskServiceImpl().publishTask(req,resp);
    }
}
