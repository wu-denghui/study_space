<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<link rel="stylesheet" href="/static/css/all.css" type="text/css" charset="utf-8"/>
	<link href="/static/css/vendor/bootstrap.min.css" type="text/css" rel="stylesheet">
	<link href="/static/css/vendor/font-awesome.min.css" type="text/css" rel="stylesheet">
	<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,600' rel='stylesheet' type='text/css'>
	<link href="/static/css/jquery.bdt.css" type="text/css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="/staticcss/buttons.css" />
	<link href="/static/css/style.css" type="text/css" rel="stylesheet">
<title>确认订单</title>
<jsp:include page="/goodhealth/head.jsp"></jsp:include>
</head>
<body>
<span class="layui-breadcrumb">
    <a href="http://localhost:8080/goodhealth/index.jsp">主页</a>
	<a href="http://localhost:8080/shoppingcar/showMyShoppingCar">购物车</a>
	<a onclick="bc()">订单页</a>
	<a><cite>支付</cite></a>
</span>
	<div align="center">
		<c:if test="${ allErrors!=null }">
		<c:forEach var="error" items="${allErrors }">${error.defaultMessage }</c:forEach>
	    </c:if>
	    <c:if test="${not  empty  error}">${error}</c:if>
	</div>
<c:if test="${ empty order.orderAdditional}">
<form action="${pageContext.request.contextPath }/prize/showPrize">
	<input type="hidden" name="orderId" value="${order.orderId}">
	<p> 是否要兑换积分商品</p>
	<p>兑换的商品将与订单一起打包运送,每个订单仅限兑换一件积分奖品</p>
	<input class="button small green rounded" type="submit"  name="g"  value="去兑换">
</form>
</c:if>
		<table class="table table-hover" id="bootstrap-table" border="1">
		<thead>
		<tr>
			<th>订单详情</th>
			<th>价格</th>
			<th>订单奖励积分</th>
			<th>购买时间</th>
			<c:if test="${not  empty order.orderAdditional }"><th>兑换奖品</th></c:if>
		</tr>
		</thead>
		<tbody>
			<tr>
				<td><c:out value="${order.orderDetail }"></c:out></td>
				<td><c:out value="${order.orderCount }"></c:out></td>
				<td><c:out value="${order.orderAward }"></c:out></td>
				<td><c:out value="${order.orderDate }"></c:out></td>
				<c:if test="${not  empty order.orderAdditional }"><td><c:out value="${order.orderAdditional }"></c:out></td></c:if>
			</tr>
		</tbody>
		</table>
	<div >
		<fieldset class="layui-elem-field" style="margin: 20px;">
		<legend>请认真填写注册信息，以下全为必填项</legend>
		<form class="layui-form" action="${pageContext.request.contextPath }/order/pay" method="post">
			<input type="hidden" name="orderId" value="${order.orderId}">
			<div class="layui-form-item">
				<div class="layui-inline">
				<label  class="layui-form-label">联系人</label>
				<div class="layui-inline">
					<input id="ln" type="text" value="${username}" name="username" lay-verify="username" autocomplete="off" placeholder="请输入用户名" class="layui-input">
				</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">电话</label>
					<div class="layui-inline">
						<input type="tel" name="tell" value="${tell}" lay-verify="tell" autocomplete="off" class="layui-input">
					</div>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">地址</label>
				<div class="layui-input-inline">
					<select name="province" id="province" lay-filter="province">
						<option value="">请选择省</option>
					</select>
				</div>
				<div class="layui-input-inline">
					<select name="city" id="city" lay-filter="city">
						<option value="">请选择市</option>
					</select>
				</div>
				<div class="layui-input-inline">
					<select name="area" id="area" lay-filter="area">
						<option value="">请选择县/区</option>
					</select>
				</div>
				<div class="layui-input-inline">
					<input type="text" name="address"  lay-verify="address" autocomplete="off" placeholder="详细地址" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<div class="layui-input-block">
					<button class="layui-btn" lay-submit="" lay-filter="demo1">支付</button>
					<button type="reset" class="layui-btn layui-btn-primary">重置</button>
				</div>
			</div>
		</form>
		</fieldset>
	</div>
<jsp:include page="/goodhealth/footer.jsp"/>
<script src="/static/js/jquery.js" type="text/javascript" charset="utf-8" ></script>
<script src="/static/layui/dist/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="/static/js/data.js"></script>
<script type="text/javascript" src="/static/js/province.js"></script>
<script type="text/javascript">
	var defaults = {
		s1: 'province',
		s2: 'city',
		s3: 'area',
		v1: null,
		v2: null,
		v3: null
	};
</script>
<script>
	layui.use(['form', 'layedit', 'laydate'], function(){
		var form = layui.form
			,layer = layui.layer
			,layedit = layui.layedit
			,laydate = layui.laydate;

		form.verify({
			username:[
				/^[\u0391-\uFFE5]{2,6}$/
				,'请输入正确联系人'
			]
			,tell:[
				/^1\d{10}$/
				,'请输入正确11位手机号'
			]
			,address:[
				/^[\u0391-\uFFE50-9]+$/
				,'请输入正确地址格式'
			]
		});
	});
</script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#ln").focus();
	});
</script>
<script>
	$(document).ready( function () {
		$('#bootstrap-table').bdt({
			showSearchForm: 0,
			showEntriesPerPageField: 0
		});
	});
    var bc=function(){
        if (location.href=="http://localhost:8080/goodhealth/index.jsp") {
            if (confirm('是否要离开')){
                history.back();
			}
        }else{
            history.back();
        }
    }
</script>
</body>
</html>