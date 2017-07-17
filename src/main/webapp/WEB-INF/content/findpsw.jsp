<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>找回密码</title>

    <meta name="description" content="Source code generated using layoutit.com">
    <meta name="author" content="LayoutIt!">

    <link href="source/css/bootstrap.min.css" rel="stylesheet">
    <link href="source/css/style.css" rel="stylesheet">

  </head>
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
			<h3 class="text-center">
               找&nbsp;回&nbsp;密&nbsp;码
			</h3>
		</div>

		<div class="col-md-4">
			<div class="row">
				<div class="col-md-4">
				</div>
				<div class="col-md-4">
					 
					<button type="button" class="btn btn-default">
						登录
					</button>
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
			<form class="form-horizontal" role="form" method="post" action="findpsw">
				<font color="red">${requestScope.message }</font>
				<div class="form-group form-group-lg">
					 
					<label for="inputEmail1" class="col-sm-2 control-label">
						账号：
					</label>
					<div class="col-sm-10">
						<input type="number" class="form-control" id="loginname" name="loginname">
					</div>
				
              
                <div class="form-group form-group-lg">

                    <label for="card" class="col-sm-2 control-label">
                        邮箱：
                    </label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="email" name="email">
                    </div>
                </div>
				<div class="form-group form-group-lg">
					<div class="col-sm-offset-2 col-sm-10">
						 
						<button type="submit" class="btn btn-default">
							找回
						</button>
					</div>
				</div>
			</form>
		</div>
</div>

    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/scripts.js"></script>
  </body>
</html>
</html>