package com.course.testng.groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class GroupsOnMethod {

    @Test(groups = "server")
    public void test01(){
        System.out.println("server端测试1执行");
    }

    @Test(groups = "server")
    public void test02(){
        System.out.println("server端测试2执行");
    }

    @Test(groups = "client")
    public void test03(){
        System.out.println("client端测试1执行");
    }

    @Test(groups = "client")
    public void test04(){
        System.out.println("client端测试2执行");
    }

    @BeforeGroups("server")
    public void test05(){
        System.out.println("server组运行之前的方法");
    }

    @AfterGroups("server")
    public void test06(){
        System.out.println("server组运行之后的方法！！！");
    }

}
