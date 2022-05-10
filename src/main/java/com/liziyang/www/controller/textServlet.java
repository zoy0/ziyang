package com.liziyang.www.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.liziyang.www.dao.TasksDao;
import com.liziyang.www.pojo.Tasks;

import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/tasks")
public class textServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Tasks> tasksList = new TasksDao().select();
        ObjectMapper mapper=new ObjectMapper();
        String s = mapper.writeValueAsString(tasksList);
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(s);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
