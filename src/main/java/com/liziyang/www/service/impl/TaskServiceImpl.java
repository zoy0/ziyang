package com.liziyang.www.service.impl;

import com.liziyang.www.dao.impl.TaskDetailDaoImpl;
import com.liziyang.www.dao.impl.TasksDaoImpl;
import com.liziyang.www.pojo.TaskDetail;
import com.liziyang.www.service.TaskService;
import com.liziyang.www.utils.ServletUtils;
import com.sun.deploy.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TaskServiceImpl implements TaskService {
    @Override
    public void showTask(HttpServletRequest req, HttpServletResponse resp) {
        String semester = (String) req.getAttribute("{semester}");
        String fuzzy =(String) req.getAttribute("{fuzzy}");
        List<TaskDetail> allTasks=null;
        if ("".equals(semester)&&fuzzy==null){
            allTasks = new TaskDetail().setListStatusStr(new TaskDetailDaoImpl().findAllTasks());
        }else {
            allTasks = new TaskDetail().setListStatusStr(new TaskDetailDaoImpl().findFuzzy(semester,fuzzy));
        }
        try {
            ServletUtils.write(resp,allTasks);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
