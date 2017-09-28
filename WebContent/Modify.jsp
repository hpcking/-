<!doctype html>
<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@page import="com.txl.entity.User" %>
<%
	
	User usersession=(User)session.getAttribute("user");
	if(usersession==null)
	{
		response.sendRedirect(request.getContextPath());
	}else{
	%>
<html>
<script type="text/javascript">
function check(form){
	if(form.username.value==""){
		alert("请输入姓名!");form.username.focus();return false;
	}
	if(form.password.value==""){
		alert("请输入密码!");form.password.focus();return false;
	}
	if(form.repassword.value==""){
		alert("请确认密码!");form.repassword.focus();return false;
	}		
	if(form.password.value!=form.repassword.value){
		alert("您两次输入的登录密码不一致，请重新输入!");form.repassword.focus();return false;
	}
	if(form.sex.value==""){
		alert("请选择你的性别!");return false;
	}
	if(form.qq.value==""){
		alert("请输入你的qq!");form.qq.focus();return false;
	}
		if(form.phone.value==""){
		alert("请输入你的电话!");form.phone.focus();return false;
	}
		//判断当前编辑用户操作是否修改了密码
		if(form.password.value!=form.password.defaultValue){form.flag.value=1}
		if(form.uploadFile.value!=form.uploadFile.defaultValue){form.image.value=1}
		form.submit();
		//关闭窗体	 
	    opener.location.reload();
	    window.close();
}
</script>
<head>
<meta charset="utf-8">
<title>同学录注册</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/register.css">
</head>
<body bgcolor="#333333">
<div class="left1"></div>
<div class="reg">
<div  align="center" class="biao"><b>个&nbsp;人&nbsp;信&nbsp;息</b></div>
<hr/>
<form action="${pageContext.request.contextPath }/user/UserAction_doedit.do" method="post" focus="username" onsubmit="return check(this)" enctype="multipart/form-data">
<div  class="tupian">
<img src="${pageContext.request.contextPath}<%=usersession.getImage()%>" class="img"/></div>
<div  class="xiang">用&nbsp;户&nbsp;名：<input type="text" name="username" size="25" value="<%=usersession.getUsername() %>"></div>
<div  class="xiang">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：<input type="password" name="password" size="25" value="<%=usersession.getPassword() %>"></div>
<div  class="xiang">确认密码：<input type="password" name="repassword" size="25" value="<%=usersession.getPassword() %>"></div>
<div class="xiang">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别： 
    <label>
      <input type="radio" name="sex" value="男" id="sex_0" <%if("男".equals(usersession.getSex())) {%>checked="checked"<%} %>>
      男</label>
    
    <label>
      <input type="radio" name="sex" value="女" id="sex_1" <%if("女".equals(usersession.getSex())) {%>checked="checked"<%} %>>
      女</label>
</div>
<div  class="xiang">Q&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Q：<input type="text" name="qq" size="25" value="<%=usersession.getQq() %>"></div>
<div  class="xiang">电&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;话：<input type="text" name="phone" size="25" value="<%=usersession.getPhone() %>"></div>
<div  class="xiang">图&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;像：<input type="file" name="uploadFile"></div>
<div  class="xiang">座&nbsp;右&nbsp;铭：<textarea name="motto"><%=usersession.getMotto() %></textarea></div>
<hr/>
<div align="center" class="xiang" style="margin-left:25px;"><input  class="butten" type="submit" value="提交">&nbsp;&nbsp;<input class="butten" type="reset" value="重置">&nbsp;&nbsp;<input class="butten" type="button" value="关闭" onclick="window.close()" /></div>
<input type="hidden" name="flag"><input type="hidden" name="image"><input type="hidden" name="userid" value="<%=usersession.getUserid() %>"><input type="hidden" name="imageurl" value="<%=usersession.getImage() %>">
</form>
</div>
</body>
</html><%} %>
