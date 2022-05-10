package com.liziyang.www.dao;

import com.liziyang.www.pojo.Tasks;
import com.liziyang.www.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TasksDao {

    public List<Tasks> select(){
        List list=new ArrayList<Tasks>();
        try {
            Connection conn= JDBCUtils.getConnection();
            String sql="select * from tasks";
            Statement stm=conn.createStatement();
            ResultSet resultSet = stm.executeQuery(sql);
            while(resultSet.next()){
                Tasks task=new Tasks(resultSet.getInt(1),resultSet.getString(2),
                        resultSet.getInt(3),resultSet.getInt(4),
                        resultSet.getTimestamp(5));
                list.add(task);
            }
            JDBCUtils.close(resultSet,stm,conn);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
}
