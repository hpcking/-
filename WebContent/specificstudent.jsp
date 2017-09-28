<!doctype html>
<%@page import="com.txl.entity.User"%>
<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
User usersession=(User)session.getAttribute("user");
if(usersession==null)
{
	response.sendRedirect(request.getContextPath());
}else{
	User user=(User)request.getAttribute("finduserid");
	String schoolid_str=(String)request.getAttribute("schoolid_str");%>
	<script type="text/javascript">
function check(form){
	if(form.word.value==""){
		alert("请评论才能提交!");form.username.focus();return false;
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
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/specificstudent.css">
</head>
<body>
<div class="main">
<div class="img"><img src="${pageContext.request.contextPath}<%=user.getImage()%>"/></div>
<div class="information">
<div><b>姓名：<%=user.getUsername() %></b></div>
<div><b>性别：<%=user.getSex() %></b></div>
<div><b>电话：<%=user.getPhone() %></b></div>
<div><b>QQ:<%=user.getQq() %></b></div>
<div><b>座右铭：<%=user.getMotto() %></b></div>
</div>
<div class="liuyan">
<form action="<%=request.getContextPath()%>/user/EvaluateAction_evaluate.do" method="post" onsubmit="return check(this)">
<textarea name="word" class="text"></textarea>
<input type="submit" class="butten" value="提交">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class="butten" type="reset">
<input name="userid" type="hidden" value="<%=user.getUserid()%>">
<input name="classid" type="hidden" value="<%=schoolid_str %>">
</form>
</div>
</div>
</body>
</html>
<%} %>
