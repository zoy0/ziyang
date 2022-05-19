package com.liziyang.www.dao.impl;

import com.liziyang.www.dao.TaskDetailDao;
import com.liziyang.www.pojo.AClass;
import com.liziyang.www.pojo.TaskDetail;
import com.liziyang.www.utils.JDBCTemplateUtils;

import java.util.List;

public class TaskDetailDaoImpl implements TaskDetailDao {
    JDBCTemplateUtils<TaskDetail> utils=new JDBCTemplateUtils<>();
    StringBuffer sql;
    @Override
    public List<TaskDetail> findAllTasks() {
        sql=new StringBuffer("select * from class as a,course as b,tasks as c where a.course_id=b.id and b.id=c.course_id");
        return utils.query(sql.toString(),null,TaskDetail.class);
    }
}
