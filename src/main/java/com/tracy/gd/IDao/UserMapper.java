package com.tracy.gd.IDao;

import com.tracy.gd.domain.User;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> selectAll();
    //防止用户在更新自己信息的时候把身份标识去掉 2017-11-21 10:02:53
    int ChangePersonalMsg(User record);
}