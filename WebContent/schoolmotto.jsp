<!doctype html>
<%@page import="com.txl.entity.School"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@page import="com.txl.entity.User" %>
<%
	
	User usersession=(User)session.getAttribute("user");
	if(usersession==null)
	{
		response.sendRedirect(request.getContextPath());
	}else{
		School school=(School)request.getAttribute("school");
%>
<script type="text/javascript">
function check(form){
	if(form.motto.value==""){
		alert("请输入班级寄语!");form.motto.focus();return false;
	}
		form.submit();
	    opener.location.reload();
	    window.close();
}
</script>
<html>
<head>
<meta charset="utf-8">
<title>同学录网站</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/createschoolandverify.css">
</head>
<body><form action="<%=request.getContextPath()%>/user/SchoolAction_mottoupdate.do" method="post" onsubmit="return check(this)">
<div class="main">
<div class="mainzhong">
<div align="center" style="height:20px; width:350px; float:left">班级座右铭</div>
<div style="height:20px; width:350px; float:left"></div>
<div>对<%=school.getSchoolname() %>班集的想法：</div>
<div style="height:20px; width:350px; float:left"></div>
<div class="liuyan">
<textarea name="motto" class="text"><%=school.getMotto() %></textarea>
<input type="submit" class="butten" value="提交">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class="butten" type="reset">
<input type="hidden" name="userid" value="<%=school.getUserid()%>">
<input type="hidden" name="schoolid" value="<%=school.getSchoolid()%>">
<input type="hidden" name="schoolname" value="<%=school.getSchoolname()%>">
</div>
</div>
</div>
</form>
</body>
</html>
<%} %>
