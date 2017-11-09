package com.tracy.gd.IDao;

import com.tracy.gd.domain.LendingApply;

public interface LendingApplyMapper {
    int deleteByPrimaryKey(Integer laId);

    int insert(LendingApply record);

    int insertSelective(LendingApply record);

    LendingApply selectByPrimaryKey(Integer laId);

    int updateByPrimaryKeySelective(LendingApply record);

    int updateByPrimaryKey(LendingApply record);
}