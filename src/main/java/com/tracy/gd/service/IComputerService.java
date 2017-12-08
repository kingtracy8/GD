package com.tracy.gd.service;

import com.tracy.gd.domain.Computer;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by tracy on 2017/11/9.
 */

public interface IComputerService {

    Computer selectByPrimaryKey(Integer cptId);

    List<Computer> selectAllComputers(String cptName, String cptRam, String cptCpu, String cptOs, String cptGraphicscard, String cptIslending, Integer start, Integer offset);

    List<Computer> selectComputerLists(Integer page, Integer limit);

    int updateByPrimaryKeySelective(Computer record);

    int deleteByPrimaryKey(Integer cptId);

    int insertSelective(Computer record);

    int selectCountCpt();

}
