package com.tracy.gd.controller;

import com.tracy.gd.domain.Admin;
import com.tracy.gd.domain.User;
import com.tracy.gd.service.IAdminService;
import com.tracy.gd.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
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
@Transactional(propagation = Propagation.REQUIRED)
public class AdminController {

    @Autowired
    IAdminService adminService;
    @Autowired
    IUserService userService;

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

    //测试事物回滚 2017-11-29 10:16:58  linsong.wei
    @RequestMapping("/test")
    public @ResponseBody int addAdmin(Admin admin) {
        int flag = 0;
        try {
            Admin ad = new Admin();
            ad.setAdminName("test");
            adminService.insertSelective(ad);
//            User user = new User();
//            user.setUserName("aaa");
//            user.setUserNum("sfs");
//            userService.insertSelective(user);
            String str = null;
            if (str.equals("")) {
                int i = 0;
            }
        } catch (Exception e) {
            flag = -1;
            throw new RuntimeException();
        }
        return flag;
    }
}
