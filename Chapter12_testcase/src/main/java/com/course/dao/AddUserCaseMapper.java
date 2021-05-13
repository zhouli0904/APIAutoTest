package com.course.dao;

import com.course.model.AddUserCase;

public interface AddUserCaseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AddUserCase record);

    int insertSelective(AddUserCase record);

    AddUserCase selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AddUserCase record);

    int updateByPrimaryKey(AddUserCase record);
}