<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <meta charset="utf-8">
    <title>登陆</title>
    <link type="text/css" rel="stylesheet" href="style/reset.css">
    <link type="text/css" rel="stylesheet" href="style/main.css">
    <script src="js/jquery-3.2.1.min.js"></script>
</head>
<body>
<div class="headerBar">
    <div class="logoBar login_logo">
        <h3 class="welcome_title"> 欢迎登录 </h3>
    </div>
</div>

<div class="loginBox">
    <div class="login_cont">
        <form action="/user/FormLogin" method="post">
        <ul class="login">
            <li class="l_tit">邮箱/用户名/手机号</li>
            <li class="mb_10"><input type="text" name="userName" class="login_input user_icon"></li>
            <li class="l_tit">密码</li>
            <li class="mb_10"><input type="Password" name="userPassword" class="login_input user_icon" id="userPassword"></li>
            <li class="autoLogin"><input type="checkbox" id="a1" class="checked"><label for="a1">自动登陆</label></li>
            <li><input type="submit"  class="login_btn" value=""></li>
        </ul>
        </form>
        <div class="login_partners">
            <p class="l_tit">使用合作方账号登陆网站</p>
            <ul class="login_list clearfix">
                <li><a href="#">QQ</a></li>
                <li><span>|</span></li>
                <li><a href="#">网易</a></li>
                <li><span>|</span></li>
                <li><a href="#">新浪微博</a></li>
                <li><span>|</span></li>
                <li><a href="#">腾讯微博</a></li>
                <li><span>|</span></li>
                <li><a href="#">新浪微博</a></li>
                <li><span>|</span></li>
                <li><a href="#">腾讯微博</a></li>
            </ul>
        </div>
    </div>
    <a class="reg_link" href="#"></a>
</div>

<div class="hr_25"></div>
<div class="footer">
    <p><a href="#">网站首页</a><i>|</i><a href="#">公告信息</a><i>|</i> <a href="#">招纳贤士</a><i>|</i><a href="#">联系我们</a><i>|</i>联系电话：666-6666-66666
    </p>
    <p>Copyright &copy; 2016 - 2017 版权所有&nbsp;&nbsp;&nbsp;京ICP备0906664号&nbsp;&nbsp;&nbsp;京ICP证B10666-8373号&nbsp;&nbsp;&nbsp;某市公安局XX分局备案编号：167666999</p>
    <p class="web"><a href="#"><img src="../images/webLogo.jpg" alt="logo"></a><a href="#"><img
            src="../images/webLogo.jpg" alt="logo"></a><a href="#"><img src="../images/webLogo.jpg" alt="logo"></a><a
            href="#"><img src="../images/webLogo.jpg" alt="logo"></a></p>
</div>
</body>
</html>
