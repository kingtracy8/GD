<%--
  Created by IntelliJ IDEA.
  User: linsong.wei
  Date: 2017/10/14
  Time: 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title> csu system</title>
    <link rel="stylesheet" href="../../js/css/layui.css">
    <style>


        .demo-carousel {
            height: 200px;
            line-height: 200px;
            text-align: center;
        }
    </style>

</head>
<body class="layui-layout-body">

<%
    String userName = (String) request.getSession().getAttribute("userName");
    String identity = (String) request.getSession().getAttribute("identity");
    int userId = (int) request.getSession().getAttribute("userId");
%>

<div class="layui-layout layui-layout-admin ">
    <div class="layui-header ">
        <div class="layui-logo">csu system</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left ">
            <li class="layui-nav-item"><a href="#">控制台</a></li>
            <li class="layui-nav-item"><a href="#">系统管理</a></li>
            <li class="layui-nav-item"><a href="#">
                <%--<%=identity%>--%>用户
            </a></li>
            <li class="layui-nav-item">
                <a href="javascript:void(0)">其它系统</a>
                <dl class="layui-nav-child">
                    <dd><a href="#">邮件管理</a></dd>
                    <dd><a href="#">消息管理</a></dd>
                    <dd><a href="#">授权管理</a></dd>
                </dl>
            </li>
        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="../../images/me.jpg" class="layui-nav-img">
                    <span id="user"><%=userName%></span>
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="../../html/PersonalInfo.html" target="ifrbody">修改个人资料</a></dd>
                    <dd><a href="../../html/changePassword.html" target="ifrbody">修改个人密码</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="#" onclick="logout()">退出</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree" lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;">用户模块</a>
                    <dl class="layui-nav-child">
                        <dd><a href="../../html/PersonalInfo.html" target="ifrbody">查看/修改个人信息</a></dd>
                        <dd><a href="../../html/changePassword.html" target="ifrbody">修改密码</a></dd>
                        <dd><a href="../../html/computersList.html" target="ifrbody">计算机使用申请</a></dd>
                        <dd><a href="../../html/ApplyHistory.html" target="ifrbody">申请记录</a></dd>
                        <dd><a href="javascript:;">发表评论</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">管理员模块</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;" id="userControl">用户管理</a></dd>
                        <dd><a href="javascript:;" id="computerControl">计算机档案管理</a></dd>
                        <dd><a href="../../html/Auditing.html" target="ifrbody" id="auditingControl">审核管理</a></dd>
                        <dd><a href="javascript:;" id="recordControl">记录管理</a></dd>
                        <dd style="display: none"><a href="javascript:;" id="identity"><%=identity%>
                        </a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item"><a href="#">云市场</a></li>
                <li class="layui-nav-item"><a href="#">关于</a></li>
            </ul>
        </div>
    </div>

    <div class="layui-body">

        <iframe id="ifrbody" name="ifrbody" src="../../html/welcome.html" scrolling="yes"
                onload="changeFrameHeight()"></iframe>

    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © Power by linsong.wei
    </div>
</div>
<script src="../js/jquery-3.2.1.min.js"></script>
<script src="../../js/layui.js"></script>
<script>
    //JavaScript代码区域
    layui.use(['laydate', 'laypage', 'layer', 'table', 'carousel', 'upload', 'element'], function () {
        var laydate = layui.laydate //日期
            , laypage = layui.laypage //分页
        layer = layui.layer //弹层
            , table = layui.table //表格
            , carousel = layui.carousel //轮播
            , upload = layui.upload //上传
            , element = layui.element; //元素操作

        //向世界问个好
        //  layer.msg('Hi,欢迎您来到LayStudy后台管理系统！');

        //监听Tab切换
        element.on('tab(demo)', function (data) {
            layer.msg('切换了：' + this.innerHTML);
            console.log(data);
        });


        //执行一个轮播实例
        carousel.render({
            elem: '#test1'
            , width: '100%' //设置容器宽度
            , height: 200
            , arrow: 'none' //不显示箭头
            , anim: 'fade' //切换动画方式
        });

        //将日期直接嵌套在指定容器中
        var dateIns = laydate.render({
            elem: '#laydateDemo'
            , position: 'static'
            , calendar: true //是否开启公历重要节日
            , mark: { //标记重要日子
                '0-9-1': '开学'
                , '2017-9-15': ''
                , '2017-9-16': ''
            }
            , done: function (value, date, endDate) {
                if (date.year == 2017 && date.month == 9 && date.date == 15) {
                    dateIns.hint('明天不上班');
                }
            }
            , change: function (value, date, endDate) {
                layer.msg(value)
            }
        });

        //分页
        laypage.render({
            elem: 'pageDemo' //分页容器的id
            , count: 100 //总页数
            , skin: '#1E9FFF' //自定义选中色值
            //,skip: true //开启跳页
            , jump: function (obj, first) {
                if (!first) {
                    layer.msg('第' + obj.curr + '页');
                }
            }
        });

        //上传
        upload.render({
            elem: '#uploadDemo'
            , url: '' //上传接口
            , done: function (res) {
                console.log(res)
            }
        });
        //   window.location.href="../../html/admin.html";

        function changeFrameHeight() {
            var ifm = document.getElementById("ifrbody");
            ifm.height = document.documentElement.clientHeight;
            ifm.width = document.documentElement.clientWidth;
        }

        window.onload = function () {
            changeFrameHeight();
        }

        window.onresize = function () {
            changeFrameHeight();
        }


    });

    //在layui范围内定义的话会提示未定义 （应该是不是每次刷新页面都加载layui模块）
    function iframeLoad() {
        var ifm = document.getElementById("ifrbody");
        ifm.height = document.documentElement.clientHeight;
        ifm.width = document.documentElement.clientWidth;
    }

    function changeFrameHeight() {
        var ifm = document.getElementById("ifrbody");
        ifm.height = document.documentElement.clientHeight;
        ifm.width = document.documentElement.clientWidth;
    }
    window.onload = function () {
        changeFrameHeight();
    }

    window.onresize = function () {
        changeFrameHeight();
    }

    function logout() {
        layer.confirm('确定退出吗？', {
            btn: ['确定', '取消']

        }, function (index, layero) {
            //通过ajax去清除session里的值 update by: linsong.wei 2017-11-13 17:45:17
            $.ajax({
                url: "http://localhost:8080/user/logout",
                type: "POST",
                dataType: 'json',
                contentType: 'application/json;charset=UTF-8', //contentType很重要
                success: function (result) {
                    //如果为1则表示清除成功
                }
            });
            window.location.href = "../CarIndex.jsp"
        });

        //此处无法使用jsp代码块清理session的值并重定向，否则一登陆又直接返回登陆界面，
        // 貌似是因为jsp会默认先执行页面所有代码块？(调试时发现)
        <%--<%--%>
        <%--request.getSession().removeAttribute("userName");--%>
        <%--request.getSession().removeAttribute("identity");--%>
        <%--request.getSession().removeAttribute("identity");--%>
        <%--%>--%>

    }

    $(function () {
        iframeLoad();
        // var identity = $("#identity"); //获得身份
        //权限验证  linsong.wei 2017-11-13 15:03:18  ！= admin 是不是更严谨一些？

        if (jQuery.trim($("#identity").text()) == "user") {  //如果是user，没有权限使用管理员模块()

            //不能使用用户管理功能
            $("#userControl").attr('target', 'ifrbody');
            $("#userControl").attr('href', '../../html/Jurisdiction.html');

            $("#computerControl").attr('target', 'ifrbody');
            $("#computerControl").attr('href', '../../html/Jurisdiction.html');

            $("#auditingControl").attr('target', 'ifrbody');
            $("#auditingControl").attr('href', '../../html/Jurisdiction.html');

            $("#recordControl").attr('target', 'ifrbody');
            $("#recordControl").attr('href', '../../html/Jurisdiction.html');


        }
    });


</script>


</body>
</html>
