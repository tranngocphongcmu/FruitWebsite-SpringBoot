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
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="">
	<meta name="author" content="">

	<title>SB Admin 2 - Dashboard</title>

	<!-- Custom fonts for this template-->
	<link href="<c:url  value="/assets/admin/vendor/fontawesome-free/css/all.min.css"/>" rel="stylesheet" type="text/css">
	<link
			href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
			rel="stylesheet">

	<!-- Custom styles for this template-->
	<link href="<c:url  value="/assets/admin/css/sb-admin-2.min.css"/>" rel="stylesheet">

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

<body id="page-top">

<!-- Page Wrapper -->
<div id="wrapper">

	<%@ include file="/WEB-INF/user/admin/menuadmin.jsp"  %>
	<!-- End of Sidebar -->

	<!-- Content Wrapper -->
	<div id="content-wrapper" class="d-flex flex-column">

		<!-- Main Content -->
		<div id="content">

			<!-- Topbar -->
			<%--HEADER ADMIN--%>
			<%@ include file="/WEB-INF/user/admin/headeradmin.jsp"  %>
			<!-- Page Heading -->
			<div class="d-sm-flex align-items-center justify-content-between mb-4">
				<div class="container">
					<h2>Category Table</h2>
					<td><a href="/addCategory"><button class="btn btn-primary"  type="button" data-dismiss="modal">Add</button></a></td>
					<table class="table table-bordered">
						<thead>
						<tr>
							<th>Category_Id</th>
							<th>name</th>
						</tr>
						</thead>
						<tbody>
						<c:forEach var="item" items="${list}">
							<tr>
								<td>${item.id}</td>
								<td>${item.name}</td>
								<td><a href="/updateCategory/${item.id}"><button class="btn btn-primary" type="button" data-dismiss="modal">Update</button></a></td>
								<td><a href="/deleteBook/${item.id}"><button class="btn btn-primary" type="button" data-dismiss="modal">Delete</button></a></td>
								<td><a href="/getSingleCategory/${item.id}"><button class="btn btn-primary" type="button" data-dismiss="modal">View</button></a></td>
							</tr>
						</c:forEach>
						</tbody>
					</table>

				</div>
			</div>

		</div>

	</div>
	</div>

</div>





<!-- Bootstrap core JavaScript-->
<script src="<c:url  value="/assets/admin/vendor/jquery/jquery.min.js"/>"></script>
<script src="<c:url  value="/assets/admin/vendor/bootstrap/js/bootstrap.bundle.min.js"/>"></script>

<!-- Core plugin JavaScript-->
<script src="<c:url  value="/assets/admin/vendor/jquery-easing/jquery.easing.min.js"/>"></script>

<!-- Custom scripts for all pages-->
<script src="<c:url  value="/assets/admin/js/sb-admin-2.min.js"/>"></script>

<!-- Page level plugins -->
<script src="<c:url  value="/assets/admin/vendor/chart.js/Chart.min.js"/>"></script>

<!-- Page level custom scripts -->
<script src="<c:url  value="/assets/admin/js/demo/chart-area-demo.js"/>"></script>
<script src="<c:url  value="/assets/admin/js/demo/chart-pie-demo.js"/>"></script>

</body>

</html>

<%--<body>--%>
<%--<div id="content-wrapper" class="d-flex flex-column">--%>

<%--	<!-- Main Content -->--%>
<%--	<div id="content">--%>

<%--		<!-- Topbar -->--%>
<%--		&lt;%&ndash;HEADER ADMIN&ndash;%&gt;--%>
<%--		<%@ include file="/WEB-INF/user/admin/headeradmin.jsp"  %>--%>
<%--	</div>--%>
<%--	<div class="container">--%>
<%--		<h2>Category Table</h2>--%>
<%--		<table class="table table-bordered">--%>
<%--			<thead>--%>
<%--			<tr>--%>
<%--				<th>Category_Id</th>--%>
<%--				<th>name</th>--%>
<%--			</tr>--%>
<%--			</thead>--%>
<%--			<tbody>--%>
<%--			<c:forEach var="item" items="${categoryAdmin.content}">--%>
<%--				<tr>--%>
<%--					<td>${item.id}</td>--%>
<%--					<td>${item.name}</td>--%>
<%--				</tr>--%>
<%--			</c:forEach>--%>
<%--			</tbody>--%>
<%--		</table>--%>

<%--	</div>--%>
<%--</div>--%>


