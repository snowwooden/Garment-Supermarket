<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String webpath = path + "/qiantai";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<script language="javascript">
            
		    function editInfo()
		    {
		       document.form1.submit();
		    }
		    
		    
		    function editInfo1()
		    {
		       
		      
		         if(document.form2.oldpwd.value=="")
		        {
		            alert("请输入原密码");
		            return false;
		        }
		        
		        
		        if(document.form2.loginpw.value=="")
		        {
		            alert("请输入密码");
		            return false;
		        }
		        
		        if(document.form2.loginpw.value!=document.form2.loginpw1.value)
		        {
		            alert("两次密码不一致");
		            return false;
		        }
		       document.form2.submit();
		    }
        </script>
	<body>

		<jsp:include flush="true" page="/qiantai/inc/incTop.jsp"></jsp:include>

   <script type="text/javascript" charset="utf-8" src="<%=path%>/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="<%=path%>/ueditor.all.min.js"> </script>
    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
    <script type="text/javascript" charset="utf-8" src="<%=path%>/lang/zh-cn/zh-cn.js"></script>
	
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
         
                       
      <h1><span>发布文章</span></h1>
      <div class="blank"></div>
     <form name="formAdd" method="post" action="<%=path %>/fabuWenzhang">
      
      <table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#dddddd">
                <tbody><tr>
                  <td width="28%" align="right" bgcolor="#FFFFFF">标题： </td>
                  <td width="72%" align="left" bgcolor="#FFFFFF"> 
                       <input name="title" type="text"   size="50" class="inputBg">
                      <input type="hidden" id="contents" name="contents"  />
                  </td>
                </tr>
                <tr>
                  <td width="28%" align="right" bgcolor="#FFFFFF">内容： </td>
                  <td width="72%" align="left" bgcolor="#FFFFFF"> 
                     <script id="container" type="text/plain" style="width:800px;height:300px;"></script>
                  </td>
                </tr>
               
						 
			    <tr>
                  <td colspan="2" align="center" bgcolor="#FFFFFF"> 
                    <input onclick="saveWenzhang();" style="margin-left: 450px;" type="button" value="保存" class="bnt_blue_1" style="border:none;">
                  </td>
                </tr>
       </tbody></table>
    </form>
     
          
        
 
      </div>
     </div>
    </div>
  </div>
  
</div>
<div class="blank"></div>




		<jsp:include flush="true" page="/qiantai/inc/incFoot.jsp"></jsp:include>

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
           document.formAdd.submit();
           
        }
      
    </script>
