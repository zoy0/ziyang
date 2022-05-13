package com.liziyang.www.dao.impl;

import com.liziyang.www.dao.StudentTaskDao;
import com.liziyang.www.pojo.Student;
import com.liziyang.www.pojo.StudentTask;
import com.liziyang.www.pojo.Tasks;
import com.liziyang.www.utils.JDBCTemplateUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StudentTaskDaoImpl implements StudentTaskDao {
    private final JDBCTemplateUtils<StudentTask> jdbc =  new JDBCTemplateUtils<>();
    private StringBuffer sql;

    @Override
    public int insert(StudentTask studentTask) {
        sql=new StringBuffer("insert into student_task values(?,?,?,?,?)");
        Object[] objects={null,studentTask.getStudentId(),studentTask.getTasksId(),studentTask.getFinishNumber(), studentTask.getState().ordinal()};
        return jdbc.update(sql.toString(),objects);
    }

    @Override
    public List<StudentTask> select(Map<String, Object> map) {
        return jdbc.commonSelect(map,StudentTask.class);
    }

    @Override
    public int update(int id, Map<Field, Object> map) {
        return 0;
    }
}
