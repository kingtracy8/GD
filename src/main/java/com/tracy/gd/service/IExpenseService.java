package com.tracy.gd.service;

import com.tracy.gd.domain.Expense;
import com.tracy.gd.dto.updateExpense;

import java.util.List;

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

    Expense FindRecToReturn(Expense record);

    int selectDays(int eId);

    int deleteByLaId(int LaId);

    int FindUserArrears(int userId);

    List<updateExpense> findAllExpenseRecord(Integer start, Integer offset);

    int updateExpenseRecordStatus(String isPay, Integer laId);

    int ExpenseTICount();
}
