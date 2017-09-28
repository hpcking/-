<!doctype html>
<%@page import="java.util.HashSet"%>
<%@page import="com.txl.entity.School"%>
<%@page import="java.util.Set"%>
<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@page import="com.txl.entity.User" %>
<%
	
	User usersession=(User)session.getAttribute("user");
	if(usersession==null)
	{
		response.sendRedirect(request.getContextPath());
	}else{
		Set<School> sch=new HashSet<School>();
		sch=usersession.getSchool(); 
	%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta charset="utf-8">
<title>同学录网站</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
</head>
<body>
<div class="main">
<div class="img"><img src="${pageContext.request.contextPath}<%=usersession.getImage()%>"/></div>
<div class="information">
<div><b>姓名：<%=usersession.getUsername() %></b></div>
<div><b>性别：<%=usersession.getSex() %></b></div>
<div><b>电话：<%=usersession.getPhone() %></b></div>
<div><b>QQ:<%=usersession.getQq() %></b></div>
</div>
<div class="bianji"><b><a href="#" onclick="window.open('<%=request.getContextPath()%>/user/UserAction_edit.do','','width=1100,height=630,scrollbars=yes')">个人信息</a></b></div>
<div class="out"><b><a href="<%=request.getContextPath()%>/user/UserAction_logout.do">退出登陆</a></b></div>
<div class="banji">
<div class="bjbiao">
<form action="<%=request.getContextPath()%>/user/SchoolAction_seekschool.do" method="post" style="border:none;">
<div style="width:620px; height:30px; float:left; line-height:30px"><b>班级：</b></div><div style="float:left; height:30px;"><input type="text"  class="input" name="schoolname"><input class="butten" type="submit" value="收索班级"></div>
</form>
<div style="float:left; width:1000px; height:2px;"><hr/></div>
<div class="banjiming">
<% 
for(School school:sch)
{
%>
<div class="item"><a href="<%=request.getContextPath()%>/user/SchoolAction_student.do?schoolid_str=<%=school.getSchoolid()%>&userid_str=<%=usersession.getUserid()%>"><b><%=school.getSchoolname() %></b></a></div>
<%} %>
</div>
<div class="creatbj">
<div class="creatbanji"><a href="#"  onclick="window.open('<%=request.getContextPath()%>/user/SchoolAction_create.do','','width=450,height=400,scrollbars=yes')"><b>创建班级</b></a></div>
</div>
</div>
</div>
</div>
</body>
</html>
<%} %>
