package com.liziyang.www.dao.impl;

import com.liziyang.www.dao.ClassCourseDao;
import com.liziyang.www.pojo.ClassCourse;
import com.liziyang.www.utils.JDBCTemplateUtils;

import java.util.List;

public class ClassCourseDaoImpl implements ClassCourseDao {
    private final JDBCTemplateUtils<ClassCourse> utils=new JDBCTemplateUtils<>();
    private StringBuffer sql;
    @Override
    public List<ClassCourse> selectByClassId(int classId) {
        sql=new StringBuffer("select * from class_course where class_id = ?");
        Object[] objects={classId};
        return utils.query(sql.toString(),objects,ClassCourse.class);
    }
}
