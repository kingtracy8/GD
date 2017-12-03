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

    //找到当前用户通过审核的记录 linsong.wei 2017-11-27 15:33:25
    List<LendingApply> FindPassByUser(int laUserId);

    List<LendingApply> FindPassByUserFilter(String cptName, String dateFrom, String dateTo, String cptIsReturned, Integer laUserId);

    //Service层调用FindPassByUserFilter方法进行业务逻辑处理，将结果返回到Controller
    List<LendingApply> doFindPassByUserFilter(String cptName, String dateFrom, String dateTo, String cptIsReturned, Integer laUserId);
}
