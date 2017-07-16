<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="zh-CN">
<title>订单评分</title>
<style>
	.stars{ overflow: hidden; clear: both; margin: 10px; padding: 10px; border: 1px saddlebrown solid;}
	.stars span{ float: left; height: 30px; line-height: 30px; cursor:default;}
	.stars i{width: 30px; height: 30px; line-height: 30px; float: left; margin-right: 30px; background: #ccc; color: #fff; text-align: center; cursor:default; font-style: normal;}
	.stars .on{ color: #a71417;}
</style>
<script src="source/js/jquerycommit.min.js"></script>
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
<script>
    $(function(){
        /*
        * 鼠标点击，该元素包括该元素之前的元素获得样式,并给隐藏域input赋值
        * 鼠标移入，样式随鼠标移动
        * 鼠标移出，样式移除但被鼠标点击的该元素和之前的元素样式不变
        * 每次触发事件，移除所有样式，并重新获得样式
        * */
        var stars = $('.stars');
        var Len = stars.length;
        //遍历每个评分的容器
        for(i=0;i<Len;i++){
            //每次触发事件，清除该项父容器下所有子元素的样式所有样式
            function clearAll(obj){
                obj.parent().children('i').removeClass('on');
            }
            stars.eq(i).find('i').click(function(){
                var num = $(this).index();
                clearAll($(this));
                //当前包括前面的元素都加上样式
                $(this).addClass('on').prevAll('i').addClass('on');
                //给隐藏域input赋值
                $(this).siblings('input').val(num);
            });
            stars.eq(i).find('i').mouseover(function(){
                var num = $(this).index();
                clearAll($(this));
                //当前包括前面的元素都加上样式
                $(this).addClass('on').prevAll('i').addClass('on');
            });
            stars.eq(i).find('i').mouseout(function(){
                clearAll($(this));
                //触发点击事件后input有值
                var score = $(this).siblings('input').val();
                for(i=0;i<score;i++){
                    $(this).parent().find('i').eq(i).addClass('on');
                }
            });
        }
    })
</script>

</body>
</html>