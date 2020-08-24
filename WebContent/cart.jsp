<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Cart Information</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous" />
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
				<%
 					HttpSession sessions = request.getSession(false);
 				%>
					<table class="table table-bordered">
						<thead>
							<tr>
								<th>ID</th>
								<th>Name</th>
								<th>Price</th>
								<th>Quantity</th>
								<th>Sub Total</th>
							</tr>
						</thead>
						<tbody>
							<!--   for (Todo todo: todos) {  -->
							<%-- <c:forEach var="product" items="${listProducts}"> --%>
						<%-- 	<c:forEach var="product" items="<%=prod.getAll()%>"> --%>
								<c:forEach var="it" items='<%=sessions.getAttribute("cart")%>'>
									<tr>
										<td><c:out value="${it.p.id}" /></td>
										<td><c:out value="${it.p.productName }" /></td>
										<td><c:out value="${it.p.productPrice}" /></td>
										<td><c:out value="${it.quantity}" /></td>
										<td><c:out value="${it.p.productPrice*it.quantity}" /></td>
									</tr>
								</c:forEach>
								<!-- } -->
						</tbody>

					</table>
			</div>
		</div>
</body>
</html>