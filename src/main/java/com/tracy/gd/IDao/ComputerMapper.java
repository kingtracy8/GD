package com.tracy.gd.IDao;

import com.tracy.gd.domain.Computer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ComputerMapper {
    int deleteByPrimaryKey(Integer cptId);

    int insert(Computer record);

    int insertSelective(Computer record);

    Computer selectByPrimaryKey(Integer cptId);

    int updateByPrimaryKeySelective(Computer record);

    int updateByPrimaryKey(Computer record);

    List<Computer> selectAllComputers(@Param("cptName") String cptName,@Param("cptRam") String cptRam,@Param("cptCpu") String cptCpu,@Param("cptOs") String cptOs,@Param("cptGraphicscard") String cptGraphicscard,@Param("cptIslending") String cptIslending,@Param("start") Integer start,@Param("offset") Integer offset);

    List<Computer> selectComputerLists(Integer page,Integer limit);

    int selectCountCpt();
}