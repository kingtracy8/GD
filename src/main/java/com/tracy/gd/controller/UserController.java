package com.tracy.gd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tracy.gd.domain.Computer;
import com.tracy.gd.domain.LendingHistory;
import com.tracy.gd.domain.checkPass;
import com.tracy.gd.service.ILendingHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tracy.gd.domain.User;
import com.tracy.gd.service.IUserService;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private ILendingHistoryService lendingHistoryService;

    @RequestMapping("/showUser")
    public String toIndex(HttpServletRequest request, Model model) {
        // int userId = Integer.parseInt(request.getParameter("id"));
        // User user = this.userService.getUserById(userId);
        // model.addAttribute("user", user);
        return "showUser";
    }

    //离职，更换机器开发

    //筛选用户
    //Create by linsong.wei 2017-11-21 15:12:31
    @RequestMapping(value = "/userListFilter", method = RequestMethod.GET)
    public @ResponseBody
    HashMap computerListFilter(HttpServletRequest request, HttpServletResponse response) {
        HashMap map = new HashMap();
        String userName = null;
        String userNum = null;
        String userPhone = null;
        String userDepartment = null;
        String userGender = null;
        String attribute1 = null;
        User user = new User();

        try {
            userName = URLDecoder.decode(request.getParameter("userName"), "utf-8");//将中文转码
            userNum = URLDecoder.decode(request.getParameter("userNum"), "utf-8");//将中文转码
            userPhone = URLDecoder.decode(request.getParameter("userPhone"), "utf-8");//将中文转码
            userDepartment = URLDecoder.decode(request.getParameter("userDepartment"), "utf-8");//将中文转码
            userGender = URLDecoder.decode(request.getParameter("userGender"), "utf-8");
            if (!userGender.equals(null))
                user.setUserGender(userGender);
            attribute1 = URLDecoder.decode(request.getParameter("attribute1"), "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {

        } //筛选条件


        if (!userName.equals("")) {
            user.setUserName(userName);
        }
        if (!userNum.equals("")) {
            user.setUserNum(userNum);
        }
        if (!userPhone.equals("")) {
            user.setUserPhone(userPhone);
        }
        if (!attribute1.equals(null)) {
            if (attribute1.equals("")) {
                user.setAttribute1(null);        //因为sql使用的是 = ，使用""匹配不上
            } else {
                user.setAttribute1(attribute1);
            }
        }
        if (userGender.equals(null)) {
            if (userGender.equals("")) {
                user.setUserGender(null);
            } else {
                user.setUserGender(userGender);
            }
        }
        if (!userDepartment.equals("")) {
            user.setUserDepartment(userDepartment);
        }
        List<User> users = userService.selectUserFilter(user);
        map.put("code", 0);
        map.put("msg", "");
        map.put("data", users);

        return map;
    }


    /*
   purpose:获得界面上选中的用户并删除
   Create by : linsong.wei  2017-11-21 09:48:58
*/
    @RequestMapping("/DeleteUser")
    public @ResponseBody
    HashMap doDeleteUser(HttpServletRequest request, HttpServletResponse response, @RequestBody User[] users) {

        HashMap map = new HashMap();

        int flag = 0;
        try {
            for (int i = 0; i < users.length; i++) {
                userService.deleteByPrimaryKey(users[i].getUserId());
            }
            flag = 1;
        } catch (Exception e) {
            flag = -1;
        }
        map.put("flag", flag);
        return map;
    }


    /*
       purpose:获得界面上选中的用户纪录并更新
       Create by : linsong.wei  2017-11-20 13:47:57
    */
    @RequestMapping("/UpdateUser")
    @Transactional(propagation = Propagation.REQUIRED)   //使用Try catch时，需要手动抛异常，否则不能回滚  linsong.wei 2017-11-29 16:21:31
    public @ResponseBody
    HashMap doUpdateUser(HttpServletRequest request, HttpServletResponse response, @RequestBody User[] users) {

        HashMap map = new HashMap();

        int flag = 0;
        try {
            for (int i = 0; i < users.length; i++) {
                userService.updateByPrimaryKeySelective(users[i]);
            }
            flag = 1;
        } catch (Exception e) {
            flag = -1;
            throw new RuntimeException();
        }
        map.put("flag", flag);
        return map;
    }


    //用户管理页面
    //Create by linsong.wei 2017-11-20 13:16:00
    @RequestMapping(value = "/UserManager", method = RequestMethod.GET)
    public @ResponseBody
    HashMap print(HttpServletRequest request, HttpServletResponse response) {
        HashMap map = new HashMap();
        List<User> userList = userService.selectAll();
        map.put("code", 0);
        map.put("msg", "");
        map.put("data", userList);
        return map;
    }


    //purpose : 通过laid找审核详情
    // Create by linsong.wei 2017-11-16 15:44:05
    @RequestMapping(value = "/AuditingDetailBylhLaId", method = RequestMethod.GET)
    public @ResponseBody
    LendingHistory doFindById(HttpServletRequest request, HttpServletResponse response) {

        int lhLaId;
        lhLaId = Integer.parseInt(request.getParameter("lhLaId"));
        LendingHistory lendingHistory = lendingHistoryService.selectDetailByLaId(lhLaId);

        return lendingHistory;
    }


    /*
        purpose: 退出时清除session里的值
        author:  linsong.wei
        when:   2017-11-13 17:46:52
     */
    @RequestMapping("/logout")
    public @ResponseBody
    HashMap doLogOut(HttpServletRequest request, HttpServletResponse response) {
        HashMap map = new HashMap();
        int flag = -1;
        try {
            request.getSession().removeAttribute("userName");
            request.getSession().removeAttribute("identity");
            request.getSession().removeAttribute("userId");
            flag = 1;
        } catch (Exception e) {
            flag = 0;
        }
        map.put("flag", flag);
        return map;
    }


    //修改用户密码 Create by: linsong.wei 2017-11-11 14:04:33
    //function: ajax获得一个密码对象，更新到当前用户的密码中
    @RequestMapping("/changePass")
    @Transactional(propagation = Propagation.REQUIRED)
    public @ResponseBody
    HashMap doChangePass(HttpServletRequest request, HttpServletResponse response, @RequestBody checkPass checkPass) {
        HashMap map = new HashMap();
        int flag = 0;
        int curUserId = (Integer) request.getSession().getAttribute("userId");
        User curUser = userService.getUserById(curUserId);
        curUser.setUserPassword(checkPass.getNewPass());    //设置成为新的密码
        flag = userService.updateByPrimaryKey(curUser);
        map.put("flag", flag);
        return map;
    }


    //验证原密码是否正确
    // 2017-11-11 13:35:10 Create by linsong.wei
    @RequestMapping("/CheckPassword")
    public @ResponseBody
    HashMap doCheckPass(HttpServletRequest request, HttpServletResponse response, @RequestBody checkPass checkPass) {

        HashMap map = new HashMap();

        int curUserId = (Integer) request.getSession().getAttribute("userId");
        User curUser = userService.getUserById(curUserId);
        if (curUser.getUserPassword().equals(checkPass.getOrgPass().trim())) {
            map.put("flag", "sucess");
        } else {
            map.put("flag", "faild");
        }
        return map;
    }


    //用户注册
    // 2017-11-10 10:37:48 Create by linsong.wei
    // 疑问1：@ResponseBody标签参数中有requset和response则在页面中才更方便的取json数据
    @RequestMapping("/RegisterUser")
    @Transactional(propagation = Propagation.REQUIRED)      //出异常的时候事务控制，回滚操作 Create by:linsong.wei 2017-11-29 16:15:45
    public @ResponseBody
    HashMap doRegister(HttpServletRequest request, HttpServletResponse response, @RequestBody User user) {

        HashMap map = new HashMap();
        User inUser = user;
        inUser.setRegisterTime(new Date());
        //只能注册成为user
        inUser.setAttribute1("user");
        int flag = userService.insertSelective(inUser);
        map.put("flag", flag);
        return map;
    }


    //获取用户身份
    @RequestMapping("/GetIdentity")
    public @ResponseBody
    HashMap getIdentity(HttpServletRequest request, HttpServletResponse response) {
        String identity = (String) request.getSession().getAttribute("identity");
        HashMap map = new HashMap();
        map.put("identity", identity);
        return map;
    }

    //获得用户详情
    @RequestMapping("/PersonDetail")
    public @ResponseBody
    User showPersonalInfo(HttpServletRequest request, HttpServletResponse response) {
        int userId = (Integer) request.getSession().getAttribute("userId");
        User user = userService.getUserById(userId);
        return user;
    }

    //修改用户信息
    @RequestMapping("/EditUser")
    @Transactional(propagation = Propagation.REQUIRED)
    public @ResponseBody
    int EditUser(HttpServletRequest request, HttpServletResponse response, @RequestBody User user) {
        int flag = 0;
        /* version 1
        //重置按钮会把页面上的id给清除掉，若不点重置则不会
        if(!user.getUserId().equals("")){
            flag = userService.updateByPrimaryKey(user);
            return flag;
        }else { //如果被清空了，就从session里拿到当前用户id
            User user1 = userService.getUserById((Integer) request.getSession().getAttribute("userId"));
            user.setUserId(user1.getUserId());  //把传进来的丢失了id的用户设置id
            flag = userService.updateByPrimaryKey(user);
        }
        */
        //不让重置 2017-11-09 22:30:10
        //flag = userService.updateByPrimaryKey(user);
        //防止更新个人信息的时候把用户身份给更新成null
        flag = userService.ChangePersonalMsg(user);
        return flag;
    }


    @RequestMapping(value = "/GetUser", method = RequestMethod.POST)
    public @ResponseBody
    User GetUser(@RequestBody User user) {
        //	user = userService.getUserById(2);
        userService.updateByPrimaryKey(user);
        //   userService.deleteByPrimaryKey(user.getId());
        return user;
    }

    /**
     * 检查用户名和密码
     */
    @RequestMapping(value = "/checkLogin", method = RequestMethod.POST)
    public @ResponseBody
    int
    test(HttpServletRequest request, HttpServletResponse response, @RequestBody User user) {
        int flag = 0;
        List<User> userList = userService.selectAll();

        for (int i = 0; i < userList.size(); i++) {

            String userName = userList.get(i).getUserName();
            String userPassword = userList.get(i).getUserPassword();

            if (user.getUserName().equals(userName) && user.getUserPassword().equals(userPassword)) {
//                    response.sendRedirect("../../html/success.html");
                flag = 1;
                return flag;
            } else {
//                    response.sendRedirect("../../html/error.html");
                flag = 0;
            }
        }
        return flag;

    }

    @RequestMapping(value = "/LoginTest")
    public String Logintest(HttpServletRequest request, HttpServletResponse response) {


        if (1 == 1) {
            try {
                response.sendRedirect("../../html/admin.html");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                response.sendRedirect("../../html/error.html");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "error";
    }

    //检查form表单提交的用户名和密码是否正确
    @RequestMapping(value = "/FormLogin", method = RequestMethod.POST)
    public String
    CheckFormLogin(HttpServletRequest request, HttpServletResponse response) {
        String Url = null;
        //当数据库没有数据的时候会抛出空指针异常
    /*
        Update By: linsong.wei 2017-11-13 13:58:59
        purpose:

        1.获得身份，如果是用户，去查用户表，如果是管理员去查管理员表
        2.因为管理员有可能作为用户去借用电脑，即验证成功后，为了便于之前的设计方式，把管理员id
          存储到session的userId里，身份identity存储为"admin",即管理员此时既是用户又是管理员身份
        3.注：2中因为表设计问题，只能用admin中的admin_num字段存储user_id，即。。

        放弃上面的想法，把user表中的atrribute当作身份字段吧，这样也可以更方便的添加一个功能，升级成为管理员
        只是admin表暂时就冗余了， linsong.wei 2017-11-13 14:16:23
    */
//        String identity = request.getParameter("identity");

        List<User> userList = userService.selectAll();

        if (userList.size() > 0) {
            for (int i = 0; i < userList.size(); i++) {

                String userName = userList.get(i).getUserName();
                String userPassword = userList.get(i).getUserPassword();


                if (request.getParameter("userName").equals(userName) && request.getParameter("userPassword").equals(userPassword)) {
                    Url = "admin";
                    request.getSession().setAttribute("userName", request.getParameter("userName"));
                    //如果验证成功 直接跳转 否则for循环会影响最终的结果
                    //把身份放入Session
                    //需求变更后，直接从attribute1中取出身份
                    String identity = userList.get(i).getAttribute1();
                    request.getSession().setAttribute("identity", identity);
//                    request.getSession().setAttribute("identity", request.getParameter("identity"));

                    request.getSession().setAttribute("userId", userList.get(i).getUserId());

                    return Url;
                } else {
                    Url = "error";
                    request.getSession().setAttribute("userName", request.getParameter("error"));
                }
            }
        } else {
            Url = "error";
        }
        return Url;

    }

}
