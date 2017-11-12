package com.tracy.gd.controller;

import com.tracy.gd.domain.LendingApply;
import com.tracy.gd.service.ILendingApplyService;
import com.tracy.gd.service.impl.LendingApplyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

/**
 * Created by linsong.wei on  2017-11-12 13:46:14
 * 用户申请Controller
 */
@Controller
@RequestMapping("/LendingApply")
public class LendingApllyController {
    @Autowired
    ILendingApplyService lendingApplyService;

    //purpose: 提交申请
    @RequestMapping("/commitApply")
    public @ResponseBody
    HashMap doCommitApply(HttpServletRequest request, HttpServletResponse response, @RequestBody LendingApply lendingApply) {

        HashMap map = new HashMap();

        int curUserId = (Integer) request.getSession().getAttribute("userId");
        LendingApply InlendingApply = lendingApply; //将从页面传过来的数据塞到实体中
        InlendingApply.setLaUserId(curUserId);      //设置申请人 ：当前用户
        InlendingApply.setLaIsCheck("N");           //设置为未审核状态
        //插入记录
        int flag = lendingApplyService.insertSelective(InlendingApply);
        map.put("flag",flag);
        return map;
    }

}
