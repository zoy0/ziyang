package com.liziyang.www.dao;

import com.liziyang.www.pojo.AClass;
import com.liziyang.www.pojo.Question;

import java.util.List;
import java.util.Map;

public interface QuestionDao {
    /**
     * 插入数据
     * @param question
     * @return
     */
    int insert(Question question);

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
    List<Question> select(Integer qid);

    /**
     * 修改数据
     * @param qid
     * @param map
     * @return
     */
    int update(int qid, Map<String,Object> map);
}
