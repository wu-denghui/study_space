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
<form action="${pageContext.request.contextPath }/order/admin/search" method="post">
    <div class="input-group">
        <span class="input-group-addon"><i>搜索</i></span>
        <input type="text" name="searchMess" value="${searchMess}" class="form-control search-query" placeholder="输入购买人搜索" />
        <span class="input-group-btn">
        <input class="btn btn-purple btn-sm" type="submit" name="g" value="Search"></span>
    </div>
</form>
<c:choose>
    <c:when test="${ empty orderList }">
        <h2>暂无订单记录</h2>
    </c:when>
    <c:otherwise>
        <div class="row" align="center">
            <div class="box clearfix">
                <p>订单记录</p>
                <table class="table table-hover" id="bootstrap-table" border="1">
                    <thead>
                    <tr>
                        <th>订单号</th>
                        <th>详细信息</th>
                        <th>订单金额</th>
                        <th>购买人</th>
                        <th>订单生成时间</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach  var="order"  items="${orderList}" >
                        <tr>
                            <td><c:out value="${order.orderId }"></c:out></td>
                            <td><c:out value="${order.orderDetail }"></c:out></td>
                            <td><c:out value="${order.orderCount}"></c:out></td>
                            <td><c:out value="${order.orderContacts }"></c:out></td>
                            <td><c:out value="${order.orderDate }"></c:out></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </c:otherwise>
</c:choose>
<!-- 分页功能 start -->
<c:if test="${not empty max}">
<div align="center">
    <c:if test="${not empty  orderList }">
    <font size="2">共 ${max} 页</font> <font size="2">第
        ${index} 页</font> <a href="http://localhost:8080/order/admin/queryAll/0">首页</a>
    <c:choose>
    <c:when test="${index- 1 > 0}">
    <a href="http://localhost:8080/order/admin/queryAll/${index-2}">上一页</a>
    </c:when>
    <c:when test="${index - 1 <= 0}">
    <a href="http://localhost:8080/order/admin/queryAll/${0 }">上一页</a>
    </c:when>
    </c:choose>
    <c:choose>
    <c:when test="${max==0}">
    <a href="http://localhost:8080/order/admin/queryAll/${0}">下一页</a>
    </c:when>
    <c:when test="${index+ 1 <=max}">
    <a href="http://localhost:8080/order/admin/queryAll/${index}">下一页</a>
    </c:when>
    <c:when test="${index + 1 > max}">
    <a href="http://localhost:8080/order/admin/queryAll/${max-1}">下一页</a>
    </c:when>
    </c:choose>
    <c:choose>
    <c:when test="${max==0}">
    <a href="http://localhost:8080/order/admin/queryAll/${max-1}">尾页</a>
    </c:when>
    <c:otherwise>
    <a href="http://localhost:8080/order/admin/queryAll/${max-1}">尾页</a>
    </c:otherwise>
    </c:choose>
    </c:if>
    <!-- 分页功能 End -->
</div>
</c:if>
</body>
</html>