package com.liziyang.www.utils;

import com.liziyang.www.annotation.FuzzyValues;
import com.liziyang.www.controller.CourseServlet;
import com.sun.tools.javac.code.Attribute;

import javax.servlet.annotation.WebServlet;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.*;

public class AnnotationUtils {
    public static Set<Class<?>> getClasses(String packageName){
        Set<Class<?>> set=new HashSet<>();
        String packageDirName = packageName.replace(".","/");
        try {
            //获得存储class文件的包的url的枚举类
            Enumeration<URL> resources = Thread.currentThread().getContextClassLoader().getResources(packageDirName);
            while(resources.hasMoreElements()){
                //取得存储class文件的包的url
                URL url=resources.nextElement();
                //获得真实路径
                System.out.println(url.getFile());
                String filePath = URLDecoder.decode(url.getFile(), "UTF-8");
                //获得包下class文件的file数组
                File[] files = new File(filePath).listFiles();
                for (File f:
                     files) {
                    String fileName=f.getName();
                    String className=fileName.substring(0,fileName.lastIndexOf("."));
                    className=packageName+"."+className;
                    ClassLoader classLoader=new ClassLoader() {
                        @Override
                        public Class<?> loadClass(String name) throws ClassNotFoundException {
                            return super.loadClass(name,true);
                        }
                    };
                    Package aPackage = com.liziyang.www.controller.CourseServlet.class.getPackage();
                    Class<?> c=Class.forName(className);
                    set.add(c);

                }
                System.out.println(files);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return set;
    }

    public static Map<String,int[]> getServletFuzzyMap(Set<Class<?>> classes){
        Map<String,int[]> map=new HashMap<>();
        for (Class<?> clazz:
             classes) {
            if (clazz.getAnnotation(FuzzyValues.class)!=null){
                int[] fuzzyValue = clazz.getAnnotation(FuzzyValues.class).value();
                String urlPattern = clazz.getAnnotation(WebServlet.class).value()[0];
                map.put(urlPattern,fuzzyValue);
            }
        }
        return map;
    }

}
