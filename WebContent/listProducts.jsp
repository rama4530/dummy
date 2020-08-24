<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Product Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header> <nav class="navbar navbar-expand-md navbar-dark"
		style="background-color: tomato">
	<div>
		<a href="https://www.cdc.gov/coronavirus/2019-ncov/symptoms-testing/symptoms.html" class="navbar-brand">About Corona Virus</a>
	</div>
	
	<div>
		<a href="index.jsp" class="navbar-brand"> Home </a>
	</div>
	
	<div align="right">
		<div align="right"><a href="index.jsp" class="navbar-brand"> Logout </a></div>
	</div>

	</nav> </header>
	<br>

		<div class="row">
			<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

			<div class="container">
				<h3 class="text-center">List of Products</h3>
				<hr>
					<div class="container text-left">
						<a href="<%=request.getContextPath()%>/new"
							class="btn btn-success">Add New Product</a>
					</div>
					<br>
						<table class="table table-bordered">
							<thead>
								<tr>
									<th>ID</th>
									<th>Name</th>
									<th>Description</th>
									<th>Price</th>
									<th>Actions</th>
								</tr>
							</thead>
							<tbody>
								<!--   for (Todo todo: todos) {  -->
								<c:forEach var="product" items="${listProducts}">
									<tr>
										<td><c:out value="${product.id}" /></td>
										<td><c:out value="${product.productName}" /></td>
										<td><c:out value="${product.productDesc}" /></td>
										<td><c:out value="${product.productPrice}" /></td>
										<td><a href="edit?id=<c:out value='${product.id}' />">Edit</a>
											&nbsp;&nbsp;&nbsp;&nbsp;</td>
									</tr>
								</c:forEach>
								<!-- } -->
							</tbody>

						</table>
			</div>
		</div>
</body>
</html>