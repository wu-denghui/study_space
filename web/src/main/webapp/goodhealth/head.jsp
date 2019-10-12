<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"   prefix="c"%>
<html>
<head>
    <link rel="stylesheet" href="/static/assets/css/ace.min.css" class="ace-main-stylesheet" id="main-ace-style" />
    <link rel="stylesheet" href="/static/layui/dist/css/layui.css" media="all"/>
    <link rel="stylesheet" href="/static/css/all.css" type="text/css" charset="utf-8"/>
    <script type="text/javascript"  src="/static/js/jquery.js"></script>
    <script src="/static/layui/dist/layui.js" charset="utf-8"></script>
    <script src="/static/assets/js/ace-extra.min.js"></script>
</head>
<body>
<div id="frameContentLogo"><img src="/static/images/index/logo.png"></div>
<div id="frameContentSearch">
        <form action="${pageContext.request.contextPath }/drug/user/searchDrug" method="post">
            <div class="input-group">
                <span class="input-group-addon"><i>搜索</i></span>
                <input type="text" name="searchMess" class="form-control search-query" placeholder="输入药品名信息搜索" />
                <span class="input-group-btn">
                <input class="btn btn-purple btn-sm" type="submit" name="g" value="Search"></span>
            </div>
        </form>
    </div>

<div id="frameContentLogReg">
    <c:choose>
        <c:when test="${ not empty sessionScope.member}">
            <font size="2">用户${sessionScope.member.memberName } 已登录</font>
            <A href= "http://localhost:8080/login/logout">退出</A>
        </c:when>
        <c:otherwise>
            <A href= "http://localhost:8080/goodhealth/login">登录</A>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <A href= "http://localhost:8080/goodhealth/register">注册</A>
        </c:otherwise>
    </c:choose>
</div>
<br> <br> <br> <br> <br>
<ul class="layui-nav">
    <li class="layui-nav-item"><a href="http://localhost:8080/goodhealth/index.jsp">主 页</a></li>
    <li class="layui-nav-item">
        <a href="javascript:;">最 新 活 动</a>
        <dl class="layui-nav-child">
            <dd><a href="http://localhost:8080/drug/user/half">每周半价</a></dd>
            <dd><a href="http://localhost:8080/news/user/activities">线下活动</a></dd>
        </dl>
    </li>
    <li class="layui-nav-item">
        <a href="javascript:;">精 选 药 品</a>
        <dl class="layui-nav-child">
            <dd><a href="http://localhost:8080/drug/user/findAll">全部药品</a></dd>
            <dd><a href="http://localhost:8080/drug/user/findByCondition?producer=云南白药">云南白药</a></dd>
            <dd><a href="http://localhost:8080/drug/user/findByCondition?producer=贵州百灵">贵州百灵</a></dd>
            <dd><a href="http://localhost:8080/drug/user/findByCondition?producer=修正药业">修正药业</a></dd>
        </dl>
    </li>
    <li class="layui-nav-item"><a href="http://localhost:8080/prize/user/findAll">积 分 兑 换</a></li>
    <li class="layui-nav-item"><a href="http://localhost:8080/shoppingcar/showMyShoppingCar">购 物 车</a></li>
    <li class="layui-nav-item"><a href="http://localhost:8080/news/user/findAll">健 康 社 区</a></li>
    <li class="layui-nav-item"><a href="http://localhost:8080/goodhealth/register">加 入 我 们</a></li>
    <li class="layui-nav-item">
        <a href="javascript:;">个 人 中 心</a>
        <dl class="layui-nav-child">
            <dd><a href="http://localhost:8080/order/unpaid">未完成订单</a></dd>
            <dd><a href="http://localhost:8080/order/showOrder">购买记录</a></dd>
            <dd><a href="">收货地址管理</a></dd>
        </dl>
    </li>
    <li class="layui-nav-item">
        <a href="javascript:;">联 系 我 们</a>
        <dl class="layui-nav-child">
            <dd><a href="javascript:alert('对于本药房的一切资讯及建议请联系好健康唯一邮箱:17303652309@163.com！感谢您的光临！');">官方邮箱</a></dd>
        </dl>
    </li>
</ul>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
    layui.use('element', function(){
        var element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块
    });
</script>
</body>
</html>
