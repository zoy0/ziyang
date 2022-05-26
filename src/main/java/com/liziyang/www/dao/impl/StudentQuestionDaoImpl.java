package com.liziyang.www.dao.impl;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.liziyang.www.dao.StudentQuestionDao;
import com.liziyang.www.pojo.Question;
import com.liziyang.www.pojo.Student;
import com.liziyang.www.pojo.StudentQuestion;
import com.liziyang.www.utils.JDBCTemplateUtils;
import com.liziyang.www.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class StudentQuestionDaoImpl implements StudentQuestionDao {
    private final JDBCTemplateUtils<StudentQuestion> utils = new JDBCTemplateUtils<>();
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
    public int updateById(Object[] objects, int taskId, int studentId, int length) {
        sql = new StringBuffer();
        for (int i = 0; i < length; i++) {
            sql.append(" update student_question set student_answer =  ?  where taskId = " + taskId + " and studentid = " + studentId + " and question_id= ? ;\t");
        }
        return utils.update(sql.toString(), objects);
    }

    @Override
    public int insertAll(int studentId, List<Question> questions) {
        sql = new StringBuffer();
        for (Question question :
                questions) {
            sql.append("insert into student_question values( " + question.getTaskId() + " ," + studentId + " , " + question.getQuestionId() + " , null , 0) ;");
        }
        try {
            return utils.update(sql.toString(), null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updateByArrays(int taskId, List<Student> students, JsonArray deletedQuestion, JsonArray insertedQuestion) {
        Connection conn = null;
        PreparedStatement st = null;
        List<Object> objectList = new LinkedList<>();

        try {
            conn = JDBCUtils.getConnection();
            conn.setAutoCommit(false);
            sql = new StringBuffer();
            //有则删除
            if (deletedQuestion.size() != 0) {
                for (JsonElement dq :
                        deletedQuestion) {
                    int deletedQuestionId = dq.getAsJsonObject().get("questionId").getAsInt();
                    sql.append("delete from student_question where taskid = " + taskId + " and question_id = " + deletedQuestionId + " ;");
                }
                st = conn.prepareStatement(sql.toString());
                st.executeUpdate();
                sql = new StringBuffer();
            }

            if (insertedQuestion.size() != 0) {
                for (JsonElement iq :
                        insertedQuestion) {
                    for (Student student :
                            students) {
                        int insertedQuestionId = iq.getAsJsonObject().get("questionId").getAsInt();
                        int studentId = student.getId();
                        sql.append("insert into studentQuestion values( " + taskId + " , " + studentId + ", " + insertedQuestionId + " , null , 0) ;");
                    }
                }
                st = conn.prepareStatement(sql.toString());
                st.executeUpdate();
            }
        } catch (SQLException throwables) {
            //如果失败则回滚事务
            try {
                conn.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            throwables.printStackTrace();
            return 0;
        }finally {
            JDBCUtils.close(null,st,conn);
        }

        return 1;
    }

    @Override
    public int deleteByTaskId(int taskId) {
        sql=new StringBuffer("delete from student_question where taskid = "+taskId);
        return utils.update(sql.toString(),null);
    }

}
