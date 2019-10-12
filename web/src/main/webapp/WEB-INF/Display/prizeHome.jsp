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
<div class="row" align="center">
	<div class="box clearfix">
		<h3>积分商品</h3>
		<p>请在订单结算时选择兑换商品</p>
		<table class="table table-hover" id="bootstrap-table" border="1">
			<thead>
			<tr>
				<th>样品图片</th>
				<th>奖品名称</th>
				<th>兑换所需积分</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach  var="prize"  items="${prizeList}" >
				<tr>
					<td><img alt="奖品图片" onmouseover="enlarge(this)" onmouseout="reduction(this)" src="http://localhost:8080/static/images/prize/${prize.prizePic }" width="44" height="55">
					<td><c:out value="${prize.prizeName }"></c:out></td>
					<td><c:out value="${prize.prizeValue }"></c:out></td>
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
		if (boo) {pwidth=obj.width;pheight=obj.height;obj.width=2*pwidth;obj.height=2*pheight;
		}else{pwidth=obj.width;pheight=obj.height;obj.height = pheight/2;obj.width = pwidth/2;
		}
	}
</script>
<jsp:include page="/goodhealth/footer.jsp"/>
</body>
</html>