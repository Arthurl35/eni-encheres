<%@ include file="head.jsp" %>
	<body>
		<%@ include file="nav.jsp" %>
		
		<section>
			<article class="article d-flex flex-column align-items-center m-5">
			<header>
				<h3>${model.article.nomArticle}</h3>
			</header>
			<div class="w-100 d-flex flex-column align-items-start">
				
				<p><span>catégorie : </span>${model.article.categorie.libelle}</p>
				<p><span>Vendeur : </span>${model.article.utilisateur.pseudo}</p>
				<ul>
					<li><span>descripton : </span>${model.article.description}</li>
					<li><span>Mise à prix : </span>${model.article.miseAPrix}</li>
					<li><span>date début : </span>${model.article.dateDebutEncheres}</li>
					<li><span>date fin : </span>${model.article.dateFinEncheres}</li>
				</ul>
			</div>
			</article>
		</section>
		<section>
		<form method="POST">
			<h4>Proposer une offre :</h4>
			<c:if test="${model.message != true}">
				<p>${model.message}</p>
			</c:if>
			<label for="montant">Montant :</label> <input type="number"
				name="montant" />
			<button type="submit" name="BT_OFFRE">Enchérir</button>
		</form>
	</section>
		<section>
			<h4>Historique Enchère</h4>
			<c:forEach items="${model.lstEncheres}" var="enchere">
				<div>
					<h5>${enchere.utilisateur.pseudo }</h5>
					<p><span>Date : </span>${enchere.date_enchere}</p>
					<p><span>Montant : </span>${enchere.montant_enchere}</p>
				</div>
			</c:forEach>
		</section>
	</body>
</html>