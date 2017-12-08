package org.zsl.testmybatis;  
  
import javax.annotation.Resource;

import com.tracy.gd.domain.*;
import com.tracy.gd.service.*;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类  
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})  
  
public class TestMyBatis {  
    private static Logger logger = Logger.getLogger(TestMyBatis.class);
    @Resource  
    private IUserService userService = null;
    @Autowired
    IAdminService adminService;
    @Autowired
    IComputerService computerService;
    @Autowired
    ILendingApplyService lendingApplyService;
    @Autowired
    ILendingHistoryService lendingHistoryService;
    @Autowired
    IExpenseService expenseService;

    @Test  
    public void test1() {
//        User user = userService.getUserById(1);
//        logger.info(JSON.toJSONString(user));
   /*     List<User> userList = userService.selectAll();
        User user = userService.getUserById(1);
        if(userList.contains(user)){
            logger.info(JSON.toJSONString(user));
        }
  */

   /*
        List<Admin> admins = new ArrayList<Admin>();
        admins = adminService.selectUserAdmins();
        for (int i = 0; i < admins.size(); i++) {
            logger.info(JSON.toJSONString(admins.get(i)));
        }

*/

     /*      LendingApply lendingApply = new LendingApply();
        lendingApply.setLaIsCheck("N");
       int id = lendingApplyService.insertSelective(lendingApply);

        LendingHistory lendingHistory = new LendingHistory();

        //申请表id 由于mybatis使用了 useGeneratedKeys="true" keyProperty="laId" 属性，可返回插入当前记录的主键，
        //从而可以将申请表id插入到历史表中  linsong.wei 2017-11-12 17:16:34
        //注：若不加这个属性，默认返回插入的记录数
        lendingHistory.setLhLaId(id);
      //  lendingHistory.setLhUserId(curUserId);      //仅需插入这两个字段，其余字段待管理员审核后更新,相当于在这记录一下，让管理员去审核（更新）
        int flagHis = iLendingHistoryService.insertSelective(lendingHistory);
        logger.info("flagHis"+flagHis);
        */

        //测试通过用户id查找申请记录
//
//        int count = lendingApplyService.selectCountCpt(1);

//        LendingApply lendingApply = new LendingApply();
//        lendingApply.setLaId(2);
//        lendingApply.setLaCptId(1);
//        List<LendingApply> lendingApplies = lendingApplyService.selectAuditingFilter(lendingApply);
//        logger.info(JSON.toJSONString(lendingApplies));
//
//        LendingApply lendingApply = new LendingApply();
//        lendingApply.setLaCptId(1);
//        lendingApply.setLaUserId(2);
//        int count = lendingApplyService.selectDuplicate(lendingApply);
//        logger.info(JSON.toJSONString(count));

/*
        int laId = 7;
        LendingApply lendingApply = lendingApplyService.selectByPrimaryKey(laId);


        //删除申请表里的本记录 且 user_id = 当前用户
        lendingApplyService.deleteByPkAndUser(lendingApply);
        //同时删除历史表的lhlaid=laid and lh_user_id=当前用户的纪录
        LendingHistory lendingHistory = lendingHistoryService.selectByLaId(laId);//找到对应的历史纪录
        lendingHistoryService.deleteByPkAndUser(lendingHistory);
        */

//        LendingHistory lendingHistory = lendingHistoryService.selectDetailByLaId(10);
//        logger.info(JSON.toJSONString(lendingHistory));

//        List<LendingHistory> lendingHistories = lendingHistoryService.selectAll();
//        logger.info(JSON.toJSONString(lendingHistories));

//        User user = new User();
//        user.setUserNum("P101");
//        user.setUserGender("男");
//        List<User> users = userService.selectUserFilter(user);
//        logger.info(JSON.toJSONString(users));

      //  List<LendingApply> lendingApplies = lendingApplyService.FindPassByUser(1);

//        Expense expense = new Expense();
//
//        expense.seteLaId(15);
//        expense.seteLaCptId(2);
//        expense.seteLaUserId(2);
//
//        Expense e = expenseService.FindRecToReturn(expense);

//        int days = expenseService.selectDays(1);
//        List<LendingApply> lendingApplies = lendingApplyService.FindPassByUser(2);
//        logger.info(JSON.toJSONString(lendingApplies.get(0).geteIsReturned()));

//        List<LendingApply> lendingApplies = lendingApplyService.FindPassByUserFilter
//                ("戴尔","2008-08-08","2018-08-08","Y",1);
//        float price= (float) 2.14748365E9;
//        DecimalFormat decimalFormat=new DecimalFormat(".00");//构造方法的字符格式这里如果小数不足2位,会以0补足.
//        String p=decimalFormat.format(price);
//        List<LendingApply> lendingApplies = lendingApplyService.selectAuditingAddFilter(null,null,null,null,"Y");
//        User user = new User();
//        user.setUserNum("P101");
//        user.setUserGender("男");
//        user.setUserName("test");
//         List<User> users = userService.selectUserFilter(user,0,10);
//        logger.info(JSON.toJSONString(users));
        List<Computer> Computer = computerService.selectComputerLists(0,10);
        logger.info(JSON.toJSONString(Computer));
    }
}  