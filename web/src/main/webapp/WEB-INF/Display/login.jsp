<%@page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"   prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="/static/layui/dist/css/layui.css" media="all">
<link rel="stylesheet" href="/static/css/all.css" type="text/css" charset="utf-8"/>
<jsp:include  page="/goodhealth/head.jsp"></jsp:include>
<script type="text/javascript"  src="/static/js/jquery.js"></script>
<title>登录页面</title>
</head>
<body>
<div align="center">
<c:if test="${ not empty error}" >
<p size="4"  color="red">${error }</p>
</c:if>
</div>
<br><br>
<span class="layui-breadcrumb">
            <a href="http://localhost:8080/goodhealth/index.jsp">主页</a><a><cite>登录</cite></a>
</span>
<div id="frameLoginForm">
	<form class="layui-form" action="${pageContext.request.contextPath }/login/login" method="post">
		<div class="layui-form-item">
			<label class="layui-form-label">用户名</label>
			<div class="layui-input-block">
				<input id="ln" type="text" value="${name}" name="name" lay-verify="name" autocomplete="off" placeholder="请输入用户名" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">密码</label>
			<div class="layui-input-block">
				<input  type="password" name="password"  value="${password}" lay-verify="password" placeholder="请输入密码" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit="" lay-filter="demo1">登录</button>
				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
			</div>
		</div>
	</form>
</div>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br>
<jsp:include page="/goodhealth/footer.jsp"/>
<script src="/static/js/jquery.js" type="text/javascript" charset="utf-8" ></script>
<script src="/static/layui/dist/layui.js" charset="utf-8"></script>
<script type="text/javascript">
    $(document).ready(function(){
        $("#ln").focus();
    });
</script>
</body>
</html>