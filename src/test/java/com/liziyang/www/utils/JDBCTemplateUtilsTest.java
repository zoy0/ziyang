package com.liziyang.www.utils;

import com.liziyang.www.pojo.Student;
import com.liziyang.www.pojo.StudentTask;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;

public class JDBCTemplateUtilsTest extends TestCase {

    @Test
    public void testUpdate() {
        JDBCTemplateUtils<Student> utils = new JDBCTemplateUtils<>();
        Object[] objs1={8};
        StudentTask st=new StudentTask();
        Object[] objs2={11,3,st.getState(),"无"};
        Object[] objs3={8,7};
        //int i1 = utils.update("delete from student where id=?", objs1);
        int i2 = utils.update("insert into student_task VALUES(?,?,?,?)", objs2);
        //int i3 = utils.update("UPDATE student set id=? where id=?", objs3);
        //System.out.println(i1+"||"+i2+"||"+i3);
        System.out.println(i2);
    }

    @Test
    public void testQuery() throws InstantiationException, IllegalAccessException {
        JDBCTemplateUtils<StudentTask> utils = new JDBCTemplateUtils<>();
        Object[] objs1={5};
        //List<Student> list1 = utils.query("SELECT * FROM student_task where id=?", objs1, Student.class);
        List<StudentTask> list2 = utils.query("SELECT * FROM student_task", null, StudentTask.class);
        //System.out.println(list1);
        System.out.println(list2);
    }


    public void testGetTableName() {
        JDBCTemplateUtils<Student> utils=new JDBCTemplateUtils<>();

        System.out.println(utils.getTableName(Student.class));
    }
}