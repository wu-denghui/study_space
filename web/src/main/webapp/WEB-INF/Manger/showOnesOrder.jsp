<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"   prefix="c"%>
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
    <link href="/static/css/style.css" type="text/css" rel="stylesheet">
    <title></title>
</head>
<body>
<div align="left">
    <p onclick="javascript:history.back()"><font size="3"  color="gray">返回</font></p>
</div>
<c:choose>
    <c:when test="${ empty orderList }">
        <h2>该用户暂无订单</h2>
    </c:when>
    <c:otherwise>
        <div class="row" align="center">
            <div class="box clearfix">
                <p>消费记录</p>
                <table class="table table-hover" id="bootstrap-table" border="1">
                    <thead>
                    <tr>
                        <th>订单号</th>
                        <th>详细信息</th>
                        <th>订单金额</th>
                        <th>订单奖励积分</th>
                        <th>订单生成时间</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach  var="order"  items="${orderList}" >
                        <tr>
                            <td><c:out value="${order.orderId }"></c:out></td>
                            <td><c:out value="${order.orderDetail }"></c:out></td>
                            <td><c:out value="${order.orderCount}"></c:out></td>
                            <td><c:out value="${order.orderAward }"></c:out></td>
                            <td><c:out value="${order.orderDate }"></c:out></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </c:otherwise>
</c:choose>
</body>
</html>