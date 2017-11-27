package com.tracy.gd.service.impl;

import com.tracy.gd.IDao.ExpenseMapper;
import com.tracy.gd.domain.Expense;
import com.tracy.gd.service.IExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by trcay on 2017/11/27.
 */
@Service("expenseService")
public class ExpenseServiceImpl implements IExpenseService{

    @Autowired
    ExpenseMapper expenseMapper;
    public int deleteByPrimaryKey(Integer eId) {
        return expenseMapper.deleteByPrimaryKey(eId);
    }

    public int insert(Expense record) {
        return expenseMapper.insert(record);
    }

    public int insertSelective(Expense record) {
        return expenseMapper.insert(record);
    }

    public Expense selectByPrimaryKey(Integer eId) {
        return expenseMapper.selectByPrimaryKey(eId);
    }

    public int updateByPrimaryKeySelective(Expense record) {
        return expenseMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(Expense record) {
        return expenseMapper.updateByPrimaryKey(record);
    }

    public Expense FindRecToReturn(Expense record) {
        return expenseMapper.FindRecToReturn(record);
    }

    public int selectDays(int eId) {
        return expenseMapper.selectDays(eId);
    }

    public int deleteByLaId(int LaId) {
        return expenseMapper.deleteByLaId(LaId);
    }
}
