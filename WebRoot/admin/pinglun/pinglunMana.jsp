<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 
<%
String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />

	 
		<script type="text/javascript" src="<%=path %>/js/popup.js"></script>
		<script language="JavaScript" src="<%=path %>/js/public.js" type="text/javascript"></script>
        <script language="javascript">
           function pinglunDel(id)
           {
               if(confirm('您确定删除吗？'))
               {
                   window.location.href="<%=path %>/pinglun?type=pinglunDel&id="+id;
               }
           }
           
           function pinglunAdd()
           {
                 var url="<%=path %>/admin/pinglun/pinglunAdd.jsp";
				 window.location.href=url;
           }
           function over(picPath)
	       {
			  if (picPath=="")picPath="/img/default.jpg";
			  x = event.clientX;
			  y = event.clientY;      
			  document.all.tip.style.display = "block";
			  document.all.tip.style.top = y;
			  document.all.tip.style.left = x+10;
			  document.all.photo.src = ".."+picPath; 
		   }
		   function out()
	       {
			  document.all.tip.style.display = "none";
		   }
		   
		   function pinglunDetail(id)
           {
                 var url="<%=path %>/pinglun?type=pinglunDetail&id="+id;
                 var n="";
                 var w="480px";
                 var h="500px";
                 var s="resizable:no;help:no;status:no;scroll:yes";
				 openWin(url,n,w,h,s);
           }
       </script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/img/allbg.gif'>
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#11a8f1" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="42" background="<%=path %>/img/tbg.gif">&nbsp;评论管理&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					
											<td width="15%">商品名称</td>
											<td>评论内容</td>
											<td  width="10%">评论人</td>
											<td width="15%">评论时间</td>
											<td>回复</td>
										<td width="12%">操作</td>
		        </tr>	
				<c:forEach items="${requestScope.pinglunList}" var="pinglun" varStatus="sta">
				<tr align='center' bgcolor="#FFFFFF">
			
					 
											<td bgcolor="#FFFFFF" align="center">${pinglun.mingcheng}</td>
											<td bgcolor="#FFFFFF" align="center">${pinglun.plnr}</td>
											<td bgcolor="#FFFFFF" align="center">${pinglun.plr}</td>
											<td bgcolor="#FFFFFF" align="center">${pinglun.plsj}</td>
											<td bgcolor="#FFFFFF" align="center">${pinglun.replays}</td>
										
					<td bgcolor="#FFFFFF" align="center">
						<input type="button" value="删除" onclick="pinglunDel(${pinglun.id})"/>|
						<a class="pn-loperator" href="<%=path %>/pinglun/pinglunEditPre?id=${pinglun.id}">回复</a>
					</td>
				</tr>
				</c:forEach>
			</table>
		  
	</body>
</html>
