package com.tracy.gd.controller;

import com.tracy.gd.domain.LendingApply;
import com.tracy.gd.domain.LendingHistory;
import com.tracy.gd.service.ILendingApplyService;
import com.tracy.gd.service.ILendingHistoryService;
import com.tracy.gd.service.impl.LendingApplyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;

/**
 * Created by linsong.wei on  2017-11-12 13:46:14
 * 用户申请Controller
 */
@Controller
@RequestMapping("/LendingApply")
public class LendingApllyController {
    @Autowired
    ILendingApplyService lendingApplyService;
    @Autowired
    ILendingHistoryService lendingHistoryService;


    /*
       purpose: 查看当前用户申请记录 Create by : linsong.wei  2017-11-12 18:18:52  //直接从apply表里查
     */

    @RequestMapping("/showApply")
    public @ResponseBody
    HashMap doQueryApply(HttpServletRequest request, HttpServletResponse response) {
        HashMap map = new HashMap();

        int curUserId = (Integer) request.getSession().getAttribute("userId");

        List<LendingApply> lendingApplies = lendingApplyService.selectByUser(curUserId);

        map.put("code", 0);
        map.put("msg", "");
        map.put("data", lendingApplies);
        return map;
    }


    //purpose: 提交申请
    @RequestMapping("/commitApply")
    public @ResponseBody
    HashMap doCommitApply(HttpServletRequest request, HttpServletResponse response, @RequestBody LendingApply lendingApply) {

        HashMap map = new HashMap();

        int curUserId = (Integer) request.getSession().getAttribute("userId");
        LendingApply InlendingApply = lendingApply; //将从页面传过来的数据塞到实体中
        InlendingApply.setLaUserId(curUserId);      //设置申请人 ：当前用户
        InlendingApply.setLaIsCheck("N");           //设置为未审核状态
        //插入记录 申请表
        int flagApply = lendingApplyService.insertSelective(InlendingApply);


        //并插入到申请历史表
        LendingHistory lendingHistory = new LendingHistory();

        //申请表id 由于mybatis使用了 useGeneratedKeys="true" keyProperty="laId" 属性，可返回插入当前记录的主键，
        //从而可以将申请表id插入到历史表中  linsong.wei 2017-11-12 17:16:34
        //注：若不加这个属性，默认返回插入的记录数
        lendingHistory.setLhLaId(InlendingApply.getLaId());
        lendingHistory.setLhUserId(curUserId);      //仅需插入这两个字段，其余字段待管理员审核后更新,相当于在这记录一下，让管理员去审核（更新）
        int flagHis = lendingHistoryService.insertSelective(lendingHistory);


        map.put("flag", flagApply);
        map.put("flagHis", flagHis);
        return map;
    }

}
