<%@page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"   prefix="c"%>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,Chrome=1">
		<!-- Google Chrome Frame也可以让IE用上Chrome的引擎: -->
		<meta name="renderer" content="webkit">
		<!--国产浏览器高速模式-->
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title></title>
		<!-- 公共样式 开始 -->
		<link rel="stylesheet" type="text/css" href="/static/backstage/css/base.css">
		<link rel="stylesheet" type="text/css" href="/static/backstage/css/iconfont.css">
		<script type="text/javascript" src="/static/backstage/framework/jquery-1.11.3.min.js"></script>
		<link rel="stylesheet" type="text/css" href="/static/backstage/layui/css/layui.css">
		<script type="text/javascript" src="/static/backstage/layui/layui.js"></script>
		<!-- 滚动条插件 -->
		<link rel="stylesheet" type="text/css" href="/static/backstage/css/jquery.mCustomScrollbar.css">
		<script src="/static/backstage/framework/jquery-ui-1.10.4.min.js"></script>
		<script src="/static/backstage/framework/jquery.mousewheel.min.js"></script>
		<script src="/static/backstage/framework/jquery.mCustomScrollbar.min.js"></script>
		<script src="/static/backstage/framework/cframe.js"></script><!-- 仅供所有子页面使用 -->
		<!-- 公共样式 结束 -->
	</head>
	<body>
		<div class="cBody">
			<c:if test="${ not empty error }">
					<font color="red">${error}</font>
			</c:if>
			<form id="addForm" class="layui-form" action="${pageContext.request.contextPath }/member/admin/adminModifyPassword">
				<div class="layui-form-item">
					<label class="layui-form-label">原始密码</label>
					<div class="layui-input-inline shortInput">
						<input type="password" name="oldpassword"  lay-verify="oldpassword"  placeholder="请输入原密码"  autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">新密码</label>
					<div class="layui-input-inline shortInput">
						<input type="password" name="password"  lay-verify="password"  autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">确认新密码</label>
					<div class="layui-input-inline shortInput">
						<input type="password" name="password2"  lay-verify="password2" autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<div class="layui-input-block">
						<button class="layui-btn" lay-submit lay-filter="submitBut">确认修改</button>
						<button type="reset" class="layui-btn layui-btn-primary">重置</button>
					</div>
				</div>
			</form>
			<script>
                layui.use(['form', 'layedit', 'laydate'], function(){
                    var form = layui.form
                        ,layer = layui.layer;
                    form.verify({
                        oldpassword:function(value){
                            if(value.length <= 0){
                                return '原密码不允许为空';
                            }
                        }
                        ,password:[
                            /^[a-zA-Z]\w{5,15}$/
                            ,'密码以字母开头，长度在5~15之间，只能包含字母、数字'
                        ]
                        ,password2:function(value){
                            var pass2 = document.getElementsByName("password")[0];
                            if(pass2==null || pass2.value =="" || value!=pass2.value){
                                return '前后密码不一致'
                            }
                        }
                    });
                });
			</script>
		</div>
	</body>
</html>