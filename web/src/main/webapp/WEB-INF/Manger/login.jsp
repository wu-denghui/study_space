<%@page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"   prefix="c"%>
<html>
<!-- 公共样式 开始 -->
<link rel="shortcut icon" href="/static/backstage/images/favicon.ico"/>
<link rel="bookmark" href="/static/backstage/images/favicon.ico"/>
<link rel="stylesheet" type="text/css" href="/static/backstage/css/base.css">
<link rel="stylesheet" type="text/css" href="/static/backstage/css/iconfont.css">
<script type="text/javascript" src="/static/backstage/framework/jquery-1.11.3.min.js"></script>
<link rel="stylesheet" type="text/css" href="/static/backstage/layui/css/layui.css">
<script type="text/javascript" src="/static/backstage/layui/layui.js"></script>
<!-- 公共样式 结束 -->
<link rel="stylesheet" type="text/css" href="/static/backstage/css/login1.css">
<script type="text/javascript" src="/static/backstage/js/login1.js"></script>
</head>
<body   onload="document.getElementById('ln').focus()">
<div class="loginBg"></div>
<div class="login_main">
    <div class="box">
        <div class="left">
            <img src="/static/images/index/logo.png" />
            <p>好健康后台管理系统</p>
        </div>
        <div class="right">
            <div align="center">
                <c:if test="${ not empty error}" >
                    <font color="red">${error }</font>
                </c:if>
            </div>
            <br>
            <form class="layui-form layui-form-pane" action= "${pageContext.request.contextPath }/login/adminLogin" Method= "post">
                <div class="layui-form-item">
                    <label class="layui-form-label login_title"><i class="iconfont icon-gerenzhongxin-denglu"></i></label>
                    <div class="layui-input-block login_input">
                        <input id="ln" type="text" name="name" required lay-verify="required" autocomplete="off" placeholder="请输入您的用户名" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label login_title"><i class="iconfont icon-mima1"></i></label>
                    <div class="layui-input-block login_input">
                        <input type="password" name="password" required lay-verify="required" autocomplete="off" placeholder="请输入密码" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <button class="layui-btn layui-btn-fluid login_but" lay-submit lay-filter="loginBut">登 录</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>