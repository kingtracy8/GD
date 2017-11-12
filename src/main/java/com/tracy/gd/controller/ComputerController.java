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

    //purpose : 通过id找电脑信息
    // Create by linsong.wei 2017-11-12 13:05:05
    @RequestMapping(value = "/cptInfoById", method = RequestMethod.GET)
    public @ResponseBody
    Computer doFindById(HttpServletRequest request, HttpServletResponse response) {

        int cptId;
        cptId = Integer.parseInt(request.getParameter("cptId"));
        Computer computer = computerService.selectByPrimaryKey(cptId);
        return computer;
    }




    //展示电脑列表页面
    //Create by linsong.wei 2017-11-10 14:31:44
    @RequestMapping(value = "/computerList", method = RequestMethod.GET)
    public @ResponseBody
    HashMap print(HttpServletRequest request, HttpServletResponse response) {
        HashMap map = new HashMap();
        Computer computer = new Computer();
        List<Computer> computerList = computerService.selectAllComputers(computer);
        map.put("code", 0);
        map.put("msg", "");
        map.put("data", computerList);
        return map;
    }

    //展示电脑列表页面(有过滤)
    //Create by linsong.wei 2017-11-11 08:41:32
    @RequestMapping(value = "/computerListFilter", method = RequestMethod.GET)
    public @ResponseBody
    HashMap computerListFilter(HttpServletRequest request, HttpServletResponse response) {
        HashMap map = new HashMap();
        String cptName = null;
        String cptRam = null;
        String cptCpu = null;
        String cptOs = null;
        String cptIslending = null;
        String cptCard = null;
        Computer computer = new Computer();

        try {
            cptName = URLDecoder.decode(request.getParameter("cptName"), "utf-8");//将中文转码
            cptRam = URLDecoder.decode(request.getParameter("cptRam"), "utf-8");//将中文转码
            cptCpu = URLDecoder.decode(request.getParameter("cptCpu"), "utf-8");//将中文转码
            cptOs = URLDecoder.decode(request.getParameter("cptOs"), "utf-8");//将中文转码
            cptIslending = URLDecoder.decode(request.getParameter("cptIslending"), "utf-8");
            if(!cptIslending.equals(null))
            computer.setCptIslending(cptIslending);
            cptCard = URLDecoder.decode(request.getParameter("cptCard"),"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            //  cptName = "";  ""也会占用字符，导致mybatis无法匹配！！  linsong.wei 2017-11-10 20:15:33

            computer.setCptName("");


            computer.setCptRam("");


            computer.setCptCpu("");


            computer.setCptOs(null);


            computer.setCptIslending(null);

            computer.setCptGraphicscard("");
        } //筛选条件

        // 如果没有空指针异常
        if (!cptName.equals(null)) {
            computer.setCptName(cptName);
        }
        if (!cptRam.equals(null)) {
            computer.setCptRam(cptRam);
        }
        if (!cptCpu.equals(null)) {
            computer.setCptCpu(cptCpu);
        }
        if (!cptOs.equals(null)) {
            if (cptOs.equals("")) {
                computer.setCptOs(null);        //因为sql使用的是 = ，使用""匹配不上
            } else {
                computer.setCptOs(cptOs);
            }
        }
        if(cptIslending.equals(null)){
            if(cptIslending.equals("")){
                computer.setCptIslending(null);
            }else {
                computer.setCptIslending(cptIslending);
            }
        }
        if(!cptCard.equals(null)){
            computer.setCptGraphicscard(cptCard);
        }
        List<Computer> computerList = computerService.selectAllComputers(computer);
        map.put("code", 0);
        map.put("msg", "");
        map.put("data", computerList);

        return map;
    }


}
