package com.tracy.gd.IDao;

import com.tracy.gd.domain.LendingHistory;

import java.util.List;

public interface LendingHistoryMapper {
    int deleteByPrimaryKey(Integer lhId);

    int insert(LendingHistory record);

    int insertSelective(LendingHistory record);

    LendingHistory selectByPrimaryKey(Integer lhId);

    int updateByPrimaryKeySelective(LendingHistory record);

    int updateByPrimaryKey(LendingHistory record);

    LendingHistory selectByLaId(Integer laId);

}