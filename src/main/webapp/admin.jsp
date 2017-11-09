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
    <title> Car Hire System</title>
    <link rel="stylesheet" href="/js/css/layui.css">
    <style>
        body{margin: 10px;}
        .demo-carousel{height: 200px; line-height: 200px; text-align: center;}
    </style>

</head>
<body class="layui-layout-body">

<%
    String userName = (String) request.getSession().getAttribute("userName");
%>

<div class="layui-layout layui-layout-admin ">
    <div class="layui-header ">
        <div class="layui-logo">Car Hire System</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left ">
            <li class="layui-nav-item"><a href="#">控制台</a></li>
            <li class="layui-nav-item"><a href="#">系统管理</a></li>
           <li class="layui-nav-item"><a href="#">用户</a></li>
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
                <a  href="javascript:;">
                    <img src="/images/me.jpg" class="layui-nav-img">
                    <span id="user"><%=userName%></span>
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="/html/PersonalInfo.html" target="ifrbody">基本资料</a></dd>
                    <dd><a href="#">安全设置</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="#">退出</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree"  lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;">数据管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;">学生管理</a></dd>
                        <dd><a href="javascript:;">课程管理</a></dd>
                        <dd><a href="javascript:;">题库管理</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">解决方案</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;" data-url="error.html">列表一</a></dd>
                        <dd><a href="javascript:;">列表二</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item"><a href="#">云市场</a></li>
                <li class="layui-nav-item"><a href="#">关于</a></li>
            </ul>
        </div>
    </div>

    <div class="layui-body">

        <iframe id="ifrbody" name="ifrbody" src="/html/welcome.html" scrolling="no" onload="changeFrameHeight()" ></iframe>

    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © layui.com - 底部固定区域
    </div>
</div>
<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/layui.js"></script>
<script>
    //JavaScript代码区域
    layui.use(['laydate', 'laypage', 'layer', 'table', 'carousel', 'upload', 'element'], function(){
        var laydate = layui.laydate //日期
            ,laypage = layui.laypage //分页
        layer = layui.layer //弹层
            ,table = layui.table //表格
            ,carousel = layui.carousel //轮播
            ,upload = layui.upload //上传
            ,element = layui.element; //元素操作

        //向世界问个好
        layer.msg('Hi,欢迎您来到LayStudy后台管理系统！');

        //监听Tab切换
        element.on('tab(demo)', function(data){
            layer.msg('切换了：'+ this.innerHTML);
            console.log(data);
        });


        //执行一个轮播实例
        carousel.render({
            elem: '#test1'
            ,width: '100%' //设置容器宽度
            ,height: 200
            ,arrow: 'none' //不显示箭头
            ,anim: 'fade' //切换动画方式
        });

        //将日期直接嵌套在指定容器中
        var dateIns = laydate.render({
            elem: '#laydateDemo'
            ,position: 'static'
            ,calendar: true //是否开启公历重要节日
            ,mark: { //标记重要日子
                '0-9-1': '开学'
                ,'2017-9-15': ''
                ,'2017-9-16': ''
            }
            ,done: function(value, date, endDate){
                if(date.year == 2017 && date.month == 9 && date.date == 15){
                    dateIns.hint('明天不上班');
                }
            }
            ,change: function(value, date, endDate){
                layer.msg(value)
            }
        });

        //分页
        laypage.render({
            elem: 'pageDemo' //分页容器的id
            ,count: 100 //总页数
            ,skin: '#1E9FFF' //自定义选中色值
            //,skip: true //开启跳页
            ,jump: function(obj, first){
                if(!first){
                    layer.msg('第'+ obj.curr +'页');
                }
            }
        });

        //上传
        upload.render({
            elem: '#uploadDemo'
            ,url: '' //上传接口
            ,done: function(res){
                console.log(res)
            }
        });
     //   window.location.href="../../html/admin.html";

        function changeFrameHeight(){
            var ifm= document.getElementById("ifrbody");
            ifm.height=document.documentElement.clientHeight;
            ifm.width = document.documentElement.clientWidth;
        }
        window.onload=function(){
            changeFrameHeight();
        }

        window.onresize=function(){
            changeFrameHeight();
        }

    });

//在layui范围内定义的话会提示未定义 （应该是不是每次刷新页面都加载layui模块）
    function iframeLoad()
    {
        var ifm= document.getElementById("ifrbody");
        ifm.height=document.documentElement.clientHeight;
        ifm.width = document.documentElement.clientWidth;
    }

    function changeFrameHeight(){
        var ifm= document.getElementById("ifrbody");
        ifm.height=document.documentElement.clientHeight;
        ifm.width = document.documentElement.clientWidth;
    }
    window.onload=function(){
        changeFrameHeight();
    }

    window.onresize=function(){
        changeFrameHeight();
    }

    $(function() {
        iframeLoad();
    })

</script>


</body>
</html>
