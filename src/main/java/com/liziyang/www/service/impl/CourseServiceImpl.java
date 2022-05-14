package com.liziyang.www.service.impl;

import com.liziyang.www.dao.CourseDao;
import com.liziyang.www.dao.impl.CourseDaoImpl;
import com.liziyang.www.pojo.Course;
import com.liziyang.www.service.CourseService;
import com.liziyang.www.utils.ServletUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

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
}
