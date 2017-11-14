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
public class LendingApplyServiceImpl implements ILendingApplyService{

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
}
