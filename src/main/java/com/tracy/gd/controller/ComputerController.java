package com.tracy.gd.controller;

import com.sun.deploy.net.HttpResponse;
import com.tracy.gd.domain.Admin;
import com.tracy.gd.domain.Computer;
import com.tracy.gd.domain.User;
import com.tracy.gd.service.IComputerService;
import com.tracy.gd.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by tracy on 2017/11/9.
 */
@Controller
@RequestMapping("/Computer")
public class ComputerController {

    @Autowired
    IComputerService computerService;

//    @Autowired
//    IUserService userService;

    //展示电脑列表页面
    //Create by linsong.wei 2017-11-10 14:31:44
    @RequestMapping(value = "/computerList", method = RequestMethod.GET)
    public @ResponseBody
    HashMap print(HttpServletRequest request, HttpServletResponse response) {
        HashMap map = new HashMap();
//        int currentUserId = (Integer) request.getSession().getAttribute("userId");
//        User currentUser =  userService.getUserById(currentUserId);
        String cptName = null;
        String cptRam = null;
        String cptCpu =null;
        String cptGraphicscard = null;
        String cptOs = null;
        String cptIslending = null;
        Computer computer = new Computer();
        try {
            cptName = URLDecoder.decode(request.getParameter("cptName"), "utf-8");//将中文转码
            cptRam = URLDecoder.decode(request.getParameter("cptRam"), "utf-8");//将中文转码
            cptCpu = URLDecoder.decode(request.getParameter("cptCpu"), "utf-8");//将中文转码
            cptGraphicscard = URLDecoder.decode(request.getParameter("cptGraphicscard"), "utf-8");//将中文转码
            cptOs = URLDecoder.decode(request.getParameter("cptOs"), "utf-8");//将中文转码
            cptIslending = URLDecoder.decode(request.getParameter("cptIslending"), "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            //  cptName = "";  ""也会占用字符，导致mybatis无法匹配！！  linsong.wei 2017-11-10 20:15:33
            if (!cptName.equals(null) || !cptName.equals("")) {
                computer.setCptName(cptName);
            }
            if (!cptRam.equals(null) || !cptRam.equals("")) {
                computer.setCptRam(cptRam);
            }
            if (!cptCpu.equals(null) || !cptCpu.equals("")) {
                computer.setCptCpu(cptCpu);
            }
            if (!cptGraphicscard.equals(null) || !cptGraphicscard.equals("")) {
                computer.setCptGraphicscard(cptGraphicscard);
            }
            if(!cptOs.equals(null)||!cptOs.equals("")){
                computer.setCptOs(cptOs);
            }
//            if(!cptIslending.equals(null)||!cptIslending.equals("")){
//                computer.setCptIslending(cptIslending);
//            }
//            cptName = null;
//            cptRam = null;
//            cptCpu = null;
//            cptOs = null;
//            cptIslending = null;
        } finally { //筛选条件

//            computer.setCptName(cptName);
//            computer.setCptRam(cptRam);
//            computer.setCptCpu(cptCpu);
//            computer.setCptOs(cptOs);
//            computer.setCptIslending(cptIslending);
            List<Computer> computerList = computerService.selectAllComputers(computer);
            map.put("code", 0);
            map.put("msg", "");
            map.put("data", computerList);
            return map;
        }
    }

}
