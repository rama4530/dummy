<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<header> <nav class="navbar navbar-expand-md navbar-dark"
		style="background-color: tomato">
	<div>
		<a href="https://www.javaguides.net" class="navbar-brand"> Corona
			shopping Application </a>
	</div>

	<ul class="navbar-nav">
		<li><a href="<%=request.getContextPath()%>/list" class="nav-link">Users</a></li>
	</ul>
	</nav> </header>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<caption>
					<h2>
						<c:if test="${product != null}">
            			Add product to cart
            		</c:if>
					</h2>
				</caption>

				<c:if test="${product != null}">
					<input type="hidden" name="id"
						value="<c:out value='${product.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>product Name</label> <input type="text"
						value="<c:out value='${product.productName}' />"
						class="form-control" name="name" required="required">
				</fieldset>
				<fieldset class="form-group">
					<label>product Price</label> <input type="text"
						value="<c:out value='${product.productPrice}' />"
						class="form-control" name="price">
				</fieldset>
				<fieldset class="form-group">
					<label>product Price</label> <input type="text"
						value="<c:out value='${product.quantity}' />"
						class="form-control" name="quantity">
				</fieldset>
				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>