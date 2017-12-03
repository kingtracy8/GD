package com.tracy.gd.service;

import com.tracy.gd.domain.Computer;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by tracy on 2017/11/9.
 */

public interface IComputerService {

    Computer selectByPrimaryKey(Integer cptId);

    List<Computer> selectAllComputers(Computer record);

    List<Computer> selectComputerLists();

    int updateByPrimaryKeySelective(Computer record);

    int deleteByPrimaryKey(Integer cptId);

}
