package com.tracy.gd.service;

import com.tracy.gd.domain.LendingHistory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by linsong.wei 2017-11-12 16:44:43.
 */
public interface ILendingHistoryService {
    int insertSelective(LendingHistory record);

    LendingHistory selectByLaId(Integer laId);

    int updateByPrimaryKeySelective(LendingHistory record);

    int deleteByPkAndUser(LendingHistory record);

    LendingHistory selectDetailByLaId(Integer laId);

    List<LendingHistory> selectAll(Integer start, Integer offset);

    List<LendingHistory> selectAddFilter(String cptName, String dateFrom, String dateTo, String eIsReturned,Integer start, Integer offset);

    int selectAllCount();

}
