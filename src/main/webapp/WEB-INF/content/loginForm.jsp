<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>登录</title>

    <meta name="description" content="Source code generated using layoutit.com">
    <meta name="author" content="LayoutIt!">

    <link href="source/css/bootstrap.min.css" rel="stylesheet">
    <link href="source/css/style.css" rel="stylesheet">
    <script src="source/js/jquery.1.4.2-min.js"></script>
    <script src="source/js/jquery.cookie.js"></script>
    
  </head>
<script type="text/javascript">
$(document).ready(function(){
	if($.cookie("rmbUser")=="true"){
		$("#ck_rmbUser").attr("checked",true);
		$("#loginname").val($.cookie("lgn"));
		$("#password").val($.cookie("psw"));
	}
});

function Save(){
	if($("#ck_rmbUser").attr("checked")){
		var str_loginname=$("#loginname").val();
		var str_password=$("#password").val();
		$.cookie("rmbUser","true",{expires:7});
		$.cookie("lgn",str_loginname,{expires:7});
		$.cookie("psw",str_password,{expires:7});
	}else{
		$.cookie("rmbUser","false",{expires:-1});
		$.cookie("lgn","",{expires:-1});
		$.cookie("psw","",{expires:-1});
	}
};
</script>
  <body>
<span style="color:red;font-weight:bold">
<%
if (request.getAttribute("err")!=null)
{
	
	out.println(request.getAttribute("err")+"<br/>");	
}
%>
</span>
    <div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<div class="page-header">
				<h1>
					热爱创意家居——关于你的我的热爱
				</h1>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-4">
		</div>
		<div class="col-md-4">
			<h3>
               &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;欢&nbsp;迎&nbsp;登&nbsp;录
			</h3>
		</div>
		<div class="col-md-4">
			<div class="row">
				<div class="col-md-4">
				</div>
				<div class="col-md-4">
					<a href="register"><button type="button" class="btn btn-default" >
						注册
					</button></a>
					<a href="mnglogin"><button type="button" class="btn btn-default" >
						管理员登录
					</button></a>
				
				</div>
				<div class="col-md-4">
				</div>
			</div>
		</div>
	</div>
        <br/><br/><br/><br/>
	<div class="row">
		<div class="col-md-4">
			<div class="row">
				<div class="col-md-4">
				</div>
				<div class="col-md-8">
					<img alt="Bootstrap Image Preview" src="source\img\热爱2.jpg">
				</div>
			</div>
		</div>
		<div class="col-md-4">
			<form class="form-horizontal" role="form" method="post" action="login">
				<font color="red">${requestScope.message }</font>
				<font color="red">${requestScope.changepswsuccess }</font>
				<div class="form-group form-group-lg"> 
					<label for="loginname" class="col-sm-2 control-label">
						账&nbsp;号：
					</label>
					<br/><br/>
					<div class="col-sm-10">
						<input type="number" class="form-control" id="loginname" name="loginname">
					</div>
				</div>
		
				<div class="form-group form-group-lg">
					 
					<label for="inputPassword3" class="col-sm-2 control-label">
						密&nbsp;码：
					</label>
					<br/><br/>
					<div class="col-sm-10">
						<input type="password" class="form-control" id="password" name="password">
					</div>
				</div>
				<div class="form-group form-group-lg">
					<div class="col-sm-offset-2 col-sm-10">
						<div class="checkbox">							 
							<label>
								<input type="checkbox"id="ck_rmbUser">记住密码
							</label>
						</div>
					</div>
				</div>
				<div class="form-group form-group-lg">
					<div class="col-sm-offset-2 col-sm-10">
						 
						<button type="submit" class="btn btn-default" onclick="Save()">
							登&nbsp;录
						</button>
						<a href="findpsw">
							忘记密码
						</a>
					</div>
				</div>
			</form>
		</div>
		<div class="col-md-4">
		</div>
	</div>
</div>

  </body>
</html>
</html>