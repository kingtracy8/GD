<%--
  Created by IntelliJ IDEA.
  User: linsong.wei
  Date: 2017/12/24
  Time: 19:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>缴费管理</title>
    <link rel="stylesheet" href="../../js/css/layui.css">
    <script src="../../js/jquery-3.2.1.min.js"></script>
    <script src="../../js/layui.js"></script>
</head>
<body>
<div>

    <blockquote class="layui-elem-quote layui-text" style="margin-top: 10px">
        您好，下方表格中是用户的缴费情况，您可以进行更新。
    </blockquote>
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
        <legend>如果您有需要，下方搜索框可以进行筛选</legend>
    </fieldset>

    <form class="layui-form" action="">

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">用户名</label>
                <div class="layui-input-inline">
                    <input type="text" name="userName" id="userName" autocomplete="off" class="layui-input">
                </div>
            </div>

            <div class="layui-inline">
                <label class="layui-form-label">电脑名称</label>
                <div class="layui-input-inline">
                    <input type="text" name="cptName" id="cptName" autocomplete="off" class="layui-input">
                </div>
            </div>

        </div>

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">已付款</label>
                <div class="layui-input-block">
                    <input type="radio" name="isPay" value="Y" title="是">
                    <input type="radio" name="isPay" value="N" title="否">
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-input-block" style="margin-left: 28%">
                <button class="layui-btn" lay-submit="" lay-filter="FilterForm">查询</button>
                <button type="reset" class="layui-btn layui-btn-primary" lay-filter="ReSet" onclick="doReset()">重置
                </button>
            </div>
        </div>
    </form>


</div>


<table class="layui-table"
       lay-data="{id:'ExpenseTable',width:1320,height:400,url:'/Expense/expenseMangerTI', page:true}"
       lay-filter="test">
    <thead>
    <tr>
        <th lay-data="{field:'userName', width:110}">用户名</th>
        <th lay-data="{field:'cptName', width:225,sort: true}">电脑</th>
        <th lay-data="{field:'lendTime', width:110}">借用时间</th>
        <th lay-data="{field:'areturnTime', width:120}">实际归还时间</th>
        <th lay-data="{field:'isReturned', width:120}">是否已经归还</th>
        <th lay-data="{field:'days', width:120}">实际借用天数</th>
        <th lay-data="{field:'expense', width:120}">应缴费用</th>
        <th lay-data="{field:'isPay', width:120,edit:'text'}">是否已经付款</th>
        <th lay-data="{fixed: 'right', width:160, align:'center', toolbar: '#Toolbar'}">
    </tr>
    </thead>
</table>

<script type="text/html" id="Toolbar">
    <a class="layui-btn layui-btn-xs" lay-event="update">更新</a>
</script>


<script>


    layui.use(['form', 'table'], function () {
        var table = layui.table;
        var form = layui.form
            , layer = layui.layer;


        table.on('tool(test)', function (obj) { //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"


            var data = obj.data //获得当前行数据
                , layEvent = obj.event; //获得 lay-event 对应的值


            //如果用户未归还电脑，不允许修改是否已经付款  linsong.wei    2018-04-15 14:43:24
            if(data.isReturned=='N'){
                layer.alert("用户未归还电脑，不能更新计费信息！");
            }else {

                //归还了之后才可以设置是否付款
                if (layEvent === 'update') {

                    var index = layer.confirm('确定要更新该用户的缴费信息吗?', {icon: 3, title: '提示'}, function (index) {

                        $.ajax({
                            url: 'http://localhost:8080/Expense/updateExpenseStatus',
                            type: "POST",
                            data: JSON.stringify(data),
                            dataType: 'json',
                            contentType: 'application/json;charset=UTF-8',
                            success: function (result) {
                                if (result.flag == 1) {
                                    layer.alert("更新成功！");
                                    table.reload('ExpenseTable', {
                                        url: '/Expense/expenseMangerTI'
                                    });
                                }else if(result.flag==-2){
                                    layer.alert("请正确填写！Y或者N");
                                    table.reload('ExpenseTable', {
                                        url: '/Expense/expenseMangerTI'
                                    });
                                }

                            }, error: function () {
                                layer.alert("操作失败!请重试！");
                            }
                        })
                    });

                }
            }


        });


        form.on('submit(FilterForm)', function (data) {
            var userName = document.getElementById('userName');
            var cptName = document.getElementById('cptName');
            var isPay = $('input:radio:checked').val();
            if (typeof(isPay) == "undefined") {
                isPay = '';
            }

            table.reload('ExpenseTable',{
                url:'/Expense/expenseMangerTIFilter',
                where:{
                    userName:userName.value,
                    cptName:cptName.value,
                    isPay:isPay
                }
            });

            return false;
        });


    });

    function doReset() {
        window.location.reload();
    }

</script>


</body>
</html>
