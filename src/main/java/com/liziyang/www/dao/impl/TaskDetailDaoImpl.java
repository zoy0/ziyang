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
        sql=new StringBuffer("select * from class as a,class_course as b,course as c,tasks as d where a.classId=b.class_id and b.course_id=c.id and c.id=d.course_id");
        return utils.query(sql.toString(),null,TaskDetail.class);
    }

    @Override
    public List<TaskDetail> findFuzzy(String semester, String fuzzy) {
        sql=new StringBuffer("select * from class as a,class_course as b,course as c,tasks as d where a.classId=b.class_id and b.course_id=c.id and c.id=d.course_id ");
        List<Object> objectList=new ArrayList<>();
        if (!"".equals(semester)) {
            int asemester=Integer.parseInt(semester);
            sql.append(" and d.semester=? ");
            objectList.add(asemester);
        }
        if (fuzzy!=null) {
            try {
                fuzzy = URLDecoder.decode(fuzzy,"UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            sql.append(" and (d.subjectname like ? or c.course_name like ? or a.classname like ?)");
            objectList.add("%"+fuzzy+"%");
            objectList.add("%"+fuzzy+"%");
            objectList.add("%"+fuzzy+"%");
        }
        return utils.query(sql.toString(),objectList.toArray(),TaskDetail.class);
    }


}
