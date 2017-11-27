package com.tracy.gd.IDao;

import com.tracy.gd.domain.Expense;

public interface ExpenseMapper {
    int deleteByPrimaryKey(Integer eId);

    int insert(Expense record);

    int insertSelective(Expense record);

    Expense selectByPrimaryKey(Integer eId);

    int updateByPrimaryKeySelective(Expense record);

    int updateByPrimaryKey(Expense record);
}