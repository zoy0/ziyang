package com.liziyang.www.utils;

import com.liziyang.www.annotation.TableField;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JDBCTemplateUtils<T> {
    private Connection conn = null;
    private PreparedStatement ps = null;
    private Class<T> aClass;

    public  int update(String sql, Object[] objs) {
        try {
            conn = JDBCUtils.getConnection();
            ps =conn.prepareStatement(sql);
            for (int i = 1; i <=objs.length ; i++) {
                ps.setObject(i,objs[i-1]);
            }
            return ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(null,ps,conn);
        }
        return 0;
    }

    public List<T> query(String sql, Object[] objs,Class<T> c) throws InstantiationException, IllegalAccessException {
        ResultSet rs=null;
        try {
            conn = JDBCUtils.getConnection();
            ps =conn.prepareStatement(sql);
            if (objs!=null) {
                for (int i = 1; i <=objs.length ; i++) {
                    ps.setObject(i,objs[i-1]);
                }
            }
            rs = ps.executeQuery();
            return  put(rs,c);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(rs,ps,conn);
        }
        return null;
    }

    private List<T> put(ResultSet rs, Class<T> c) throws SQLException, InstantiationException, IllegalAccessException {
        List<T> list=new ArrayList<>();
        while(rs.next()){
            T t=c.newInstance();
            Field[] fields = c.getDeclaredFields();
            Method[] methods = c.getMethods();
            for (Field f:
                 fields) {
                if (f.isAnnotationPresent(TableField.class)){
                    TableField tableField=f.getAnnotation(TableField.class);
                    String value = tableField.value();
                    char[] chars = f.getName().toCharArray();
                    if (chars[0]>='a'&&chars[0]<='z') {
                        chars[0]-=32;
                    }
                    String name= new String(chars);
                    if (f.getType().isEnum()){
                        try {
                            Method m=f.getType().getMethod("values");
                            Object[] enumValues =(Object[]) m.invoke(t);
                            Method method = c.getMethod("set" + name, f.getType());
                            method.invoke(t,enumValues[rs.getInt(value)]);
                        } catch (InvocationTargetException | NoSuchMethodException e) {
                            e.printStackTrace();
                        }
                    } else {
                        try {
                            Method method = c.getMethod("set" + name, f.getType());
                            method.invoke(t, rs.getObject(value));
                        } catch (NoSuchMethodException | InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            list.add(t);
        }
        return list;

    }




}
