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
<div align="left">
    <p onclick="javascript:history.back()"><font size="3"  color="gray">返回</font></p> </div>
<div align="center">
<%--    <c:if test="${ allErrors!=null }">
        <c:forEach var="error" items="${allErrors }">
            <font color="red">${error.defaultMessage }</font>
        </c:forEach>
    </c:if>--%>
        <div >
            <form class="layui-form" action="${pageContext.request.contextPath }/drug/admin/save" method="post">
                <input  type="hidden"  name="drugId"  value="${drug.drugId}">
                <input  type="hidden"  name="drugPic"  value="${drug.drugPic}">
                <div class="layui-form-item">
                    <label class="layui-form-label">药品名</label>
                    <div class="layui-input-block">
                        <input id="ln" type="text" value="${drug.drugName}" name="drugName" lay-verify="drugName" autocomplete="off" class="layui-input" >
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">单价</label>
                    <div class="layui-input-block">
                        <input  type="text" value="${drug.drugPrice}" name="drugPrice" lay-verify="drugPrice" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">赠送积分</label>
                    <div class="layui-input-block">
                        <input  type="text" value="${drug.drugIntegral}" name="drugIntegral" lay-verify="drugIntegral" autocomplete="off" class="layui-input">
                    </div>
                </div>
            <div class="layui-form-item">
                <label class="layui-form-label">生产商</label>
                <div class="layui-input-block">
                    <input  type="text" value="${drug.drugProductor}" name="drugProductor" lay-verify="drugProductor" autocomplete="off" class="layui-input">
                </div>
            </div>
                <div class="layui-form-item">
                <label class="layui-form-label">主治功能</label>
                <div class="layui-input-block">
                    <input  type="text" value="${drug.drugFunction}" name="drugFunction" lay-verify="drugFunction" autocomplete="off"  class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">性状</label>
                <div class="layui-input-block">
                    <input  type="text" value="${drug.drugCharacter}" name="drugCharacter" lay-verify="drugCharacter" autocomplete="off"  class="layui-input">
                </div>
            </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">成分</label>
                    <div class="layui-input-block">
                        <input  type="text" value="${drug.drugComponent}" name="drugComponent" lay-verify="drugComponent" autocomplete="off"  class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">用量</label>
                    <div class="layui-input-block">
                        <input  type="text" value="${drug.drugUsage}" name="drugUsage" lay-verify="drugUsage" autocomplete="off"  class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">贮藏方式</label>
                    <div class="layui-input-block">
                        <input  type="text" value="${drug.drugStorage}" name="drugStorage" lay-verify="drugStorage" autocomplete="off"  class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">包装</label>
                    <div class="layui-input-block">
                        <img alt="药品图片" src="http://localhost:8080/static/images/drug/${drug.drugPic }" width="66" height="66">
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn" lay-submit="" lay-filter="demo1">保存</button>
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
                    drugName:function(value){
                       if(value.length < 0){
                           return '药品名不允许为空';
                       }
                    }
                    ,drugPrice:function(value){
                        if(value.length < 0){
                            return '单价不允许为空';
                        }
                    }
                    ,drugIntegral:[
                        /^[0-9]+$/
                        ,'积分不允许为空'
                    ]
                    ,drugProductor:function(value){
                        if(value.length < 0){
                            return '生产商不允许为空';
                        }
                    }
                    ,drugFunction:function(value){
                        if(value.length < 0){
                            return '主治功能不允许为空';
                        }
                    }
                    ,drugCharacter:function(value){
                        if(value.length < 0){
                            return '性状不允许为空';
                        }
                    }
                    ,drugComponent:function(value){
                        if(value.length < 0){
                            return '成分不允许为空';
                        }
                    }
                    ,drugUsage:function(value){
                        if(value.length < 0){
                            return '用量不允许为空';
                        }
                    }
                    ,drugStorage: function(value){
                        if(value.length < 0){
                            return '贮藏不允许为空';
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