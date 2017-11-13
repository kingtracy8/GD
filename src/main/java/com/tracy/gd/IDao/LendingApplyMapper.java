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
    //purpose: 审核记录模块，查出申请表中所有申请记录 linsong.wei 2017-11-13 19:34:48
    List<LendingApply> selectAuditing();
    //purpose: 审核记录模块，查看有几个人同时提交了同一台电脑的申请 linsong.wei 2017-11-13 19:34:48
    int selectCountCpt(int cptId);
    List<LendingApply> selectAuditingFilter(LendingApply record);
}