package com.liziyang.www.dao;

import com.liziyang.www.pojo.AClass;
import com.liziyang.www.pojo.Course;

import java.util.List;
import java.util.Map;

public interface CourseDao {
    /**
     * 插入数据
     * @param course
     * @return
     */
    int insert(Course course);

    /**
     * 删除数据
     * @param cid
     * @return
     */
    int delete(int cid);

    /**
     * 查找数据
     * @param map
     * @return
     */
    List<Course> select(Map<String, Object> map);

    /**
     * 修改数据
     * @param cid
     * @param map
     * @return
     */
    int update(int cid, Map<String,Object> map);



    List<Course> searchByCourseId(List<Integer> courseId);
}
