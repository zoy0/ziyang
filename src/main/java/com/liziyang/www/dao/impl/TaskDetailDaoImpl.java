package com.liziyang.www.dao.impl;

import com.liziyang.www.dao.TaskDetailDao;
import com.liziyang.www.pojo.AClass;
import com.liziyang.www.pojo.TaskDetail;
import com.liziyang.www.utils.JDBCTemplateUtils;
import com.sun.deploy.net.URLEncoder;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

public class TaskDetailDaoImpl implements TaskDetailDao {
    JDBCTemplateUtils<TaskDetail> utils=new JDBCTemplateUtils<>();
    StringBuffer sql;
    @Override
    public List<TaskDetail> findAllTasks() {
        sql=new StringBuffer("select * from class as a,course as b,tasks as c where a.course_id=b.id and b.id=c.course_id");
        return utils.query(sql.toString(),null,TaskDetail.class);
    }

    @Override
    public List<TaskDetail> findFuzzy(String semester, String fuzzy) {
        sql=new StringBuffer("select * from class as a,course as b,tasks as c where a.course_id=b.id and b.id=c.course_id ");
        List<Object> objectList=new ArrayList<>();
        if (!"".equals(semester)) {
            int asemester=Integer.parseInt(semester);
            sql.append(" and c.semester=? ");
            objectList.add(asemester);
        }
        if (fuzzy!=null) {
            try {
                fuzzy = URLDecoder.decode(fuzzy,"UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            sql.append(" and (c.subjectname like ? or b.course_name like ? or a.class_name like ?)");
            objectList.add("%"+fuzzy+"%");
            objectList.add("%"+fuzzy+"%");
            objectList.add("%"+fuzzy+"%");
        }
        return utils.query(sql.toString(),objectList.toArray(),TaskDetail.class);
    }


}
