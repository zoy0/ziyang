package com.liziyang.www.service;

import javax.servlet.http.HttpServletResponse;

public interface CourseService {

     void showAllCourse(HttpServletResponse resp);

    void showClassCourse(HttpServletResponse resp,int studentId);
}
