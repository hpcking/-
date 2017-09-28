<!doctype html>
<%@page import="java.util.Set"%>
<%@page import="com.txl.entity.School"%>
<%@page import="java.util.List"%>
<%@page import="com.txl.entity.User"%>
<%@ page contentType="text/html; charset=UTF-8" language="java"%>

<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<%
	
	User usersession=(User)session.getAttribute("user");
	if(usersession==null)
	{
		response.sendRedirect(request.getContextPath());
	}else{		
		Set<School> userschools=usersession.getSchool();
	    List<School> schools=(List<School>)request.getAttribute("schools");
	%>
<head>
<meta charset="utf-8">
<title>同学录网站</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/school.css">
</head>
<body>
<div class="main">
  <div class="banji" style="top:70px; left:50px;">
    <div class="bjbiao">
<b>班级：</b>
<hr/>
<div class="banjiming">
<%
for(School school:schools){
	int schoolid=school.getSchoolid();
	boolean flag=true;
	for(School userschool:userschools){
	if(schoolid==userschool.getSchoolid()){flag=false;}	
		}
	if(flag==true){
%>
<div class="item"><a href="#" onclick="window.open('<%=request.getContextPath()%>/user/SchoolAction_verify.do?schoolid_str=<%=school.getSchoolid()%>&schoolname_str=<%=school.getSchoolname()%>','','width=600,height=500,scrollbars=yes')"><b><%=school.getSchoolname() %></b></a></div>
<%} }%>
</div>
<div class="creatbj"></div>
</div>
</div>
</div>
</body>
</html>
<%} %>
