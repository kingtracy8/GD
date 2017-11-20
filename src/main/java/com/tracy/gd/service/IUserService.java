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
}
