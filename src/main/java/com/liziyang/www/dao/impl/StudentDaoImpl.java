package com.liziyang.www.dao.impl;

import com.liziyang.www.dao.StudentDao;
import com.liziyang.www.pojo.Student;
import com.liziyang.www.utils.JDBCTemplateUtils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDaoImpl implements StudentDao {
    private final JDBCTemplateUtils<Student> jdbc =  new JDBCTemplateUtils<>();
    private String sql;

    @Override
    public int insert(Student student) {
        sql="insert into "+jdbc.getTableName(Student.class)+" values(?,?)";
        Object[] objects={student.getId(),student.getName()};
        return jdbc.update(sql,objects);
    }

    @Override
    public int delete(int sid) {
        return 0;
    }

    @Override
    public List<Student> select(int sid) {
        sql="select * from student where studentid = ?";
        Object[] objects={sid};
        return jdbc.query(sql,objects,Student.class);
    }

    @Override
    public int update(int id, Map<Field, Object> map) {
        return 0;
    }

    @Override
    public List<Student> findByCourseId(int courseId) {
        sql="select * from student as A , class_course as B , class as C where course_id = ? and A.classid = B.class_id and B.class_id = C.classId";
        Object[] objects={courseId};
        return jdbc.query(sql,objects,Student.class);
    }
}
