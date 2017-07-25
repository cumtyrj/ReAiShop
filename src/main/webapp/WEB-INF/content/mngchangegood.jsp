<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title></title>
<script type="text/javascript">
</script>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="source/css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="source/css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="source/css/styleee.css" />
    <link rel="stylesheet" type="text/css" href="source/css/style1.css" />
    <script type="text/javascript" src="source/js/jquery2.js"></script>
    <script type="text/javascript" src="source/js/jquery2.sorted.js"></script>
    <script type="text/javascript" src="source/js/bootstrap1.js"></script>
    <script type="text/javascript" src="source/js/ckform.js"></script>
    <script type="text/javascript" src="source/js/common.js"></script>
</head>
<body >
<form method="post" action="mngupdgood">
<table class="table table-bordered table-hover definewidth m10" align="center">
 	<tr>
		<th>商品名称</th><th>类别</th><th>价格</th><th>详细</th><th>数量</th>
		<th>操作</th>		
	</tr>
	<tr align="center">
	<td><input type="text" id="name" name="name" value="${good.name }"></td>
	<td><input type="text" id="goodtype" name="goodtype" value="${good.goodtype }"></td>
	<td><input type="text" id="price" name="price" value="${good.price }"></td>
	<td><input type="text" id="detail" name="detail" value="${good.detail }"></td>
	<td><input type="text" id="inventory" name="inventory" value="${good.inventory }">
	<input type="hidden" name="good_id" value="${good.good_id }"></td>	
	<td><input type="submit" value="修改"></td>
	</tr>
       </table>
       </form>
</body>

</html>