package com.liziyang.www.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface TaskService {
    void showTask(HttpServletRequest req, HttpServletResponse resp);

    void addTask(HttpServletRequest req, HttpServletResponse resp) throws IOException;

    void publishTask(HttpServletRequest req, HttpServletResponse resp, String params) throws IOException;

    void modifyTask(HttpServletRequest req, HttpServletResponse resp, String params) throws IOException;

}
