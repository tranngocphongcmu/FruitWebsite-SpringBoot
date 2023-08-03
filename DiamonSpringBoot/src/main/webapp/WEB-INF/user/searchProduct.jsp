<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
		   prefix="decorator"%>
<%@include file="/WEB-INF/user/taglib.jsp" %>
<!DOCTYPE html>
<html>
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

	<style>
		.center {
			text-align: center;
		}

		.pagination {
			display: inline-block;
		}

		.pagination a {
			color: black;
			float: left;
			padding: 8px 16px;
			text-decoration: none;
			transition: background-color .3s;
			border: 1px solid #ddd;
			margin: 0 4px;
		}

		.pagination a.active {
			background-color: #4CAF50;
			color: white;
			border: 1px solid #4CAF50;
		}

		.pagination a:hover:not(.active) {background-color: #ddd;}
	</style>
</head>

<body>



<!-- Header -->
<%@ include file="/WEB-INF/user/header.jsp"  %>

<!--
New Products
-->
<div class="container">

	<div class="well well-small">
		<div class="row">
			<span style="margin-left: 25px;">Danh Sách Sản Phẩm Cua ${keySearch}</span>
			<select class="pull-right" onchange="goToLink(this)">
				<option value="/paginationAndSort/0/5/name" >A</option>
				<option value="/paginationAndSort/0/5/name/a-z" >A - Z</option>
				<option value="/paginationAndSort/0/5/costPrice/cao-thap">Cao - Thap</option>
				<option value="/paginationAndSort/0/5/costPrice/thap-cao">Thap - Cao</option>
			</select>
		</div>



		<c:if test="${products.content.size() > 0 }">
		<div class="row-fluid">
			<ul class="thumbnails">
				<c:forEach var="item" items="${products.content}" varStatus="loop">
					<li class="span4">
						<div class="thumbnail">
							<a href="product_details.html" class="overlay"></a>
							<a class="zoomTool" href="" title="add to cart"><span class="icon-search"></span> QUICK VIEW</a>
							<a href="<c:url value="/chi-tiet-san-pham/${item.id}"/>"><img src="<c:url value="/assets/img/product/${item.image}"/>" alt=""></a>
							<div class="caption cntr">
								<p>${item.name }</p>
								<p><strong><fmt:formatNumber type="number" groupingUsed="true" value="${item.costPrice} " />₫</strong></p>
								<h4><a class="shopBtn" href="<c:url value="/viewcart/buy/${item.id}"/>" title="add to cart"> Add to cart </a></h4>
								<div class="actionList">
									<a class="pull-left" href="#">Add to Wish List </a>
									<a class="pull-left" href="#"> Add to Compare </a>
								</div>
								<br class="clr">
							</div>
						</div>
					</li>
				</c:forEach>
				<div class="row-fluid">
					<ul class="thumbnails">
						</c:if>


				</div>

		<div class="center">

			<div class="pagination">

				<c:if test="${searching.totalPages > 1}">
					<ul>
						<c:forEach var="i" begin="1" end="${searching.totalPages}">
							<li ><a <c:if test="${page eq i-1}">class="active"</c:if> href="/search-paging/${keySearch}?page=${i}">${i}</a></li>
						</c:forEach>
					</ul>
				</c:if>

			</div>
		</div>

		<!-- footer -->
		<%@ include file="/WEB-INF/user/footer.jsp"  %>

		<script>
			function goToLink(selectElement) {
				var selectedOption = selectElement.options[selectElement.selectedIndex];
				var link = selectedOption.value;
				if (link) {
					window.location.href = link;
				}
			}
		</script>

</body>


<!-- Placed at the end of the document so the pages load faster -->
<script src="<c:url value="/assets/js/jquery.js" />"></script>
<script src="<c:url value="/assets/js/bootstrap.min.js" />"></script>
<script src="<c:url value="/assets/js/jquery.easing-1.3.min.js" />"></script>
<script src="<c:url value="/assets/js/jquery.scrollTo-1.4.3.1-min.js" />"></script>
<script src="<c:url value="/assets/js/shop.js"/>"></script>
</html>