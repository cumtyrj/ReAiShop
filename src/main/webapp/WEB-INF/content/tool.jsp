<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>家具/桌椅</title>

<!--图标样式-->

<link rel="stylesheet" type="text/css" href="source/css/bootstrap.min.css" />

<!--主要样式-->

<link href="source/css/basic.css" rel="stylesheet" type="text/css">

<link rel="stylesheet" type="text/css" href="source/css/style.css" />

<script type="text/javascript" src="source/js/jquery-1.7.2.min.js"></script>

<script type="text/javascript">
$(function(){
    $('.tree li:has(ul)').addClass('parent_li').find(' > span').attr('title', 'Collapse this branch');
    $('.tree li.parent_li > span').on('click', function (e) {
        var children = $(this).parent('li.parent_li').find(' > ul > li');
        if (children.is(":visible")) {
            children.hide('fast');
            $(this).attr('title', 'Expand this branch').find(' > i').addClass('icon-plus-sign').removeClass('icon-minus-sign');
        } else {
            children.show('fast');
            $(this).attr('title', 'Collapse this branch').find(' > i').addClass('icon-minus-sign').removeClass('icon-plus-sign');
        }
        e.stopPropagation();
    });
});
</script>
<style type="text/css">
	table{border-collapse:collapse;border-spacing:0;border-left:1px solid #888;border-top:1px solid #888;background:#efefef;}
	th,td{border-right:1px solid #888;border-bottom:1px solid #888;padding:5px 15px;}
	th{font-weight:bold;background:#ccc;}
</style>
</head>
  <body>

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
				<div class="col-md-3">
				                   <div class="tree well">
                                <ul>
                                    <li>
                                        <span><i class="icon-folder-open"></i> 热爱</span> 
                                    </li>
                                    <li>
                                        <span><i class="icon-minus-sign"></i> 分类</span> 
                                        <ul>
                                            <li>
                                                <span><i class="icon-minus-sign"></i> 家具</span>
                                                <ul>
                                                    <li>
                                                        <ul>
                                                            <li>
                                                                <span><i class="icon-leaf"></i><a href="chair">桌椅</a></span>
                                                            </li>
                                                            <li>
                                                                <span><i class="icon-leaf"></i><a href="bookcase">书架</a></span> 
                                                            </li>
                                                        </ul>
                                                    </li>
                                                </ul>
                                            </li>
                                        </ul>
                                        <ul>
                                            <li>
                                                <span><i class="icon-minus-sign"></i> 厨房</span>
                                                <ul>
                                                    <li>
                                                        <ul>
                                                            <li>
                                                                <span><i class="icon-leaf"></i><a href="vessel">器皿</a></span>

                                                            </li>
                                                            <li>
                                                                <span><i class="icon-leaf"></i><a href="tool">用具</a></span>
                                                            </li>
                                                        </ul>
                                                    </li>
                                                </ul>
                                            </li>
                                        </ul>
                                    </li>
                                </ul>
                                
                            </div>
				</div>
				
				<div class="col-md-8">
					<div class="row">
						<div class="col-md-8">
						<table border="1">
							<tr>
							<th>商品名称</th><th>价格</th><th>详细</th><th>图片</th>
							<th>操作</th>
							</tr>
							<c:forEach items="${requestScope.tool_list }" var="tool">
								<tr>
								<td>${tool.name }</td>
								<td>￥${tool.price }</td>
								<td>${tool.detail }</td>
								<td><img src="source/img/${tool.image1}" height="60"></td>
								<td><a class="btn btn-danger" href="lookupgood?good_id=${tool.good_id}" role="button">查看详情</a></td>								
								</tr>
							</c:forEach>
							</table>
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
</html>