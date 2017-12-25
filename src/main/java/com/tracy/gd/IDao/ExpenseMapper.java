package com.tracy.gd.IDao;

import com.tracy.gd.domain.Expense;
import com.tracy.gd.dto.updateExpense;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

    //当用户申请电脑的时候，查询该用户是否有欠费  2017-12-11 10:21:04
    int FindUserArrears(@Param("userId") int userId);

    /**
     * Author: linsong.wei
     * 管理员“缴费管理”页面，可更新“是否已经缴费”
     *
     * @return 查找所有用户的借用、归还信息，以及是否已经缴费 (e_attribute1) ，
     */
    List<updateExpense> findAllExpenseRecord(@Param("start") Integer start, @Param("offset") Integer offset);

    /**
     * 缴费管理页面,管理员更新某条记录 是否已经付款
     * Author:linsong.wei
     * 2017-12-24 20:00:49
     *
     * @param isPay 是否已经付款 "Y","N"
     * @param laId  对应哪一条费用记录
     * @return
     */
    int updateExpenseRecordStatus(@Param("isPay") String isPay, @Param("laId") Integer laId);

    /**
     * 查询有多少条记录，给缴费管理的表格接口(ExpenseManager Table Interface)赋值
     * author:linsong.wei 2017-12-24 21:54:47
     *
     * @return
     */
    int ExpenseTICount();

    /**
     * Author: linsong.wei
     *
     * @return 查找所有用户的借用、归还信息，以及是否已经缴费 (e_attribute1) ，有查询条件
     */
    List<updateExpense> findAllExpenseRecordFilter(@Param("userName") String userName, @Param("cptName") String cptName, @Param("isPay") String isPay, @Param("start") Integer start, @Param("offset") Integer offset);

}