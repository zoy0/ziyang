package com.liziyang.www.dao.impl;

import com.liziyang.www.dao.StudentDao;
import com.liziyang.www.pojo.Student;
import com.liziyang.www.utils.JDBCTemplateUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

public class StudentDaoImpl implements StudentDao {
    private final JDBCTemplateUtils<Student> jdbc =  new JDBCTemplateUtils<>();
    private String sql;

    @Override
    public int insert(Student student) {
        sql="insert into "+jdbc.getTableName()+" values(?,?)";
        Object[] objects={student.getId(),student.getName()};
        return jdbc.update(sql,objects);
    }

    @Override
    public int delete(int sid) {
        return 0;
    }

    @Override
    public List<Student> select(int sid) {
        return null;
    }

    @Override
    public int update(int id, Map<Field, Object> map) {
        return 0;
    }
}
