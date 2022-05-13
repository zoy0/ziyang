package com.liziyang.www.dao;

import com.liziyang.www.pojo.Student;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

/**
 * @author 扬
 */
public interface StudentDao {
    /**
     * 插入数据
     * @param student
     * @return
     */
    int insert(Student student);

    /**
     * 删除数据
     * @param sid
     * @return
     */
    int delete(int sid);

    /**
     * 查找数据
     * @param sid
     * @return
     */
    List<Student> select(int sid);

    /**
     * 修改数据
     * @param id
     * @param map
     * @return
     */
    int update(int id, Map<Field,Object> map);



}
