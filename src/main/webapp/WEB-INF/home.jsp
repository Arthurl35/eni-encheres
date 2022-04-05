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
		<h1>ENCHÈRE</h1>
		<c:if test="${model.pseudo == null}">
			<a href="LoginServlet">Connection</a>
			<a href="RegisterServlet">Inscription</a>
		</c:if>
		<c:if test="${model.pseudo != null}">
			<form action="" method="post">
				<button type="submit" name="BT_LOGOUT">Se déconnecter</button>
			</form>
			<p>${model.pseudo}</p>
		</c:if>
		
	</body>
</html>