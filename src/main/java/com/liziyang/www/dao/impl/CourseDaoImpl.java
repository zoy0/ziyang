package com.liziyang.www.dao.impl;

import com.liziyang.www.dao.CourseDao;
import com.liziyang.www.pojo.AClass;
import com.liziyang.www.pojo.Course;
import com.liziyang.www.pojo.StudentTask;
import com.liziyang.www.pojo.Tasks;
import com.liziyang.www.utils.JDBCTemplateUtils;

import java.util.List;
import java.util.Map;

public class CourseDaoImpl implements CourseDao {
    private final JDBCTemplateUtils<Course> jdbc =  new JDBCTemplateUtils<>();
    private StringBuffer sql;

    @Override
    public int insert(Course course) {
        sql=new StringBuffer("insert into "+jdbc.getTableName(Course.class)+" values(?,?,?,?,?)");
        Object[] objects={null ,course.getCourseName(),course.getAProfiles(),course.getCountSubject(),course.getCountQuestion()};
        return jdbc.update(sql.toString(),objects);
    }

    @Override
    public int delete(int cid) {
        return 0;
    }

    @Override
    public List<Course> select(Map<String, Object> map) {
        return jdbc.commonSelect( map,Course.class);
    }

    @Override
    public int update(int cid, Map<String, Object> map) {
        return 0;
    }



    @Override
    public List<Course> searchByClassId(int classId) {
        return null;
    }
}
