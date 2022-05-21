package com.liziyang.www.dao.impl;

import com.liziyang.www.dao.AClassDao;
import com.liziyang.www.pojo.AClass;
import com.liziyang.www.pojo.StudentTask;
import com.liziyang.www.utils.JDBCTemplateUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AClassDaoImpl implements AClassDao {
    private final JDBCTemplateUtils<AClass> jdbc =  new JDBCTemplateUtils<>();
    private StringBuffer sql;



    @Override
    public int delete(int cid) {
        return 0;
    }



    @Override
    public int update(int cid, Map<String, Object> map) {
        return 0;
    }

    @Override
    public List<AClass> findAllClass() {
        sql=new StringBuffer("select class_name ,count(*) as course_id from student group by class_name");
        return jdbc.query(sql.toString(),null,AClass.class);
    }
}
