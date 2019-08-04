<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />
		<script type='text/javascript' src='<%=path%>/dwr/engine.js'></script>
		<script type='text/javascript' src='<%=path%>/dwr/util.js'></script>
		<script type="text/javascript" src="<%=path%>/js/popup.js"></script>
                    <script type="text/javascript" charset="utf-8" src="<%=path%>/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="<%=path%>/ueditor.all.min.js"> </script>
    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
    <script type="text/javascript" charset="utf-8" src="<%=path%>/lang/zh-cn/zh-cn.js"></script>
		<script language="javascript">
		    function check()
		    {
		        document.formAdd.submit();
		    }
        </script>
	</head>

	<body leftmargin="2" topmargin="9"
		background='<%=path%>/images/allbg.gif'>
		<form action="<%=path%>/wenzhangAdd.action" name="formAdd"
			method="post">
			<table width="98%" align="center" border="0" cellpadding="4"
				cellspacing="1" bgcolor="#11a8f1" style="margin-bottom: 8px">
				<tr bgcolor="#EEF4EA">
					<td colspan="3" background="<%=path%>/images/wbg.gif"
						class='title'>
						<span>添加</span>
					</td>
				</tr>



				<tr align='center' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='red';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td width="25%" bgcolor="#FFFFFF" align="right">
						标题：
					</td>
					<td width="75%" bgcolor="#FFFFFF" align="left">
						<input type="text" id="title" name="title" size="50" maxlength="255" />
	                   <input type="hidden" id="contents" name="contents"  />
					</td>
				</tr>


				<tr align='center' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='red';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td width="25%" bgcolor="#FFFFFF" align="right">
						内容：
					</td>
					<td width="75%" bgcolor="#FFFFFF" align="left">
					
	 <script id="container" type="text/plain" style="width:800px;height:300px;"></script>
		
					</td>
				</tr>


			 

				<tr align='center' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='red';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td width="25%" bgcolor="#FFFFFF" align="right">
						&nbsp;
					</td>
					<td width="75%" bgcolor="#FFFFFF" align="left">
						<input type="button" value="提交" onclick="saveWenzhang()" />
						&nbsp;
						<input type="reset" value="重置" />
						&nbsp;
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>


<script type="text/javascript">
        var ue = UE.getEditor('container');
        
        function saveWenzhang(){
           var htmlv = ue.getContent();
           
    
                if(document.formAdd.title.value==''){
                  alert('请输入标题');
                  return false;
               }
                if(htmlv==''){
                  alert('请输入内容');
                  return false;
               }
            
           document.getElementById("contents").value = htmlv;
           document.forms[0].submit();
           
        }
      
    </script>