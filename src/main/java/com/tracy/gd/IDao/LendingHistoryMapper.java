package com.tracy.gd.IDao;

import com.tracy.gd.domain.LendingHistory;

public interface LendingHistoryMapper {
    int deleteByPrimaryKey(Integer lhId);

    int insert(LendingHistory record);

    int insertSelective(LendingHistory record);

    LendingHistory selectByPrimaryKey(Integer lhId);

    int updateByPrimaryKeySelective(LendingHistory record);

    int updateByPrimaryKey(LendingHistory record);
}