package com.liziyang.www.dao;

import com.liziyang.www.pojo.Student;
import com.liziyang.www.pojo.Tasks;

import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 * @author 扬
 */
public interface TasksDao {

    /**
     * 插入数据
     *
     * @param tasks
     * @return
     */
    int insert(Tasks tasks);

    /**
     * 删除数据
     *
     * @param tid
     * @return
     */
    int delete(int tid);

    /**
     * 查找数据
     *
     * @param tid
     * @return
     */
    List<Tasks> select(Integer tid);

    /**
     * 修改数据
     *
     * @param tid
     * @param map
     * @return
     */
    int update(int tid, Map<Field, Object> map);

    int searchLastTaskId();

    int updateEndTimeById(int taskId, Timestamp endTime);

    int updateDetail(int taskId, String subjectName, int courseId, int size,int totalScore);
}
