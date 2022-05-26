package com.liziyang.www.dao.impl;

import com.liziyang.www.dao.StudentQuestionDao;
import com.liziyang.www.pojo.Question;
import com.liziyang.www.pojo.StudentQuestion;
import com.liziyang.www.utils.JDBCTemplateUtils;

import java.util.List;
import java.util.Map;

public class StudentQuestionDaoImpl implements StudentQuestionDao {
    private final JDBCTemplateUtils<StudentQuestion> utils=new JDBCTemplateUtils<>();
    private StringBuffer sql;

    @Override
    public int insert(StudentQuestion studentQuestion) {
        return 0;
    }

    @Override
    public int delete(int qid) {
        return 0;
    }

    @Override
    public List<StudentQuestion> select(Integer qid) {
        return null;
    }

    @Override
    public int updateById(Object[] objects,int taskId,int studentId ,int length){
        sql=new StringBuffer();
        for (int i = 0; i < length; i++) {
            sql.append(" update student_question set student_answer =  ?  where taskId = "+taskId+" and studentid = "+studentId+" and question_id= ? ;\t");
        }
        return utils.update(sql.toString(),objects);
    }

    @Override
    public int insertAll(int studentId, List<Question> questions) {
        sql=new StringBuffer();
        for (Question question:
             questions) {
            sql.append("insert into student_question values( "+question.getTaskId()+" ,"+studentId+" , "+question.getQuestionId()+" , null , 0) ;");
        }
        try {
            return utils.update(sql.toString(),null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

}
