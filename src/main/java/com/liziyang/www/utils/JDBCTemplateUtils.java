package com.liziyang.www.utils;

import com.liziyang.www.annotation.TableField;
import com.liziyang.www.annotation.TableName;
import com.liziyang.www.pojo.AClass;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class JDBCTemplateUtils<T> {
    private Connection conn = null;
    private PreparedStatement ps = null;
    private Class<T> aClass;

    public int update(String sql, Object[] objs) {
        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            for (int i = 1; i <= objs.length; i++) {
                ps.setObject(i, objs[i - 1]);
            }
            return ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(null, ps, conn);
        }
        return 0;
    }

    public List<T> query(String sql, Object[] objs, Class<T> c)  {
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            if (objs != null) {
                for (int i = 1; i <= objs.length; i++) {
                    ps.setObject(i, objs[i - 1]);
                }
            }
            rs = ps.executeQuery();
            return put(rs, c);
        } catch (SQLException | InstantiationException | IllegalAccessException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(rs, ps, conn);
        }
        return null;
    }

    private List<T> put(ResultSet rs, Class<T> c) throws InstantiationException, IllegalAccessException, SQLException {
        List<T> list = new ArrayList<>();
        while (rs.next()) {
            T t = null;
            t = c.newInstance();
            Field[] fields = c.getDeclaredFields();
            Method[] methods = c.getMethods();
            for (Field f :
                    fields) {
                if (f.isAnnotationPresent(TableField.class)) {
                    TableField tableField = f.getAnnotation(TableField.class);
                    String value = tableField.value();
                    char[] chars = f.getName().toCharArray();
                    if (chars[0] >= 'a' && chars[0] <= 'z') {
                        chars[0] -= 32;
                    }
                    String name = new String(chars);
                    if (f.getType().isEnum()) {
                        try {
                            Method m = f.getType().getMethod("values");
                            Object[] enumValues = (Object[]) m.invoke(t);
                            Method method = c.getMethod("set" + name, f.getType());
                            method.invoke(t, enumValues[rs.getInt(value)]);
                        } catch (InvocationTargetException | NoSuchMethodException e) {
                            e.printStackTrace();
                        }
                    } else {
                        try {
                            Method method = c.getMethod("set" + name, f.getType());
                            Object o=rs.getObject(value);
                            try {
                                method.invoke(t, o);
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            } catch (IllegalArgumentException e) {
                                e.printStackTrace();
                            }
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

    public  String getTableName(Class<?> clazz) {
        return clazz.getAnnotation(TableName.class).value();
    }

    public List<T> commonSelect( Map<String,Object> map,Class<T> clazz){
        StringBuffer sql = new StringBuffer("select * from  "+getTableName(clazz));
        if (map==null) {
            return query(sql.toString(),null, clazz);
        }else {
            sql.append(" where ");
            Set<String> set = map.keySet();
            int i=0;
            ArrayList<Object> arrayList=new ArrayList<>();
            for (String s:
                    set) {
                sql.append(s).append(" = ? ");
                if (++i!=set.size()) {
                    sql.append( "and ");
                }
                arrayList.add(map.get(s));
            }
            return query(sql.toString(),arrayList.toArray(),clazz);
        }
    }


}
