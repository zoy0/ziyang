package com.liziyang.www.dao.impl;

import com.liziyang.www.pojo.Tasks;
import junit.framework.TestCase;

import java.sql.Timestamp;

public class TasksDaoImplTest extends TestCase {

    public void testInsert() {
        Tasks tasks = new Tasks(0,"Chinese",20,50,new Timestamp(System.currentTimeMillis()));
        System.out.println(new TasksDaoImpl().insert(tasks));
    }

    public void testDelete() {

    }

    public void testSelect() {
        TasksDaoImpl dao = new TasksDaoImpl();
        System.out.println(dao.select(null));
        System.out.println(dao.select(2));
    }

}