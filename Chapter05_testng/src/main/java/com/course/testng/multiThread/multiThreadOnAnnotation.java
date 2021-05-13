package com.course.testng.multiThread;

import org.testng.annotations.Test;

public class multiThreadOnAnnotation {

    @Test(invocationCount = 10, threadPoolSize = 5)
    public void test01(){
        System.out.println(1);
        System.out.printf("Thread ID : %s%n",Thread.currentThread().getId());
    }
}
