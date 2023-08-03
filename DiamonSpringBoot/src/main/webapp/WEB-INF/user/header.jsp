<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/user/taglib.jsp" %> 
<!-- 
	Upper Header Section 
-->
<div class="navbar navbar-inverse navbar-fixed-top">
	<div class="topNav">
		<div class="container">
			<div class="alignR">
				<div class="pull-left socialNw">
					<a href="#"><span class="icon-twitter"></span></a>
					<a href="#"><span class="icon-facebook"></span></a>
					<a href="#"><span class="icon-youtube"></span></a>
					<a href="#"><span class="icon-tumblr"></span></a>
				</div>
				<a class="active" href="/"> <span class="icon-home"></span> Trang Chu</a>
<%--				<div class="active">--%>
					<c:if test="${empty logininfo}">
						<a href="/dang-nhap"><span class="icon-user"></span>Dang Nhap</a>

					</c:if>
					<c:if test="${not empty logininfo}">
						<a href=""><span class="icon-user"></span>${logininfo.name}</a>
						<a href="<c:url value="/dang-xuat"/>"><span class="icon-user"></span>Dang Xuat</a>
					</c:if>
<%--				</div>--%>
				<a href="/dang-ky"><span class="icon-edit"></span> Register </a>
				<a href="contact.html"><span class="icon-envelope"></span> Contact us</a>
				<a href="<c:url value="${pageContext.request.contextPath}/viewcart/cart/"/>"><span class="icon-shopping-cart"> </span></a>${sessionScope.cart.size()}  sản phẩm - <span class="badge badge-warning"><fmt:formatNumber type="number" groupingUsed="true" value="${total}" />₫ </span></a>
			</div>
		</div>
	</div>
</div>

<!--
Lower Header Section 
-->
<div class="container">
<div id="gototop"> </div>
<header id="header">
<div class="row">
	<div class="span4">
	<h1>
	<a class="logo" href="index.html"><span>Twitter Bootstrap ecommerce template</span> 
		<img src="<c:url  value="/assets/img/logo-bootstrap-shoping-cart.png"/>" alt="bootstrap sexy shop">
	</a>
	</h1>
	</div>
	<div class="span4">
	<div class="offerNoteWrapper">
	</div>
	</div>
	<div class="span4 alignR">
	<p><br> <strong> Support (24/7) :  0800 1234 678 </strong><br><br></p>
	<span class="btn btn-mini">	${Cart.size()} <span class="icon-shopping-cart"></span></span>
	<span class="btn btn-warning btn-mini">$</span>
	<span class="btn btn-mini">&pound;</span>
	<span class="btn btn-mini">&euro;</span>
	</div>
</div>
</header>

<!--
Navigation Bar Section 
-->
<div class="navbar">
	  <div class="navbar-inner">
		<div class="container">
		  <a data-target=".nav-collapse" data-toggle="collapse" class="btn btn-navbar">
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
		  </a>
		  <div class="nav-collapse">
			<ul class="nav">

				<li class="active"><a href="/">Trang Chủ</a></li>
				<li class=""><a href="list-view.html">Sản Phẩm</a></li>
				<li class=""><a href="grid-view.html">So Sánh</a></li>
				<li class=""><a href="three-col.html">Giỏ Hàng</a></li>
				<li class=""><a href="four-col.html">Bài viết</a></li>
				<li class=""><a href="general.html">Liên Hệ</a></li>
			</ul>
			<form action="/search/" class="navbar-search pull-left" method="get">
			  <input name="keySearch" type="text" placeholder="Search" class="search-query span2">
			</form>
		  </div>
		</div>
	  </div>
	</div>
</div>