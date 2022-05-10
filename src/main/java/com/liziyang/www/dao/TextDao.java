package com.liziyang.www.dao;

import com.liziyang.www.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TextDao {
    public void insert() throws SQLException {
        Connection conn= JDBCUtils.getConnection();
        String sql="insert into student values(6,\"李四\");";
        Statement stm=conn.createStatement();
        int i = stm.executeUpdate(sql);
        System.out.println(i);
        JDBCUtils.close(null,stm,conn);

    }
}
