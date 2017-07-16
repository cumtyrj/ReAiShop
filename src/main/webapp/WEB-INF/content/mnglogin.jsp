<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>管理员登录</title>

<link rel="stylesheet" type="text/css" href="source/css/styles.css">

</head>
<body>

<div class="wrapper">

	<div class="container">
		<h1>管理员登录</h1>
						<font color="red">${requestScope.message }</font>
		<form class="form"  method="post" action="mnglogin">
			<input type="text" placeholder="Loginname" id="loginname" name="loginname">
			<input type="password" placeholder="Password"id="password" name="password"><br>
			<button type="submit" id="login-button"><strong>登陆</strong></button>
			
		</form>
	</div>
	
	<ul class="bg-bubbles">
		<li></li>
		<li></li>
	</ul>
</div>
</body>
</html>