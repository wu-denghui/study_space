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
    <link rel="stylesheet" href="/static/layui/dist/css/layui.css" media="all">
    <link rel="stylesheet" href="/static/css/all.css" type="text/css" charset="utf-8"/>
    <title></title>
</head>
<body>

<div align="center">
    <c:if test="${ allErrors!=null }">
    <c:forEach var="error" items="${allErrors }">
    <font color="red">${error.defaultMessage }</font>
    </c:forEach>
    </c:if>
    <div >
        <form class="layui-form" action="${pageContext.request.contextPath }/admin/prize/add" method="post" enctype="multipart/form-data">
            <div class="layui-form-item">
                <label class="layui-form-label">名称</label>
                <div class="layui-input-block">
                    <input id="ln" type="text" value="${prize.prizeName}" name="prizeName" lay-verify="prizeName" autocomplete="off" placeholder="请输入积分奖品名称" class="layui-input" >
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">价值积分</label>
                <div class="layui-input-block">
                    <input  type="text" value="${prize.prizeValue}" name="prizeValue" lay-verify="prizeValue" placeholder="请输入积分奖品价值积分" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">图片</label>
                <div class="layui-input-block">
                    <input align="left" type="file" name="file">
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn" lay-submit="" lay-filter="demo1">确定</button>
                    <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                </div>
            </div>
        </form>
    </div>
    <script src="/static/js/jquery.js" type="text/javascript" charset="utf-8" ></script>
    <script src="/static/layui/dist/layui.js" charset="utf-8"></script>
    <script>
        layui.use(['form', 'layedit', 'laydate'], function(){
            var form = layui.form
                ,layer = layui.layer
                ,layedit = layui.layedit
                ,laydate = layui.laydate;

            form.verify({
                prizeName: function(value){
                    if(value.length <= 0){
                        return '名称不允许为空';
                    }
                }
                ,prizeValue: [
                    /^[0-9]+$/
                    ,'价值积分不允许为空'
                ]
            });
        });
    </script>
    <script type="text/javascript">
        $(document).ready(function(){
            $("#ln").focus();
        });
    </script>
</body>
</html>