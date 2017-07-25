<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>后台管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="source/css/adminStyle.css" rel="stylesheet" type="text/css" />
<link href="source/css/style2.css" rel="stylesheet" type="text/css" />

<title>热爱家居购物网站后台管理</title>
<script type="text/javascript" src="source/js/jquery1.js"></script>
<script type="text/javascript" src="source/js/jquery9.js"></script>

</head>
<body>

	<div class="top1">
		<marquee scrollAmount=2 width=300>欢迎进入热爱家居后台管理系统！</marquee>
	</div>
	<div class="top2">
		<div class="title" >
			<h3>热爱家居购物网站后台管理</h3>
		</div>
		<div class="fr top-link">
			<a href="admin_list.html" target="mainCont" title="DeathGhost"><i
				class="adminIcon"></i><span>欢迎管理员：【${sessionScope.user.username}】登录</span></a> 
		</div>
	</div>

	<div class="left">
		<div class="div1">
			<div class="left_top">
				<img src="source\img\/bbb_01.jpg"><img src="source\img\bbb_02.jpg"
					id="2"><img src="source\img\bbb_03.jpg"><img
					src="source\img\bbb_04.jpg">
			</div>
			
			<div class="div2">
				<div class="spgl"></div>
				商品管理
			</div>
			<div class="div3">
				<ul>
					<li><a class="a" href="javascript:void(0);"
						onClick="openurl('mnggood.html');">商品查看</a></li>
					<li><a class="a" href="javascript:void(0);"
						onClick="openurl('mngaddgood.html');">商品添加</a></li>
				</ul>
				
					
			</div>
						<div class="div2">
				<div class="yhgl"></div>
				订单管理
			</div>
			<div class="div3">
				<ul>
					<li><a class="a" href="javascript:void(0);"
						onClick="openurl('mngorder.html');">订单查看</a></li>
				</ul>
			</div>
			<div class="div2">
				<div class="yhgl"></div>
				销售情况
			</div>
			<div class="div3">
				<ul>
					<li><a class="a" href="javascript:void(0);"
						onClick="openurl('mngxskc.html');">库存量及库存量</a></li>
				</ul>
			</div>
			
			<div class="div2">
				<div class="gggl"></div>
				评价管理
			</div>
			<div class="div3">

				<ul>
					<li><a class="a" href="javascript:void(0);"
						onClick="openurl('mngcommit.html');">评价查看</a></li>
				</ul>

			</div>
			<a class="a1" href="mngloginout"><div class="div2">
					<div class="tcht"></div>
					退出后台
				</div></a>
		</div>
	</div>

	<div class="right">
		<iframe id="rightFrame" name="rightFrame" width="100%" height="100%"
			scrolling="auto" marginheight="0" marginwidth="0" align="center"
			style="border: 0px solid #CCC; margin: 0; padding: 0;"></iframe>
	</div>

</body>
</html>