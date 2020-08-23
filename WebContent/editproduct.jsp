<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Product Details</title>
</head>
<body>
<body>
<jsp:include page="header.jsp" />
	<form method="post" action="update">
		Product Id   : <input type="text" name="productId" value='${product.id}'>
		Product Name : <input type="text" name="productName"><br>
		Description 	: <input type="text" name="productDesc"><br>	
		Price			: <input type="text" name="productPrice"><br>
						  <input type="submit" name="submit" value="Submit">
	</form>
<%-- <%getServletContext().getRequestDispatcher("/welcome.jsp").forward(request, response); %> --%>
</body>

</html>