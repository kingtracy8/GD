package com.tracy.gd.service;

import com.tracy.gd.domain.LendingHistory;

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
}
