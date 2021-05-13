package com.course.testng.multiThread;

import org.testng.annotations.Test;

public class multiThreadOnXml3 {

    @Test
    public void test31(){
        System.out.printf("test31---Thread ID : %s%n",Thread.currentThread().getId());
    }

    @Test
    public void test32(){
        System.out.printf("test32---Thread ID : %s%n",Thread.currentThread().getId());
    }

    @Test
    public void test33(){
        System.out.printf("test33---Thread ID : %s%n",Thread.currentThread().getId());
    }
}
