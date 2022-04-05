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
		<form action="LoginServlet" method="post">
			<label for="pseudo">Pseudo :</label>
			<input type="text" name="pseudo"/>
			<label for="name">Nom :</label>
			<input type="text" name="name"/>
			<label for="surname">Prénom :</label>
			<input type="text" name="surname"/>
			<label for="mail">Email :</label>
			<input type="email" name="mail"/>
			<label for="tel">Téléphone :</label>
			<input type="tel" name="tel"/>
			<label for="street">Rue :</label>
			<input type="text" name="street"/>
			<label for="cp">Code postal :</label>
			<input type="text" name="cp"/>
			<label for="city">Ville :</label>
			<input type="text" name="city"/>
			<label for="pass">Mot de passe :</label>
			<input type="password" name="pass"/>
			<label for="pass-confirm">Confirmation :</label>
			<input type="password" name="pass-confirm"/>
			
			<button type="submit" name="BT_VALID" value="Créer"></button>
			<button type="submit" name="BT_ANNUL" value="Annuler"></button>
		</form>
		<p>Déjà inscrit ? <a href="LoginServlet">Se connecter</a></p>
	</body>
</html>