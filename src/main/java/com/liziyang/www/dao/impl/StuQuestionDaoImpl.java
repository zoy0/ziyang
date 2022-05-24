package com.liziyang.www.dao.impl;

import com.liziyang.www.dao.StuQuestionDao;
import com.liziyang.www.pojo.*;
import com.liziyang.www.utils.JDBCTemplateUtils;

import java.util.List;

public class StuQuestionDaoImpl implements StuQuestionDao {
    private final JDBCTemplateUtils<StuQuestion> utils=new JDBCTemplateUtils<>();
    StringBuffer sql;

    @Override
    public List<StuQuestion> findStuQuestions(int studentId, int taskId) {
        sql=new StringBuffer("select * from "+utils.getTableName(Question.class)+" as A,"+utils.getTableName(StudentQuestion.class)
                +" as B where B.studentid = ? and B.taskid = ? and A.question_id=B.question_id and A.task_id = B.taskid");
        Object[] objects={studentId,taskId};
        return  utils.query(sql.toString(), objects, StuQuestion.class);
    }
}
