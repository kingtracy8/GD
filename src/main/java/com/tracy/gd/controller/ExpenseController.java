package com.tracy.gd.controller;

import com.tracy.gd.domain.Computer;
import com.tracy.gd.domain.Expense;
import com.tracy.gd.service.IComputerService;
import com.tracy.gd.service.IExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by linsong.wei on 2017/11/27.
 */
@Controller
@RequestMapping("/Expense")
public class ExpenseController {

    @Autowired
    IExpenseService expenseService;
    @Autowired
    IComputerService computerService;

    /*
        purpose:将已经审核的电脑归还
        Create by : linsong.wei  2017-11-27 16:56:26
     */
    @RequestMapping("/ReturnCpt")
    public @ResponseBody
    HashMap doReturnCpt(HttpServletRequest request, HttpServletResponse response) {

        HashMap map = new HashMap();

        int flag = 0;
        int cost = 0;
        int laId = Integer.parseInt(request.getParameter("laId"));
        int laCptId = Integer.parseInt(request.getParameter("laCptId"));
        int curUserId = (Integer) request.getSession().getAttribute("userId");

        try {


            Expense expense = new Expense();

            expense.seteLaId(laId);
            expense.seteLaCptId(laCptId);
            expense.seteLaUserId(curUserId);

            expense = expenseService.FindRecToReturn(expense);
            expense.seteAreturnTime(new Date());
            expense.seteIsReturned("Y");
            //先更新一次，否则计算天数和费用查不到记录
            expenseService.updateByPrimaryKeySelective(expense);
            //计算天数
            int days = expenseService.selectDays(expense.geteId());
            expense.seteDays(days);
            //计算费用      前七天免费，后面一天10元
            if (days > 7) {
                cost = 10 * days;
            } else {
                cost = 0;
            }
            expense.seteExpense(BigDecimal.valueOf(cost));

            expenseService.updateByPrimaryKeySelective(expense);
            //把电脑租借状态设置成“N”

            Computer computer = computerService.selectByPrimaryKey(laCptId);
            computer.setCptIslending("N");

            computerService.updateByPrimaryKeySelective(computer);

            flag = 1;
        } catch (Exception e) {

            flag = -1;
        }

        map.put("flag", flag);
        map.put("cost", cost);
        return map;

    }

}