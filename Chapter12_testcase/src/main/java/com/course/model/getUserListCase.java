package com.course.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class getUserListCase implements Serializable {
    private Integer id;

    private String username;

    private Integer age;

    private Integer sex;

    private String expected;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

   }