package com.liziyang.www.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.liziyang.www.annotation.FuzzyValues;
import com.liziyang.www.dao.impl.StudentTaskDaoImpl;
import com.liziyang.www.pojo.StudentTask;
import com.liziyang.www.service.impl.StudentTaskServiceImpl;
import com.liziyang.www.utils.ServletUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.annotation.Target;
import java.util.List;

@FuzzyValues({2,4})
@WebServlet("/course/{courseId}/studentTasks/{taskId}")
public class StudentTaskServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println(req.getAttribute("{courseId}")+" and "+req.getAttribute("{taskId}"));
        String id=ServletUtils.getParameter(req.getRequestURI(),2);
        StudentTaskServiceImpl service=new StudentTaskServiceImpl();
        service.showUserTasks(resp,id);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("put...");
        resp.getWriter().write("put成功");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("delete...");
    }

}
