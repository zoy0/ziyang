package com.liziyang.www.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/text/user/*")
public class demo02Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String s="{" +
                "    \"sites\": [\n" +
                "    { \"name\":\"demo02\" , \"url\":\"www.runoob.com\" }, \n" +
                "    { \"name\":\"google\" , \"url\":\"www.google.com\" }, \n" +
                "    { \"name\":\"微博\" , \"url\":\"www.weibo.com\" }\n" +
                "    ]\n" +
                "}";
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(s);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
