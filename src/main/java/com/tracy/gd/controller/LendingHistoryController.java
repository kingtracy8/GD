package com.tracy.gd.controller;

import com.tracy.gd.domain.LendingHistory;
import com.tracy.gd.service.ILendingHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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


    @RequestMapping(value = "/ShowHisList", method = RequestMethod.GET)
    public @ResponseBody
    HashMap doShowHisList(HttpServletRequest request, HttpServletResponse response){
        HashMap map = new HashMap();

        List<LendingHistory> lendingHistories = lendingHistoryService.selectAll();

        map.put("code", 0);
        map.put("msg", "");
        map.put("data", lendingHistories);
        return map;
    }

}
