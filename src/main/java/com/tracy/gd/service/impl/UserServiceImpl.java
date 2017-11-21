package com.tracy.gd.service.impl;

import javax.annotation.Resource;

import com.tracy.gd.service.IUserService;
import org.springframework.stereotype.Service;

import com.tracy.gd.IDao.UserMapper;
import com.tracy.gd.domain.User;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements IUserService {

    @Resource
    private UserMapper userMapper;


    public User getUserById(int userId) {
        // TODO Auto-generated method stub
        return this.userMapper.selectByPrimaryKey(userId);
    }

    public int updateByPrimaryKey(User record) {
        return userMapper.updateByPrimaryKey(record);
    }

    public int deleteByPrimaryKey(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    public List<User> selectAll() {
        return userMapper.selectAll();
    }

    public int insertSelective(User record) {
        return userMapper.insertSelective(record);
    }

    public int updateByPrimaryKeySelective(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }

    public int ChangePersonalMsg(User record) {
        return userMapper.ChangePersonalMsg(record);
    }

    public List<User> selectUserFilter(User record) {
        return userMapper.selectUserFilter(record);
    }

}
