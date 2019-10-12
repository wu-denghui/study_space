<%@page contentType="text/html;charset=utf-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<HTML>
<HEAD>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="/static/layui/dist/css/layui.css" media="all">
    <link rel="stylesheet" href="/static/css/all.css" type="text/css" charset="utf-8"/>
    <jsp:include  page="/goodhealth/head.jsp"></jsp:include>
    <title>注册为会员，加入我们</title>
</HEAD>
<body>
<span class="layui-breadcrumb">
    <a href="http://localhost:8080/goodhealth/index.jsp">主页</a>
	<a><cite>加入我们</cite></a>
</span>
	<div  align="center">
	   <c:if test="${not  empty  duplicateName  }">
	  <font  color="red">${duplicateName }</font>
	  </c:if>
	 <c:if test="${ allErrors!=null }">
		<c:forEach var="error" items="${allErrors }">
	  <font  color="red">${error.defaultMessage }</font>
	</c:forEach>
	</c:if>
	</div>
	<br><br>
    <div id="frameFormRegister">
        <fieldset class="layui-elem-field" style="margin: 20px;">
            <legend>请认真填写注册信息，以下全为必填项</legend>
            <form class="layui-form" action="${pageContext.request.contextPath }/login/register" method="post">
                <div class="layui-form-item">
                    <label class="layui-form-label">用户名</label>
                    <div class="layui-input-block">
                        <input id="ln" type="text" name="memberName" value="${member.memberName }" lay-verify="username" autocomplete="off" placeholder="请输入用户名" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">密码</label>
                    <div class="layui-input-block">
                        <input type="password" name="memberPassword" lay-verify="password" placeholder="请输入密码" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">确认密码</label>
                    <div class="layui-input-block">
                        <input type="password" name="password2"  lay-verify="password2"  placeholder="请再输一次密码" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">手机号</label>
                        <div class="layui-input-inline">
                            <input type="tel" name="memberTell" value="${member.memberTell }" lay-verify="memberTell" placeholder="请输入您的手机号" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">邮箱</label>
                            <div class="layui-input-inline">
                                <input type="text" name="memberEmail" value="${member.memberEmail }" lay-verify="memberEmail" autocomplete="off" placeholder="请输入您的邮箱" class="layui-input">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">出生年月</label>
                    <div class="layui-inline">
                        <input type="text" name="memberBirthday" value="${member.memberBirthday}"  id="date" lay-verify="date" placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">选择地区</label>
                    <div class="layui-input-inline">
                        <select name="province" id="province" lay-filter="province">
                            <option value="">请选择省</option>
                        </select>
                    </div>
                    <div class="layui-input-inline">
                        <select name="city" id="city" lay-filter="city">
                            <option value="">请选择市</option>
                        </select>
                    </div>
                    <div class="layui-input-inline">
                        <select name="area" id="area" lay-filter="area">
                            <option value="">请选择县/区</option>
                        </select>
                    </div>
                    <div class="layui-input-inline">
                        <input type="text" name="address"  lay-verify="address" autocomplete="off" placeholder="详细地址" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">单选框</label>
                    <div class="layui-input-block">
                        <input type="radio" name="memberGender" value="0" title="女">
                        <input type="radio" name="memberGender" value="1" title="男" checked="">
                        <input type="radio" name="memberGender" value="2" title="保密">
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn" lay-submit="" lay-filter="demo1">注册</button>
                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                    </div>
                </div>
            </form>
        </fieldset>
    </div>
    <script type="text/javascript"  src="/static/js/jquery.js"></script>
    <script type="text/javascript" src="/static/layui/dist/layui.js"></script>
    <script type="text/javascript" src="/static/js/data.js"></script>
    <script type="text/javascript" src="/static/js/province.js"></script>
    <script type="text/javascript">
        var defaults = {
            s1: 'province',
            s2: 'city',
            s3: 'area',
            v1: null,
            v2: null,
            v3: null
        };
    </script>
    <script>
        layui.use(['form', 'layedit', 'laydate'], function(){
            var form = layui.form
                ,layer = layui.layer
                ,laydate = layui.laydate;

            //日期
            laydate.render({
                elem: '#date'
            });
            form.verify({
                username:[
                    /^[\u0391-\uFFE50-Za-z0-9]{4,10}$/
                    ,'用户名为4~10位中文、英文、数字但不包括下划线等符号'
                ]
                ,password:[
                    /^[a-zA-Z]\w{5,15}$/
                    ,'密码以字母开头，长度在5~15之间，只能包含字母、数字'
                ]
/*                ,password2:function(value){
                    var pass = document.getElementsByName("password")[0];
                    alert(pass.value);
                    if(pass==null || pass.value =="" || value!=pass.value){
                        return '前后密码不一致'
                    }
                }*/
                ,memberTell:[
                    /^1\d{10}$/
                    ,'请输入正确11位手机号'
                ]
                ,memberEmail:[
                    /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/
                    ,'请输入正确的邮箱地址'
                ]
                ,address:[
                    /^[\u0391-\uFFE50-9]+$/
                    ,'请输入正确地址格式'
                ]
            });
        });
    </script>
    <script type="text/javascript">
        $(document).ready(function(){
            $("#ln").focus();
        });
    </script>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br>
<jsp:include page="/goodhealth/footer.jsp"/>
</body>
</HTML>