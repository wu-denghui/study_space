<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的购物车</title>
<script type="text/javascript"  src="/static/js/jquery.js"></script>
<link rel="stylesheet" href="/static/css/shoppingCar.css" type="text/css" charset="utf-8"/>
<link rel="stylesheet" href="/static/css/all.css" type="text/css" charset="utf-8"/>
<jsp:include page="/goodhealth/head.jsp"></jsp:include>
</head>
<body>
<span class="layui-breadcrumb">
    <a href="http://localhost:8080/goodhealth/index.jsp">主页</a>
	<a><cite>购物车</cite></a>
</span>
	<div align="center">
		<form   id="myform"  action="${pageContext.request.contextPath }/order/generateOrderMany">
			<c:choose>
				<c:when test="${empty  recordList }">
					<h2>您的购物车为空</h2>
				</c:when>
				<c:otherwise>
					<table id="cartTable" >
						<thead>
						<tr>
							<th><label for="ss"><input id="ss" name="all" type="checkbox" onclick="sall(this)">全选</label></th>
							<th>商品</th>
							<th>单价</th>
							<th>数量</th>
							<th>小计</th>
							<th>操作</th>
						</tr>
						</thead>
						<tbody>
						<c:forEach var="record" items="${recordList}">
							<tr>
								<td class="checkbox"><input onchange="changeBox()" type="checkbox" name="intoOrder" value="${record.recordId }"></td>
								<td class="goods"><img alt="药品图片"  onmouseover="enlarge(this)" onmouseout="reduction(this)"  src="http://localhost:8080/static/images/drug/${record.drug.drugPic }" width="44" height="55">
									<span><c:out value="${record.drug.drugName }"></c:out></span></td>
								<td class="price"><c:out value="${record.drug.drugPrice }"></c:out></td>
								<td class="count">
									<c:url var="linkR"
										   value="http://localhost:8080/shoppingcar/countReduce/${record.recordId}">
										<c:param name="i" value="${index }"></c:param>
									</c:url>
									<a href="${linkR}"><span class="reduce">-</span></a>
									<input class="count-input" type="text" value="${record.recordNumber }"/>
									<c:url var="linkA"
										   value="http://localhost:8080/shoppingcar/countAdd/${record.recordId}">
										<c:param name="i" value="${index }"></c:param>
									</c:url>
									<a href="${linkA}"><span class="add">+</span></a>
								</td>
								<td class="subtotal"><c:out value="${record.drug.drugPrice * record.recordNumber}"></c:out></td>
								<c:url var="linkD"
									   value="http://localhost:8080/shoppingcar/countDelete/${record.recordId}">
									<c:param name="i" value="${index }"></c:param>
									<c:param name="size" value="${size}"></c:param>
								</c:url>
								<td class="operation"><span class="delete"><a href="${linkD}">删除</a></span></td>
							</tr>
						</c:forEach>
						</tbody>
					</table>
						<div class="foot" id="foot">
							<div class="fr closing"><input type="submit" value="结  算"></div>
							<div class="fr total">合计：￥<span id="priceTotal">0.00</span></div>
							<div class="fr select" id="selected">已选商品<span id="selectedTotal">0</span>件</div>
						</div>
				</c:otherwise>
			</c:choose>
		</form>
	</div>
	<script type="text/javascript">
		function changeBox () {
            var tr = cartTable.children[1].rows;//获取table下的tbody下的每一行
            var priceTotal = document.getElementById('priceTotal');
            var selectedTotal = document.getElementById('selectedTotal');
            var selected = 0;
            var price = 0;
            for(var i=0;i < tr.length; i++){
                if(tr[i].getElementsByTagName('input')[0].checked){
                    selected += parseInt(tr[i].getElementsByTagName('input')[1].value);
                    price += parseFloat(tr[i].cells[4].innerHTML);//cells属性为获得tr下面的td
				}
            }
            selectedTotal.innerHTML = selected;
            priceTotal.innerHTML = price;//保留两位小数
        }

		function sall(obj) {
			var arr = document.getElementsByName("intoOrder");
			for (let i = 0; i < arr.length; i++) {
				arr[i].checked = obj.checked;
			}
            changeBox ();
        }
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
<jsp:include page="/goodhealth/footer.jsp"/>
</body>
</html>