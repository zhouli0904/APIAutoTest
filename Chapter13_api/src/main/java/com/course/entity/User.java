package com.course.entity;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class User implements Serializable {
    private Integer id;

    private String username;

    private String password;

    private Integer age;

    private Integer sex;

    private Integer permission;

    private Integer isdelete;

    private static final long serialVersionUID = 1L;


}