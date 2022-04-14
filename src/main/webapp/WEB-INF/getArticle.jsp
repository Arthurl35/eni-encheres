<section class="row m-5">
	<h2>Les Articles</h2>
	<c:forEach items="${model.lstArticles}" var="articleVendu">
		<article class="article d-flex flex-column align-items-center col-lg-4 col-md-6 col-sm-12 m-5">
			<header class="d-flex flex-column align-items-center">
				<h3>${articleVendu.nomArticle}</h3>
			</header>
			<div class="w-100 d-flex flex-column align-items-start">
				<c:if test="${articleVendu.etatVente == 1}">
					<p>OUVERT</p>
				</c:if>
				<c:if test="${articleVendu.etatVente == 2}">
					<p>FERMÉ</p>
				</c:if>
				<c:if test="${articleVendu.etatVente == 0}">
					<p>A VENIR</p>
				</c:if>
				<p><span>catégorie : </span>${articleVendu.categorie.libelle}</p>
				<p><span>Vendeur : </span>${articleVendu.utilisateur.pseudo}</p>
				<ul>
					<li><span>descripton : </span>${articleVendu.description}</li>
					<li><span>Mise à prix : </span>${articleVendu.miseAPrix}</li>
					<li><span>date début : </span>${articleVendu.dateDebutEncheres}</li>
					<li><span>date fin : </span>${articleVendu.dateFinEncheres}</li>
				</ul>
			</div>
			<c:if test="${articleVendu.etatVente == 1}">
					<a href="EncheresServlet?idArticle=${articleVendu.noArticle}" class="btn btn-primary">Enchérir</a>
				</c:if>
				<c:if test="${articleVendu.etatVente == 2}">
					<p>VENDU pour : ${articleVendu.prixVente == 2}</p>
				</c:if>
		</article>
	</c:forEach>
</section>