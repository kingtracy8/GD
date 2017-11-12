package com.tracy.gd.IDao;

import com.tracy.gd.domain.LendingApply;

import java.util.List;

public interface LendingApplyMapper {
    int deleteByPrimaryKey(Integer laId);

    int insert(LendingApply record);

    int insertSelective(LendingApply record);

    LendingApply selectByPrimaryKey(Integer laId);

    int updateByPrimaryKeySelective(LendingApply record);

    int updateByPrimaryKey(LendingApply record);

    List<LendingApply> selectByUser(int laUserId);
}