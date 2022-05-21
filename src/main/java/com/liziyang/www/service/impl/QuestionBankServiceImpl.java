package com.liziyang.www.service.impl;

import com.liziyang.www.dao.impl.QuestionBankDaoImpl;
import com.liziyang.www.pojo.QuestionBank;
import com.liziyang.www.service.QuestionBankService;
import com.liziyang.www.utils.ServletUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class QuestionBankServiceImpl implements QuestionBankService {
    @Override
    public void showQuestionBank(HttpServletRequest req, HttpServletResponse resp) {
        List<QuestionBank> list = new QuestionBankDaoImpl().findAllQuestion();
        try {
            ServletUtils.write(resp,list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
