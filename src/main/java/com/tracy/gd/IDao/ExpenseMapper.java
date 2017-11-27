package com.tracy.gd.IDao;

import com.tracy.gd.domain.Expense;

public interface ExpenseMapper {
    int deleteByPrimaryKey(Integer eId);

    int insert(Expense record);

    int insertSelective(Expense record);

    Expense selectByPrimaryKey(Integer eId);

    int updateByPrimaryKeySelective(Expense record);

    int updateByPrimaryKey(Expense record);

    //找到待归还那条记录的费用记录
    Expense FindRecToReturn(Expense record);

    //查询借了多少天
    int selectDays(int eId);

    //撤回申请时候同步删除费用记录
    int deleteByLaId(int LaId);

}