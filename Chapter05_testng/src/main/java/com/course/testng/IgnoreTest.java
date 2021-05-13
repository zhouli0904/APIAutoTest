package com.course.testng;

import org.testng.annotations.Test;

public class IgnoreTest {

    @Test
    public void test01(){
        System.out.println("test01正在执行");
    }

    @Test(enabled = true)
    public void test02(){
        System.out.println("test02正在执行");
    }

    @Test(enabled = false)
    public void test03(){
        System.out.println("test03正在执行");
    }
}
