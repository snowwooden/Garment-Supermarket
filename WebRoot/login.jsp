<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link href="<%=path %>/css/login.css" rel="stylesheet" type="text/css">
 <link rel="stylesheet" href="<%=path %>/css/layer.css" id="layui_layer_skinlayercss" style="">

<script type='text/javascript' src='<%=path %>/dwr/interface/loginService.js'></script>
        <script type='text/javascript' src='<%=path %>/dwr/engine.js'></script>
        <script type='text/javascript' src='<%=path %>/dwr/util.js'></script>
        
		<script language="javascript">
		function check1()
		{                                                                                         
		     if(document.ThisForm.userName.value=="")
			 {
			 	alert("请输入用户名");
				document.ThisForm.userName.focus();
				return false;
			 }
			 if(document.ThisForm.userPw.value=="")
			 {
			 	alert("请输入密码");
				document.ThisForm.userPw.focus();
				return false;
			 }
			 document.getElementById("indicator").style.display="block";
			 loginService.login(document.ThisForm.userName.value,document.ThisForm.userPw.value,0,callback);
		}
		
		function callback(data)
		{
		    document.getElementById("indicator").style.display="none";
		    if(data=="no")
		    {
		        alert("用户名或密码错误");
		    }
		    if(data=="yes")
		    {
		        alert("通过验证,系统登录成功");
		        window.location.href="<%=path %>/loginSuccess.jsp";
		    }
		    
		}
	    </script>

</head>
<body style="background-color:#323a4d; height:100%; width:100%; background:url(./images/bg.png) no-repeat; background-size:100% 100%; overflow:hidden">
<div class="logintop"> <span>欢迎登录后台管理系统</span>
  <ul>

  </ul>
</div>
<div class="loginbody"> <span class="systemlogo"></span>
  <div class="loginbox loginbox1" style="position:relative;">
  <FORM name="ThisForm" action="<%=path %>/adminLogin.action" method=post>
      <ul>
	   	   		  <li>
        <input  name="userName" id="userName"  type="text" class="loginuser text" placeholder="账号" value="">
	      </li>
	      <li>
	        <input name="userPw" id="userPw" type="password" class="loginpwd text" placeholder="密码">
	      </li>
	     
	      <li>
	      <input name="" type="button" class="loginbtn" value="登录" onClick="check1()">
     
        <img id="indicator" src="<%=path %>/img/loading.gif" style="display:none"/>
        
      
    
    
      </li>
    </ul>
    </form>
    
  </div>
</div>

<img src="<%=path%>/images/bg.png" style="position:absolute; top:0; left:0; bottom:0;" height="100%" width="100%">


 </body>
</html>
