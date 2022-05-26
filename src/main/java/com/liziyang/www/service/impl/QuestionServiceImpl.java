package com.liziyang.www.service.impl;

import com.liziyang.www.dao.impl.QuestionDaoImpl;
import com.liziyang.www.pojo.Question;
import com.liziyang.www.service.QuestionService;
import com.liziyang.www.utils.ServletUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class QuestionServiceImpl implements QuestionService {
    @Override
    public void showTaskQuestions(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String taskId= (String) req.getAttribute("{taskId}");
        List<Question> list = new QuestionDaoImpl().findByTaskId(Integer.parseInt(taskId));
        ServletUtils.write(resp,list);
    }
}
