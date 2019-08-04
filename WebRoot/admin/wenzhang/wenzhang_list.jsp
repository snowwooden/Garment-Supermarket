<%@ page language="java" pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
        <script language="javascript">

	    function wenzhangDel(id)
           {
               if(confirm('您确定删除吗？'))
               {
                   window.location.href="<%=path %>/wenzhangDel.action?id="+id;
               }
           }
           
           function wenzhangEditPre(id)
           {
                   window.location.href="<%=path %>/wenzhangEditPre.action?id="+id;
           }
           
           function wenzhangAdd()
           {
                 var url="<%=path %>/admin/wenzhang/wenzhang_add.jsp";
                
		  window.location.href=url;
           }
           
             function wenzhangZhiding(id,ty)
           {
                   window.location.href="<%=path %>/wenzhangZhiding.action?id="+id+"&ty="+ty;
           }
             function wenzhangAudit(id,ty)
           {
                   window.location.href="<%=path %>/wenzhangAudit.action?id="+id+"&ty="+ty;
           }
           


       </script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/images/allbg.gif'>
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#11a8f1" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="8" background="<%=path %>/images/tbg.gif">&nbsp;文章管理&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
											<td>标题</td>
											<td  width="15%">发布时间</td>
											<td  width="8%">发布人</td>
											<td  width="8%">点赞数</td>
											<td  width="8%">浏览数</td>
											<td  width="8%">审核状态</td>
											<td  width="8%">是否置顶</td>
										<td width="25%">操作</td>
		        </tr>	
				 
				 <c:forEach items="${wenzhangList}" var="wenzhang" varStatus="sta">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					
					
									 
											<td bgcolor="#FFFFFF" align="center">${wenzhang.title} </td>
								 
											<td bgcolor="#FFFFFF" align="center">${wenzhang.fbsj} </td>
											<td bgcolor="#FFFFFF" align="center">${wenzhang.fbr} </td>
											<td bgcolor="#FFFFFF" align="center">${wenzhang.zcount} </td>
											<td bgcolor="#FFFFFF" align="center">${wenzhang.vcount} </td>
											<td bgcolor="#FFFFFF" align="center">${wenzhang.state} </td>
											<td bgcolor="#FFFFFF" align="center">
											  <c:if test="${wenzhang.zhiding=='1'}">是</c:if>
											  <c:if test="${wenzhang.zhiding=='0'}">否</c:if>
											    
											</td>
										 
					<td bgcolor="#FFFFFF" align="center">
					
					<c:if test="${wenzhang.state=='不通过'}"> 
					
					  
                                                
                                                  
						<input type="button" value="删除" onclick="wenzhangDel('${wenzhang.id}')"/>
					 
                      </c:if>
                      
                      
                      
                      
                      
                      
                      	<c:if test="${wenzhang.state=='通过'}"> 
					
					<c:if test="${wenzhang.zhiding=='1'}">
					  <input type="button" value="取消置顶" onclick="wenzhangZhiding('${wenzhang.id}',0)"/>
					</c:if>
					
					<c:if test="${wenzhang.zhiding=='0'}">
					  <input type="button" value="置顶" onclick="wenzhangZhiding('${wenzhang.id}',1)"/>
					</c:if>
					
					
				
					  <input type="button" value="通过" onclick="wenzhangAudit('${wenzhang.id}',1)"/>
				 
			 
    

                                                <input type="button" value="修改" onclick="wenzhangEditPre('${wenzhang.id}')"/>
                                                
                                                
                                                  
						<input type="button" value="删除" onclick="wenzhangDel('${wenzhang.id}')"/>
					 
                      </c:if>
                      
                      
                      
                      
                      
                      <c:if test="${wenzhang.state=='待审核'}"> 
					
		 
				
					  <input type="button" value="通过" onclick="wenzhangAudit('${wenzhang.id}',1)"/>
				 
					 
					  <input type="button" value="不通过" onclick="wenzhangAudit('${wenzhang.id}',0)"/>
					 
 
    

                                                <input type="button" value="修改" onclick="wenzhangEditPre('${wenzhang.id}')"/>
                                                
                                                
                                                  
						<input type="button" value="删除" onclick="wenzhangDel('${wenzhang.id}')"/>
					 
                      </c:if>
 
					</td>
				</tr>
				</c:forEach>
			</table>
			
			<table width='98%'  border='0'style="margin-top:8px;margin-left: 5px;">
			  <tr>
			    <td>
			        <input type="button" value="添加" style="width: 80px;" onclick="wenzhangAdd()" />
			    </td>
			  </tr>
		    </table>
		     
	</body>
</html>