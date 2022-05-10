package com.liziyang.www.dao;

import org.junit.Test;

import java.sql.SQLException;

public class TextDaoTest {

    @Test
    public void textFact(){
        try {
            new TextDao().insert();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
