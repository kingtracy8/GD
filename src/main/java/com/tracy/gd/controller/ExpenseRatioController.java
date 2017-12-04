package com.tracy.gd.controller;

import com.tracy.gd.domain.ExpenseRatio;
import com.tracy.gd.service.IExpenseRatioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;

/**
 * Created by trcay on 2017/12/4.
 */
@Controller
@RequestMapping("/ExpenseRatio")
public class ExpenseRatioController {

    @Autowired
    IExpenseRatioService expenseRatioService;


     /*
        purpose: 对传入的费用比例进行更新
        Author: linsong.wei 2017-12-04 14:56:26
     */

    @RequestMapping("/updateExpenseRatio")
    @Transactional(propagation = Propagation.REQUIRED) //控制事务
    public @ResponseBody
    int doUpdateExpenseRatio(HttpServletRequest request, HttpServletResponse response, @RequestParam("freeDays") String freeDays, @RequestParam("baseNum") String baseNum, @RequestParam("expense") String expense) {
        HashMap map = new HashMap();

        int flag = 0;

        ExpenseRatio expenseRatio = expenseRatioService.selectByPrimaryKey(1);

        expenseRatio.setrFreeDays(Integer.valueOf(freeDays));
        expenseRatio.setrBaseNum(Integer.valueOf(baseNum));
        expenseRatio.setrExpense(Float.valueOf(expense));

        expenseRatioService.updateByPrimaryKeySelective(expenseRatio);
        flag = 1;

        return flag;
    }


    /*
         purpose:费用比例
         Author : linsong.wei 2017-12-04 14:39:38
     */
    @RequestMapping(value = "/showExpenseRatio")
    public @ResponseBody
    ExpenseRatio doshowExpenseRatio(HttpServletRequest request, HttpServletResponse response) {
        HashMap map = new HashMap();

        ExpenseRatio expenseRatio = expenseRatioService.selectByPrimaryKey(1);

        return expenseRatio;
    }


}
