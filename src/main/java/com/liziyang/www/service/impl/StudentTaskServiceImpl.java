package com.liziyang.www.service.impl;

import com.liziyang.www.dao.impl.StuTasksDaoImpl;
import com.liziyang.www.dao.impl.StudentTaskDaoImpl;
import com.liziyang.www.dao.impl.TasksDaoImpl;
import com.liziyang.www.pojo.StuTasks;
import com.liziyang.www.pojo.StudentTask;
import com.liziyang.www.pojo.Tasks;
import com.liziyang.www.service.StudentTaskService;
import com.liziyang.www.utils.ServletUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class StudentTaskServiceImpl implements StudentTaskService {


    @Override
    public void showUserTasks(HttpServletRequest req, HttpServletResponse resp) {
        String studentId = (String) req.getAttribute("{studentId}");
        String courseId =(String) req.getAttribute("{courseId}");
        List<StuTasks> stuTasks = new StuTasksDaoImpl().findOnesTasks(Integer.parseInt(studentId), Integer.parseInt(courseId));
        try {
            ServletUtils.write(resp,stuTasks);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
