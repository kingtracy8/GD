package com.tracy.gd.controller;

import com.tracy.gd.domain.LendingApply;
import com.tracy.gd.domain.LendingHistory;
import com.tracy.gd.domain.User;
import com.tracy.gd.service.ILendingHistoryService;
import com.tracy.gd.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.lang.model.type.NullType;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;

/**
 * Created by tracy on 2017-11-20 16:40:18.
 */
@Controller
@RequestMapping("/LendingHistory")
public class LendingHistoryController {

    @Autowired
    ILendingHistoryService lendingHistoryService;
    @Autowired
    IUserService userService;

    /*
    *   purpose: 原始申请记录页面，管理员可以更改审核意见
    *   Author：linsong.wei 2017-12-05 15:42:01
    */

    @RequestMapping(value = "/UpdateHis")
    @Transactional(propagation = Propagation.REQUIRED)
    public @ResponseBody
    HashMap doUpdateHis(HttpServletRequest request, HttpServletResponse response, @RequestBody LendingHistory[] lendingHistories) {
        HashMap map = new HashMap();
        int flag = -1;

        for (int i = 0; i < lendingHistories.length; i++) {
            //清除掉attribute2
            lendingHistories[i].setAttribute2(null);
            //更新审核意见
            lendingHistoryService.updateByPrimaryKeySelective(lendingHistories[i]);
        }
        flag = 1;
        map.put("flag", flag);
        return map;
    }


    @RequestMapping(value = "/ShowHisList", method = RequestMethod.GET)
    public @ResponseBody
    HashMap doShowHisList(HttpServletRequest request, HttpServletResponse response, @RequestParam("page") String page, @RequestParam("limit") String limit) {
        HashMap map = new HashMap();

        //添加分页 2017-12-08
        int start = (Integer.valueOf(page) - 1) * Integer.valueOf(limit);
        int offset = Integer.valueOf(limit);

        List<LendingHistory> lendingHistories = lendingHistoryService.selectAll(start, offset);

        //通过审核人的id去找名字，并将其设置到his对象的备用字段2上（不保存） 传送到前端  以方便获得审核人的名字 
        //update by: linsong.wei 2017-12-05 15:29:15

        for (int i = 0; i < lendingHistories.size(); i++) {

            int who = 0;

            //当用户提交申请，且未审核的时候，是没有审核人的，即拿不到who，抛出kong'zhi'zhen空指针异常
            //update by : linsong.wei 2017-12-11 11:16:50
            try {
                who = lendingHistories.get(i).getLhWhoChecked();    //是谁审核的
            } catch (NullPointerException e) {
                who = 0;
            }



            //如果用户对象不为空，才设置是谁审核的
            try {
                User user = userService.getUserById(who);
                lendingHistories.get(i).setAttribute2(user.getUserName());
            }catch (NullPointerException e){
                lendingHistories.get(i).setAttribute2("尚未审核");
            }




        }

        map.put("code", 0);
        map.put("msg", "");
        int count = lendingHistoryService.selectAllCount();
        map.put("count", count);
        map.put("data", lendingHistories);
        return map;
    }

    /*
     purpose:查询所有记录  （有过滤条件）
      Create by : linsong.wei  2017-12-05 18:31:47
   */
    @RequestMapping("/ShowHisListFilter")
    public @ResponseBody
    HashMap doShowHisListFilter(HttpServletRequest request, HttpServletResponse response, @RequestParam("cptName") String cptName, @RequestParam("dateFrom") String dateFrom, @RequestParam("dateTo") String dateTo, @RequestParam("eIsReturned") String eIsReturned, @RequestParam("page") String page, @RequestParam("limit") String limit) {
        HashMap map = new HashMap();

        //添加分页 2017-12-08
        int start = (Integer.valueOf(page) - 1) * Integer.valueOf(limit);
        int offset = Integer.valueOf(limit);

        List<LendingHistory> lendingHistories = lendingHistoryService.selectAddFilter(cptName, dateFrom, dateTo, eIsReturned, start, offset);

        map.put("code", 0);
        map.put("msg", "");
        map.put("data", lendingHistories);
        return map;
    }

}
