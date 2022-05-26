package com.liziyang.www.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface QuestionService {
    void showTaskQuestions(HttpServletRequest req, HttpServletResponse resp) throws IOException;
}
