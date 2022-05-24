package com.liziyang.www.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface StudentQuestionService {
    void showQuestions(HttpServletRequest req, HttpServletResponse resp);

    void submitAnswer(HttpServletRequest req, HttpServletResponse resp) throws IOException;
}
