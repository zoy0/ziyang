package com.liziyang.www.service.impl;

import com.liziyang.www.dao.CourseDao;
import com.liziyang.www.dao.StudentDao;
import com.liziyang.www.dao.impl.AClassDaoImpl;
import com.liziyang.www.dao.impl.CourseDaoImpl;
import com.liziyang.www.dao.impl.StudentDaoImpl;
import com.liziyang.www.pojo.AClass;
import com.liziyang.www.pojo.Course;
import com.liziyang.www.pojo.Student;
import com.liziyang.www.service.CourseService;
import com.liziyang.www.utils.ServletUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseServiceImpl implements CourseService {


    @Override
    public void showAllCourse(HttpServletResponse resp) {
        List<Course> list = new CourseDaoImpl().select(null);
        try {
            ServletUtils.write(resp,list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void showClassCourse(HttpServletResponse resp, int studentId) {
        Student student = new StudentDaoImpl().select(studentId).get(0);

    }
}
