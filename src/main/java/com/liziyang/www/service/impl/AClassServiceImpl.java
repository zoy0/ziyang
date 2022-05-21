package com.liziyang.www.service.impl;

import com.liziyang.www.dao.impl.AClassDaoImpl;
import com.liziyang.www.pojo.AClass;
import com.liziyang.www.service.AClassService;
import com.liziyang.www.utils.ServletUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AClassServiceImpl implements AClassService {

    @Override
    public void showAllClass(HttpServletRequest req, HttpServletResponse resp) {
        List<AClass> list = new AClassDaoImpl().findAllClass();
        try {
            ServletUtils.write(resp,list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
