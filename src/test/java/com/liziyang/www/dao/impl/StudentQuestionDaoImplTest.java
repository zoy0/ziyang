package com.liziyang.www.dao.impl;

import junit.framework.TestCase;

public class StudentQuestionDaoImplTest extends TestCase {

    public void testUpdateById() {
        Object[] objects={"\"嗯2嗯\"",2,"1",1};
        int i = new StudentQuestionDaoImpl().updateById(objects, 2, 2, 2);
        System.out.println(i);
    }
}