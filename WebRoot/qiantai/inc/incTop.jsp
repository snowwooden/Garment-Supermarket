<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false"%>
<%
	String path = request.getContextPath();
	String webpath = path + "/qiantai";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<script language="JavaScript" src="<%=path%>/js/public.js"
			type="text/javascript">
</script>
		<script type='text/javascript'
			src='<%=path%>/dwr/interface/loginService.js'>
</script>
		<script type='text/javascript' src='<%=path%>/dwr/engine.js'>
</script>
		<script type='text/javascript' src='<%=path%>/dwr/util.js'>
</script>


			<script type="text/javascript">
function admin() {
	var url = "<%=path%>/login.jsp";
	window.open(url, "_blank");
}

function liuyanAll() {
<c:if test="${sessionScope.user==null}">
                  alert("请先登录");
            </c:if>
            
            <c:if test="${sessionScope.user!=null}">
                var url="<%=path%>/liuyan/liuyanAll";
				var targetWinName="newWin";
				var features="width="+screen.width-200+" ,height="+screen.height-150+" ,toolbar=no, top=0, left=0, menubar=no, scrollbars=yes, resizable=no,location=no, status=no"
				var new_win=window.open(url,targetWinName,features);
            </c:if>
         } 
          
         
          
         
         function mycart()
         {
            <c:if test="${sessionScope.user==null}">
                  alert("请先登录");
            </c:if>
            
            <c:if test="${sessionScope.user!=null}">
                var url="<%=path%>/order/mygouwuche";
                window.open(url,"_self");
            </c:if>
         } 
         
         
         
         function myorder()
         {
            <c:if test="${sessionScope.user==null}">
                  alert("请先登录");
            </c:if>
            
            <c:if test="${sessionScope.user!=null}">
                var url="<%=path%>/buy/myorder";
                window.open(url,"_self");
            </c:if>
         } 
         
         
      </script>
		
		
		
		
		<link href="<%=webpath%>/css/style.css" rel="stylesheet" type="text/css">

<script src="<%=webpath%>/js/jquery.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" src="<%=webpath%>/js/common.js"></script>
  
<script type="text/javascript" src="<%=webpath%>/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="<%=webpath%>/js/jquery.json-2.4.min.js"></script>
</head>
<body>
  <link href="<%=webpath%>/css/lanrenzhijia.css" rel="stylesheet" type="text/css"/>
 
  <link href="<%=webpath%>/themes/ecmoban_meilishuo/style.css" rel="stylesheet" type="text/css" />
  
    <link href="<%=webpath%>/css/index1.css" rel="stylesheet" type="text/css" />
    
    
    <style>
    a:hover{ color:#c60c0d; text-decoration:underline}
    </style>
    <script src="<%=webpath%>/js/index.js" type="text/javascript"></script>
<div class="top" id="top_nav" style="z-index:9999;position:fixed;width: 100%;">
  <div class="main_1200">
    <div class="welcome"> </div>
    <div class="f_r log">  <script type="text/javascript" src="<%=webpath%>/js/utils.js"></script>      <ul>
        <font id="ECS_MEMBERZONE"><div id="append_parent"></div>
 您好，Zoom年轻人潮流购物网站欢迎您&nbsp;&nbsp;&nbsp;&nbsp;
 
 
 
 <c:if test="${sessionScope.user==null}">
				 <a href="<%=path%>/order/login" rel="nofollow">登录</a>｜
                 <a href="<%=path%>/order/register" rel="nofollow">免费注册</a>
			</c:if>
			
			
  <c:if test="${sessionScope.user!=null}">
				${sessionScope.user.loginname }｜
				 <a href="<%=path%>/user/userInfo" rel="nofollow">用户中心</a>｜
                 <a href="<%=path%>/user/userLogout" rel="nofollow">退出</a>
			</c:if>

 
 
 
 
 
 
 
 ｜客服热线:<strong style="color:#0da944;">4123456799</strong>
 <!-- <strong style="color:#c9151e;">4123456799</strong> --> 
 </font>
      </ul>
    </div>
  </div>
</div>
<div class="top">
  <div class="main_1200">
 
  </div>
</div>
<div class="main_1200"> </div>
<div class="block header_bg">
  <div class="f_l" style="width:150px;"> <a href="#" name="top"><img src="<%=webpath%>/images/logo.jpg" usemap="#Map" style="float:left;" border="0"> </a> </div>
  <div id="search" class="clearfix">
    <script type="text/javascript">
    
      // <!--
    function checkSearchForm()
    {
        if(document.getElementById('queryname').value)
        {
            return true;
        }
        else
        {
           alert("请输入搜索关键词！");
            return false;
        }
    }   // -->
    
    </script>
    <form id="ThisForm1" name="ThisForm1" method="post"
					action="<%=path%>/goods/goodsByName">
      <div class="i-search ld">
        <div class="form">
          <input class="text1" name="queryname" type="text" id="queryname" value="">
          <input name="imageField" type="submit" value="搜 索" class="button1">
        </div>
      </div>
      <div class="hot_search"> 
      </div>
    </form>
  </div>
</div>




 <div class="menu_box clearfix">
        <div class="block">
            <div class="menu" style="position: absolute; z-index: 1000;">
                <ul>
                    <li><a href="<%=path %>/index">首页<span></span></a> </li>
 
                    <li onmouseover="showsub(this)" onmouseout="hidesub(this)"><a href="#" style="width: 90px;
                        height: 40px;">全部商品分类</a>
                        <ul>
                            
                            
                            <c:forEach items="${sessionScope.cateList}" var="cate">
                                   <li onmouseover="showsub(this)" onmouseout="hidesub(this)"> <a href="<%=path %>/goods/goodsByCatelog?catelog_id=${cate.id}" style="width: 90px; height: 40px; padding-top: 5px">${cate.name}</a>
                                   </li>
                            </c:forEach>
                     
                                    
                                    
                             
                        </ul>
                    </li>
                    <li><a href="#" onclick="myorder()">个人中心<span></span></a> </li>
                 <li><a href="#" onclick="mycart();">购物车<span></span></a> </li>
                 <li><a href="<%=path%>/wenzhangAll.action" target="_blank">文章社区<span></span></a> </li>
                 
                        <li><a class="a1" href="<%=path%>/liuyan/liuyanAll"> 在线留言</a> </li>
                        
                       
                     
                </ul>
            </div>
              
        </div>
    </div>
     
 
		
		
		
		
		
</html>
