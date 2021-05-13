package com.course.dao;

import com.course.model.GetAllCase;

public interface GetAllCaseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GetAllCase record);

    int insertSelective(GetAllCase record);

    GetAllCase selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GetAllCase record);

    int updateByPrimaryKey(GetAllCase record);
}