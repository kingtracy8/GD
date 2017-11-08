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

<title>My JSP 'GetUser.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<%--<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>--%>
	<script src="../js/jquery-3.2.1.min.js"></script>

</head>

<body>
	<div id="a"></div>
	<br>
</body>
<script>
	jQuery(function($){
	var urlStr = "<%=request.getContextPath()%>/user/GetUser";
		var user = {
			"id" : 2,
			"userName" : "小红",
			"password" : "123",
			"age" : 12
		};
		$.ajax({
			url : urlStr,
			type : "POST",
			data : JSON.stringify(user), //转JSON字符串  
			dataType : 'json',
			contentType : 'application/json;charset=UTF-8', //contentType很重要     
			success : function(result) {
				console.log(result);
				//alert(result);
				//data = eval("(" + result + ")");
				//alert(data);
			//	alert("请求成功！spring mvc 返回数据是:"+result);
				$("#a").html(result.userName);
			}
		});
	});
</script>
</html>
