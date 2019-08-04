<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
		<link rel="stylesheet" href="<%=path%>/css/style.css" type="text/css" />
		<title>Zoom年轻人潮流购物网站</title>


		<link href="css/style.css" rel="stylesheet" type="text/css" />
		<script language="JavaScript" src="<%=path%>/js/jquery.js">
		</script>


		<script language=JavaScript>
function logout() {
	if (confirm("您确定要退出Zoom年轻人潮流购物网站吗？")) {
		top.location = "<%=path%>/loginout.jsp";
		return true;
	}

	return false;
}

 
</script>

	</head>

	<body style="background: url(images/topbg.gif) repeat-x;">

		<div class="topleft">
			<img src="images/logo.png" />
		</div>

		<div class="topright">
			<ul>
				 
				<li>
					<a href="#" onclick="return logout()">退出</a>
				</li>
			</ul>

           
			 
		</div>

	</body>
</html>

