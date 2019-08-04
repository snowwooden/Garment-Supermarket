<%@ page language="java" import="java.util.*"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK"%>

<%
	String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		 
	</head>
 
	<body leftmargin="2" topmargin="9"
		background='<%=path%>/img/allbg.gif'>
		<form action="<%=path%>/pinglun/pinglunReplay" name="formAdd"
			method="post">
			<input type="hidden" name="id" size="60" value="${pinglun.id}" />
			<table width="98%" border="0" cellpadding="2" cellspacing="1"
				bgcolor="#11a8f1" align="center" style="margin-top: 8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="4" background="<%=path%>/img/tbg.gif">
						&nbsp;评论回复&nbsp;
					</td>
				</tr>


				<tr align='center' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='red';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td width="25%" bgcolor="#FFFFFF" align="right">
						回复内容：
					</td>
					<td width="75%" bgcolor="#FFFFFF" align="left">
						<textarea name="replays" rows="15" cols="80">${replays}</textarea>
					</td>
				</tr>
				 

				<tr align='center' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='red';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td width="25%" bgcolor="#FFFFFF" align="right">
						&nbsp;
					</td>
					<td width="75%" bgcolor="#FFFFFF" align="left">
						<input type="submit" value="提交" onclick="return check()" />
						&nbsp;
						<input type="reset" value="重置" />
						&nbsp;
					</td>
				</tr>
			</table>
		</form>
	</body>
	 
</html>
