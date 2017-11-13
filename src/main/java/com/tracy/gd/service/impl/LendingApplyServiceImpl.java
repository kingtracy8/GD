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
}
