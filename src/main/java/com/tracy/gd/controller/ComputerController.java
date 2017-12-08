package com.tracy.gd.controller;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.deploy.net.HttpResponse;
import com.tracy.gd.domain.Admin;
import com.tracy.gd.domain.Computer;
import com.tracy.gd.domain.User;
import com.tracy.gd.service.IComputerService;
import com.tracy.gd.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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


    /*
         purpose:添加电脑
         Author : linsong.wei  2017-12-04 22:14:02
 */
    @RequestMapping("/addComputer")
    @Transactional(propagation = Propagation.REQUIRED)      //出异常的时候事务控制，回滚操作 Create by:linsong.wei 2017-11-29 16:15:45
    public @ResponseBody
    HashMap doRegister(HttpServletRequest request, HttpServletResponse response, @RequestBody Computer computer) {

        HashMap map = new HashMap();
        int flag = computerService.insertSelective(computer);
        map.put("flag", flag);
        return map;
    }


    /*
        purpose:获取一个电脑实体进行更新操作 (单个)
        Create by : linsong.wei  2017-12-03 21:50:37
*/
    @RequestMapping("/DeleteComputerSingle")
    @Transactional(propagation = Propagation.REQUIRED)  //update by: linsong.wei 2017年11月29日17:59:20
    public @ResponseBody
    HashMap doDeleteComputerSingle(HttpServletRequest request, HttpServletResponse response, @RequestBody Computer computer) {

        HashMap map = new HashMap();
        int flag = -1;
        try {

            computerService.deleteByPrimaryKey(computer.getCptId());

            flag = 1;
        } catch (Exception e) {
            flag = -1;
            throw new RuntimeException();
        }
        map.put("flag", flag);
        return map;
    }


    /*
     purpose:获取一个电脑实体的集合，对页面上选中的电脑进行更新操作
     Create by : linsong.wei  2017-11-17 09:00:01
  */
    @RequestMapping("/DeleteComputer")
    @Transactional(propagation = Propagation.REQUIRED)  //update by: linsong.wei 2017年11月29日17:59:20
    public @ResponseBody
    HashMap doDeleteComputer(HttpServletRequest request, HttpServletResponse response, @RequestBody Computer[] computers) {

        HashMap map = new HashMap();
        int flag = -1;
        try {
            for (int i = 0; i < computers.length; i++) {
                computerService.deleteByPrimaryKey(computers[i].getCptId());
            }
            flag = 1;
        } catch (Exception e) {
            flag = -1;
            throw new RuntimeException();
        }
        map.put("flag", flag);
        return map;
    }


    /*
   purpose:获取一个电脑实体 进行更新操作 （单个）
   Create by : linsong.wei  2017-11-17 09:00:01
*/
    @RequestMapping("/UpdateComputerSingle")
    @Transactional(propagation = Propagation.REQUIRED)  //update by: linsong.wei 2017年11月29日17:59:20
    public @ResponseBody
    HashMap doUpdateComputerSingle(HttpServletRequest request, HttpServletResponse response, @RequestBody Computer computer) {

        HashMap map = new HashMap();
        //用数组接收，用List<Computer>会报java.util.LinkedHashMap cannot be cast to com.xxx  linsong.wei 2017-11-17 10:28:23
        int flag = -1;
        try {

            computerService.updateByPrimaryKeySelective(computer);

            flag = 1;
        } catch (Exception e) {
            flag = -1;
            throw new RuntimeException();
        }
        map.put("flag", flag);
        return map;
    }


    /*
       purpose:获取一个电脑实体的集合，对页面上选中的电脑进行更新操作
       Create by : linsong.wei  2017-11-17 09:00:01
    */
    @RequestMapping("/UpdateComputer")
    @Transactional(propagation = Propagation.REQUIRED)  //update by: linsong.wei 2017年11月29日17:59:20
    public @ResponseBody
    HashMap doUpdateComputer(HttpServletRequest request, HttpServletResponse response, @RequestBody Computer[] computers) {

        HashMap map = new HashMap();
        //用数组接收，用List<Computer>会报java.util.LinkedHashMap cannot be cast to com.xxx  linsong.wei 2017-11-17 10:28:23
        int flag = -1;
        try {
            for (int i = 0; i < computers.length; i++) {
                computerService.updateByPrimaryKeySelective(computers[i]);
            }
            flag = 1;
        } catch (Exception e) {
            flag = -1;
            throw new RuntimeException();
        }
        map.put("flag", flag);
        return map;
    }


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
    HashMap print(HttpServletRequest request, HttpServletResponse response, @RequestParam("page") String page, @RequestParam("limit") String limit) {
        HashMap map = new HashMap();
        Computer computer = new Computer();
//        List<Computer> computerList = computerService.selectAllComputers(computer);
        //添加分页 2017-12-08 20:16:10
        int start = (Integer.valueOf(page)-1)*Integer.valueOf(limit);
        int offset = Integer.valueOf(limit);
        List<Computer> computerList = computerService.selectComputerLists(start,offset);
        map.put("code", 0);
        map.put("msg", "");
        int count = computerService.selectCountCpt();
        map.put("count",count);
        map.put("data", computerList);
        return map;
    }

    //展示电脑列表页面(有过滤)
    //Create by linsong.wei 2017-11-11 08:41:32
    @RequestMapping(value = "/computerListFilter", method = RequestMethod.GET)
    public @ResponseBody
    HashMap computerListFilter(HttpServletRequest request, HttpServletResponse response, @RequestParam("page") String page, @RequestParam("limit") String limit) {
        HashMap map = new HashMap();
        String cptName = null;
        String cptRam = null;
        String cptCpu = null;
        String cptOs = null;
        String cptIslending = null;
        String cptCard = null;
        Computer computer = new Computer();
        int start = (Integer.valueOf(page)-1)*Integer.valueOf(limit);
        int offset = Integer.valueOf(limit);
        try {
            cptName = URLDecoder.decode(request.getParameter("cptName"), "utf-8");//将中文转码
            cptRam = URLDecoder.decode(request.getParameter("cptRam"), "utf-8");//将中文转码
            cptCpu = URLDecoder.decode(request.getParameter("cptCpu"), "utf-8");//将中文转码
            cptOs = URLDecoder.decode(request.getParameter("cptOs"), "utf-8");//将中文转码
            cptIslending = URLDecoder.decode(request.getParameter("cptIslending"), "utf-8");
            if (!cptIslending.equals(null))
                computer.setCptIslending(cptIslending);
            cptCard = URLDecoder.decode(request.getParameter("cptCard"), "utf-8");
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
        if (cptIslending.equals(null)) {
            if (cptIslending.equals("")) {
                computer.setCptIslending(null);
            } else {
                computer.setCptIslending(cptIslending);
            }
        }
        if (!cptCard.equals(null)) {
            computer.setCptGraphicscard(cptCard);
        }
        List<Computer> computerList = computerService.selectAllComputers(computer.getCptName(),computer.getCptRam(),computer.getCptCpu(),computer.getCptOs(),computer.getCptGraphicscard(),computer.getCptIslending(),start,offset);
        map.put("code", 0);
        map.put("msg", "");
        map.put("data", computerList);

        return map;
    }


}
