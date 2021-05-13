package com.course.cases;

import com.alibaba.fastjson.JSON;
import com.course.model.User;

import java.util.List;

public class Demo {

//    private static final com.alibaba.fastjson.JSON JSON = ;

    public static void main(String[] args) {
        String ex = "[User(id=1, username=zhouli, password=123456, age=18, sex=0, permission=0, isdelete=0)]";
        String ac = "[{\"id\":1,\"username\":\"zhouli\",\"password\":\"123456\",\"age\":18,\"sex\":0,\"permission\":0,\"isdelete\":0}]";

        List<User> users = JSON.parseArray(ac, User.class);
        System.out.println(users.toString());

    }
}
