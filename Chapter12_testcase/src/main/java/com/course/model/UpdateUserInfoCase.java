package com.course.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class UpdateUserInfoCase implements Serializable {
    private Integer id;

    private Integer userid;

    private String username;

    private Integer sex;

    private Integer age;

    private Integer permission;

    private Integer isdelete;

    private static final long serialVersionUID = 1L;

}