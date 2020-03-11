package com.kim.security.core.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class BeanValidatorUtilTest {

    @Test
    public void test(){
        String str = "hello world";
        String str1 = new String("hello world");
        String str2 = "hello"+ new String(" world");

        System.out.println(str == str1);
        System.out.println(str == str2);
        System.out.println(str1 == str2);
    }

}