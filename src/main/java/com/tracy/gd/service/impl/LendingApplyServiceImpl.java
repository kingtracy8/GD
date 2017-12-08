package com.tracy.gd.service.impl;

import com.tracy.gd.IDao.LendingApplyMapper;
import com.tracy.gd.IDao.UserMapper;
import com.tracy.gd.domain.LendingApply;
import com.tracy.gd.service.ILendingApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by trcay on 2017/11/12.
 */
@Service("lendingApplyService")
public class LendingApplyServiceImpl implements ILendingApplyService {

    @Autowired
    LendingApplyMapper lendingApplyMapper;

    public int insertSelective(LendingApply record) {
        return lendingApplyMapper.insertSelective(record);
    }

    public List<LendingApply> selectByUser(int laUserId) {
        return lendingApplyMapper.selectByUser(laUserId);
    }

    public LendingApply selectByPrimaryKey(Integer laId) {
        return lendingApplyMapper.selectByPrimaryKey(laId);
    }

    public List<LendingApply> selectAuditing() {
        return lendingApplyMapper.selectAuditing();
    }

    public int selectCountCpt(int cptId) {
        return lendingApplyMapper.selectCountCpt(cptId);
    }

    ////4.把apply表里申请了这台电脑的其他的记录，除了当前记录的其他记录给设置成“N”（sql语句条件给为不等于laId即可）
    public List<LendingApply> selectAuditingFilter(LendingApply record) {
        return lendingApplyMapper.selectAuditingFilter(record);
    }

    public int updateByPrimaryKeySelective(LendingApply record) {
        return lendingApplyMapper.updateByPrimaryKeySelective(record);
    }

    public int selectDuplicate(LendingApply record) {
        return lendingApplyMapper.selectDuplicate(record);
    }

    public int deleteByPkAndUser(LendingApply record) {
        return lendingApplyMapper.deleteByPkAndUser(record);
    }

    public List<LendingApply> FindPassByUser(int laUserId, Integer start, Integer offset) {
        return lendingApplyMapper.FindPassByUser(laUserId,start,offset);
    }

    public List<LendingApply> FindPassByUserFilter(String cptName, String dateFrom, String dateTo, String cptIsReturned, Integer laUserId,Integer start, Integer offset) {
        return lendingApplyMapper.FindPassByUserFilter(cptName, dateFrom, dateTo, cptIsReturned, laUserId,start,offset);
    }

    /*
           purpose: 获得当前用户已经被审核了的记录    （添加查询条件）
           Author: linsong.wei  2017-12-03 16:41:40
        */
    public List<LendingApply> doFindPassByUserFilter(String cptName, String dateFrom, String dateTo, String cptIsReturned, Integer laUserId,Integer start, Integer offset) {
        //此处没有特殊逻辑处理，直接调用FindPassByUserFilter方法
        return lendingApplyMapper.FindPassByUserFilter(cptName, dateFrom, dateTo, cptIsReturned, laUserId,start,offset);
    }

    /*
               purpose: 获得当前用户全部记录    （添加查询条件）
               Author: linsong.wei  2017-12-05 13:27:27
            */
    public List<LendingApply> selectByUserFilter(String cptName, String dateFrom, String dateTo, String attribute1, Integer laUserId) {
        return lendingApplyMapper.selectByUserFilter(cptName, dateFrom, dateTo, attribute1, laUserId);
    }

    //与上一样，供Controller层调用
    public List<LendingApply> doSelectByUserFilter(String cptName, String dateFrom, String dateTo, String attribute1, Integer laUserId) {
        return lendingApplyMapper.selectByUserFilter(cptName, dateFrom, dateTo, attribute1, laUserId);
    }

    public List<LendingApply> selectAuditingAddFilter(String cptName, String dateFrom, String dateTo, String userIdentity, String attribute1) {
        return lendingApplyMapper.selectAuditingAddFilter(cptName,dateFrom,dateTo,userIdentity,attribute1);
    }

    public int FindPassByUserCount(Integer laUserId) {
        return lendingApplyMapper.FindPassByUserCount(laUserId);
    }


}
