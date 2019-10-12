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
        <form class="layui-form" action="${pageContext.request.contextPath }/news/admin/add" method="post" >
            <div class="layui-form-item">
                <label class="layui-form-label">标题</label>
                <div class="layui-input-block">
                    <input id="ln" type="text" value="${news.newTitle}" name="newTitle" lay-verify="newTitle" placeholder="请输入标题" autocomplete="off" class="layui-input" >
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">摘要</label>
                <div class="layui-input-block">
                    <input  type="text" value="${news.newDetail}" name="newDetail" placeholder="请输入摘要" lay-verify="newDetail" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">发布者</label>
                <div class="layui-input-block">
                    <input  type="text" value="${news.newAuthor}" name="newAuthor" placeholder="请输入发布者" lay-verify="newAuthor" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">链接</label>
                <div class="layui-input-block">
                    <input  type="text" value="${news.newUrl}" name="newUrl" lay-verify="newUrl" placeholder="请输入链接" autocomplete="off" class="layui-input">
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
                newTitle:function(value){
                    if(value.length < 1){
                        return '标题不允许为空';
                    }
                }
                ,newDetail:function(value){
                    if(value.length < 1){
                        return '摘要不允许为空';
                    }
                }
                ,newAuthor:function(value){
                    if(value.length < 1){
                        return '发布者不允许为空';
                    }
                }
                ,newUrl:function(value){
                    if(value.length < 1){
                        return '链接不允许为空';
                    }
                }
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