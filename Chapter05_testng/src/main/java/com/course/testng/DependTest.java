package com.course.testng;

import org.testng.annotations.Test;

public class DependTest {

    @Test
    public void test01(){
        System.out.println("test01正在执行");
        throw new RuntimeException();
    }

    // 依赖test01执行成功才会执行test02，否则不执行
    @Test(dependsOnMethods = "test01")
    public void test02(){
        System.out.println("test02正在执行");
    }
}
