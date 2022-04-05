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
		<h1>INSCRIPTION</h1>
		<c:if test="${model.mess != null}">
			<p>${model.mess}</p>
		</c:if>
		<form action="RegisterServlet" method="post">
			<label for="pseudo">Pseudo :</label>
			<input type="text" name="pseudo" value="${model.pseudo}"/>
			<label for="name">Nom :</label>
			<input type="text" name="name" value="${model.nom}"/>
			<label for="surname">Prénom :</label>
			<input type="text" name="surname" value="${model.prenom}"/>
			<label for="mail">Email :</label>
			<input type="email" name="mail" value="${model.email}"/>
			<label for="tel">Téléphone :</label>
			<input type="tel" name="tel" value="${model.telephone}"/>
			<label for="street">Rue :</label>
			<input type="text" name="street" value="${model.rue}"/>
			<label for="cp">Code postal :</label>
			<input type="text" name="cp" value="${model.code_postal}"/>
			<label for="city">Ville :</label>
			<input type="text" name="city" value="${model.ville}"/>
			<label for="pass">Mot de passe :</label>
			<input type="password" name="pass" value="${model.mot_de_passe}"/>
			<label for="pass-confirm">Confirmation :</label>
			<input type="password" name="pass-confirm" value="${model.mot_de_passe_confirm}"/>
			
			<button type="submit" name="BT_VALID">Créer</button>
			<button type="submit" name="BT_ANNUL">Annuler</button>
		</form>

	</body>
</html>