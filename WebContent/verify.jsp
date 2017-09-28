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
	   String schoolname=(String)request.getAttribute("schoolname_str");
	   int schoolid=(int)request.getAttribute("schoolid_int");
	%>
	<script type="text/javascript">
function check(form){
	if(form.word.value==""){
		alert("请输入验证信息才能提交!");form.word.focus();return false;
	}
		form.submit();
        window.close();
}
</script>
<html>
<head>
<meta charset="utf-8">
<title>同学录网站</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/createschoolandverify.css">
</head>
<body><form action="<%=request.getContextPath()%>/user/VerifyAction_verify.do" method="post" onsubmit="return check(this)">
<div class="main">
<div class="mainzhong">
<div align="center" style="height:20px; width:350px; float:left">进入<%=schoolname %>验证信息</div>
<div style="height:20px; width:350px; float:left"></div>
<div>对班长的谈话：</div>
<div style="height:20px; width:350px; float:left"></div>
<div class="liuyan">
<textarea name="word" class="text"></textarea>
<input type="hidden" name="userid" value="<%=usersession.getUserid()%>">
<input type="hidden" name="classid" value="<%=schoolid%>">
<input type="submit" class="butten" value="提交">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class="butten" type="reset">
</div>
</div>
</div>
</form>
</body>
</html>
<%} %>
