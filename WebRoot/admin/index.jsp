<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
 

<link rel="stylesheet" href="<%=path %>/css/base.css" />
<link rel="stylesheet" type="text/css" href="<%=path %>/css/jquery.dialog.css" />
<link rel="stylesheet" href="<%=path %>/css/index_admin.css" />

<title>Zoom年轻人潮流购物网站</title>
</head>
 <body>
 
 
 
 <div id="container">
	<div id="hd">
    	<div class="hd-wrap ue-clear">
        	<div class="top-light"></div>
            <h1 class="logo"></h1>     
            <div class="login-info ue-clear">
            <span style="color: white;">
             
            </span>
                 <div class="welcome ue-clear" style="width:200px;"><span>
                 
			     <span>${sessionScope.currentuser.name}</span>
			 
                 </span> 
                </div>
                
                
   
                
                
            </div>
            <div class="toolbar ue-clear">
            
                <a href="javascript:;" data-src="<%=path%>/loginout.jsp" class="quit-btn exit"></a>
            </div>
        </div>
    </div>
    <div id="bd">
    	<div class="wrap ue-clear">
        	<div class="sidebar">
            	<h2 class="sidebar-header"><p>功能导航</p></h2>
                <ul class="nav">
               
                    
            
                    <li class="user">
                    	<div class="nav-header"><a href="javascript:;" class="ue-clear"><span>基本信息管理</span><i class="icon"></i></a></div>
                    	<ul class="subnav">
                        	<li><a href="javascript:;" date-src="<%=path %>/admin/userinfo/userPw.jsp">修改个人密码</a></li>
                        </ul>
                    </li>
                 
                     <li class="apply"><div class="nav-header"><a href="javascript:;" class="ue-clear"><span>商品管理</span><i class="icon"></i></a></div>
                    	<ul class="subnav">
                        	<li><a href="javascript:;" date-src="<%=path %>/catelog/catelogMana">商品类别管理</a></li>
                        	<li><a href="javascript:;" date-src="<%=path%>/goods/goodsMana">商品信息管理</a></li>
                        </ul>
                    </li>
              
                    <li class="croom">
                    	<div class="nav-header"><a href="javascript:;" class="ue-clear"><span>会员管理</span><i class="icon"></i></a></div>
                        <ul class="subnav">
                         
                            <li><a href="javascript:;" date-src="<%=path%>/user/userMana">会员管理</a></li>
                        </ul>
                    </li>
                    <li class="apply"><div class="nav-header"><a href="javascript:;" class="ue-clear"><span>订单管理</span><i class="icon"></i></a></div>
                    	<ul class="subnav">
                    	    <li><a href="javascript:;" date-src="<%=path%>/order/orderMana">订单管理</a></li>
                    	     <li><a href="javascript:;" date-src="<%=path%>/order/report">销量排行榜</a></li>
                        </ul>
                    </li>
         
              
     
                    
                     <li class="croom"><div class="nav-header"><a href="javascript:;" class="ue-clear"><span>留言管理</span><i class="icon"></i></a></div>
                    	<ul class="subnav">
                    	    <li><a href="javascript:;" date-src="<%=path%>/liuyan/liuyanMana">留言管理</a></li>
                        </ul>
                    </li>
                    
                     <li class="croom"><div class="nav-header"><a href="javascript:;" class="ue-clear"><span>评论管理</span><i class="icon"></i></a></div>
                    	<ul class="subnav">
                    	    <li><a href="javascript:;" date-src="<%=path%>/pinglun/pinglunList">评论管理</a></li>
                        </ul>
                    </li>
                    
                    
                    <li class="croom"><div class="nav-header"><a href="javascript:;" class="ue-clear"><span>文章管理</span><i class="icon"></i></a></div>
                    	<ul class="subnav">
                    	    <li><a href="javascript:;" date-src="<%=path%>/wenzhangList">文章管理</a></li>
                        </ul>
                    </li>
                    
          
                </ul>
            </div>
            <div class="content">
            	<iframe src="<%=path%>/admin/main.jsp" id="iframe" width="100%" height="100%" frameborder="0"></iframe>
            </div>
        </div>
    </div>
    <div id="ft" class="ue-clear">
    	<div class="ft-left">
            <span>Zoom年轻人潮流购物网站</span>
            <em>版权所有</em>
        </div>
        <div class="ft-right">
            <span>Management</span>
            <em>V1.0&nbsp;2018</em>
        </div>
    </div>
</div>
<div class="exitDialog">
	<div class="dialog-content">
    	<div class="ui-dialog-icon"></div>
        <div class="ui-dialog-text">
        	<p class="dialog-content">你确定要退出系统？</p>
            <p class="tips">如果是请点击“确定”，否则点“取消”</p>
            
            <div class="buttons">
                <input type="button" class="button long2 ok" value="确定" />
                <input type="button" class="button long2 normal" value="取消" />
            </div>
        </div>
        
    </div>
</div>

 
 </body>
</html>


<script type="text/javascript" src="<%=path %>/js/jquery.js"></script>
<script type="text/javascript" src="<%=path %>/js/common.js"></script>
<script type="text/javascript" src="<%=path %>/js/core.js"></script>
<script type="text/javascript" src="<%=path %>/js/jquery.dialog.js"></script>
<script type="text/javascript" src="<%=path %>/js/index.js"></script>

