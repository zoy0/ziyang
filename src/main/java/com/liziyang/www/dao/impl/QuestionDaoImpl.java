package com.liziyang.www.dao.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.liziyang.www.dao.QuestionDao;
import com.liziyang.www.pojo.Question;
import com.liziyang.www.pojo.QuestionBank;
import com.liziyang.www.utils.JDBCTemplateUtils;

import java.nio.Buffer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class QuestionDaoImpl implements QuestionDao {

    JDBCTemplateUtils<Question> utils = new JDBCTemplateUtils<>();
    StringBuffer sql;


    @Override
    public int insertAll(JsonArray questions, int taskId) {
        sql = new StringBuffer("insert into " + utils.getTableName(Question.class));
        List<Object> list=new LinkedList<>();
        ObjectMapper mapper = new ObjectMapper();
        for (int i=0;i<questions.size();i++) {
            Question q= null;
            try {
                q = mapper.readValue(questions.get(i).toString(),Question.class);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            if (i!=0) {
                sql.append(" , ");
            }else {
                sql.append(" values");
            }
            sql.append(" (?,?,?,?,?,?,null) ");
            list.add(q.getQuestionId());
            list.add(taskId);
            list.add(q.getQuestionType().ordinal());
            list.add(q.getQuestionContent());
            list.add(q.getQuestionOption());
            list.add(q.getFullScore());
        }
        return utils.update(sql.toString(),list.toArray());
    }

    @Override
    public List<Question> findByTaskId(int taskId) {
        sql=new StringBuffer("select * from question where task_id = ?");
        Object[] objects={taskId};
        return utils.query(sql.toString(),objects,Question.class);
    }

    @Override
    public int updateOrInsert(int taskId, JsonArray submittedQuestion) {
        sql = new StringBuffer("insert into question(question_id,task_id,question_type,question_content,question_option,full_score,right_answer) VALUES ");
        ObjectMapper mapper = new ObjectMapper();
        List<Object> list=new LinkedList<>();
        for (int i = 0; i < submittedQuestion.size(); i++) {
            try {
                Question question = mapper.readValue(submittedQuestion.get(i).toString(),Question.class);
                if (i!=0) {
                    sql.append(",");
                }
                sql.append("( "+question.getQuestionId()+" ,"+taskId+" , "+question.getQuestionType().ordinal()+" , ? ,? , "+question.getFullScore()+" ,null ) " );
                list.add(question.getQuestionContent());
                list.add(question.getQuestionOption());
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        sql.append(" ON DUPLICATE KEY UPDATE full_score=VALUES(full_score);");
        return utils.update(sql.toString(),list.toArray());
    }


}
