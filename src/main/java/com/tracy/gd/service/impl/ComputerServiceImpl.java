package com.tracy.gd.service.impl;

import com.tracy.gd.IDao.ComputerMapper;
import com.tracy.gd.domain.Computer;
import com.tracy.gd.service.IComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by tracy on 2017/11/9.
 */
@Service("computerService")
public class ComputerServiceImpl implements IComputerService{

    @Autowired
    ComputerMapper computerMapper;

    public Computer selectByPrimaryKey(Integer cptId) {
        return computerMapper.selectByPrimaryKey(cptId);
    }

    public List<Computer> selectAllComputers(Computer record) {
        return computerMapper.selectAllComputers(record);
    }

    public List<Computer> selectComputerLists() {
        return computerMapper.selectComputerLists();
    }

//    public List<Computer> selectAllComputers() {
//        return computerMapper.selectAllComputers();
//    }
}
