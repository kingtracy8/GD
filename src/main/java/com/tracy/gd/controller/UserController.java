package com.tracy.gd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tracy.gd.domain.User;
import com.tracy.gd.service.IUserService;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/showUser")
    public String toIndex(HttpServletRequest request, Model model) {
        // int userId = Integer.parseInt(request.getParameter("id"));
        // User user = this.userService.getUserById(userId);
        // model.addAttribute("user", user);
        return "showUser";
    }
    @RequestMapping("/PersonDetail")
    public @ResponseBody
    User showPersonalInfo(HttpServletRequest request, HttpServletResponse response){
        int userId = (Integer) request.getSession().getAttribute("userId");
        User user = userService.getUserById(userId);
        return user;
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

            List<User> userList = userService.selectAll();

            if(userList.size()>0) {
                for (int i = 0; i < userList.size(); i++) {

                    String userName = userList.get(i).getUserName();
                    String userPassword = userList.get(i).getUserPassword();



                    if (request.getParameter("userName").equals(userName) && request.getParameter("userPassword").equals(userPassword)) {
                        Url = "admin";
                        request.getSession().setAttribute("userName", request.getParameter("userName"));
                        //如果验证成功 直接跳转 否则for循环会影响最终的结果
                        //把身份放入Session
                        request.getSession().setAttribute("identity",request.getParameter("identity1"));

                        request.getSession().setAttribute("userId",userList.get(i).getUserId());

                        return Url;
                    } else {
                        Url = "error";
                        request.getSession().setAttribute("userName", request.getParameter("error"));
                    }
                }
            }else {
                Url = "error";
            }
            return Url;


    }

}
