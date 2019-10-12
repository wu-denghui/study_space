<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"   prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include  page="/goodhealth/head.jsp"></jsp:include>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="/static/layui/dist/css/layui.css"  media="all">
<title>健康社区</title>
</head>
<body>
<span class="layui-breadcrumb">
    <a href="http://localhost:8080/goodhealth/index.jsp">主页</a>
	<a><cite>健康社区</cite></a>
</span>
<div class="row">
	<div class="box clearfix">
		<table class="table table-hover" id="bootstrap-table" border="1">
			<tbody>
			<div style="padding: 20px; background-color: #F2F2F2;">
				<div class="layui-row layui-col-space15">
			<c:forEach  var="news"  items="${newsList}" >
				<div class="layui-col-md12">
					<div class="layui-card">
						<div class="layui-card-header"><a href="${news.newUrl }">${news.newTitle}</a></div>
						<div class="layui-card-body">
							<a href="${news.newUrl }">${news.newDetail }</a>
							<p align="right">${news.newAuthor }&nbsp;&nbsp;&nbsp;&nbsp;${news.newDate }</p>
						</div>
					</div>
				</div>
			</c:forEach>
				</div>
			</div>
			</tbody>
		</table>
	</div>
</div>
</body>
</html>