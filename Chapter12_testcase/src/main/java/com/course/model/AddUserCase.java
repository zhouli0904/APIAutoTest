package com.course.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class AddUserCase implements Serializable {
    private Integer id;

    private String username;

    private String password;

    private Integer permission;

    private String expected;

    private Integer sex;

    private Integer age;

    private Integer isdelete;

    private static final long serialVersionUID = 1L;

}