package com.liziyang.www.dao.impl;

import com.liziyang.www.pojo.StuQuestion;
import junit.framework.TestCase;

import java.util.List;

public class StuQuestionDaoImplTest extends TestCase {

    public void testFindStuQuestions() {
        List<StuQuestion> list = new StuQuestionDaoImpl().findStuQuestions(1, 7);
        System.out.println(list.size());
    }
}