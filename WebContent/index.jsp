<!doctype html>
<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<script type="text/javascript">
	window.onload=createCode;
	var code ; //在全局 定义验证码
	function createCode()
	{
		code = "";
	    var codeLength = 4;//验证码的长度
	    var checkCode = document.getElementById("checkCode");
	    var selectChar = new Array(0,1,2,3,4,5,6,7,8,9,'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z');//所有候选组成验证码的字符，当然也可以用中文的汉字
		for(var i = 0 ; i < codeLength ; i++)
		{
			var charIndex = Math.floor(Math.random()*36);
	        code +=selectChar[charIndex];       
	    }
		//alert(code);
		if(checkCode)
		{
			checkCode.innerHTML = code;
	    }
	}
		function check(form){
			if (form.username.value==""){
				alert("请输入用户名!");
				form.username.focus();
				return false;
			}
			if (form.password.value==""){
				alert("请输入密码!");
				form.password.focus();
				return false;
			}
			var inputCode = document.getElementById("ch").value;
			if(inputCode.length <=0)
			{
				alert("验证码不能为空，请输入验证码！");
				return false;
		    }
			else if(inputCode != code )
			{
				alert("验证码错误，请重新输入验证码！");
		        createCode();//刷新验证码
				return false; 
		    }
			else { return true; }
		}
	</script>
<head>
<meta charset="utf-8">
<title>同学录网站</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/index.css">
</head>
<body>
<div style=" position:relative; margin:auto auto; width:1180px; height:500px;">
<div class="index" style="background:url(${pageContext.request.contextPath }/img/bground.jpg)">
<div class="login">
<div  align="center" class="biao"><b>登&nbsp;&nbsp;录</b></div>
<hr/>
<form action="${pageContext.request.contextPath }/user/LoginAction_index.do" method="post" focus="username" onsubmit="return check(this)">
<div  class="xiang" style="height:15px; font-size:12px; line-height:15px;" align="center"><s:actionerror/></div>
<div  class="xiang">用&nbsp;户&nbsp;名：<input type="text" name="username" size="25"></div>
<div  class="xiang">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：<input type="password" name="password" size="25"></div>
<div class="xiang">
验&nbsp;证&nbsp;码：
<input  type="text" id="ch" maxlength="4"/><span onClick="createCode()" id="checkCode" style="cursor:pointer;font-size:18px;color:#FF0004;" alt="点击刷新验证码！" title="点击刷新验证码！" ></div>
<hr/>
<div align="center" class="xiang"><input  class="butten" type="submit" value="提交">&nbsp;&nbsp;<input class="butten" type="reset" value="重置">&nbsp;&nbsp;<input class="butten" type="button" value="关闭" onclick="window.close()" /></div>
</form>
</div>
<div class="zhuce"><a href="${pageContext.request.contextPath }/user/UserAction_add.do"><b>注&nbsp;&nbsp;册</b></a></div>
</div>
</div>
</body>
</html>
