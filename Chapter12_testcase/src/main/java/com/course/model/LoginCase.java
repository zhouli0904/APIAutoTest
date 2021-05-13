package com.course.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class LoginCase implements Serializable {
    private Integer id;

    private String username;

    private String password;

    private String expected;

    private static final long serialVersionUID = 1L;

}