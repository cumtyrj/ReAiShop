<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta name="description" content="Source code generated using layoutit.com">

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>商品详情-${good.name}</title>

<link rel="stylesheet" href="source/css/shouye.css">

<script src="source/js/jquery-1.8.3.min.js"></script>
<script   src="source/js/modernizr-custom-v2.7.1.min.js"></script>
<script src="source/js/jquery5.js"></script>


</head>
<body>
<div class="Xcontent">
	<ul class="Xcontent01">
		<div class="Xcontent06"><img src="source/img/${good.image1 }"></div>
		<ol class="Xcontent08">
			<div class="Xcontent07"><img src="source/img/${good.image1 }"></div>
			<div class="Xcontent09"><img src="source/img/${good.image2 }"></div>
			<div class="Xcontent10"><img src="source/img/${good.image3 }"></div>

		</ol>
		<ol class="Xcontent13">
			<div class="Xcontent14"><a href="#"><p>${good.name}</p></a></div>
			<div class="Xcontent16"><p>${good.detail }</p></div>
			<div class="Xcontent17">
				<p class="Xcontent18">售价</p>
				<p class="Xcontent19">￥<span>${good.price}</span></p>
			</div>
			
			<form method="post" action="" name="form1"> 
			<div class="Xcontent30">
				<p class="Xcontent31">数量</p>
				<div class="Xcontent32"><img src="source/img/X15.png"></div>
				<input class="input"type="text" value="1" name="num">
				<div class="Xcontent33"><img src="source/img/16.png"></div>
			</div>
	<input type="hidden" name="good_id" value="${good.good_id }"></td>	
			<div class="Xcontent34"><input type="submit" value="立即购买" onclick="form1.action='savedirectly';form1.submit();"></div>
			<div class="Xcontent35"><input type="submit" value="加入购物车" onclick= "form1.action='save';form1.submit();"></div>
			<div><a href="savecollect?good_id=${good.good_id}" role="button"><img src="source/img/sc.jpg"></a></div>
			</form>
		</ol>
	</ul>
</div>
</form>
    <script src="source/js/jquery.min.js"></script>
    <script src="source/js/bootstrap.min.js"></script>
    <script src="source/js/scripts.js"></script>
</body>
</html>