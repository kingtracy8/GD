<%--
  Created by IntelliJ IDEA.
  User: linsong.wei
  Date: 2017/12/19
  Time: 10:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>借用申请</title>
    <!--Create by : linsong.wei  2017-11-12 09:52:34   借用申请页面-->

    <link rel="stylesheet" href="../js/css/layui.css">
    <style>
        body {
            margin: 10px;
        }
    </style>

    <script src="../js/jquery-3.2.1.min.js"></script>
    <script>
        $(function () {
            //先用ajax获得当前的用户身份
            $.ajax({
                url: "http://localhost:8080/user/GetIdentity",
                type: "POST",
                dataType: 'json',
                contentType: 'application/json;charset=UTF-8', //contentType很重要
                success: function (result) {
                    var identity = result.identity;
                    $("#identity").text(identity);
                    document.getElementById("identity").text = identity;
                }
            });

            //页面初始化
            $("#cptName").val(GetQueryString("cptName"));
            $("#cptOs").val(GetQueryString("cptOs"));
            $("#cptRam").val(GetQueryString("cptRam"));
            $("#cptCpu").val(GetQueryString("cptCpu"));
            $("#laCptId").val(GetQueryString("cptId"));

//            由于url拼接问题  只能通过id从controller 获取电脑信息
            //注意type的类型，若controller为GET而这里type为POST则会有405错误
            $.ajax({
                url: "http://localhost:8080/Computer/cptInfoById?cptId=" + $("#laCptId").val(),       //去请求有过滤的电脑列表，只传入一个id
                type: "GET",
                dataType: 'json',
                contentType: 'application/json;charset=UTF-8', //contentType很重要
                success: function (result) {

                    $("#cptName").val(result.cptName);
                    $("#cptOs").val(result.cptOs);
                    $("#cptRam").val(result.cptRam);
                    $("#cptCpu").val(result.cptCpu);
                }
            });


        });


        function GetQueryString(name) {
            var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
            var r = window.location.search.substr(1).match(reg);
            if (r != null)return decodeURI(r[2]);
            return null;        //防止中文乱码用decodeURI替换unescape
        }


        //获得当前日期并给日期选择控件限定只能选今天以后

        function getNowFormatDate() {
            var date = new Date();
            var seperator1 = "-";
            var month = date.getMonth() + 1;
            var strDate = date.getDate();
            if (month >= 1 && month <= 9) {
                month = "0" + month;
            }
            if (strDate >= 0 && strDate <= 9) {
                strDate = "0" + strDate;
            }
            var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate;
            return currentdate;
        }


    </script>
</head>
<body>

<blockquote class="layui-elem-quote layui-text">
    这里是申请页面，请确认电脑信息，并填写申请信息。<div>${token}</div>
</blockquote>

<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>请您确认以下信息</legend>
</fieldset>

<!--从上个页面获得的信息不放在表单域里，既不传入后端，否则使用@RequestBody时候又得新写一个实体-->
<div class="layui-form-item">
    <label class="layui-form-label">电脑名称</label>
    <div class="layui-input-inline">
        <input type="text" name="cptName" id="cptName" autocomplete="off" class="layui-input" disabled>
    </div>

    <label class="layui-form-label">操作系统</label>
    <div class="layui-input-inline">
        <input type="text" name="cptOs" id="cptOs" autocomplete="off" class="layui-input" disabled>
    </div>
</div>

<div class="layui-form-item">
    <label class="layui-form-label">RAM</label>
    <div class="layui-input-inline">
        <input type="text" name="cptRam" id="cptRam" autocomplete="off" class="layui-input" disabled>
    </div>

    <label class="layui-form-label">CPU</label>
    <div class="layui-input-inline">
        <input type="text" name="cptCpu" id="cptCpu" autocomplete="off" class="layui-input" disabled>
    </div>
</div>

<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>请填写以下信息</legend>
</fieldset>
<form class="layui-form" action="">


    <div class="layui-form-item">

        <label class="layui-form-label" style="display: none">电脑ID</label>
        <div class="layui-input-inline" style="display: none">
            <input type="tel" name="laCptId" id="laCptId" autocomplete="off" class="layui-input"
                   disabled>
        </div>


        <label class="layui-form-label">申请理由</label>

        <div class="layui-input-inline">
            <select name="laReason" id="laReason" lay-verify="required" lay-search="">
                <option value="">直接选择或搜索选择</option>
                <option value="查资料">查资料</option>
                <option value="娱乐">娱乐</option>
                <option value="社团活动">社团活动</option>
                <option value="比赛">比赛</option>
                <option value="学习">学习</option>
                <option value="其他">其他</option>
            </select>
        </div>

    </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">借用时间从</label>
        <div class="layui-input-inline">
            <input type="text" name="laLendTime" id="laLendTime" placeholder="yyyy-MM-dd" autocomplete="off"
                   lay-verify="required"
                   class="layui-input">
        </div>

        <label class="layui-form-label">借用时间至</label>
        <div class="layui-input-inline">
            <input type="text" name="laReturnTime" id="laReturnTime" placeholder="yyyy-MM-dd" autocomplete="off"
                   lay-verify="required"
                   class="layui-input">
        </div>

    </div>


    <div class="layui-form-item">

        <label class="layui-form-label">地点</label>
        <div class="layui-input-inline">
            <select name="laLocation" lay-verify="required" lay-search="">
                <option value="">直接选择或搜索选择</option>
                <option value="校内">校内</option>
                <option value="兰州市">兰州市</option>
                <option value="榆中县">榆中县</option>
                <option value="天水市">天水市</option>
                <option value="省内">省内</option>
                <option value="其他">其他</option>
            </select>
        </div>


        <label class="layui-form-label">备注</label>
        <div class="layui-input-inline">
            <input type="tel" name="laCommons" id="laCommons" autocomplete="off" class="layui-input">
        </div>
    </div>


    <div class="layui-form-item" style="margin-top: 1.5%;margin-left: 17%">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit="" lay-filter="demo1">提交申请</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            <input type='hidden' name='token' value="${token}"/>
        </div>
    </div>
</form>

<div id="identity" style="display: none ;width: 0px"></div>

<script src="../js/layui.js"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
    layui.use(['form', 'layedit', 'laydate'], function () {
        var form = layui.form
            , layer = layui.layer
            , layedit = layui.layedit
            , laydate = layui.laydate;


        //日期
        laydate.render({
            elem: '#date'
        });
        laydate.render({
            elem: '#laLendTime',
            min: getNowFormatDate()         //只能从今天之后开始选
        });

        laydate.render({
            elem: '#laReturnTime',
            min: getNowFormatDate()
        });

        //创建一个编辑器
        var editIndex = layedit.build('LAY_demo_editor');


        //监听提交
        form.on('submit(demo1)', function (data) {


            if (data.field.laReturnTime < data.field.laLendTime) {  //时间验证
                //  layer.msg("归还日期不能早于借用日期！请重新选择");
                layer.alert('归还日期不能早于借用日期！', {icon: 5});
            } else {

                //ajax 提交
                data.field.laCptId = GetQueryString("cptId");   //layui表格重置之后 cptId会被清空，在这再次从url中设置一遍 linsong.wei 2017-11-12 13:35:22

//                layer.alert(JSON.stringify(data.field), {
//                    title: '最终的提交信息'
//                });

                $.ajax({
                    url: "http://localhost:8080/LendingApply/commitApply",
                    type: "POST",
                    data: JSON.stringify(data.field), //转JSON字符串
                    dataType: 'json',
                    contentType: 'application/json;charset=UTF-8',
                    success: function (result) {
                        console.log(result.flag);
                        if (result.flag >= 1 && result.flagHis >= 1) {
                            layer.msg("恭喜您，成功提交申请，待管理员审核后方可借出!");
                            //获得父控件的弹层并设置关闭时间
                            var index = parent.layer.getFrameIndex(window.name);
                            setTimeout(function () {
                                parent.layer.close(index)
                            }, 2500);
                        }else {
                            layer.msg("请勿重复提交！");
                        }
                    }, error: function (XMLHttpRequest, textStatus) {
                        //如果后台发生错误，进行回滚，前台给出相应的提示 update by: linsong.wei 2017年11月29日
                        layer.alert("操作失败!请重试！");
                    }
                });


            }


            return false;
        });


    });
</script>

</body>
</html>
