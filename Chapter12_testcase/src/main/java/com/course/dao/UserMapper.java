package com.course.dao;

import com.course.model.User;

import java.util.List;

public interface UserMapper {

    List<User> getUserInfoList(User user);

    int userLogin(String userName, String password);

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}