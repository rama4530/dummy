<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Products Details</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<form method="post" action="insert">
		Product Id		:	<input type="text" name="productId"><br>
		Product Name	:	<input type="text" name="productName"><br>
		Description		:	<input type="text" name="productDesc"><br>
		Price			:	<input type="text" name="productPrice"><br>
		 <input	type="submit" />
	</form>
</body>
</html>