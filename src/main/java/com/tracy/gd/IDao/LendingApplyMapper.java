package com.tracy.gd.IDao;

import com.tracy.gd.domain.LendingApply;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LendingApplyMapper {
    int deleteByPrimaryKey(Integer laId);

    int insert(LendingApply record);

    int insertSelective(LendingApply record);

    LendingApply selectByPrimaryKey(Integer laId);

    int updateByPrimaryKeySelective(LendingApply record);

    int updateByPrimaryKey(LendingApply record);

    List<LendingApply> selectByUser(@Param("laUserId") int laUserId, @Param("start") Integer start, @Param("offset") Integer offset);

    //purpose: 审核记录模块，查出申请表中所有申请记录 linsong.wei 2017-11-13 19:34:48
    List<LendingApply> selectAuditing(@Param("start") Integer start, @Param("offset") Integer offset);

    //purpose: 审核记录模块，查看有几个人同时提交了同一台电脑的申请 linsong.wei 2017-11-13 19:34:48
    int selectCountCpt(int cptId);

    List<LendingApply> selectAuditingFilter(LendingApply record);

    //如果当前用户已经申请了这台电脑，又重复申请，拒绝操作！
    // 传入电脑id，去后端controller里查询，用当前用户id和电脑id去查，
    // 如果存在该电脑该用户且未经过管理员审核的记录，则不允许重复申请 （attribute1=“N”）如果不加这个条件会影响下一次借电脑

    int selectDuplicate(LendingApply record);

    int deleteByPkAndUser(LendingApply record);

    List<LendingApply> FindPassByUser(@Param("laUserId") int laUserId, @Param("start") Integer start, @Param("offset") Integer offset);

    //与上面的方法一样，加上了过滤条件  linsong.wei 2017-12-03 16:14:19
    List<LendingApply> FindPassByUserFilter(@Param("cptName") String cptName, @Param("dateFrom") String dateFrom, @Param("dateTo") String dateTo, @Param("cptIsReturned") String cptIsReturned, @Param("laUserId") Integer laUserId, @Param("start") Integer start, @Param("offset") Integer offset);

    //过滤申请记录  2017-12-05 13:24:22
    List<LendingApply> selectByUserFilter(@Param("cptName") String cptName, @Param("dateFrom") String dateFrom, @Param("dateTo") String dateTo, @Param("attribute1") String attribute1, @Param("laUserId") Integer laUserId, @Param("start") Integer start, @Param("offset") Integer offset);

    //过滤审核记录  2017-12-05 16:35:09
    List<LendingApply> selectAuditingAddFilter(@Param("cptName") String cptName, @Param("dateFrom") String dateFrom, @Param("dateTo") String dateTo, @Param("userIdentity") String userIdentity, @Param("attribute1") String attribute1,@Param("start") Integer start, @Param("offset") Integer offset);

    //2017-12-08 21:48:57 查询该用户总共有几条通过了的记录 purpose: 用于table组件的count
    int FindPassByUserCount(@Param("laUserId") Integer laUserId);

    //同上，但没有 已通过 的限制条件
    int selectByUserCount(@Param("laUserId") Integer laUserId);
    //2017-12-09 11:01:30 查询所有记录数量 purpose: 用于table组件的count
    int selectAuditingCount();
}