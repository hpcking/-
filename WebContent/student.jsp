<!doctype html>
<%@page import="com.txl.entity.ViceMonitor"%>
<%@page import="com.txl.entity.Evaluate"%>
<%@page import="java.util.List"%>
<%@page import="com.txl.entity.User"%>
<%@page import="java.util.Set"%>
<%@page import="com.txl.entity.School"%>
<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
User usersession=(User)session.getAttribute("user");
if(usersession==null)
{
	response.sendRedirect(request.getContextPath());
}else{
School school=(School)request.getAttribute("school");
List<Evaluate> evaluate=(List<Evaluate>)request.getAttribute("evaluate");
List<ViceMonitor> viceMonitor=(List<ViceMonitor>)request.getAttribute("viceMonitor");
Set<User> user=(Set<User>)school.getUser();
%>
<html>
<head>
<meta charset="utf-8">
<title>同学录网站</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/school.css">
</head>
<body>
<div class="main">
<div style="width:1000px; height:600px; left:50px; top:70px; position:relative;">
 <div class="banji"> 
    <div class="bjbiao">
<div style="width:900px; height:30px; float:left"><b><%=school.getSchoolname() %>班级对我评价：</b></div>
<%if(usersession.getUserid()==school.getUserid()){ %>
<div class="jiaose">
<a href="#" onclick="window.open('<%=request.getContextPath()%>/user/SchoolAction_role.do?schoolid_str=<%=school.getSchoolid() %>&role_str=1','','width=1500,height=800,scrollbars=yes')"><b>班长</b></a>
</div>
<%} %>
<%
boolean flag=false;
for(ViceMonitor viceMonitors:viceMonitor)
{
	if(viceMonitors.getUserid()==usersession.getUserid()){flag=true; break;}
}
if(flag){ %>
<div class="jiaose">
<a href="#" onclick="window.open('<%=request.getContextPath()%>/user/SchoolAction_role.do?schoolid_str=<%=school.getSchoolid() %>&role_str=2','','width=1500,height=800,scrollbars=yes')"><b>副班长</b></a>
</div>
<%} %>
<div class="banjiming">
<%for(Evaluate evaluates:evaluate) {%>
<div class="item"><a href="#"><b><%=evaluates.getWord() %></b></a></div>
<%} %>
</div>
</div>
</div>
<div class="banji2">
<div class="bjbiao">
<b>同学：</b>
<hr/>
<div class="banjiming">
<%for(User users:user){ %>
<div class="item"><a href="#" onclick="window.open('<%=request.getContextPath()%>/user/SchoolAction_specificstudent.do?userid_str=<%=users.getUserid() %>&schoolid_str=<%=school.getSchoolid() %>','','width=1500,height=800,scrollbars=yes')"><b><%=users.getUsername() %></b></a></div>
<%} %>
</div>
</div>
</div>
<div class="banjijiyu"><%=school.getMotto() %></div>
</div>
</div>
</body>
</html>
<%} %>
