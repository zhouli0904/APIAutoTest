package com.course.testng.multiThread;

import org.testng.annotations.Test;

public class multiThreadOnXml2 {

    @Test
    public void test21(){
        System.out.printf("test21---Thread ID : %s%n",Thread.currentThread().getId());
    }

    @Test
    public void test22(){
        System.out.printf("test22---Thread ID : %s%n",Thread.currentThread().getId());
    }

    @Test
    public void test23(){
        System.out.printf("test23---Thread ID : %s%n",Thread.currentThread().getId());
    }
}
