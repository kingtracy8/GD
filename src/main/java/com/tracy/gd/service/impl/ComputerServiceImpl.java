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

    public List<Computer> selectAllComputers(String cptName, String cptRam, String cptCpu, String cptOs, String cptGraphicscard, String cptIslending, Integer start, Integer offset) {
        return computerMapper.selectAllComputers(cptName,cptRam,cptCpu,cptOs,cptGraphicscard,cptIslending,start,offset);
    }

    public List<Computer> selectComputerLists(Integer page,Integer limit) {
        return computerMapper.selectComputerLists(page,limit);
    }

    public int updateByPrimaryKeySelective(Computer record) {
        return computerMapper.updateByPrimaryKeySelective(record);
    }

    public int deleteByPrimaryKey(Integer cptId) {
        return computerMapper.deleteByPrimaryKey(cptId);
    }

    public int insertSelective(Computer record) {
        return computerMapper.insertSelective(record);
    }

    public int selectCountCpt() {
        return computerMapper.selectCountCpt();
    }

//    public List<Computer> selectAllComputers() {
//        return computerMapper.selectAllComputers();
//    }
}
