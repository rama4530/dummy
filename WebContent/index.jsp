<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Corona Home page</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<form action="">

		<input type="button" value="Admin login"
			onClick="JavaScript:window.location='loginPage.jsp';"> <input
			type="button" value="Add New User"
			onClick="JavaScript:window.location='addnewuser.jsp';">

	</form>
</body>
</html>