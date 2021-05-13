package com.course.testng.parameter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class DataProviderTest {

    @Test(dataProvider = "dataProvider")
    public void test01(String name, int age){
        System.out.println("name=" + name + "; age=" + age);
    }

    // 不传method
    @DataProvider
    public Object[][] dataProvider(){
        Object[][] o = {
                {"zl",20},
                {"lzq",30},
        };
        return o;
    }

    @Test(dataProvider = "dataProvider2")
    public void test02(String name, int age){
        System.out.println("test02---name=" + name + "; age=" + age);
    }

    @Test(dataProvider = "dataProvider2")
    public void test03(String name, int age){
        System.out.println("test03---name=" + name + "; age=" + age);
    }

    // 传method
    @DataProvider
    public Object[][] dataProvider2(Method method){
        Object[][] o = null;
        if (method.getName().equals("test02")) {
            o = new Object[][]{
                    {"a", 10},
                    {"b", 19}
            };
        } else if (method.getName().equals("test03")){
            o = new Object[][]{
                    {"c", 123},
                    {"d", 456}
            };
        }
        return o;
    }
}
