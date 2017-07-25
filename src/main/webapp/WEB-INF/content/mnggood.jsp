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
 	<tr>
		<th>商品名称</th><th>价格</th><th>详细</th><th>图片</th>
		<th>数量</th><th>操作</th>		
	</tr>
	<c:forEach items="${requestScope.good_list }" var="good">
	<tr align="center">
		<td>${good.name }</td>
		<td>${good.price }</td>
		<td>${good.detail }</td>
		<td><img src="source/img/${good.image1}" height="60"></td>
		<td>${good.inventory }</td>
		<td>
		<a  href="mnggetgoodinf?good_id=${good.good_id}" >编辑</a> 
		<a class="btn btn-warning" href="mngremovegood?good_id=${good.good_id}" >删除</a>                      	
		<br/><br/>                     	
         </td> 
		</tr>
     </c:forEach>
       </table>

</body>

</html>