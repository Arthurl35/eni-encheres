
<%@ include file="head.jsp" %>
	<body>
		<h1>ENCH�RE</h1>
		<c:if test="${model.pseudo == null}">
			<a href="LoginServlet">Connection</a>
			<a href="RegisterServlet">Inscription</a>
		</c:if>
		<c:if test="${model.pseudo != null}">
			<form action="" method="post">
				<button type="submit" name="BT_LOGOUT">Se d�connecter</button>
			</form>
			<p>${model.pseudo}</p>
		</c:if>
		
	</body>
</html>