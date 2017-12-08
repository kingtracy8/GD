package com.tracy.gd.service;

import com.tracy.gd.domain.LendingApply;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by linsong.wei on 2017-11-12 13:48:45
 */
public interface ILendingApplyService {

    int insertSelective(LendingApply record);

    //通过用户找用户申请记录 linsong.wei 2017-11-12 18:27:22
    //update by linsong.wei 2017-12-08 22:30:59
    List<LendingApply> selectByUser(int laUserId, Integer start, Integer offset);

    LendingApply selectByPrimaryKey(Integer laId);

    List<LendingApply> selectAuditing();

    int selectCountCpt(int cptId);

    List<LendingApply> selectAuditingFilter(LendingApply record);

    int updateByPrimaryKeySelective(LendingApply record);

    int selectDuplicate(LendingApply record);

    //用户撤回操作  2017-11-15 19:22:31  linsong.wei
    int deleteByPkAndUser(LendingApply record);

    //找到当前用户通过审核的记录 linsong.wei 2017-11-27 15:33:25
    //update by : linsong.wei 添加两个参数，用来实现分页
    List<LendingApply> FindPassByUser(int laUserId, Integer start, Integer offset);

    List<LendingApply> FindPassByUserFilter(String cptName, String dateFrom, String dateTo, String cptIsReturned, Integer laUserId,Integer start, Integer offset);

    //Service层调用FindPassByUserFilter方法进行业务逻辑处理，将结果返回到Controller
    List<LendingApply> doFindPassByUserFilter(String cptName, String dateFrom, String dateTo, String cptIsReturned, Integer laUserId,Integer start, Integer offset);

    List<LendingApply> selectByUserFilter(String cptName, String dateFrom, String dateTo, String attribute1, Integer laUserId,Integer start, Integer offset);

    List<LendingApply> doSelectByUserFilter(String cptName, String dateFrom, String dateTo, String attribute1, Integer laUserId,Integer start, Integer offset);

    List<LendingApply> selectAuditingAddFilter(String cptName, String dateFrom, String dateTo, String userIdentity, String attribute1);

    int FindPassByUserCount(Integer laUserId);

    int selectByUserCount(Integer laUserId);

}
