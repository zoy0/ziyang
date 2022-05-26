package com.liziyang.www.dao.impl;

import com.liziyang.www.dao.StudentTaskDao;
import com.liziyang.www.pojo.Student;
import com.liziyang.www.pojo.StudentQuestion;
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

    @Override
    public int updateAnswer(StudentQuestion studentQuestion) {
//        sql=new StringBuffer("update "+jdbc.getTableName(StudentQuestion.class)+ " set student_answer=? where student_task_id=? and question_id=?");
//        Object[] objects={studentQuestion.getStudentAnswer(),studentQuestion.getStudentTaskId(),studentQuestion.getQuestionId()};
//        return jdbc.update(sql.toString(),objects);
        return 0;
    }

    @Override
    public int deleteByTaskId(int taskId) {
        sql=new StringBuffer("delete from student_task where task_id = "+taskId);
        return jdbc.update(sql.toString(),null);
    }

    @Override
    public int insertAll(List<Student> students, int taskId) {
        sql=new StringBuffer("insert into student_task values ");
        for (Student s:
             students) {
            sql.append(" (null,"+s.getId()+","+taskId+",0,0) ,");
        }
        return jdbc.update(sql.substring(0,sql.lastIndexOf(",")),null);
    }

    @Override
    public int updateFinishedTask(int studentId, int taskId, int finishNumber) {
        sql=new StringBuffer("update student_task set finish_number = ? , state = 1 where student_id= ? and task_id = ?");
        Object[] objects={finishNumber,studentId,taskId};
        return jdbc.update(sql.toString(),objects);
    }


}
