<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>管理系统</title>
		<link href="<%=path%>/admin/css/style.css" rel="stylesheet"
			type="text/css" />
		<script type="text/javascript" src="<%=path%>/js/jquery.js">
		</script>

	</head>
	<body>
		<div class="mainindex">
			<div class="welinfo">
				<b>欢迎使用Zoom年轻人潮流购物网站</b>
				 
			</div>
			<div class="xline"></div>

			 
		</div>
	</body>
</html>

