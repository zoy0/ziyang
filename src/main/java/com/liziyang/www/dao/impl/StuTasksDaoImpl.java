package com.liziyang.www.dao.impl;

import com.liziyang.www.dao.StuTasksDao;
import com.liziyang.www.pojo.StuTasks;
import com.liziyang.www.pojo.StudentTask;
import com.liziyang.www.pojo.Tasks;
import com.liziyang.www.utils.JDBCTemplateUtils;

import java.util.List;

public class StuTasksDaoImpl implements StuTasksDao {
     private final JDBCTemplateUtils<StuTasks> utils=new JDBCTemplateUtils<>();
     StringBuffer sql;

    @Override
    public List<StuTasks> findOnesTasks(int studentId, int courseId) {
        sql=new StringBuffer("select * from "+utils.getTableName(Tasks.class)+","+utils.getTableName(StudentTask.class)
                            +" where course_id = ? and student_id = ? and taskid = task_id");
        Object[] objects={courseId,studentId};
        return  utils.query(sql.toString(), objects, StuTasks.class);
    }
}
