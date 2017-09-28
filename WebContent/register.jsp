<!doctype html>
<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<script type="text/javascript">
function check(form){
	if(form.username.value==""){
		alert("请输入注册姓名!");form.username.focus();return false;
	}
	if(form.password.value==""){
		alert("请输入注册密码!");form.password.focus();return false;
	}
	if(form.repassword.value==""){
		alert("请确认注册密码!");form.repassword.focus();return false;
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
		if(form.uploadFile.value==""){
		alert("请上传你的照片!");form.uploadFile.focus();return false;
	}	
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
<div  align="center" class="biao"><b>注&nbsp;&nbsp;册</b></div>
<hr/>
<form action="${pageContext.request.contextPath }/user/UserAction_doadd.do" method="post" focus="username" onsubmit="return check(this)" enctype="multipart/form-data">
<div  class="xiang">用&nbsp;户&nbsp;名：<input type="text" name="username" size="25"></div>
<div  class="xiang">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：<input type="password" name="password" size="25"></div>
<div class="xiang">确认密码：<input type="password" name="repassword" size="25"></div>
<div class="xiang">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别： 
    <label>
      <input type="radio" name="sex" value="男" id="sex_0">
      男</label>
    
    <label>
      <input type="radio" name="sex" value="女" id="sex_1">
      女</label>
</div>
<div  class="xiang">Q&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Q：<input type="text" name="qq" size="32"></div>
<div  class="xiang">电&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;话：<input type="text" name="phone" size="32"></div>
<div  class="xiang">图&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;像：<input type="file" name="uploadFile"></div>
<div  class="xiang">座&nbsp;右&nbsp;铭：<textarea name="motto"></textarea></div>
<hr/>
<div align="center" class="xiang" style="margin-left:25px;"><input  class="butten" type="submit" value="提交">&nbsp;&nbsp;<input class="butten" type="reset" value="重置">&nbsp;&nbsp;<input class="butten" type="button" value="关闭" onclick="window.close()" /></div>
</form>
</div>
</body>
</html>
