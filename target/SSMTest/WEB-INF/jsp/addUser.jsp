<%--
  Created by IntelliJ IDEA.
  User: trcay
  Date: 2017/12/18
  Time: 19:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>添加用户</title>
    <!--Create By: linsong.wei 2017-11-21 09:39:35-->
    <link rel="stylesheet" href="../js/css/layui.css">
    <script src="../js/jquery-3.2.1.min.js"></script>
    <script src="../../js/layui.js"></script>
</head>
<body>
<blockquote class="layui-elem-quote layui-text" style="margin-top: 10px">
    您好，管理员，您可以添加用户。
</blockquote>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>请您输入以下信息</legend>
</fieldset>

<form class="layui-form" action="">
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">用户名</label>
            <div class="layui-input-inline">
                <input type="text" name="userName" lay-verify="required" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">用户编号</label>
            <div class="layui-input-inline">
                <input type="text" name="userNum" lay-verify="required" autocomplete="off" class="layui-input">
            </div>
        </div>
    </div>


    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">手机号码</label>
            <div class="layui-input-inline">
                <input type="tel" name="userPhone" lay-verify="phone" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">电子邮箱</label>
            <div class="layui-input-inline">
                <input type="text" name="userEmail" lay-verify="email" autocomplete="off" class="layui-input">
            </div>
        </div>
    </div>


    <div class="layui-form-item">
        <label class="layui-form-label">密码</label>
        <div class="layui-input-inline">
            <input type="password" name="userPassword" lay-verify="pass" placeholder="请输入密码" autocomplete="off"
                   class="layui-input">
        </div>


        <label class="layui-form-label" style="margin-left: 15px">部门</label>
        <div class="layui-input-inline">
            <select name="userDepartment" lay-verify="required" lay-search="">
                <option value="">直接选择或搜索选择</option>
                <option value="数学与计算机科学学院">数学与计算机科学学院</option>
                <option value="外国语学院">外国语学院</option>
                <option value="化工学院">化工学院</option>
                <option value="生命科学学院">生命科学学院</option>
                <option value="管理学院">管理学院</option>
                <option value="历史学院">历史学院</option>
                <option value="电气工程学院">电气工程学院</option>
                <option value="土木工程学院">土木工程学院</option>
                <option value="体育学院">体育学院</option>
                <option value="音乐学院">音乐学院</option>
                <option value="舞蹈学院">舞蹈学院</option>
                <option value="文学院">文学院</option>
                <option value="民族学与社会学学院">民族学与社会学学院</option>
                <option value="蒙古语言文化学院">蒙古语言文化学院</option>
                <option value="藏语言文化学院">藏语言文化学院</option>
            </select>
        </div>
    </div>
    </div>

    </div>


    <div class="layui-form-item" style="margin-top: 15px">
        <label class="layui-form-label">性别</label>
        <div class="layui-input-block">
            <input type="radio" name="userGender" value="男" title="男" checked="">
            <input type="radio" name="userGender" value="女" title="女">
            <input type="radio" name="userGender" value="不确定" title="不确定" disabled="">
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-input-block" style="text-align: center;margin-right: 19%">
            <button class="layui-btn" lay-submit="" lay-filter="RegForm">添加</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            <input type='hidden' name='token' value="${token}"/>
        </div>
    </div>
</form>


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
            elem: '#date1'
        });

        //创建一个编辑器
        var editIndex = layedit.build('LAY_demo_editor');

        //自定义验证规则
        form.verify({
            title: function (value) {
                if (value.length < 5) {
                    return '标题至少得5个字符啊';
                }
            }
            , pass: [/(.+){6,12}$/, '密码必须6到12位']
            , content: function (value) {
                layedit.sync(editIndex);
            }
        });


        form.on('submit(RegForm)', function (data) {

            $.ajax({
//                url: "http://localhost:8080/user/RegisterUser",
                url: "http://localhost:8080/csu/AddUser",
                type: "POST",
                data: JSON.stringify(data.field), //转JSON字符串
                dataType: 'json',
                contentType: 'application/json;charset=UTF-8', //contentType很重要
                success: function (result) {
                    console.log(result.flag);
                    if (result.flag == 1) {
                        layer.msg("添加用户成功!");
                        //调用到父页面layui的控件
                        parent.layui.table.reload('idTest', {
                            url: '/user/UserManager'
                        });
                        //获得父控件的弹层并设置关闭时间
                        var index = parent.layer.getFrameIndex(window.name);
                        setTimeout(function () {
                            parent.layer.close(index)
                        }, 1000);
                    }else if(result.flag == -2){
                        layer.msg("请勿重复提交!");
                    }
                }
            });
            return false;
        });
    });
</script>
</body>
</html>
