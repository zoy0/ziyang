package com.liziyang.www.service.impl;

import com.liziyang.www.dao.impl.StudentTaskDaoImpl;
import com.liziyang.www.dao.impl.TasksDaoImpl;
import com.liziyang.www.pojo.StudentTask;
import com.liziyang.www.pojo.Tasks;
import com.liziyang.www.service.StudentTaskService;
import com.liziyang.www.utils.ServletUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class StudentTaskServiceImpl implements StudentTaskService {
    @Override
    public void showUserTasks(HttpServletResponse response,String id) {
        //int courseId=Integer.parseInt(id);
        TasksDaoImpl dao1=new TasksDaoImpl();
        List<Tasks> list1 = dao1.select(null);
        StudentTaskDaoImpl dao2=new StudentTaskDaoImpl();
        List<StudentTask> list2 = dao2.select(null);
        try {
            ServletUtils.write(response,list1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
