package com.course.testng.multiThread;

import org.testng.annotations.Test;

public class multiThreadOnXml {

    @Test
    public void test01(){
        System.out.printf("test01---Thread ID : %s%n",Thread.currentThread().getId());
    }

    @Test
    public void test02(){
        System.out.printf("test02---Thread ID : %s%n",Thread.currentThread().getId());
    }

    @Test
    public void test03(){
        System.out.printf("test03---Thread ID : %s%n",Thread.currentThread().getId());
    }
}
