<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
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
	 
	<body>

		<jsp:include flush="true" page="/qiantai/inc/incTop.jsp"></jsp:include>


		<div class="blank"></div>




		<div >
   <div class="box" style="width: 90%">
  <div class="tc" style="padding:8px;">
         <font class="f5 f6" style="font-size: 22px;line-height: 30px;"> ${wenzhang.title}</font><br>
         
         <font class="f3"> ${wenzhang.fbr} &nbsp;&nbsp;${wenzhang.fbsj}</font></br>
         <font class="f3"> 点赞：${wenzhang.zcount}&nbsp;&nbsp; 浏览：${wenzhang.vcount}</font>
         </div>
     <c:out value="${requestScope.wenzhang.contents}" escapeXml="false"></c:out>
     
     <c:if test="${wenzhang.state=='通过'}">
           <div class="tc" style="padding:8px;">
                    <input style="float: center;" type="button" value="点赞" onclick="zan(${wenzhang.id});"/> 
                    </div>
                    </c:if>
   </div>
   
   
  </div>
  <div class="blank5"></div>
  
  
  
  
  
  
  
  	<div class="usBox">
			<div class="usBox_2 clearfix"
				style="font-size: 16px !important; width: auto !important; padding: 20px 200px 50px 200px; border: 1px solid #ddd;">
				<div class="regtitle"></div>
				

 <c:forEach items="${requestScope.pinglunList}" var="pinglun">
	     <TABLE style="MARGIN-TOP: 8px; WORD-BREAK: break-all" borderColor=#e3e3e3 cellSpacing=0 borderColorDark=white cellPadding=0 rules=all width="100%"  borderColorLight=#e0e0e0 border=1>
	        
	       
	        <TR height=20>
		          <TD style="PADDING-RIGHT: 6px; PADDING-LEFT: 6px; PADDING-BOTTOM: 6px; PADDING-TOP: 6px" vAlign=top style="font-size: 11px;">
		           ${pinglun.plr }发表于 ${pinglun.plsj }
		          </TD>
	        </TR>
	         <TR height=20>
		          <TD style="PADDING-RIGHT: 6px; PADDING-LEFT: 6px; PADDING-BOTTOM: 6px; PADDING-TOP: 6px" vAlign=top style="font-size: 11px;">
		               &nbsp;&nbsp;${pinglun.plnr } 
		          </TD>
		          
	        </TR>
	    </TABLE>
	    </c:forEach>
	    
	    
	  
	    <TABLE style="MARGIN-TOP: 8px; WORD-BREAK: break-all" borderColor=#e3e3e3 cellSpacing=0 borderColorDark=white cellPadding=0 rules=all width="100%"  borderColorLight=#e0e0e0 border=1>
	        <TR bgColor=#f0f0f0 height=30>
		          
		          <TD colSpan=2 style="font-size: 11px;">
		                <span style="float:left">评论</span>
		          </TD>
	        </TR>
	       
	        <TR height=20>
		          <TD>
			            <form action="<%=path %>/pinglun/pinglunWzAdd" name="form1" method="post">
			            <input type="hidden" name="gid" value="${wenzhang.id}"/>
			            <table border="0">
						    
						     <tr>
						         <td style="font-size: 11px;">评论内容:</td>
						         <td>
						         
						             <textarea rows="15" cols="80" name="plnr"></textarea>
						               
				                 </td>
						     </tr>
						     <tr>
						         <td style="font-size: 11px;">&nbsp;</td>
						         <td>
						             <input type="button"  onclick="savePinglun();" name="" value="提交"/>
				                 </td>
						     </tr>
						</table>
						</form>
		          </TD>
	        </TR>
	    </TABLE>
 
  
  
  
 
  <script language="javascript">
 
             function zan(id)
           {
                   window.location.href="<%=path %>/wenzhangZan.action?id="+id;
           }
           
           function savePinglun(){
           
           	    <c:if test="${sessionScope.user==null}">
           	         alert('请先登录');
           	         return;
           	    </c:if>
              if(document.form1.plnr.value==''){
                  alert('请输入评论内容');
                  return;
              }
              document.form1.submit();
           }


       </script>









		<div class="blank"></div>
		<jsp:include flush="true" page="/qiantai/inc/incFoot.jsp"></jsp:include>

	</body>
</html>
