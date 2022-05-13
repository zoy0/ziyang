package com.liziyang.www.dao.impl;

import junit.framework.TestCase;

import java.util.HashMap;
import java.util.Map;

public class StudentTaskDaoImplTest extends TestCase {

    public void testInsert() {
    }

    public void testSelect() {
        StudentTaskDaoImpl dao=new StudentTaskDaoImpl();
        Map<String,Object> map=new HashMap<>();
        map.put("task_id",3);

        System.out.println(dao.select(map));
    }

    public void testUpdate() {
    }
}