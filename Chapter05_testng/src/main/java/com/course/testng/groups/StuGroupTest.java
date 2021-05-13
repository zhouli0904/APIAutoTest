package com.course.testng.groups;

import org.testng.annotations.Test;

@Test(groups = "stu")
public class StuGroupTest {

    @Test
    public void test01(){
        System.out.println("stu1正在执行");
    }

    @Test
    public void test02(){
        System.out.println("stu2正在执行");
    }
}
