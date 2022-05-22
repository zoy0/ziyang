package com.liziyang.www.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liziyang.www.dao.impl.StudentTaskDaoImpl;
import com.liziyang.www.pojo.StudentTask;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ServletUtils {
    public static void write(HttpServletResponse resp, Object obj) throws IOException {
        ObjectMapper mapper=new ObjectMapper();
        String s = mapper.writeValueAsString(obj);
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter out= resp.getWriter();
        out.write(s);
        out.close();
        out.flush();
    }

    public static String getParameter(String uri,int i) {
        String[] vals = uri.split("/");
        if (i< vals.length+1){
            return vals[i];
        }else {
            return null;
        }

    }
}
