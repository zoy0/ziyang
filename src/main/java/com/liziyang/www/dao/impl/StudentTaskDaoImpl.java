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
        sql=new StringBuffer("insert into student_task values(?,?,?,?)");
        Object[] objects={studentTask.getStudentId(),studentTask.getTasksId(),studentTask.getState(),studentTask.getAnswer()};
        return jdbc.update(sql.toString(),objects);
    }

    @Override
    public List<StudentTask> select(Map<String, Object> map) {
        sql = new StringBuffer("select * from student_task ");
        if (map==null) {
            return jdbc.query(sql.toString(),null, StudentTask.class);
        }else {
            sql.append("where ");
            Set<String> set = map.keySet();
            int i=0;
            ArrayList<Object> arrayList=new ArrayList<>();
            for (String s:
                 set) {
                sql.append(s).append(" = ? ");
                if (++i!=set.size()) {
                    sql.append( "and ");
                }
                arrayList.add(map.get(s));
            }
            return jdbc.query(sql.toString(),arrayList.toArray(),StudentTask.class);
        }
    }

    @Override
    public int update(int id, Map<Field, Object> map) {
        return 0;
    }
}
