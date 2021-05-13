package com.course.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class getUserInfoCase implements Serializable {
    private Integer id;

    private Integer userid;

    private String expected;

    private static final long serialVersionUID = 1L;

}