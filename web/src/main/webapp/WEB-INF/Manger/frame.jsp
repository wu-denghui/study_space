<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,Chrome=1">
		<!-- Google Chrome Frame也可以让IE用上Chrome的引擎: -->
		<meta name="renderer" content="webkit">
		<!--国产浏览器高速模式-->
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>好健康后台管理系统</title>
		<!-- 公共样式 开始 -->
		<link rel="shortcut icon" href="/static/backstage/images/favicon.ico"/>
		<link rel="bookmark" href="/static/backstage/images/favicon.ico"/>
		<link rel="stylesheet" type="text/css" href="/static/backstage/css/base.css">
		<link rel="stylesheet" type="text/css" href="/static/backstage/css/iconfont.css">
		<script type="text/javascript" src="/static/backstage/framework/jquery-1.11.3.min.js" ></script>
		<link rel="stylesheet" type="text/css" href="/static/backstage/layui/css/layui.css">
	    <!--[if lt IE 9]>
	      	<script src="/static/backstage/framework/html5shiv.min.js"></script>
	      	<script src="/static/backstage/framework/respond.min.js"></script>
	    <![endif]-->
		<script type="text/javascript" src="/static/backstage/layui/layui.js"></script>
		<!-- 滚动条插件 -->
		<link rel="stylesheet" type="text/css" href="/static/backstage/css/jquery.mCustomScrollbar.css">
		<script src="/static/backstage/framework/jquery-ui-1.10.4.min.js"></script>
		<script src="/static/backstage/framework/jquery.mousewheel.min.js"></script>
		<script src="/static/backstage/framework/jquery.mCustomScrollbar.min.js"></script>
		<script src="/static/backstage/framework/cframe.js"></script><!-- 仅供所有子页面使用 -->
		<!-- 公共样式 结束 -->
		<link rel="stylesheet" type="text/css" href="/static/backstage/css/frameStyle.css">
		<script type="text/javascript" src="/static/backstage/framework/frame.js" ></script>
	</head>
	<body>
		<!-- 左侧菜单 - 开始 -->
		<div class="frameMenu">
		    <div class="logo">
		        <img src="/static/images/index/logo.png"/>
		        <div class="logoText">
		            <h1>好健康</h1>
		            <p>goodhealth</p>
		        </div>
		    </div>
		    <div class="menu">
				<ul>
					<li>
						<a class="menuFA" href="javascript:void(0)"><i class="iconfont icon-liuliangyunpingtaitubiao03 left"></i>会员管理<i class="iconfont icon-dajiantouyou right"></i></a>
						<dl>
							<dt><a href="javascript:void(0)" onclick="menuCAClick('${pageContext.request.contextPath }/member/admin/showMember/0',this)">会员资料</a></dt>
						</dl>
					</li>
					<li>
						<a class="menuFA" href="javascript:void(0)"><i class="iconfont icon-shangpin left"></i>药品管理<i class="iconfont icon-dajiantouyou right"></i></a>
						<dl>
							<dt><a href="javascript:void(0)" onclick="menuCAClick('${pageContext.request.contextPath }/drug/admin/queryAll/0',this)">药品管理</a></dt>
							<dt><a href="javascript:void(0)" onclick="menuCAClick('${pageContext.request.contextPath }/drug/admin/intoAddView',this)">新品上架</a></dt>
					</dl>
					</li>
					<li>
						<a class="menuFA" href="javascript:void(0)"><i class="iconfont icon-shangpin left"></i>积分奖品管理<i class="iconfont icon-dajiantouyou right"></i></a>
						<dl>
							<dt><a href="javascript:void(0)" onclick="menuCAClick('${pageContext.request.contextPath }/prize/admin/queryAll/0',this)">积分奖品管理</a></dt>
							<dt><a href="javascript:void(0)" onclick="menuCAClick('${pageContext.request.contextPath }/prize/admin/intoAddView',this)">添加新品</a></dt>
						</dl>
					</li>
					<li>
						<a class="menuFA" href="javascript:void(0)"><i class="iconfont icon-yunying left"></i>社区管理<i class="iconfont icon-dajiantouyou right"></i></a>
						<dl>
							<dt><a href="javascript:void(0)" onclick="menuCAClick('${pageContext.request.contextPath }/news/admin/queryAll/0',this)">帖子管理</a></dt>
							<dt><a href="javascript:void(0)" onclick="menuCAClick('${pageContext.request.contextPath }/news/admin/intoAddView',this)">发布帖子</a></dt>
						</dl>
					</li>
					<li>
						<a class="menuFA" href="javascript:void(0)"><i class="iconfont icon-caiwu left"></i></i>订单统计<i class="iconfont icon-dajiantouyou right"></i></a>
						<dl>
							<dt><a href="javascript:void(0)" onclick="menuCAClick('${pageContext.request.contextPath }/order/admin/queryAll/0',this)">订单记录</a></dt>
						</dl>
					</li>
				</ul>
		    </div>
		</div>
		<!-- 左侧菜单 - 结束 -->
		<div class="main">
			<!-- 头部栏 - 开始 -->
			<div class="frameTop">
				<img class="jt" src="/static/backstage/images/top_jt.png"/>
				<div class="topMenu">
					<ul>
						<li><a href="javascript:void(0)" ><i class="iconfont icon-yonghu1"></i>管理员${sessionScope.member.memberName }</a></li>
						<li><a href="javascript:void(0)" onclick="menuCAClick('${pageContext.request.contextPath }/member/admin/intoModifyPasswordView',this)"><i class="iconfont icon-xiugaimima"></i>修改密码</a></li>
						<li><a href="${pageContext.request.contextPath }/login/adminLogout"><i class="iconfont icon-084tuichu"></i>注销</a></li>
					</ul>
				</div>
			</div>
			<div class="frameMain">
				<div class="title" id="frameMainTitle">
					<span><i class="iconfont icon-xianshiqi"></i>后台首页</span>
				</div>
				<div class="con">
					<iframe id="mainIframe" src="" scrolling="no"></iframe>
				</div>
			</div>
		</div>
	</body>
</html>