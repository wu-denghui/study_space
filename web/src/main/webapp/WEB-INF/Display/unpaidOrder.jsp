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
    <title>我的订单</title>
    <jsp:include page="/goodhealth/head.jsp"></jsp:include>
</head>
<body>
<c:choose>
    <c:when test="${ empty orderList }">
        <h2>您暂无未付款的订单</h2>
    </c:when>
    <c:otherwise>
        <div class="row" align="center">
            <div class="box clearfix">
                <p>未付款订单</p>
                <table class="table table-hover" id="bootstrap-table" border="1">
                    <thead>
                    <tr>
                        <th>详细信息</th>
                        <th>订单金额</th>
                        <th>订单奖励积分</th>
                        <th>订单生成时间</th>
                        <th>结算订单</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach  var="order"  items="${orderList}" >
                        <tr>
                            <td><c:out value="${order.orderDetail }"></c:out></td>
                            <td><c:out value="${order.orderCount}"></c:out></td>
                            <td><c:out value="${order.orderAward }"></c:out></td>
                            <td><c:out value="${order.orderDate }"></c:out></td>
                            <c:url  var="link" value="http://localhost:8080/order/payOrder/${order.orderId }" ></c:url>
                            <td><a  href="${link}" >结算支付</a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </c:otherwise>
</c:choose>
<%--<script>
    $(document).ready( function () {
        $('#bootstrap-table').bdt({
            showSearchForm: 0,
            showEntriesPerPageField: 0
        });
    });
</script>--%>
<jsp:include page="/goodhealth/footer.jsp"></jsp:include>
</body>
</html>