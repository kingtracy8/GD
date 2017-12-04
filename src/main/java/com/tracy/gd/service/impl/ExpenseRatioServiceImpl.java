package com.tracy.gd.service.impl;

import com.tracy.gd.IDao.ExpenseRatioMapper;
import com.tracy.gd.domain.ExpenseRatio;
import com.tracy.gd.service.IExpenseRatioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by trcay on 2017/12/4.
 */
@Service("expenseRatioService")
@Transactional(propagation = Propagation.REQUIRED)
public class ExpenseRatioServiceImpl implements IExpenseRatioService {

    @Autowired
    ExpenseRatioMapper expenseRatioMapper;

    public ExpenseRatio selectByPrimaryKey(Integer rId) {
        return expenseRatioMapper.selectByPrimaryKey(rId);
    }

    public int updateByPrimaryKeySelective(ExpenseRatio record) {
        return expenseRatioMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(ExpenseRatio record) {
        return expenseRatioMapper.updateByPrimaryKey(record);
    }

    /*
       purpose:通过实际借用天数来计算费用
       Author : linsong.wei  2017-12-04 12:14:58
    */
    public float Checkout(int days) {

        float cost = 0;
        //查到费用记录
        ExpenseRatio expenseRatio = expenseRatioMapper.selectByPrimaryKey(1);

        int freedays = expenseRatio.getrFreeDays();

        int baseNum = expenseRatio.getrBaseNum();

        float expense = expenseRatio.getrExpense();
        //如果小于免费天数，则免费
        if (days <= freedays) {
            cost = 0;
        } else {
            //若实际借用天数大于r_free_days ,则使用公式(”r_base_numn-1*r_expense”元收费，n为计费天数)计算费用。
//            cost = (float) (Math.pow(baseNum,(days-1))*expense);
            //如果天数比较大，按原有方式数字精度太高 Linsong.wei
            cost = days*expense;
        }

        return cost;
    }
}
