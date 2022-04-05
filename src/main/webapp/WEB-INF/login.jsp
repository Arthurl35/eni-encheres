<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<h1>CONNECTION</h1>
		<c:if test="${model.message != null}">
			<p>${model.message}</p>
		</c:if>
		<a href="RegisterServlet">Pas encore inscrit ?</a>
		<form action="LoginServlet" method="post">
			<input type="text" name="pseudo"/>
			<input type="password" name="pass"/>
			<input type="submit" name="BT_VALID"/>
		</form>
	</body>
</html>