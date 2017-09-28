<!doctype html>
<%@page import="com.txl.entity.ViceMonitor"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.List"%>
<%@page import="com.txl.entity.Verify"%>
<%@page import="com.txl.entity.School"%>
<%@page import="com.txl.entity.User"%>
<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
User usersession=(User)session.getAttribute("user");
if(usersession==null)
{
	response.sendRedirect(request.getContextPath());
}else{
School school=(School)request.getAttribute("school");
int flag=(int)request.getAttribute("flagrole");
List<Verify> verifys=(List<Verify>)request.getAttribute("verifies");
List<ViceMonitor> viceMonitors=(List<ViceMonitor>)request.getAttribute("viceMonitor");
Set<User> users=school.getUser();%>
<html>
<head>
<meta charset="utf-8">
<title>同学录网站</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/role.css">
</head>
<body>
<div class="main">
<div style="width:1000px; height:600px; left:50px; top:70px; position:relative;">
 <div class="banji"> 
    <div class="bjbiao">
<div style="width:900px; height:30px; float:left"><b>审核：</b></div>
<div class="banjiming">
<%for(Verify verify:verifys){ %>
<div class="item"><a href="#"><b><%=verify.getUser().getUsername() %></b></a>
<a href="#"><b>-<%=verify.getWord() %></b></a>
<a href="<%=request.getContextPath()%>/user/SchoolAction_roleadd.do?schoolid_str=<%=verify.getClassid()%>&userid_str=<%=verify.getUser().getUserid()%>&role_str=<%=flag %>" onclick="return confirm('通过<%=verify.getUser().getUsername() %>认证')"><b>-通过</b>
<a href="<%=request.getContextPath()%>/user/SchoolAction_roledelete.do?schoolid_str=<%=verify.getClassid()%>&userid_str=<%=verify.getUser().getUserid()%>&role_str=<%=flag %>" onclick="return confirm('不通过<%=verify.getUser().getUsername() %>认证')"><b>-删除</b></a></div>
<%} %>
</div>
</div>
</div>
<%if(flag==1){ %>
<div class="banji2">
<div class="bjbiao">
<b>管理班级：</b>
<hr/>
<div class="banjiming">
<%for(User user:users){ 
boolean monitor=false;
boolean vicemonitor=false;
if(usersession.getUserid()==user.getUserid()){monitor=true;}
if(monitor){}
else{ 
%>
<div class="item">
<a href="#"><b><%=user.getUsername() %></b></a>
<%for(ViceMonitor viceMonitor:viceMonitors){
	if(viceMonitor.getUserid()==user.getUserid()){vicemonitor=true;break;}
	}
if(vicemonitor){
	%>
<a href="<%=request.getContextPath()%>/user/SchoolAction_viceMonitordelete.do?schoolid_str=<%=school.getSchoolid()%>&userid_str=<%=user.getUserid()%>&role_str=<%=flag %>" onclick="return confirm('降级为成员')"><b>-副班</b></a>
<%}
else{
%>
<a href="<%=request.getContextPath()%>/user/SchoolAction_viceMonitoradd.do?schoolid_str=<%=school.getSchoolid()%>&userid_str=<%=user.getUserid()%>&role_str=<%=flag %>" onclick="return confirm('提升为副班')"><b>-成员</b></a>
<%} %>
<a href="<%=request.getContextPath()%>/user/SchoolAction_userdelete.do?schoolid_str=<%=school.getSchoolid()%>&userid_str=<%=user.getUserid()%>&role_str=<%=flag %>" onclick="return confirm('删除该成员')"><b>-删除</b></a>
</div>
<%} }%>
</div>
</div>
</div>
<div class="bjmotto" style="width:100px; height:20px;">
<div class="banjimotto"><a href="#" onclick="window.open('<%=request.getContextPath()%>/user/SchoolAction_motto.do?schoolid_str=<%=school.getSchoolid() %>','','width=450,height=400,scrollbars=yes')"><b>班级座右铭</b></a></div>
</div>
<%} %>
</div>
</body>
</html>
<%} %>
