package com.liziyang.www.dao.impl;

import com.liziyang.www.dao.QuestionBankDao;
import com.liziyang.www.pojo.QuestionBank;
import com.liziyang.www.utils.JDBCTemplateUtils;

import java.util.List;

public class QuestionBankDaoImpl implements QuestionBankDao {
    private final JDBCTemplateUtils<QuestionBank> utils=new JDBCTemplateUtils<>();
    private StringBuffer sql;

    @Override
    public List<QuestionBank> findAllQuestion() {
        sql=new StringBuffer("select * from "+utils.getTableName(QuestionBank.class));
        return utils.query(sql.toString(),null,QuestionBank.class);
    }
}
