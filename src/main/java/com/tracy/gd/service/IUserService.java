package com.tracy.gd.service;

import com.tracy.gd.domain.User;

import java.util.List;

public interface IUserService {
	public User getUserById(int userId);
	public int updateByPrimaryKey(User record);
	public int deleteByPrimaryKey(Integer id);
	public List<User> selectAll();
	int insertSelective(User record);
	int updateByPrimaryKeySelective(User record);
	//防止用户在更新自己信息的时候把身份标识去掉 2017-11-21 10:02:53
	int ChangePersonalMsg(User record);
}
