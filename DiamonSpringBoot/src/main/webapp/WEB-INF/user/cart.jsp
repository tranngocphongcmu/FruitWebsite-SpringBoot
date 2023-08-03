 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
           prefix="decorator"%>

 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="/WEB-INF/user/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Twitter Bootstrap shopping cart</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- Bootstrap styles -->
    <link href="<c:url  value="/assets/css/bootstrap.css"/>" rel="stylesheet"/>
    <!-- Customize styles -->
    <link href="<c:url  value="/assets/style.css"/>" rel="stylesheet"/>
    <!-- font awesome styles -->
	<link href="<c:url  value="/assets/font-awesome/css/font-awesome.css"/>" rel="stylesheet">
		<!--[if IE 7]>
			<link href="css/font-awesome-ie7.min.css" rel="stylesheet">
		<![endif]-->

		<!--[if lt IE 9]>
			<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->

	<!-- Favicons -->
    <link rel="shortcut icon" href="<c:url  value="/assets/ico/favicon.ico"/>">
  </head>
<body>

<!-- Header -->
    <%@ include file="/WEB-INF/user/header.jsp"  %>
<div class="container">
	<div class="row">
		<div class="span12">
			<div class="well well-small">
				<h1>Gio Hang <small class="pull-right"> ${sessionScope.cart.size()} Sản Phẩm </small></h1>
				<hr class="soften"/>

				<table class="table table-bordered table-condensed">
					<thead>
					<tr>
						<th>Hình Ảnh</th>
						<th>Mô Tả</th>
						<th>Giá Bán </th>
						<th>Số Lượng</th>
						<th>Chỉnh Sửa</th>
						<th>Xóa </th>
						<th>Tổng</th>
					</tr>
					</thead>
					<tbody>

				<c:set var="total" value="0"></c:set>
					<c:forEach var="item" items="${ sessionScope.cart }">
						<c:set var="total" value="${total + item.quantity * item.product.costPrice}"></c:set>
						<tr>
							<td><img width="100" src="<c:url value="/assets/img/product/${ item.product.image}"/>" alt=""></td>
							<td>${ item.product.name }</td>
							<td><fmt:formatNumber type="number" groupingUsed="true" value="${ item.product.costPrice }"/> ₫</td>
							<td>
								<input type="number" min="0" max="1000" class="span1" style="max-width:34px" placeholder="1" id="quanty-cart-${ item.product.id }" size="16" type="text" value="${ item.quantity }">
							</td>
							<td>
								<a href="<c:url value="/viewcart/update/${ item.product.id }/${item.quantity}"/>" class="btn btn-mini btn-danger" type="button">
									<span class="icon-edit"></span>
								</a>
							</td>
							<td>
								<a href="${pageContext.request.contextPath }/viewcart/remove/${item.product.id }" onclick="return confirm('Xóa Khỏi Giỏ Hàng?')" class="btn btn-mini btn-danger" type="button">
									<span class="icon-remove"></span>
								</a>
							</td>
							<td><fmt:formatNumber type="number" groupingUsed="true" value="${ item.quantity * item.product.costPrice }"/> ₫</td>
						</tr>
					</c:forEach>
				<tr>
					<td colspan="6" align="right">Tổng Tiền</td>
					<td>${total }</td>
				</tr>



<%--				<tr>--%>
<%--					<a href="<c:url value="viewcart/clear/${ item.product.id }"/>" class="btn btn-mini btn-danger" type="button">--%>
<%--						<span class="icon-remove"></span>--%>
<%--					</a>--%>
<%--				</tr>--%>
					</tbody>
				</table><br/>


				<a href="<c:url value="/index"/>" class="shopBtn btn-large"><span class="icon-arrow-left"></span> Tiếp Tục Mua Sắm </a>
				<a href="/checkout" class="shopBtn btn-large pull-right">Thanh Toán <span class="icon-arrow-right"></span></a>

			</div>
		</div>
	</div>

</div>

    <%@ include file="/WEB-INF/user/footer.jsp"  %>

<a href="#" class="gotop"><i class="icon-double-angle-up"></i></a>
    <!-- Placed at the end of the document so the pages load faster -->





  </body>

  <script src="<c:url value="/assets/js/jquery.js" />"></script>
  <script src="<c:url value="/assets/js/bootstrap.min.js" />"></script>
  <script src="<c:url value="/assets/js/jquery.easing-1.3.min.js" />"></script>
  <script src="<c:url value="/assets/js/jquery.scrollTo-1.4.3.1-min.js" />"></script>
  <script src="<c:url value="/assets/js/shop.js"/>"></script>

</html>