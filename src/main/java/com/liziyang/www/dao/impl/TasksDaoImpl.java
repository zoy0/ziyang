package com.liziyang.www.dao.impl;

import com.liziyang.www.dao.TasksDao;
import com.liziyang.www.pojo.Student;
import com.liziyang.www.pojo.Tasks;
import com.liziyang.www.utils.JDBCTemplateUtils;
import com.liziyang.www.utils.JDBCUtils;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author 扬
 */
public class TasksDaoImpl implements TasksDao {
    private final JDBCTemplateUtils<Tasks> jdbc =  new JDBCTemplateUtils<>();
    private String sql;

    @Override
    public int insert(Tasks tasks) {
        sql = "insert into tasks values(?,?,?,?,?)";
        Object[] objects = {tasks.getTaskId(), tasks.getSubjectName(), tasks.getProblemNumber(), tasks.getTotalScore(),
                            tasks.getEndTime()};
        return jdbc.update(sql,objects);
    }

    @Override
    public int delete(int tid) {
        return 0;
    }

    @Override
    public List<Tasks> select(Integer tid) {
        sql = "select * from tasks";
        if (tid==null) {
            return jdbc.query(sql,null,Tasks.class);
        }else {
            Object[] objects={tid};
            sql+=" where taskid=?";
            return jdbc.query(sql,objects,Tasks.class);
        }
    }

    @Override
    public int update(int tid, Map<Field, Object> map) {
        return 0;
    }

}
