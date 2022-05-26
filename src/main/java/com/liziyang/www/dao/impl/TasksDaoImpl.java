package com.liziyang.www.dao.impl;

import com.liziyang.www.dao.TasksDao;
import com.liziyang.www.pojo.Student;
import com.liziyang.www.pojo.Tasks;
import com.liziyang.www.utils.JDBCTemplateUtils;
import com.liziyang.www.utils.JDBCUtils;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author 扬
 */
public class TasksDaoImpl implements TasksDao {
    private final JDBCTemplateUtils<Tasks> jdbc = new JDBCTemplateUtils<>();
    private String sql;

    @Override
    public int insert(Tasks tasks) {
        sql = "insert into tasks values(null,?,?,?,?,?,?,?,?)";
        Object[] objects = {tasks.getCourseId(), tasks.getSemester(), tasks.getSubjectName(),
                tasks.getProblemNumber(), tasks.getTotalScore(), tasks.getStartTime(),
                tasks.getEndTime(), tasks.getFinishNumber()};
        return jdbc.update(sql, objects);
    }

    @Override
    public int delete(int tid) {
        return 0;
    }

    @Override
    public List<Tasks> select(Integer tid) {
        sql = "select * from tasks";
        if (tid == null) {
            return jdbc.query(sql, null, Tasks.class);
        } else {
            Object[] objects = {tid};
            sql += " where taskid=?";
            return jdbc.query(sql, objects, Tasks.class);
        }
    }

    @Override
    public int update(int tid, Map<Field, Object> map) {
        return 0;
    }

    @Override
    public int searchLastTaskId() {
        sql = "select max(taskid) from " + jdbc.getTableName(Tasks.class);
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int taskId = 0;
        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                taskId = rs.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(rs, ps, conn);
        }
        return taskId;
    }

    @Override
    public int updateEndTimeById(int taskId, Timestamp endTime) {
        sql = "update tasks set starttime = ? , endTime = ? where taskid = ? ";
        Object[] objects = {new Timestamp(System.currentTimeMillis()), endTime, taskId};
        return jdbc.update(sql, objects);
    }

    @Override
    public int updateDetail(int taskId, String subjectName, int courseId, int size,int totalScore) {
        sql = "update tasks set subjectname = ? , course_id = ? , problemnumber =? ,totalScore = ? where taskid = ? ";
        Object[] objects={subjectName,courseId,size,totalScore,taskId};
        return jdbc.update(sql, objects);
    }

}
