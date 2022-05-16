package com.liziyang.www.controller;

import com.liziyang.www.annotation.FuzzyValues;
import com.liziyang.www.service.impl.CourseServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@FuzzyValues({2,4})
@WebServlet("/student/{studentId}/course/{courseId}")
public class CourseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String studentId = (String) req.getAttribute("{studentId}");
        CourseServiceImpl service = new CourseServiceImpl();
        service.showClassCourse(resp,Integer.parseInt(studentId));
    }

}
