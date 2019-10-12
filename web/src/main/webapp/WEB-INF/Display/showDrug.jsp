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
    <title>精选药品</title>
    <jsp:include page="/goodhealth/head.jsp"></jsp:include>
</head>
<body>
<span class="layui-breadcrumb">
    <a href="http://localhost:8080/goodhealth/index.jsp">主页</a>
	<a><cite>精选药品</cite></a>
</span>
<div class="row">
    <div class="box clearfix">
        <h3>精选药品</h3>
        <p>购买前请先登录</p>
        <table class="table table-hover" id="bootstrap-table" border="1">
            <thead>
            <tr>
                <th>包装</th>
                <th>药品名称</th>
                <th>零售价</th>
                <th>购买赠送积分</th>
                <th>功能</th>
                <th>用量</th>
                <th>说明书</th>
                <th>加入购物车</th>
            </tr>
            </thead>
            <tbody>
            <c:choose >
            <c:when test="${not empty drugList}">
                <c:forEach  var="drug"  items="${drugList}" >
                    <tr><td><img onmouseover="enlarge(this)" onmouseout="reduction(this)" alt="药品图片" src="http://localhost:8080/static/images/drug/${drug.drugPic }" width="44" height="55">
                        <td><c:out value="${drug.drugName }"></c:out></td>
                        <td><c:out value="${drug.drugPrice}"></c:out></td>
                        <td><c:out value="${drug.drugIntegral }"></c:out></td>
                        <td><c:out value="${drug.drugFunction }"></c:out></td>
                        <td><c:out value="${drug.drugUsage }"></c:out></td>
                        <c:url  var="linkC" value="http://localhost:8080/drug/intoShoppingCar">
                            <c:param name="id" value="${drug.drugId }"></c:param>
                        </c:url>
                        <c:url  var="linkS" value="http://localhost:8080/drug/user/showDetail">
                            <c:param name="id" value="${drug.drugId }"></c:param>
                        </c:url>
                        <td><a href="${linkS }">详细说明书</a></td>
                        <td><a href="${linkC }">加入购物车</a></td>
                    </tr>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <td><c:out value="暂无数据"></c:out></td>
                <td><c:out value="暂无数据"></c:out></td>
                <td><c:out value="暂无数据"></c:out></td>
                <td><c:out value="暂无数据"></c:out></td>
                <td><c:out value="暂无数据"></c:out></td>
                <td><c:out value="暂无数据"></c:out></td>
                <td><c:out value="暂无数据"></c:out></td>
                <td><c:out value="暂无数据"></c:out></td>
            </c:otherwise>
            </c:choose>
            </tbody>
        </table>
    </div>
</div>
<jsp:include page="/goodhealth/footer.jsp"/>
<script src="http://code.jquery.com/jquery-2.1.1.min.js" type="text/javascript"></script>
<script src="/static/js/vendor/bootstrap.min.js" type="text/javascript"></script>
<script src="/static/js/vendor/jquery.sortelements.js" type="text/javascript"></script>
<script src="/static/js/jquery.bdt.min.js" type="text/javascript"></script>
<script type="text/javascript">
    var boo=undefined;
    var pheight,pwidth;
    var enlarge=function(o){
        boo=true;
        picchange(o);
    }
    var reduction=function(o){
        boo=false;
        picchange(o);
    }
    var picchange=function(obj){

        if (boo) {
            pwidth=obj.width;
            pheight=obj.height;
            obj.width=2*pwidth;
            obj.height=2*pheight;
        }else{
            pwidth=obj.width;
            pheight=obj.height;
            obj.height = pheight/2;
            obj.width = pwidth/2;
        }
    }
</script>
<script>
    $(document).ready( function () {
        $('#bootstrap-table').bdt({
            showSearchForm: 0,
            showEntriesPerPageField: 0
        });
    });
</script>
</body>
</html>