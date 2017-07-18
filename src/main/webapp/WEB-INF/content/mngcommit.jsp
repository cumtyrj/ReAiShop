<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title></title>

    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="source/css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="source/css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="source/css/styleee.css" />
    <script type="text/javascript" src="source/js/jquery2.js"></script>
        <script type="text/javascript" src="source/js/jquery7.js"></script>
    
    <script type="text/javascript" src="source/js/jquery2.sorted.js"></script>
    <script type="text/javascript" src="source/js/bootstrap1.js"></script>
    <script type="text/javascript" src="source/js/ckform.js"></script>
    <script type="text/javascript" src="source/js/common.js"></script>
	
    <style type="text/css">
        body {font-size: 20px;
		font-size: 20px;
            padding-bottom: 40px;
            background-color:#e9e7ef;
        }
        .sidebar-nav {
            padding: 9px 0;
        }

        @media (max-width: 980px) {
            /* Enable use of floated navbar text */
            .navbar-text.pull-right {
                float: none;
                padding-left: 5px;
                padding-right: 5px;
            }
        }


    </style>
</head>
<body >
</form>

<table class="table table-bordered table-hover definewidth m10" align="center">
 	<tr >
		<th>商品信息</th>
		<th>总金额</th><th>订单流水号</th><th>评价</th>	
	</tr>
	<c:forEach items="${requestScope.order_list }" var="order">
		<tr  align="center">
		<td>名称：${order.name }<br/><img src="source/img/${order.image}" height="60"><br/>价格：${order.price }</td>
		<td>数量：${order.num }总金额：${order.account }</td>
		<td>${order.ordernum}</td>
		<td>服务：${order.fuwu}质量：${order.zhiliang}物流：${order.wuliu}</td>
		</td>
		</tr>
     </c:forEach>
       </table>

</body>

</html>