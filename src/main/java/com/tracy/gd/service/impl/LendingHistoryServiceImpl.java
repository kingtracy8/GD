package com.tracy.gd.service.impl;

import com.tracy.gd.IDao.LendingHistoryMapper;
import com.tracy.gd.domain.LendingHistory;
import com.tracy.gd.service.ILendingHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by trcay on 2017/11/12.
 */
@Service("lendingHistoryService")
public class LendingHistoryServiceImpl implements ILendingHistoryService {

    @Autowired
    LendingHistoryMapper lendingHistoryMapper;


    public int insertSelective(LendingHistory record) {
        return lendingHistoryMapper.insertSelective(record);
    }

    public LendingHistory selectByLaId(Integer laId) {
        return lendingHistoryMapper.selectByLaId(laId);
    }

    public int updateByPrimaryKeySelective(LendingHistory record) {
        return lendingHistoryMapper.updateByPrimaryKeySelective(record);
    }

    public int deleteByPkAndUser(LendingHistory record) {
        return lendingHistoryMapper.deleteByPkAndUser(record);
    }

    public LendingHistory selectDetailByLaId(Integer laId) {
        return lendingHistoryMapper.selectDetailByLaId(laId);
    }

    public List<LendingHistory> selectAll() {
        return lendingHistoryMapper.selectAll();
    }

}
