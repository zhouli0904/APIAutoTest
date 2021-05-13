package com.course.dao;

import com.course.model.getUserInfoCase;

public interface GetUserInfoCaseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(getUserInfoCase record);

    int insertSelective(getUserInfoCase record);

    getUserInfoCase selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(getUserInfoCase record);

    int updateByPrimaryKey(getUserInfoCase record);
}