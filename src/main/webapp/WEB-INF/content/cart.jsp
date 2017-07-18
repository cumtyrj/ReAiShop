<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>购物车</title>

    <meta name="description" content="Source code generated using layoutit.com">
    <meta name="author" content="LayoutIt!">

    <link href="source/css/bootstrap.min.css" rel="stylesheet">
    <link href="source/css/style.css" rel="stylesheet">
<style type="text/css">
	table{border-collapse:collapse;border-spacing:0;border-left:1px solid #888;border-top:1px solid #888;background:#efefef;}
	th,td{border-right:1px solid #888;border-bottom:1px solid #888;padding:5px 15px;}
	th{font-weight:bold;background:#ccc;}
</style>
  </head>
  <body>
<link href='http://fonts.googleapis.com/css?family=Lato:300,400,700,900' rel='stylesheet' type='text/css'>
    <div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<div class="row">
				<div class="col-md-12">
					<div class="page-header">
						<h1>
							热爱创意家居——关于你的我的热爱
						</h1>
						&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
						欢迎【${sessionScope.user.username}】登录
						<a href="loginout">退出</a>						
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-8">
					<ul class="breadcrumb">
						<li>
							<a href="index">首页</a> <span class="divider">/</span>
						</li>
						<li>
							<a href="owninf">我的设置</a> <span class="divider">/</span>
						</li>
							<li>
							<a href="cart">购物车</a> <span class="divider">/</span>
						</li>
							<li>
							<a href="order">订单</a> <span class="divider">/</span>
						</li>
							<li>
							<a href="collection">收藏夹</a> <span class="divider">/</span>
						</li>
												<li>
							<a href="commitorder">订单评价</a> <span class="divider">/</span>
						</li>
					</ul>
				</div>
				<div class="col-md-4">
					<ul class="nav nav-pills">
						<li class="active">
							 <a href="#"> <span class="badge pull-right">42</span> Home</a>
						</li>
						<li>
							 <a href="#"> <span class="badge pull-right">16</span> More</a>
						</li>
					</ul>
				</div>
			</div>
			<div class="row">
				<div class="col-md-4">
				
<dropdown>
  <input id="toggle1" type="checkbox" checked>
  <label for="toggle1" class="animate">我的<i class="fa fa-bars float-right"></i></label>
  <ul class="animate">
   <a href="owninf"><li class="animate">账号管理<i class="fa fa-code float-right"></i></li></a>
   <a href="cart"><li class="animate">购物车<i class="fa fa-arrows-alt float-right"></i></li></a>
   <a href="order"><li class="animate">订单<i class="fa fa-cog float-right"></i></li></a>
   <a href="collection"><li class="animate">收藏<i class="fa fa-cllection float-right"></i></li></a>
   <a href="commitorder"><li class="animate">订单评价<i class="fa fa-cllection float-right"></i></li></a>
  
  </ul>
</dropdown>
				</div>
				<div class="col-md-8">
					<div class="row">
						<div class="col-md-8">
						<table border="1" >
							<tr>
							<th>商品名称</th><th>价格</th><th>详细</th><th>图片</th>
							<th>数量</th><th>操作</th><th>购买</th>
							</tr>
							<c:forEach items="${requestScope.cart_list }" var="good">
								<tr>
								<td>${good.name }</td>
								<td>${good.price }</td>
								<td>${good.detail }</td>
								<td><img src="source/img/${good.image}" height="60"></td>
								<td>${good.num }</td>
								<td>
								<a class="btn btn-warning" href="add?good_id=${good.good_id}" role="button">+</a>                      	
								<br/><br/>
								<a class="btn btn-warning" href="reduce?good_id=${good.good_id}" role="button">-</a>                      	
								<br/><br/>
								<a class="btn btn-warning" href="remove?good_id=${good.good_id}" role="button">X</a>                      	
	
                        		</td>
                        		<td>								
                        		<a class="btn btn-warning" href="saveorder?good_id=${good.good_id}" role="button">立即购买</a>                      	
                        		</td>
								</tr>
							</c:forEach>
							</table>
								<br/><br/><br/>
								<a class="btn btn-danger" href="clear?good_id=${good.good_id}" role="button">清空购物车</a>                      	
							
						</div>
						<div class="col-md-4">
						</div>
					</div>
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
