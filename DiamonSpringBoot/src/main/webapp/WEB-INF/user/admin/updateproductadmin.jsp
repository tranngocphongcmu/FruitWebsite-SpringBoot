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
		body {
			font-family: Arial, Helvetica, sans-serif;
			background-color: black;
		}

		* {
			box-sizing: border-box;
		}

		/* Add padding to containers */
		.container {
			padding: 16px;
			background-color: white;
		}

		/* Full-width input fields */
		input[type=text], input[type=password] {
			width: 100%;
			padding: 15px;
			margin: 5px 0 22px 0;
			display: inline-block;
			border: none;
			background: #f1f1f1;
		}

		input[type=text]:focus, input[type=password]:focus {
			background-color: #ddd;
			outline: none;
		}

		/* Overwrite default styles of hr */
		hr {
			border: 1px solid #f1f1f1;
			margin-bottom: 25px;
		}

		/* Set a style for the submit button */
		.registerbtn {
			background-color: #04AA6D;
			color: white;
			padding: 16px 20px;
			margin: 8px 0;
			border: none;
			cursor: pointer;
			width: 100%;
			opacity: 0.9;
		}

		.registerbtn:hover {
			opacity: 1;
		}

		/* Add a blue text color to links */
		a {
			color: dodgerblue;
		}

		/* Set a grey background color and center the text of the "sign in" section */
		.signin {
			background-color: #f1f1f1;
			text-align: center;
		}
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

			<form action="/updateProduct/${updateproduct.id}" method="post"  modelAttribute="updateproductadmin" enctype="multipart/form-data" >
				<div class="container">
					<h1>Update Product</h1>
					<hr>

<%--					<label for="id"><b>Product_ID</b></label>--%>
<%--					<input type="text" value="${updateproduct.id}" placeholder="Enter Product_ID" name="id" id="id" required>--%>

					<label for="name"><b>Product_Name</b></label>
					<input type="text" value="${updateproduct.name}" placeholder="Enter Product_Name" name="name" id="name" required>
					<hr>

					<label for="currentQuantity"><b>currentQuantity</b></label>
					<input type="text" value="${updateproduct.currentQuantity}" placeholder="Enter currentQuantity" name="currentQuantity" id="currentQuantity" required>

					<hr>

					<label for="costPrice"><b>costPrice</b></label>
					<input type="text" value="${updateproduct.costPrice}" placeholder="Enter costPrice" name="costPrice" id="costPrice" required>

					<hr>

					<label for="salePrice"><b>salePrice</b></label>
					<input type="text" value="${updateproduct.salePrice}" placeholder="Enter salePrice" name="salePrice" id="salePrice" required>
					<hr>


					<label for="salePrice"><b>Category: </b></label>
					<select id="cars" name="category_id" required>
						<c:forEach var="item" items="${listCategory}">

							<option value="${item.id}" >${item.name}</option>


						</c:forEach>
					</select>

					<hr>
					<label for="salePrice"><b>Image_Product: </b></label>
					<input type="file" name="file"  />


					<button type="submit" class="registerbtn" >Update Product</button>
				</div>

			</form>
		</div>

	</div>
</div>

</body>





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

