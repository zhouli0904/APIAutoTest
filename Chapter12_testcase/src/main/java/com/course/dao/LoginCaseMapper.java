package com.course.dao;

import com.course.model.LoginCase;


public interface LoginCaseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LoginCase record);

    int insertSelective(LoginCase record);

    LoginCase selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LoginCase record);

    int updateByPrimaryKey(LoginCase record);
}