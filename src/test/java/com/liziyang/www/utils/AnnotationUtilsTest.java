package com.liziyang.www.utils;

import junit.framework.TestCase;

public class AnnotationUtilsTest extends TestCase {

    public void testGetClasses() {
        AnnotationUtils.getClasses("com.liziyang.www.controller");
    }
}