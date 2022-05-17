package com.liziyang.www.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface StudentTaskService {


    void showUserTasks(HttpServletRequest req, HttpServletResponse resp);
}
