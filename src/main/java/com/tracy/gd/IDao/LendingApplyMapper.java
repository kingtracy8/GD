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

    //如果当前用户已经申请了这台电脑，又重复申请，拒绝操作！
    // 传入电脑id，去后端controller里查询，用当前用户id和电脑id去查，
    // 如果存在该电脑该用户且未经过管理员审核的记录，则不允许重复申请 （attribute1=“N”）如果不加这个条件会影响下一次借电脑

    int selectDuplicate(LendingApply record);

    int deleteByPkAndUser(LendingApply record);

}