<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
		   prefix="decorator"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	.product-content{
		overflow-x: hidden;
	}
</style>
  </head>

<body>



<!-- Header -->
    <%@ include file="/WEB-INF/user/header.jsp"  %>

<!--
Body Section
-->
<div class="container">
<div class="row product-content">
	<div id="sidebar" class="span3">
		<div class="well well-small">
			<ul class="nav nav-list">
				<h1>${Cart.size()}</h1>
				<c:forEach var="item" items="${categorys}">
					<li>
						<a href='<c:url value = "/san-pham/${item.id}"/>'><span class="icon-chevron-right"></span>${item.name}</a>
					</li>
				</c:forEach>
				<li style="border:0"> &nbsp;</li>
				<li> <a class="totalInCart" href="cart.html"><strong>Total Amount  <span class="badge badge-warning pull-right" style="line-height:18px;">$448.42</span></strong></a></li>
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
		<ul class="breadcrumb">
			<li><a href="/">Trang Chủ</a> <span class="divider">/</span></li>
			<li><a href="products.html">Sản Phẩm</a> <span class="divider">/</span></li>
			<li class="active">Chi tiết sản phẩm</li>
		</ul>
		<div class="well well-small">
			<div class="row-fluid">
				<div class="span5">
					<div id="myCarousel" class="carousel slide cntr">
						<div class="carousel-inner">
							<div class="item active">
								<a href="#"> <img src="<c:url value="/resources/uploads/${productdetails.image}"/>" alt="" style="width:100%"></a>
							</div>
<%--							<div class="item">--%>
<%--								<a href="#"> <img src="<c:url value="/assets/img/product/${productdetails.image}"/>" alt="" style="width:100%"></a>--%>
<%--							</div>--%>
<%--							<div class="item">--%>
<%--								<a href="#"> <img src="assets/img/e.jpg" alt="" style="width:100%"></a>--%>
<%--							</div>--%>
						</div>
						<a class="left carousel-control" href="#myCarousel" data-slide="prev">‹</a>
						<a class="right carousel-control" href="#myCarousel" data-slide="next">›</a>
					</div>
				</div>
				<div class="span7">
					<h3>${productdetails.name}</h3>
					<hr class="soft"/>

					<form class="form-horizontal qtyFrm" method="get" action="<c:url value="/addCart/${productdetails.id}"/>" >
						<div class="control-group">
							<label class="control-label"><span><fmt:formatNumber type="number" groupingUsed="true" value="${productdetails.costPrice} " />₫</span></label>
							<div class="controls">
								<input type="number" min="0" value="0" class="span6" >
							</div>
						</div>

						<div class="control-group">
							<label class="control-label"><span>currentQuantity</span></label>
							<div class="controls">
								<h3>${productdetails.currentQuantity}</h3>
							</div>
						</div>

							<label class="control-label"><span>SalePrice</span></label>
							<div class="controls">
								<h3>${productdetails.salePrice}</h3>
								<h4><a class="shopBtn" href="<c:url value="/viewcart/buy/${productdetails.id}"/>" title="add to cart"> Add to cart </a></h4>
							</div>
					</form>
				</div>
			</div>
			<hr class="softn clr"/>


			<ul id="productDetail" class="nav nav-tabs">
				<li class="active"><a href="#home" data-toggle="tab">Chi Tiet Sản Phẩm</a></li>
				<li class=""><a href="#profile" data-toggle="tab">Sản Pham Liên Quan </a></li>
			</ul>
			<div id="myTabContent" class="tab-content tabWrapper">
				<div class="tab-pane fade active in" id="home">
					<h4>Product Information</h4>
					<table class="table table-striped">
						<tbody>
						<tr class="techSpecRow"><td class="techSpecTD1">Color:</td><td class="techSpecTD2">Black</td></tr>
						<tr class="techSpecRow"><td class="techSpecTD1">Style:</td><td class="techSpecTD2">Apparel,Sports</td></tr>
						<tr class="techSpecRow"><td class="techSpecTD1">Season:</td><td class="techSpecTD2">spring/summer</td></tr>
						<tr class="techSpecRow"><td class="techSpecTD1">Usage:</td><td class="techSpecTD2">fitness</td></tr>
						<tr class="techSpecRow"><td class="techSpecTD1">Sport:</td><td class="techSpecTD2">122855031</td></tr>
						<tr class="techSpecRow"><td class="techSpecTD1">Brand:</td><td class="techSpecTD2">Shock Absorber</td></tr>
						</tbody>
					</table>
					<p>Raw denim you probably haven't heard of them jean shorts Austin. Nesciunt tofu stumptown aliqua, retro synth master cleanse. Mustache cliche tempor, williamsburg carles vegan helvetica. Reprehenderit butcher retro keffiyeh dreamcatcher synth. Cosby sweater eu banh mi, qui irure terry richardson ex squid. Aliquip placeat salvia cillum iphone. Seitan aliquip quis cardigan american apparel, butcher voluptate nisi qui.</p>

				</div>
				<div class="tab-pane fade" id="profile">
					<div class="row-fluid">
						<div class="span2">
							<img src="assets/img/d.jpg" alt="">
						</div>
						<div class="span6">
							<h5>Product Name </h5>
							<p>
								Nowadays the lingerie industry is one of the most successful business spheres.
								We always stay in touch with the latest fashion tendencies -
								that is why our goods are so popular..
							</p>
						</div>
						<div class="span4 alignR">
							<form class="form-horizontal qtyFrm">
								<h3> $140.00</h3>
								<div class="btn-group">
									<a href="product_details.html" class="defaultBtn"><span class=" icon-shopping-cart"></span> Add to cart</a>
									<a href="product_details.html" class="shopBtn">VIEW</a>
								</div>
							</form>
						</div>
					</div>
					<hr class="soft">

					</div>
				</div>
			</div>

		</div>
	</div>
</div> <!-- Body wrapper -->

<!-- footer -->
    <%@ include file="/WEB-INF/user/footer.jsp"  %>
</body>

    <!-- Placed at the end of the document so the pages load faster -->
    <script src="<c:url value="/assets/js/jquery.js" />"></script>
	<script src="<c:url value="/assets/js/bootstrap.min.js" />"></script>
	<script src="<c:url value="/assets/js/jquery.easing-1.3.min.js" />"></script>
    <script src="<c:url value="/assets/js/jquery.scrollTo-1.4.3.1-min.js" />"></script>
    <script src="<c:url value="/assets/js/shop.js"/>"></script>
</html>