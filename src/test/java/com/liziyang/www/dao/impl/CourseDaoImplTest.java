package com.liziyang.www.dao.impl;

import com.liziyang.www.pojo.Course;
import com.liziyang.www.utils.JDBCTemplateUtils;
import junit.framework.TestCase;

public class CourseDaoImplTest extends TestCase {

    private final CourseDaoImpl dao=new CourseDaoImpl();

    public void testInsert() {
        Course course=new Course(0,"C语言程序设计","广工",5,40);
        System.out.println(dao.insert(course));
    }

    public void testDelete() {
    }

    public void testSelect() {
    }

    public void testUpdate() {
    }
}