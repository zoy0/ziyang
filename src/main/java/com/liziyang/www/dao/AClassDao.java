package com.liziyang.www.dao;

import com.liziyang.www.pojo.AClass;
import com.liziyang.www.pojo.Student;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

public interface AClassDao {


    /**
     * 删除数据
     * @param cid
     * @return
     */
    int delete(int cid);



    /**
     * 修改数据
     * @param cid
     * @param map
     * @return
     */
    int update(int cid, Map<String,Object> map);

    List<AClass> findAllClass();
}
