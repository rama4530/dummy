<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ page
	import="net.application.corona.dao.ProductDaoJdbcImpl,java.util.List,net.application.model.Product"%>

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
		<a href="index.jsp" class="navbar-brand"> Home Page </a>
	</div>

	</nav> </header>
	<br>
		<div class="row">

			<div class="container">
				<h3 class="text-center">List of Products</h3>
				<br>
				<% ProductDaoJdbcImpl prod=new ProductDaoJdbcImpl(); %>
					
					<table class="table table-bordered">
						<thead>
							<tr>
								<th>ID</th>
								<th>Name</th>
								<th>Description</th>
								<th>Price</th>
								<th>Buy</th>
							</tr>
						</thead>
						<tbody>
							<!--   for (Todo todo: todos) {  -->
							<%-- <c:forEach var="product" items="${listProducts}"> --%>
							<c:forEach var="product" items="<%=prod.getAll()%>">
								<tr>
									<td><c:out value="${product.id}" /></td>
									<td><c:out value="${product.productName}" /></td>
									<td><c:out value="${product.productDesc}" /></td>
									<td><c:out value="${product.productPrice}" /></td>
									<td><a href="ShoppingCartController?id=${product.id}&action=orderNow">Add to Cart</a>
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