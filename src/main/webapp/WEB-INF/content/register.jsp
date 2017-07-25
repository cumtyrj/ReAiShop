<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>注册</title>

    <meta name="description" content="Source code generated using layoutit.com">
    <meta name="author" content="LayoutIt!">

    <link href="source/css/bootstrap.min.css" rel="stylesheet">
    <link href="source/css/style.css" rel="stylesheet">

  </head>
  <body>

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
			<h3 class="text-center">
             欢&nbsp;迎&nbsp;注&nbsp;册
			</h3>
		</div>

		<div class="col-md-4">
			<div class="row">
				<div class="col-md-4">
				</div>
				<div class="col-md-4">
					 
					<a href="loginForm"><button type="button" class="btn btn-default">
						登录
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
			<form id="regFrm" class="form-horizontal" role="form" method="post" action="register">
				<div class="form-group form-group-lg">
					 
					<label for="loginname" class="col-sm-2 control-label">
						账号：
					</label>
					<br/><br/>
					<div class="col-sm-10">
						<input type="number" class="form-control" id="loginname" name="loginname">
						6-8位数字或英文字母
						<font color="red">${requestScope.ms1 }</font>
					</div>
				</div>
				<div class="form-group form-group-lg"> 
					<label for="username" class="col-sm-2 control-label">
						昵称：
					</label>
					<br/><br/>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="username" name="username">
						6-8位数字或英文字母										
						<font color="red">${requestScope.ms2 }</font>
					</div>
				</div>
				<div class="form-group form-group-lg">
					 
					<label for="password" class="col-sm-2 control-label">
						密码：
					</label>
					<span style="color: red;" id="pwdError"></span>
					<br/><br/>
					<div class="col-sm-10">
						<input type="password" class="form-control" id="password" name="password">
						6-12位数字或英文字母
						<font color="red">${requestScope.ms3 }</font>
					</div>
				</div>
                <div class="form-group form-group-lg">


                    <label for="phone" class="col-sm-2 control-label">
                        电话：
                    </label>
                    <br/><br/>
                    <div class="col-sm-10">
                        <input type="number" class="form-control" id="phone" name="phone">
                   		11位数字
                   		<font color="red">${requestScope.ms4 }</font>
                    </div>
                </div>
                <div class="form-group form-group-lg">
					 
					<label for="email" class="col-sm-2 control-label">
						邮箱：
					</label>
					<br/><br/>
					<div class="col-sm-10">
						<input type="email" class="form-control" id="email" name="email">
						标准邮箱地址
						<font color="red">${requestScope.ms5 }</font>
					</div>
				</div>
                <div class="form-group form-group-lg">

                    <label for="card" class="col-sm-2 control-label">
                        身份证：
                    </label>
                    <br/><br/>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="card" name="card">
                    	18位数字（或数字和字母组成）
                    	<font color="red">${requestScope.ms6 }</font>
                    </div>
                </div>
				<div class="form-group form-group-lg">
					<div class="col-sm-offset-2 col-sm-10">
						 
						<button type="submit" class="btn btn-default">
							注册
						</button>
					</div>
				</div>
			</form>
		</div>
		<div class="col-md-4">
			<div class="row">
				<div class="col-md-4">
				</div>
				<div class="col-md-4">
					<div class="alert alert-success alert-dismissable">
						 
						<button type="button" class="close" data-dismiss="alert" aria-hidden="true">
							×
						</button>
						<h4>
                            <strong>注意！ </strong>
						</h4> 请牢记您的信息，便于密码找回！
					</div>
				</div>
				<div class="col-md-4">
				</div>
			</div>
		</div>
	</div>
</div>

    <script src="source/js/jquery.min.js"></script>
    <script src="source/js/bootstrap.min.js"></script>
    <script src="source/js/scripts.js"></script>
  </body>
</html>
</html>