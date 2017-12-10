package com.tracy.gd.controller;

import com.tracy.gd.domain.User;
import com.tracy.gd.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by trcay on 2017/12/10.
 */
@Controller
@RequestMapping(value = "/csu")
public class CommonController {


    @Autowired
    private IUserService userService;

    //检查form表单提交的用户名和密码是否正确
    @RequestMapping(value = "/platform", method = RequestMethod.POST)
    public String
    doCheckFormLogin(HttpServletRequest request, HttpServletResponse response) {
        String Url = null;
        //当数据库没有数据的时候会抛出空指针异常


        //update by Linsong.wei : 通过用户名去找密码 2017-12-10 13:19:46
        String name = request.getParameter("userName");
        String pass = request.getParameter("userPassword");
        //获得表单提交过来的身份
        String position = request.getParameter("identity");

        List<User> userList = userService.selectAllByUserName(name,position);

        if (userList.size() > 0) {
            for (int i = 0; i < userList.size(); i++) {

                String userName = userList.get(i).getUserName();
                String userPassword = userList.get(i).getUserPassword();


                if (name.equals(userName) && pass.equals(userPassword)) {
                    Url = "admin";
                    request.getSession().setAttribute("userName", request.getParameter("userName"));
                    //如果验证成功 直接跳转 否则for循环会影响最终的结果
                    //把身份放入Session
                    //需求变更后，直接从attribute1中取出身份
                    String identity = userList.get(i).getAttribute1();
                    request.getSession().setAttribute("identity", identity);

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
