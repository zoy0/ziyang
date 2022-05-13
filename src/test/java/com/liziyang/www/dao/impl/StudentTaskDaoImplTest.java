package com.liziyang.www.dao.impl;

import com.liziyang.www.pojo.StudentTask;
import junit.framework.TestCase;

import java.util.HashMap;
import java.util.Map;

public class StudentTaskDaoImplTest extends TestCase {
    private final StudentTaskDaoImpl dao=new StudentTaskDaoImpl();
    public void testInsert() {
        StudentTask studentTask=new StudentTask(0,2,5,5, StudentTask.State.UNFINISH);

        System.out.println(dao.insert(studentTask));
    }

    public void testSelect() {
        Map<String,Object> map=new HashMap<>();
        map.put("task_id",3);

        System.out.println(dao.select(null));
    }

    public void testUpdate() {
    }
}