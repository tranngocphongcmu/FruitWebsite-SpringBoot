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
Body Section
-->
<div class="container">
<div class="row">
<div id="sidebar" class="span3">
<div class="well well-small">
	<ul class="nav nav-list">

		<c:forEach var="item" items="${categorys}">
					<li>
						<a href='<c:url value = "/san-pham/${item.id}"/>'><span class="icon-chevron-right"></span>${item.name}</a>
<%--						<span>${item.id}</span>--%>
					</li>
		</c:forEach>
		<li style="border:0"> &nbsp;</li>
		<li> <a class="totalInCart" href="cart.html"><strong>Total  <span class="badge badge-warning pull-right" style="line-height:18px;"><fmt:formatNumber type="number" groupingUsed="true" value="${total}" />₫ </span></strong></a></li>
	</ul>
</div>

			  <div class="well well-small alert alert-warning cntr">
				  <h2>50% Discount</h2>
				  <p>
					 only valid for online order. <br><br><a class="defaultBtn" href="#">Click here </a>
				  </p>
			  </div>
			  <div class="well well-small" ><a href="#"><img src="assets/img/paypal.jpg" alt="payment method paypal"></a></div>

			<a class="shopBtn btn-block" href="#">Upcoming products <br><small>Click to view</small></a>
			<br>
			<br>


	</div>
	<div class="span9">
		<div class="well np">
			<div id="myCarousel" class="carousel slide homCar">

				<div class="carousel-inner">
					<c:forEach var="item" items="${ slides }" varStatus="index">
					<c:if test="${ index.first }">
					<div class="item active">
						</c:if>
						<c:if test="${ not index.first }">
						<div class="item">
							</c:if>
							<img style="width: 100%"
								 src="<c:url value="/assets/img/slides/${ item.image }"/>"
								 alt="bootstrap ecommerce templates">
							<div class="carousel-caption">
								<h4>${ item.caption }</h4>
							</div>
						</div>
						</c:forEach>
					</div>

					<a class="left carousel-control" href="#myCarousel"
					   data-slide="prev">&lsaquo;</a> <a class="right carousel-control"
														 href="#myCarousel" data-slide="next">&rsaquo;</a>
				</div>
			</div>

<!--
New Products
-->
	<div class="well well-small">
	<h3>New Products </h3>
	<hr class="soften"/>
		<div class="row-fluid">
		<div id="newProductCar" class="carousel slide">
            <div class="carousel-inner">

            <c:if test="${productSlides.size() > 0 }">
	            	<div class="item active">
				  	<ul class="thumbnails">
	            <c:forEach var="item" items="${productSlides}" varStatus="loop">
					<li class="span3">
						<div class="thumbnail">
							<a class="zoomTool" href="/chi-tiet-san-pham/${item.id }" title="add to cart"><span class="icon-search"></span> QUICK VIEW</a>
							<a href="/chi-tiet-san-pham/${item.id }" class="tag"></a>
							<a href="/chi-tiet-san-pham/${item.id }"><img src='<c:url value ="/assets/img/product/${item.image }"/>' alt="bootstrap-ring"></a>
						</div>
					</li>

					<c:if test="${(loop.index +1) % 4 == 0 || (loop.index +1) == productSlides.size() }">
						  </ul>
						  </div>
						<c:if test="${(loop.index +1) <productSlides.size()}">
							   <div class="item">
							  <ul class="thumbnails">
						</c:if>

					</c:if>
	            </c:forEach>
            </c:if>



		   </div>
		  <a class="left carousel-control" href="#newProductCar" data-slide="prev">&lsaquo;</a>
            <a class="right carousel-control" href="#newProductCar" data-slide="next">&rsaquo;</a>
		  </div>
		  </div>

	</div>
	<!--
	Featured Products
	-->
		<div class="well well-small">
		  <h3><a class="btn btn-mini pull-right" href="products.html" title="View more">VIew More<span class="icon-plus"></span></a> San Pham Noi Bat  </h3>
		  <hr class="soften"/>
		  <div class="row-fluid">

		  <c:if test="${products.content.size() > 0 }">
		  			  <ul class="thumbnails">
		  		<c:forEach var="item" items="${products.content}" varStatus="loop">
				  	<li class="span4">
					  <div class="thumbnail">
						<a class="zoomTool" href="/chi-tiet-san-pham/${item.id }" title="add to cart"><span class="icon-search"></span> QUICK VIEW</a>
						<a  href="/chi-tiet-san-pham/${item.id }"><img src="<c:url value="/resources/uploads/${item.image}"/>" alt=""></a>
						<div class="caption">
						  <h5>${item.name}</h5>
						  <h4>
							  <a class="defaultBtn" href="product_details.html" title="Click to view"><span class="icon-zoom-in"></span></a>
							  <a class="shopBtn" href="<c:url value="/viewcart/buy/${item.id}"/>" title="add to cart"><span class="icon-plus"></span></a>
							  <span class="pull-right">  <fmt:formatNumber type="number" groupingUsed="true" value="${item.costPrice} " />₫ </span>
						  </h4>
							</div>
					  	</div>
					</li>
					<c:if test="${(loop.index +1) % 3 == 0 || (loop.index +1) == products.content.size() }">
						</ul>
						<c:if test="${(loop.index +1) <products.content.size()}">
							  <ul class="thumbnails">
						</c:if>

					</c:if>
		  		</c:forEach>
		  </c:if>
		  </ul>
	</div>
		</div>

		<div class="center">

			<div class="pagination">

				<c:if test="${products.totalPages > 1}">
					<ul>
						<c:forEach var="i" begin="1" end="${products.totalPages}">
							<li ><a <c:if test="${page eq i-1}">class="active"</c:if> href="?page=${i}">${i}</a></li>
						</c:forEach>
					</ul>
				</c:if>

			</div>
		</div>

<!-- footer -->
    <%@ include file="/WEB-INF/user/footer.jsp"  %>
<a href="#" class="gotop"><i class="icon-double-angle-up"></i></a>


    <!-- Placed at the end of the document so the pages load faster -->
    <script src="<c:url value="/assets/js/jquery.js" />"></script>
	<script src="<c:url value="/assets/js/bootstrap.min.js" />"></script>
	<script src="<c:url value="/assets/js/jquery.easing-1.3.min.js" />"></script>
    <script src="<c:url value="/assets/js/jquery.scrollTo-1.4.3.1-min.js" />"></script>
    <script src="<c:url value="/assets/js/shop.js"/>"></script>
  </body>
</html>