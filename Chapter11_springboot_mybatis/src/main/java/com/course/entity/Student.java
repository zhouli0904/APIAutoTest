package com.course.entity;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class Student implements Serializable {
    private Integer id;

    private String name;

    private Integer age;

    private String city;

    private String mobilePhone;

    private static final long serialVersionUID = 1L;


}