package com.liziyang.www.service;

import javax.servlet.http.HttpServletResponse;

public interface StudentTaskService {

    void showUserTasks(HttpServletResponse resp,String id);
}
