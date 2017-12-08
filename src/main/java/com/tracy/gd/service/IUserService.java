package com.tracy.gd.service;

import com.tracy.gd.domain.User;

import java.util.List;

public interface IUserService {
    public User getUserById(int userId);

    public int updateByPrimaryKey(User record);

    public int deleteByPrimaryKey(Integer id);

    //添加分页，2017-12-08 19:15:29  linsong.wei
    List<User> selectAllToTable(Integer page, Integer limit);

    List<User> selectAll();

    int insertSelective(User record);

    int updateByPrimaryKeySelective(User record);

    //防止用户在更新自己信息的时候把身份标识去掉 2017-11-21 10:02:53
    int ChangePersonalMsg(User record);


    int selectCountUser();

    List<User> selectUserFilter(String userName, String userNum, String userPhone, String userDepartment, String userGender, String attribute1, Integer start, Integer offset);

    int selectCountUserFilter(String userName, String userNum, String userPhone, String userDepartment, String userGender, String attribute1);
}
