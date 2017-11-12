package com.tracy.gd.service;

import com.tracy.gd.domain.LendingHistory;

/**
 * Created by linsong.wei 2017-11-12 16:44:43.
 */
public interface ILendingHistoryService {
    int insertSelective(LendingHistory record);
}
