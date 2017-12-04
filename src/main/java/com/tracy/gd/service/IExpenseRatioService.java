package com.tracy.gd.service;

import com.tracy.gd.domain.ExpenseRatio;

/**
 * Created by trcay on 2017/12/4.
 */
public interface IExpenseRatioService {

    ExpenseRatio selectByPrimaryKey(Integer rId);

    int updateByPrimaryKeySelective(ExpenseRatio record);

    int updateByPrimaryKey(ExpenseRatio record);

    //通过实际借用天数来计算费用
    float Checkout(int days);
}
