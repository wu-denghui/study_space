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
    <title>药品管理</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/drug/admin/search" method="post">
    <div class="input-group">
        <span class="input-group-addon"><i>模糊搜索</i></span>
        <input type="text" name="searchMess" class="form-control search-query" placeholder="输入药品名信息搜索" />
        <span class="input-group-btn">
                <input class="btn btn-purple btn-sm" type="submit" name="g" value="Search"></span>
    </div>
</form>
        <table class="table table-hover" id="bootstrap-table" border="1">
            <thead>
            <tr>
                <th>包装</th>
                <th>药品名称</th>
                <th>零售价</th>
                <th>购买赠送积分</th>
                <th>详细说明书</th>
                <th>更新信息</th>
                <th>下架</th>
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
                            <c:url  var="linkD" value="http://localhost:8080/drug/admin/delete">
                                <c:param name="id" value="${drug.drugId }"></c:param>
                            </c:url>
                            <c:url  var="linkU" value="http://localhost:8080/drug/admin/edit">
                                <c:param name="id" value="${drug.drugId }"></c:param>
                            </c:url>
                            <c:url  var="linkS" value="http://localhost:8080/drug/admin/details">
                                <c:param name="id" value="${drug.drugId }"></c:param>
                            </c:url>
                            <td><a href="${linkS }">说明书</a></td>
                            <td><a href="${linkU }">编辑</a></td>
                            <td><a href="${linkD }">下架</a></td>
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
        <!-- 分页功能 start -->
<c:if test="${not empty max}">
        <div align="center">
            <c:if test="${not empty  drugList }">
                <font size="2">共 ${max} 页</font> <font size="2">第
                    ${index} 页</font> <a href="http://localhost:8080/drug/admin/queryAll/0">首页</a>
                <c:choose>
                    <c:when test="${index- 1 > 0}">
                        <a href="http://localhost:8080/drug/admin/queryAll/${index-2}">上一页</a>
                    </c:when>
                    <c:when test="${index - 1 <= 0}">
                        <a href="http://localhost:8080/drug/admin/queryAll/${0 }">上一页</a>
                    </c:when>
                </c:choose>
                <c:choose>
                    <c:when test="${max==0}">
                        <a href="http://localhost:8080/drug/admin/queryAll/${0}">下一页</a>
                    </c:when>
                    <c:when test="${index+ 1 <=max}">
                        <a href="http://localhost:8080/drug/admin/queryAll/${index}">下一页</a>
                    </c:when>
                    <c:when test="${index + 1 > max}">
                        <a href="http://localhost:8080/drug/admin/queryAll/${max-1}">下一页</a>
                    </c:when>
                </c:choose>
                <c:choose>
                    <c:when test="${max==0}">
                        <a href="http://localhost:8080/drug/admin/queryAll/${max-1}">尾页</a>
                    </c:when>
                    <c:otherwise>
                        <a href="http://localhost:8080/drug/admin/queryAll/${max-1}">尾页</a>
                    </c:otherwise>
                </c:choose>
            </c:if>
            <!-- 分页功能 End -->
        </div>
</c:if>
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