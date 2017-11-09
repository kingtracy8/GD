package com.tracy.gd.IDao;

import com.tracy.gd.domain.Computer;

public interface ComputerMapper {
    int deleteByPrimaryKey(Integer cptId);

    int insert(Computer record);

    int insertSelective(Computer record);

    Computer selectByPrimaryKey(Integer cptId);

    int updateByPrimaryKeySelective(Computer record);

    int updateByPrimaryKey(Computer record);
}