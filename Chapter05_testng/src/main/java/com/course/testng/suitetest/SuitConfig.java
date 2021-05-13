package com.course.testng.suitetest;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class SuitConfig {

    @BeforeSuite
    public void beforeSuit(){
        System.out.println("BeforeSuite运行。。");
    }

    @AfterSuite
    public void afterSuit(){
        System.out.println("afterSuit运行。。");
    }
}
