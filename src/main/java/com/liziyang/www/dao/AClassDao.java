package com.liziyang.www.dao;

import com.liziyang.www.pojo.AClass;
import com.liziyang.www.pojo.Student;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

public interface AClassDao {
    /**
     * 插入数据
     * @param aClass
     * @return
     */
    int insert(AClass aClass);

    /**
     * 删除数据
     * @param cid
     * @return
     */
    int delete(int cid);

    /**
     * 查找数据
     * @param cid
     * @return
     */
    List<AClass> select(Map<String, Object> map);

    /**
     * 修改数据
     * @param cid
     * @param map
     * @return
     */
    int update(int cid, Map<String,Object> map);

    List<AClass> findAllClass();
}
