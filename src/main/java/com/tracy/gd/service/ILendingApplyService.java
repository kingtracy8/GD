package com.tracy.gd.service;

import com.tracy.gd.domain.LendingApply;

import java.util.List;

/**
 * Created by linsong.wei on 2017-11-12 13:48:45
 */
public interface ILendingApplyService {

   int insertSelective(LendingApply record);
   //通过用户找用户申请记录 linsong.wei 2017-11-12 18:27:22
   List<LendingApply> selectByUser(int laUserId);

   LendingApply selectByPrimaryKey(Integer laId);

   List<LendingApply> selectAuditing();

   int selectCountCpt(int cptId);

   List<LendingApply> selectAuditingFilter(LendingApply record);

   int updateByPrimaryKeySelective(LendingApply record);

   int selectDuplicate(LendingApply record);
//用户撤回操作  2017-11-15 19:22:31  linsong.wei
   int deleteByPkAndUser(LendingApply record);
}
