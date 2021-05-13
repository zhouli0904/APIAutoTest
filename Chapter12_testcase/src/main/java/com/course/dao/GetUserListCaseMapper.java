package com.course.dao;

import com.course.model.User;
import com.course.model.getUserListCase;

import java.util.List;

public interface GetUserListCaseMapper {

    List<User> getUserSex(Integer sex);

    int deleteByPrimaryKey(Integer id);

    int insert(getUserListCase record);

    int insertSelective(getUserListCase record);

    getUserListCase selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(getUserListCase record);

    int updateByPrimaryKey(getUserListCase record);
}