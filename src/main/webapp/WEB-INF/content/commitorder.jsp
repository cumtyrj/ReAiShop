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
    <link href="source/css/style4.css" rel="stylesheet">
<script src="source/js/jquerycommit.min.js"></script>
<script src="source/js/jquery4.js"></script>
<script src="source/js/jquery8.js"></script>

    <link href="source/css/style3.css" rel="stylesheet">


        
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
				<font color="red">${requestScope.message }</font>			
					<div class="row">
						<div class="col-md-8">

						<table border="1">
							<tr>
							<th>商品信息</th>
							<th>数量</th><th width="200px">评价</th>
							</tr>
							<c:forEach items="${requestScope.order_list }" var="order">
								<tr>
								<td>${order.name }<br/><img src="source/img/${order.image}" height="60">
								<br/>价格：${order.price }																
								</td>
								<td>数量：${order.num }<br/>总价：${order.account }
									<td>
								<br/><br/>
								<form method="post" action="commitgetorder" id="myForm">
									<div class="stars">
									    <span>物流：</span>
									    <i>★</i>
									    <i>★</i>
									    <i>★</i>
									    <i>★</i>
									    <i>★</i>
									    <input type="text" name="wuliu" id="wuliu"/>
									</div>
									<div class="stars">
									    <span>质量：</span>
									    <i class="" score="1">★</i>
									    <i class="" score="2">★</i>
									    <i class="" score="3">★</i>
									    <i class="" score="4">★</i>
									    <i class="" score="5">★</i>
									    <input type="text" name="zhiliang" id="zhiliang"/>
									</div>
									<div class="stars">
									    <span>服务：</span>
									    <i>★</i>
									    <i>★</i>
									    <i>★</i>
									    <i>★</i>
									    <i>★</i>
									    <input type="text" name="fuwu" id="fuwu"/>
									</div>	
									<input type="hidden" name="ordernum" value="${order.ordernum}">
									<input type="submit" value="评价">
								</form>
								</tr>
							</c:forEach>
							</table>
								<br/><br/><br/>
							
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
