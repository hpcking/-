<!doctype html>
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
<script type="text/javascript">
function check(form){
	if(form.schoolname.value==""){
		alert("请输入注册班级名!");form.schoolname.focus();return false;
	}
	if(form.motto.value==""){
		alert("请输入班级寄语!");form.word.focus();return false;
	}
		form.submit();
		//关闭窗体	 
	    opener.location.reload();
	    window.close();
}
</script>
<html>
<head>
<meta charset="utf-8">
<title>同学录网站</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/createschoolandverify.css">
</head>
<body><form action="<%=request.getContextPath()%>/user/SchoolAction_docreate.do" focus="schoolname" onsubmit="return check(this)" method="post">
<div class="main">
<div class="mainzhong">
<div  style="height:15px; font-size:12px; line-height:15px;" align="center"><s:actionerror/></div>
<div align="center" style="height:20px; width:350px; float:left">创建班级</div>
<div style="height:20px; width:350px; float:left"></div>
<div>班级名：<input type="text" name="schoolname" class="input"></div>
<div style="height:20px; width:350px; float:left"></div>
<div>班级寄语：</div>
<div class="liuyan">
<textarea name="motto" class="text"></textarea>
<input type="hidden" name="userid" value="<%=usersession.getUserid() %>">
<input type="submit" class="butten" value="提交">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class="butten" type="reset">
</div>
</div>
</div>
</form>
</body>
</html>
<%} %>
