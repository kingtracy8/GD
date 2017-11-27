package com.tracy.gd.service;

import com.tracy.gd.domain.Expense;

/**
 * Created by trcay on 2017/11/27.
 */

public interface IExpenseService {

    int deleteByPrimaryKey(Integer eId);

    int insert(Expense record);

    int insertSelective(Expense record);

    Expense selectByPrimaryKey(Integer eId);

    int updateByPrimaryKeySelective(Expense record);

    int updateByPrimaryKey(Expense record);

}
