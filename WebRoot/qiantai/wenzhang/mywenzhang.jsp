<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false"%>
<%
	String path = request.getContextPath();
	String webpath = path + "/qiantai";
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<html>
	<head>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
	 
 <script type="text/javascript">
	       
	 
	         function delwenzhang(id)
	        {
	                 var url="<%=path %>/mydelwenzhang.action?id=" + id;
	                 window.location.href = url;
	        }
    </script>
	</head>
	<body>
		 <jsp:include flush="true" page="/qiantai/inc/incTop.jsp"></jsp:include>

		






<div class="block clearfix">
  
  <div class="AreaL">
    <div class="box">
     <div class="">
      <div class="userCenterBox">
        <div class="userMenu">
<a href="<%=path%>/user/userInfo"><img src="<%=webpath%>/images/u2.gif"> 用户信息</a>
<a href="<%=path%>/user/userAddress"><img src="<%=webpath%>/images/u4.gif"> 收货地址</a>
<a href="<%=path%>/buy/myorder"><img src="<%=webpath%>/images/u3.gif"> 我的订单</a>
 <a href="<%=path%>/qiantai/wenzhang/fabu.jsp"><img src="<%=webpath%>/images/u3.gif"> 发布文章</a>
 <a href="<%=path%>/mywenzhang"><img src="<%=webpath%>/images/u3.gif">我的文章</a>
<a href="<%=path%>/user/userLogout" style="background:none; text-align:right;margin-left: 10px;margin-right: 60px;margin-top: 12px;border-bottom:0;"><img src="<%=webpath%>/images/bnt_sign.gif"></a>
</div>      </div>
     </div>
    </div>
  </div>
  
  
  <div class="AreaR">
    <div class="box">
     <div class="">
      <div class="userCenterBox boxCenterList clearfix" style="_height:1%;">
         
              
        
      
              <h1><span>我的文章</span></h1>
       <div class="blank"></div>
       <table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#dddddd">
          <tbody>	<tr align="center">
						<td bgcolor="#ffffff">
							标题
						</td>
						<td bgcolor="#ffffff">
							发布时间
						</td>
						<td bgcolor="#ffffff">
							审核状态
						</td>
						 
						<td bgcolor="#ffffff">
							操作
						</td>
					</tr>


<c:forEach items="${requestScope.wenzhangList}" var="wenzhang">
					<tr align="center">
						<td bgcolor="#ffffff">
						<a target="_blank" href="<%=path %>/wenzhangView.action?id=${wenzhang.id}"  class="f6">	${wenzhang.title}</a>
						</td>
						<td bgcolor="#ffffff">
							${wenzhang.fbsj}
						</td>
						<td bgcolor="#ffffff">
							${wenzhang.state}
						</td>
						 
						<td bgcolor="#ffffff">
					 
							   
							     <input value="删除" type="button" onclick="delwenzhang(${wenzhang.id})"/>
							 
						 
							  
						</td>
					</tr>

</c:forEach>
          
                    </tbody></table>
        <div class="blank5"></div>
 
 
       <div class="blank5"></div>
      
             
       
          
     
          
    
                                                   
      
          
      
               




      </div>
     </div>
    </div>
  </div>
  
</div>
<div class="blank"></div>




























 

		<div class="blank"></div>
			<jsp:include flush="true" page="/qiantai/inc/incFoot.jsp"></jsp:include>
	</body>
</html>
