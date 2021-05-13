package com.course.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class GetAllCase implements Serializable {
    private Integer id;

    private Integer pageno;

    private Integer pagesize;

    private String expected;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPageno() {
        return pageno;
    }


}