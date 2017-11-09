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

<br /><br /><br /><br /><br /><br />

<div class="car">
    <div class="body">
        <div class="loginBox" style="border:2px solid #000">
            <div class="login_cont">
                <form action="/user/FormLogin" method="post">
                <ul class="login">
                    <li class="l_tit" style="color:#000">邮箱/用户名/手机号</li>
                    <li class="mb_10"><input type="text" name="userName" class="login_input" style="border:#000 solid 1px"></li>
                    <li class="l_tit" style="color:#000">密码</li>
                    <li class="mb_10"><input type="Password" name="userPassword" class="login_input"  id="userPassword" style="border:#000 solid 1px"></li>
                    <li class="autoLogin">
                        <label><input name="identity1" type="radio" value="user" checked/>用户</label>
                        <label><input name="identity2" type="radio" value="admin" />管理员</label>
                    </li>
                    <li><input type="submit" value="" class="login_btn"></li>
                </ul>
                </form>
                <div class="login_partners">
                    <p class="l_tit" style="color:#000">使用合作方账号登陆网站</p>
                    <ul class="login_list clearfix">
                        <li><a href="#" style="color:#000">QQ</a></li>
                        <li><span style="color:#000">|</span></li>
                        <li><a href="#" style="color:#000">新浪微博</a></li>
                        <li><span style="color:#000">|</span></li>
                        <li><a href="#" style="color:#000">腾讯微博</a></li>
                        <li><span style="color:#000">|</span></li>
                        <li><a href="#" style="color:#000">新浪微博</a></li>
                        <li><span style="color:#000">|</span></li>
                        <li><a href="#" style="color:#000">腾讯微博</a></li>
                        <li><span style="color:#000">|</span></li>
                        <li><a href="#" style="color:#000">微信</a></li>
                    </ul>
                </div>
            </div>
            <a class="reg_link" href="#" onclick="doRegister()"></a>
        </div>
        <div class="mirror-wrap">
            <div class="mirror-inner">
                <div class="mirror">
                    <div class="shine"></div>
                </div>
            </div>
        </div>
        <div class="middle">
            <div class="top">
                <div class="line"></div>
            </div>
            <div class="bottom">
                <div class="lights">
                    <div class="line"></div>
                </div>
            </div>
        </div>
        <div class="bumper">
            <div class="top"></div>
            <div class="middle" data-numb="&#2348;&#2366; &#2415;&#2411; &#2330; &#2415;&#2411;&#2415;&#2411;"></div>
            <div class="bottom"></div>
        </div>
    </div>
    <div class="tyres">
        <div class="tyre back"></div>
        <div class="tyre front"></div>
    </div>
</div>
<div class="road-wrap">
    <div class="road">
        <div class="lane-wrap">
            <div class="lane">
                <div></div>
                <div></div>
                <div></div>
                <div></div>
                <div></div>
                <div></div>
                <div></div>
                <div></div>
                <div></div>
                <div></div>
                <div></div>
            </div>
        </div>
    </div>
</div>

</body>
<script src="/js/layui.js"></script>
<script>
    layui.use('layer', function(){
        var layer = layui.layer;


    });

    function doRegister() {
        layer.open({
            type: 2,
            title:'用户注册',
            area: ['900px', '600px'],
            content: 'http://localhost:8080/html/register.html' //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
        });
    }

</script>
</html>
