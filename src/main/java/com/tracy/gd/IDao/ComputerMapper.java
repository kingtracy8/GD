package com.tracy.gd.IDao;

import com.tracy.gd.domain.Computer;

import java.util.List;

public interface ComputerMapper {
    int deleteByPrimaryKey(Integer cptId);

    int insert(Computer record);

    int insertSelective(Computer record);

    Computer selectByPrimaryKey(Integer cptId);

    int updateByPrimaryKeySelective(Computer record);

    int updateByPrimaryKey(Computer record);

    List<Computer> selectAllComputers(Computer record);

    List<Computer> selectComputerLists(Integer page,Integer limit);

    int selectCountCpt();
}