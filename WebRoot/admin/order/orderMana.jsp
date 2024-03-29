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

 
		<script language="JavaScript" src="<%=path %>/js/public.js" type="text/javascript"></script>
		
        <script language="javascript">
            function orderDetail(order_id)
	        {
	                 var url="<%=path %>/buy/orderDetail?order_id="+order_id;
	                 var n="";
	                 var w="600px";
	                 var h="500px";
	                 var s="resizable:no;help:no;status:no;scroll:yes";
				     openWin(url,n,w,h,s);
	        }
	        
	       function orderDel(id)
           {
               if(confirm('您确定删除吗？'))
               {
                   window.location.href="<%=path %>/order/orderDel?id="+id;
               }
           }
           
           function userXinxi(user_id)
           {
                     var url="<%=path %>/user/userXinxi?user_id="+user_id;
	                 var n="";
	                 var w="700px";
	                 var h="200px";
	                 var s="resizable:no;help:no;status:no;scroll:yes";
				     openWin(url,n,w,h,s);
           }
           
           function orderShouli(id)
           {
               if(confirm('您确定发货吗？'))
               {
               
               
                     var url="<%=path %>/admin/order/sendKuaidi.jsp?id="+id;
	                 var n="";
	                 var w="600px";
	                 var h="500px";
	                 var s="resizable:no;help:no;status:no;scroll:yes";
				     openWin(url,n,w,h,s);
				    
               }
           }
        </script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/img/allbg.gif'>
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#11a8f1" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="9" background="<%=path %>/img/tbg.gif">&nbsp;订单管理&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="10%">订单编号</td>
					<td width="12%">下单时间</td>
					<td width="10%">快递单号</td>
					<td width="10%">状态</td>
					<td width="15%">送货地址</td>
					<td width="10%">付款方式</td>
					<td width="5%">总金额</td>
					<td width="5%">明细</td>
					<td width="15%">操作</td>
		        </tr>	
				<c:forEach items="${requestScope.orderList}" var="order">
				<tr align='center' bgcolor="#FFFFFF" height="22">
					<td bgcolor="#FFFFFF" align="center">${order.bianhao}</td>
					<td bgcolor="#FFFFFF" align="center">${order.shijian}</td>
					<td bgcolor="#FFFFFF" align="center">${order.kddh}</td>
					<td bgcolor="#FFFFFF" align="center">
					 ${order.zhuangtai}
					     <c:if test="${order.zhuangtai=='已付款'}">
					        &nbsp;&nbsp;&nbsp;<a href="#" style="color: red" onclick="orderShouli(${order.id})" class="pn-loperator">发货</a>
					     </c:if>
					    
					</td>
					
					<td bgcolor="#FFFFFF" align="center">${order.songhuodizhi}</td>
					<td bgcolor="#FFFFFF" align="center">${order.fukuanfangshi}</td>
					<td bgcolor="#FFFFFF" align="center">${order.jine}</td>
					<td><input value="明细" type="button" onclick="orderDetail(${order.id})"/></td>
					<td>
					    <input type="button" onclick="userXinxi(${order.userId})" value="查看会员信息"/>
					    <input type="button" onclick="orderDel(${order.id})" value="删除"/>
					</td>
				</tr>
				</c:forEach>
			</table>
	</body>
</html>
