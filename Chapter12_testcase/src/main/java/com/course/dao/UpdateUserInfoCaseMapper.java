package com.course.dao;

import com.course.model.UpdateUserInfoCase;

public interface UpdateUserInfoCaseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UpdateUserInfoCase record);

    int insertSelective(UpdateUserInfoCase record);

    UpdateUserInfoCase selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UpdateUserInfoCase record);

    int updateByPrimaryKey(UpdateUserInfoCase record);
}