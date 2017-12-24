package com.tracy.gd.controller;

import com.tracy.gd.dto.lengding;
import com.tracy.gd.domain.Expense;
import com.tracy.gd.domain.LendingApply;
import com.tracy.gd.domain.LendingHistory;
import com.tracy.gd.domain.User;
import com.tracy.gd.dto.addUser;
import com.tracy.gd.dto.updateExpense;
import com.tracy.gd.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by trcay on 2017/12/10.
 */
@Controller
@RequestMapping(value = "/csu")
public class CommonController {


    @Autowired
    private IUserService userService;

    /**
     * 跳转到缴费管理页面
     * linsong.wei 2017-12-24 19:33:15
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/expenseManager")
    public String doExpenseManager(HttpServletRequest request, Model model) {

        return "ExpenseManager";
    }


    /**
     * 跳转到用户注册页面
     * 2017-12-19 19:13:49 Create by linsong.wei
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/register")
    public String doRegister(HttpServletRequest request, Model model) {
        return "register";
    }


    /**
     * 跳转到申请电脑页面
     * 2017-12-19 10:05:36 Create by linsong.wei
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/ApplyCpt")
    public String doApplyCpt(HttpServletRequest request, Model model) {
        return "LendingApply";
    }


    @RequestMapping("/AddUserPage")
    public String doShowAddUserPage(HttpServletRequest request, Model model) {
        return "addUser"; //返回jsp视图
    }


    /**
     * 处理添加用户jsp页面提交的请求 防止重复提交
     * 2017-12-18 20:28:11 Create by linsong.wei
     *
     * @param request
     * @param response
     * @param adduser
     * @return
     */
    @RequestMapping("/AddUser")
    @Transactional(propagation = Propagation.REQUIRED)
    public @ResponseBody
    HashMap doRegister(HttpServletRequest request, HttpServletResponse response, @RequestBody addUser adduser) {

        HashMap map = new HashMap();
        User inUser = new User();
        //将dto的数据相应的赋予dao
        inUser.setUserName(adduser.getUserName());
        inUser.setUserNum(adduser.getUserNum());
        inUser.setUserPassword(adduser.getUserPassword());
        inUser.setUserDepartment(adduser.getUserDepartment());
        inUser.setUserEmail(adduser.getUserEmail());
        inUser.setUserPhone(adduser.getUserPhone());
        inUser.setUserGender(adduser.getUserGender());

        int flag = -1;
        String ptoken = adduser.getToken();//表单
        String stoken = (String) request.getSession().getAttribute("token");
        if (ptoken != null && ptoken.equals(stoken)) {
            request.getSession().removeAttribute("token");
            inUser.setRegisterTime(new Date());
            //只能注册成为user
            inUser.setAttribute1("user");
            flag = userService.insertSelective(inUser);


        } else {
//            System.out.println("请不要重复提交");
            flag = -2; //-2标志为重复提交
        }
        map.put("flag", flag);
        return map;
    }


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

        List<User> userList = userService.selectAllByUserName(name, position);

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
