package com.liziyang.www.dao;

import com.liziyang.www.pojo.QuestionBank;

import java.util.List;

public interface QuestionBankDao {
    List<QuestionBank> findAllQuestion();
}
