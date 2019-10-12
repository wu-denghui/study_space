<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"   prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>奖品兑换页</title>
 <jsp:include page="/goodhealth/head.jsp"></jsp:include>
</head>
<body>
<a href="http://localhost:8080/goodhealth/index.jsp">主页</a>
<a href="http://localhost:8080/shoppingcar/showMyShoppingCar">购物车</a>
<a onclick="bc()">订单页</a>
<a><cite>兑换积分奖品</cite></a>
<div class="row" align="center">
	<div class="box clearfix">
		<h3>精选药品</h3>
		<p>购买前请先登录</p>
		<table class="table table-hover" id="bootstrap-table" border="1">
			<thead>
			<tr>
				<th>样品图片</th>
				<th>奖品名称</th>
				<th>兑换所需积分</th>
				<th>兑换</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach  var="prize"  items="${prizeList}" >
				<tr>
					<td><img alt="奖品图片" onmouseover="enlarge(this)" onmouseout="reduction(this)" src="http://localhost:8080/static/images/prize/${prize.prizePic }" width="44" height="55">
					<td><c:out value="${prize.prizeName }"></c:out></td>
					<td><c:out value="${prize.prizeValue }"></c:out></td>
					<c:url  var="link" value="http://localhost:8080/prize/exchange">
						<c:param name="prizeId" value="${prize.prizeId }"></c:param>
						<c:param name="orderId" value="${orderId}"></c:param>
					</c:url>
					<td><a href="${link}">兑换 </a></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<script type="text/javascript">
		var boo=undefined;
		var pheight,pwidth;
		var enlarge=function(o){
			    boo=true;
			    picchange(o);
			}
	    var reduction=function(o){
			    boo=false;
			    picchange(o);
			}
		var picchange=function(obj){

		 if (boo) {
			pwidth=obj.width;
			pheight=obj.height;
			obj.width=2*pwidth;
			obj.height=2*pheight;
		  }else{
		  	pwidth=obj.width;
			pheight=obj.height;
		    obj.height = pheight/2;
            obj.width = pwidth/2;
		  }
		}		
	</script>
<jsp:include page="/goodhealth/footerjsp"/>
<script>
    $(document).ready( function () {
        $('#bootstrap-table').bdt({
            showSearchForm: 0,
            showEntriesPerPageField: 0
        });
    });
    var bc=function(){
        if (location.href=="http://localhost:8080/goodhealth/index.jsp") {
            if (confirm('是否要离开')){
                history.back();
            }
        }else{
            history.back();
        }
    }
</script>
</body>
</html>