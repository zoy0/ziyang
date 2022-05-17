package com.liziyang.www.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface StudentQuestionService {
    void showQuestions(HttpServletRequest req, HttpServletResponse resp);
}
