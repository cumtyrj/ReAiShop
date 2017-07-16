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
    <link href="source/css/index.css" rel="stylesheet" type="text/css" />
  
<script type="text/javascript" src="source/js/jquery.1.4.2-min.js"></script>
<script type="text/javascript" src="source/js/Calculation.js"></script>
<script type="text/javascript">
$(document).ready(function () {

	//jquery特效制作复选框全选反选取消(无插件)
	// 全选        
	$(".allselect").click(function () {
		
		if($(this).attr("checked")){
			$(".gwc_tb2 input[name=newslist]").each(function () {
				$(this).attr("checked", true);
				// $(this).next().css({ "background-color": "#3366cc", "color": "#ffffff" });
			});
			GetCount();
		
		}
		else
   		{
			$(".gwc_tb2 input[name=newslist]").each(function () {
				if ($(this).attr("checked")) {
					$(this).attr("checked", false);
					//$(this).next().css({ "background-color": "#ffffff", "color": "#000000" });
				} else {
					$(this).attr("checked", true);
					//$(this).next().css({ "background-color": "#3366cc", "color": "#000000" });
				} 
			});
			GetCount();
    
   		}
		
	});

	//反选
	$("#invert").click(function () {
		$(".gwc_tb2 input[name=newslist]").each(function () {
			if ($(this).attr("checked")) {
				$(this).attr("checked", false);
				//$(this).next().css({ "background-color": "#ffffff", "color": "#000000" });
			} else {
				$(this).attr("checked", true);
				//$(this).next().css({ "background-color": "#3366cc", "color": "#000000" });
			} 
		});
		GetCount();
	});

	//取消
	$("#cancel").click(function () {
		$(".gwc_tb2 input[name=newslist]").each(function () {
			$(this).attr("checked", false);
			// $(this).next().css({ "background-color": "#ffffff", "color": "#000000" });
		});
		GetCount();
	});

	// 所有复选(:checkbox)框点击事件
	$(".gwc_tb2 input[name=newslist]").click(function () {
		if ($(this).attr("checked")) {
			//$(this).next().css({ "background-color": "#3366cc", "color": "#ffffff" });
		} else {
			// $(this).next().css({ "background-color": "#ffffff", "color": "#000000" });
		}
	});

	// 输出
	$(".gwc_tb2 input[name=newslist]").click(function () {
		// $("#total2").html() = GetCount($(this));
		GetCount();
		//alert(conts);
	});
});
//******************
function GetCount() {
	var conts = 0;
	var aa = 0;
	$(".gwc_tb2 input[name=newslist]").each(function () {
		if ($(this).attr("checked")) {
			for (var i = 0; i < $(this).length; i++) {
				conts += parseInt($(this).val());
				aa += 1;
			}
		}
	});
	$("#shuliang").text(aa);
	$("#zong1").html((conts).toFixed(2));
	$("#jz1").css("display", "none");
	$("#jz2").css("display", "block");
}
</script>

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
<div class="gwc" style=" margin:auto;">
	<table cellpadding="0" cellspacing="0" class="gwc_tb1">
		<tr>
			<td class="tb1_td1"><input id="Checkbox1" type="checkbox"  class="allselect"/></td>
			<td class="tb1_td1">全选</td>
			<td class="tb1_td3">商品</td>
			<td class="tb1_td4">商品信息</td>
			<td class="tb1_td5">数量</td>
			<td class="tb1_td6">单价</td>
			<td class="tb1_td7">操作</td>
		</tr>
	</table>
		   
	
	<!---商品加减算总数---->
	<script type="text/javascript">
	$(function () {
		var t = $("#text_box2");
		$("#add2").click(function () {
			t.val(parseInt(t.val()) + 1)
			setTotal(); GetCount();
		})
		$("#min2").click(function () {
			if(t.val()>0){
				t.val(parseInt(t.val()) - 1)
				setTotal(); GetCount();
			}
		})
		function setTotal() {

			$("#total2").html((parseInt(t.val()) * ${good.price}).toFixed(2));
			$("#newslist-2").val(parseInt(t.val()) * ${good.price}za1	);
		}
		setTotal();
	})
	</script>
	<table cellpadding="0" cellspacing="0" class="gwc_tb2">
		<c:forEach items="${requestScope.cart_list }" var="good">
	
		<tr>		
			<td class="tb2_td1"><input type="checkbox" value="1" name="newslist" id="newslist-2" /></td>
			<td class="tb2_td2"><img src="source/img/${good.image}"/></td>
			<td class="tb2_td3">${good.name}</td>
			<td class="tb1_td4">${good.detail}</td>			
			<td class="tb1_td5">
				<input id="min2" name=""  style=" width:20px; height:18px;border:1px solid #ccc;" type="button" value="-" />
				<input id="text_box2" name="" type="text" value="1" style=" width:30px; text-align:center; border:1px solid #ccc;" />
				<input id="add2" name="" style=" width:20px; height:18px;border:1px solid #ccc;" type="button" value="+" />
			</td>
						<td class="tb1_td4">${good.price}</td>
			
			<td class="tb1_td7"><a href="#">删除</a></td>
		</tr>
		</c:forEach>
	</table>
	
	<!---总数---->
	<script type="text/javascript">
	$(function () {
		$(".quanxun").click(function () {
			setTotal();
			//alert($(lens[0]).text());
		});
		function setTotal() {
			var len = $(".tot");
			var num = 0;
			for (var i = 0; i < len.length; i++) {
				num = parseInt(num) + parseInt($(len[i]).text());

			}
			//alert(len.length);
			$("#zong1").text(parseInt(num).toFixed(2));
			$("#shuliang").text(len.length);
		}
		//setTotal();
	})
	</script>
	<table cellpadding="0" cellspacing="0" class="gwc_tb3">
		<tr>
			<td class="tb1_td1">&nbsp;</td>
			<td class="tb1_td1">&nbsp;</td>
			<td class="tb3_td1">&nbsp;</td>
			<td class="tb3_td2">已选商品 <label id="shuliang" style="color:#ff5500;font-size:14px; font-weight:bold;">0</label> 件</td>
			<td class="tb3_td3">合计(不含运费):<span>￥</span><span style=" color:#ff5500;"><label id="zong1" style="color:#ff5500;font-size:14px; font-weight:bold;"></label></span></td>
			<td class="tb3_td4"><span id="jz1">结算</span><a href="#" style=" display:none;"  class="jz2" id="jz2">结算</a></td>
		</tr>
	</table>

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
