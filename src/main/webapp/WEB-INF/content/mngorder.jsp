<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title></title>
        <script type="text/javascript" src="source/js/jquery7.js"></script>

    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="source/css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="source/css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="source/css/styleee.css" />
    <script type="text/javascript" src="source/js/jquery2.js"></script>
    <script type="text/javascript" src="source/js/jquery2.sorted.js"></script>
    <script type="text/javascript" src="source/js/bootstrap1.js"></script>
    <script type="text/javascript" src="source/js/ckform.js"></script>
    <script type="text/javascript" src="source/js/common.js"></script>
	    <link rel="stylesheet" type="text/css" href="source/css/style1.css" />
	
</head>
<body >
<form class="form-inline definewidth m20" action="#" method="get">
    <font color="#777777"><strong>商品名称：</strong></font>
    <input type="text" name="menuname" id="menuname"class="abc input-default" placeholder="" value="">&nbsp;&nbsp; 
    <button type="submit" class="btn btn-primary">查询</button>&nbsp;&nbsp; 
</form>

<table class="table table-bordered table-hover definewidth m10" align="center">
 	<tr >
		<th>商品名称</th><th>价格</th><th>图片</th>
		<th>数量</th><th>总金额</th><th>订单流水号</th><th>操作</th>	
	</tr>
	<c:forEach items="${requestScope.order_list }" var="order">
		<tr  align="center">
		<td>${order.name }</td>
		<td>${order.price }</td>
		<td><img src="source/img/${order.image}" height="60"></td>
		<td>${order.num }</td>
		<td>${order.account }</td>
		<td>${order.ordernum}</td>
		<td><a class="btn btn-warning" href="mngsendgoodnum?ordernum=${order.ordernum}" role="button">${order.state}</a>                      	
		</td>
		</tr>
     </c:forEach>
       </table>

</body>

</html>