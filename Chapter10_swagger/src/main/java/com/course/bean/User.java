package com.course.bean;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class User {

    private String passWord;
    private String userName;
    private String name;
    private String age;
    private String sex;
}
