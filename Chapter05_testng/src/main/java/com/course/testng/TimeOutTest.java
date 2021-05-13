package com.course.testng;

import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class TimeOutTest {

    @Test(timeOut = 3000)
    public void testSuccess() throws InterruptedException {
        Thread.sleep(1000);
    }

    @Test(timeOut = 4000)
    public void testFail() throws InterruptedException {
        Thread.sleep(8000);
    }
}
