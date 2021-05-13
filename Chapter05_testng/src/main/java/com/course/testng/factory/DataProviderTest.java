package com.course.testng.factory;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class DataProviderTest
{
    private int param;

    @Factory(dataProvider = "dataMethod")
    public DataProviderTest(int param) {
        this.param = param;
    }

    /**
     * 返回一个二维数组，维数表示迭代的次数，第二个值表示传入的参数。
     * @return
     */
    @DataProvider
    public static Object[][] dataMethod() {
        Object[][] o = new Object[][] { new Object[]{ 0 }, new Object[]{ 10 } };
        return o;
    }

    @Test
    public void testMethodOne() {
        int opValue = param + 1;
        System.out.println("Test method one output: " + opValue);
    }

    @Test
    public void testMethodTwo() {
        int opValue = param + 2;
        System.out.println("Test method two output: " + opValue);
    }
}
