package com.tracy.gd.controller;

import com.tracy.gd.domain.Admin;
import com.tracy.gd.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by trcay on 2017/10/28.
 */

@Controller
@RequestMapping("/Admin")
public class AdminController {

    @Autowired
    IAdminService adminService;

    @RequestMapping(value = "/printAdmin")
    public String print() {
        List<Admin> admins = new ArrayList<Admin>();
        admins = adminService.selectUserAdmins();
        for (int i = 0; i < admins.size(); i++) {
            System.out.println(admins.get(i).getAdminId() + "," + admins.get(i).getAdminName() + "," + admins.get(i).getAdminPassword());
        }
        return "error";
    }

    @RequestMapping(value = "/ShowAdmins")
//    public @ResponseBody Admin showAdmins(){
    public @ResponseBody
    HashMap showAdmins() {
        List<Admin> admins = new ArrayList<Admin>();
        admins = adminService.selectUserAdmins();
        HashMap s = new HashMap();
        s.put("code", 0);
        s.put("msg", "");
        // s.put("count",100);
        // return admins.get(0);
        s.put("data", admins);
        return s;
    }

    @RequestMapping("/DeleteAdmin")
    public @ResponseBody
    int DeleteAdmin(@RequestBody Admin admin) {
        int flag = 0;
        int AdminId = admin.getAdminId();
        try {
            //执行删除操作
            adminService.deleteByPrimaryKey(AdminId);
            flag = 1;
        } catch (Exception e) {
            flag = 0;
        }
        return flag;
    }

}
