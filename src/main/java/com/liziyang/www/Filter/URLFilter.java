package com.liziyang.www.Filter;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.liziyang.www.utils.AnnotationUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;
import java.util.*;

@WebFilter("/*")
public class URLFilter implements Filter {
    static final String FUZZY_MAP = "fuzzyServletMap";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        String uri = req.getRequestURI();
        if (uri.contains("html")) {
            filterChain.doFilter(servletRequest, servletResponse);
        }
        if (servletRequest.getServletContext().getAttribute(FUZZY_MAP) == null) {
            Set<Class<?>> classes = AnnotationUtils.getClasses("com.liziyang.www.controller");
            Map<String, int[]> servletFuzzyMap = AnnotationUtils.getServletFuzzyMap(classes);
            servletRequest.getServletContext().setAttribute(FUZZY_MAP, servletFuzzyMap);
        }
        Map<String, int[]> servletFuzzyMap = (Map<String, int[]>) servletRequest.getServletContext().getAttribute(FUZZY_MAP);
        String[] uriArray = uri.split("/");
        Set<String> uriFuzzySet = servletFuzzyMap.keySet();
        for (String s :
                uriFuzzySet) {
            String[] split = s.split("/");
            if (split.length == uriArray.length || split.length == uriArray.length + 1) {
                int[] fuzzyOrder = servletFuzzyMap.get(s);
                StringBuffer s1 =null;
                for (int i :
                        fuzzyOrder) {
                    if (i == uriArray.length) {
                        s1=splicing(uriArray);
                        s1 .append("/").append(split[i]);
                    } else {
                        uriArray[i] = split[i];
                    }
                }
                if (s1 == null) {
                    s1 = splicing(uriArray);
                }
                if (s.equals(s1.toString())) {
                    uriArray=uri.split("/");
                    HttpServletResponse resp = (HttpServletResponse) servletResponse;
                    for (int i:
                         fuzzyOrder) {
                        if (i!=uriArray.length) {
                            req.setAttribute(split[i],uriArray[i]);
                        }
                    }
                    req.getRequestDispatcher(s).forward(servletRequest,servletResponse);
                }
            }
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }

    StringBuffer splicing(String[] s){
        StringBuffer stringBuffer=new StringBuffer();
        for (String o:
                s) {
            if (!o.equals("")) {
                stringBuffer.append("/").append(o);
            }
        }
        return stringBuffer;
    }
}
