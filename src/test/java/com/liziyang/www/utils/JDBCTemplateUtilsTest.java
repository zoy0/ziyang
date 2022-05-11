package com.liziyang.www.utils;

import com.liziyang.www.pojo.Student;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;

public class JDBCTemplateUtilsTest extends TestCase {

    @Test
    public void testUpdate() {
        JDBCTemplateUtils<Student> utils = new JDBCTemplateUtils<>();
        Object[] objs1={8};
        Object[] objs2={11,"小强"};
        Object[] objs3={8,7};
        int i1 = utils.update("delete from student where id=?", objs1);
        int i2 = utils.update("insert into student VALUES(?,?)", objs2);
        int i3 = utils.update("UPDATE student set id=? where id=?", objs3);
        System.out.println(i1+"||"+i2+"||"+i3);
    }

    @Test
    public void testQuery() throws InstantiationException, IllegalAccessException {
        JDBCTemplateUtils<Student> utils = new JDBCTemplateUtils<>();
        Object[] objs1={5};
        List<Student> list1 = utils.query("SELECT * FROM student where id=?", objs1, Student.class);
        List<Student> list2 = utils.query("SELECT * FROM student", null, Student.class);
        System.out.println(list1);
        System.out.println(list2);
    }
}