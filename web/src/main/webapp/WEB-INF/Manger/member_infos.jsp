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
<form action="${pageContext.request.contextPath }/member/admin/search" method="post">
    <div class="input-group">
        <span class="input-group-addon"><i>模糊搜索</i></span>
        <input type="text" name="searchMess" class="form-control search-query" placeholder="输入昵称搜索" />
        <span class="input-group-btn">
        <input class="btn btn-purple btn-sm" type="submit" name="g" value="Search"></span>
    </div>
</form>
<div class="row">
    <div class="box clearfix">
        <h3>会员信息</h3>
        <table class="table table-hover" id="bootstrap-table" border="1">
            <thead>
            <tr>
                <th>用户昵称</th>
                <th>性别</th>
                <th>生日</th>
                <th>积分余额</th>
                <th>家庭地址</th>
                <th>联系电话</th>
                <th>邮箱</th>
                <th>消费记录</th>
            </tr>
            </thead>
            <tbody>
            <c:choose >
                <c:when test="${not empty memberList}">
                    <c:forEach  var="member"  items="${memberList}" >
                        <tr>
                            <td><c:out value="${member.memberName }"></c:out></td>
                            <td>
                                <c:choose>
                                    <c:when test="${member.memberGender == 1 }">
                                        男
                                    </c:when>
                                    <c:when test="${member.memberGender == 0 }">
                                        女
                                    </c:when>
                                    <c:otherwise>
                                        保密
                                    </c:otherwise>
                                </c:choose>
                            </td>
                            <td><c:out value="${member.memberBirthday }"></c:out></td>
                            <td><c:out value="${member.memberIntegral }"></c:out></td>
                            <td>
                                <c:out value="${member.address}"></c:out>
                            </td>
                            <td><c:out value="${member.memberTell }"></c:out></td>
                            <td><c:out value="${member.memberEmail }"></c:out></td>
                            <c:url  var="link" value="http://localhost:8080/order/admin/showOnesOrder">
                                <c:param name="memberId" value="${member.memberId }"></c:param>
                            </c:url>
                            <td><a href="${link}">消费记录</a></td>
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
            <c:if test="${not empty  memberList }">
                <font size="2">共 ${max} 页</font> <font size="2">第
                    ${index} 页</font> <a href="http://localhost:8080/member/admin/showMember/0">首页</a>
                <c:choose>
                    <c:when test="${index- 1 > 0}">
                        <a href="http://localhost:8080/member/admin/showMember/${index-2}">上一页</a>
                    </c:when>
                    <c:when test="${index - 1 <= 0}">
                        <a href="http://localhost:8080/member/admin/showMember/${0 }">上一页</a>
                    </c:when>
                </c:choose>
                <c:choose>
                    <c:when test="${max==0}">
                        <a href="http://localhost:8080/member/admin/showMember/${0}">下一页</a>
                    </c:when>
                    <c:when test="${index+ 1 <=max}">
                        <a href="http://localhost:8080/member/admin/showMember/${index}">下一页</a>
                    </c:when>
                    <c:when test="${index + 1 > max}">
                        <a href="http://localhost:8080/member/admin/showMember/${max-1}">下一页</a>
                    </c:when>
                </c:choose>
                <c:choose>
                    <c:when test="${max==0}">
                        <a href="http://localhost:8080/member/admin/showMember/${max-1}">尾页</a>
                    </c:when>
                    <c:otherwise>
                        <a href="http://localhost:8080/member/admin/showMember/${max-1}">尾页</a>
                    </c:otherwise>
                </c:choose>
            </c:if>
            <!-- 分页功能 End -->
        </div>
        </c:if>
    </div>
</div>
<script src="http://code.jquery.com/jquery-2.1.1.min.js" type="text/javascript"></script>
<script src="/static/js/vendor/bootstrap.min.js" type="text/javascript"></script>
<script src="/static/js/vendor/jquery.sortelements.js" type="text/javascript"></script>
<script src="/static/js/jquery.bdt.min.js" type="text/javascript"></script>
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