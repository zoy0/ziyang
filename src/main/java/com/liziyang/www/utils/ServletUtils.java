package com.liziyang.www.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liziyang.www.dao.impl.StudentTaskDaoImpl;
import com.liziyang.www.pojo.StudentTask;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ServletUtils {
    public static void write(HttpServletResponse resp, Object obj) throws IOException {
        ObjectMapper mapper=new ObjectMapper();
        String s = mapper.writeValueAsString(obj);
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(s);
    }
}
