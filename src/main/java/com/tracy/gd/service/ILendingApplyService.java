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
}
