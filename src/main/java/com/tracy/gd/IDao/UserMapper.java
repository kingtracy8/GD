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

    //添加分页，2017-12-08 19:15:29  linsong.wei
    List<User> selectAllToTable(Integer page,Integer limit);

    List<User> selectAll();

    //防止用户在更新自己信息的时候把身份标识去掉 2017-11-21 10:02:53
    int ChangePersonalMsg(User record);

    List<User> selectUserFilter(User record);

    //为支持table模块分页，需查询出总数 linsong.wei 2017-12-08 19:05:02
    int selectCountUser();
}