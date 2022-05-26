package com.liziyang.www.dao;

import com.liziyang.www.pojo.Student;
import com.liziyang.www.pojo.StudentQuestion;
import com.liziyang.www.pojo.StudentTask;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

/**
 * @author 扬
 */
public interface StudentTaskDao {

    /**
     * 插入数据
     * @param studentTask
     * @return
     */
    int insert(StudentTask studentTask);


    /**
     *查找数据
     * @param map
     * @return
     */
    List<StudentTask> select(Map<String,Object> map);

    /**
     * 修改数据
     * @param id
     * @param map
     * @return
     */
    int update(int id, Map<Field,Object> map);

    int updateAnswer(StudentQuestion studentQuestion);

    int deleteByTaskId(int taskId);

    int insertAll(List<Student> students, int taskId);


    int updateFinishedTask(int studentId, int taskId, int finishNumber);
}
