package com.liziyang.www.dao;

import com.liziyang.www.pojo.AClass;
import com.liziyang.www.pojo.Question;
import com.liziyang.www.pojo.StudentQuestion;

import java.util.List;
import java.util.Map;

public interface StudentQuestionDao {
    /**
     * 插入数据
     * @param studentQuestion
     * @return
     */
    int insert(StudentQuestion studentQuestion);

    /**
     * 删除数据
     * @param qid
     * @return
     */
    int delete(int qid);

    /**
     * 查找数据
     * @param qid
     * @return
     */
    List<StudentQuestion> select(Integer qid);

    int updateById(Object[] objects,int taskId,int studentId ,int length);

    int insertAll(int studentId, List<Question> questions);
}
