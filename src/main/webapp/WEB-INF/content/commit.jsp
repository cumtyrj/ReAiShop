<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="zh-CN">
<title>订单评分</title>

<script src="source/js/jquerycommit.min.js"></script>
<link href="source/css/commit.css" rel="stylesheet">

</head>
<body>
<form method="post" action="submitcommit">
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
<a class="btn btn-danger" href="submitcommit?ordernum=${good.ordernum}" role="button">提交评价</a>                      	

</form>


</body>
</html>