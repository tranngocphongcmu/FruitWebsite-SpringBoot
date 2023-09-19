<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
		   prefix="decorator"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="/WEB-INF/user/taglib.jsp" %>

<!-- Sidebar -->
<ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

	<!-- Sidebar - Brand -->
	<a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.html">
		<div class="sidebar-brand-icon rotate-n-15">
			<i class="fas fa-laugh-wink"></i>
		</div>
		<div class="sidebar-brand-text mx-3">SB Admin <sup>2</sup></div>
	</a>

	<!-- Divider -->
	<hr class="sidebar-divider my-0">

	<!-- Nav Item - Dashboard -->
	<li class="nav-item active">
		<a class="nav-link" href="/adminhome">
			<i class="fas fa-fw fa-tachometer-alt"></i>
			<span>Home</span></a>
	</li>

	<!-- Divider -->
	<hr class="sidebar-divider">
	<!-- Nav Item - Dashboard -->
	<li class="nav-item active">
		<a class="nav-link" href="/useradmin">
			<i class="fas fa-fw fa-tachometer-alt"></i>
			<span>UserAccounts</span></a>
	</li>

	<!-- Divider -->
	<hr class="sidebar-divider">
	<!-- Nav Item - Dashboard -->
	<li class="nav-item active">
		<a class="nav-link" href="/adminhome">
			<i class="fas fa-fw fa-tachometer-alt"></i>
			<span>Product</span></a>
	</li>
	<!-- Heading -->
	<div class="sidebar-heading">
		Addons
	</div>


	<!-- Nav Item - Charts -->
	<li class="nav-item">
		<a class="nav-link" href="/category">
			<i class="fas fa-fw fa-chart-area"></i>
			<span>Category</span></a>
	</li>

	<!-- Nav Item - Tables -->
	<li class="nav-item">
		<a class="nav-link" href="/adminaccount">
			<i class="fas fa-fw fa-table"></i>
			<span>AdminAccounts</span></a>
	</li>

	<!-- Divider -->
	<hr class="sidebar-divider d-none d-md-block">

	<!-- Sidebar Toggler (Sidebar) -->
	<div class="text-center d-none d-md-inline">
		<button class="rounded-circle border-0" id="sidebarToggle"></button>
	</div>


</ul>