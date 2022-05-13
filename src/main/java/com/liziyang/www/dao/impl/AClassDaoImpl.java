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
    public int insert(AClass aClass) {
        sql=new StringBuffer("insert into student_task values(?,?)");
        Object[] objects={aClass.getClassName(),aClass.getCourseId()};
        return jdbc.update(sql.toString(),objects);
    }

    @Override
    public int delete(int cid) {
        return 0;
    }

    @Override
    public List<AClass> select(Map<String, Object> map) {
        return jdbc.commonSelect(map,AClass.class);
    }

    @Override
    public int update(int cid, Map<String, Object> map) {
        return 0;
    }
}
