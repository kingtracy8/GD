<%--
  Created by IntelliJ IDEA.
  User: trcay
  Date: 2017/12/10
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <meta charset="utf-8">
    <title>登陆</title>

    <script src="js/jquery-3.2.1.min.js"></script>


    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    <%--<meta name="keywords" content="Flat Dark Web Login Form Responsive Templates, Iphone Widget Template, Smartphone login forms,Login form, Widget Template, Responsive Templates, a Ipad 404 Templates, Flat Responsive Templates" />--%>
    <link href="style/LoginForm.css" rel='stylesheet' type='text/css' />
    <%--<!--webfonts-->--%>
    <%--<link href='http://fonts.useso.com/css?family=PT+Sans:400,700,400italic,700italic|Oswald:400,300,700' rel='stylesheet' type='text/css'>--%>
    <%--<link href='http://fonts.useso.com/css?family=Exo+2' rel='stylesheet' type='text/css'>--%>
    <%--<!--//webfonts-->--%>

    <style>
        .reg_link{width:115px; height:31px; background:url(images/icon/red_link.jpg);  left: 550px; top: 475px; position:absolute; right:31px; bottom:-31px;z-index: 999}
    </style>

</head>
<body>

<script>$(document).ready(function(c) {
    $('.close').on('click', function(c){
        $('.login-form').fadeOut('slow', function(c){
            $('.login-form').remove();
        });
    });
});
</script>
<!--SIGN UP-->
<h1>Csu Login Form</h1>
<div class="login-form">
    <div class="close"> </div>
    <div class="head-info">
        <label class="lbl-1"> </label>
        <label class="lbl-2"> </label>
        <label class="lbl-3"> </label>
    </div>
    <div class="clear"> </div>
    <div class="avtar">
        <img src="images/lg_img/avtar.png" />
    </div>
    <form action="/csu/platform" method="post">
        <input type="text" name="userName" class="text" value="Username" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Username';}" >
        <div class="key">
            <input type="password" name="userPassword" id="userPassword" value="Password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Password';}" style="margin-bottom:20px">
            <ul style="margin-top:0px;text-align: center">
                <li class="autoLogin" style="text-align: center;margin-bottom:20px;">
                    <label  style="color:#FFF"><input  name="identity" type="radio" value="user" checked/>用户</label>
                    <label style="color:#C30"><input name="identity" type="radio" value="admin"/>管理员</label>
                </li>
            </ul>
        </div>
        <div class="signin">
            <input type="submit" value="Login" >
        </div>
    </form>
</div>
<a class="reg_link" onclick="doRegister()"></a>
</div>

</div>
<div class="copy-rights">
    <p>Copyright &copy; 2017 linsong.wei All rights reserved. Contact us <a href="https://weibo.com/u/3037977221?refer_flag=1001030101_" target="_blank" title="新浪微博">@__特雷西</a>  E-mail <a title="E-mail" target="_blank">linsong_wei@163.com</a></p>
</div>


<script src="/js/layui.js"></script>
<script>
    layui.use('layer', function () {
        var layer = layui.layer;
    });

    function doRegister() {
        var index = layer.open({
            type: 2,
            title: '用户注册',
            offset: '100px',  //水平居中
            area: ['700px', '500px'],
            content: 'http://localhost:8080/html/register.html' //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
        });
        layer.iframeAuto(index);    //自适应

    }

</script>
<script>

    $(function () {
    })

</script>


</body>
</html>
