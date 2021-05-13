package com.course.testng.groups;

import org.testng.annotations.Test;

@Test(groups = "tea")
public class TeaGroupTest {

    @Test
    public void test01(){
        System.out.println("tea1正在执行");
    }

    @Test
    public void test02(){
        System.out.println("tea2正在执行");
    }
}
