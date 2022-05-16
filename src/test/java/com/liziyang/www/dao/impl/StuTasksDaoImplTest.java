package com.liziyang.www.dao.impl;

import com.liziyang.www.pojo.StuTasks;
import junit.framework.TestCase;

import java.util.List;

public class StuTasksDaoImplTest extends TestCase {

    public void testFindOnesTasks() {
        List<StuTasks> onesTasks = new StuTasksDaoImpl().findOnesTasks(5, 1);
        System.out.println(onesTasks);
    }
}