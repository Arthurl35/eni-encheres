<section class="row m-5">
	<h2>Les Articles</h2>
	<c:forEach items="${model.lstArticles}" var="articleVendu">
		<article class="article d-flex flex-column align-items-center col-lg-4 col-md-6 col-sm-12 m-5">
			<header>
				<h3>${articleVendu.nomArticle}</h3>
			</header>
			<div class="w-100 d-flex flex-column align-items-start">
				<c:if test="${articleVendu.etatVente != 1}">
					<p>En Vente</p>
				</c:if>
				<c:if test="${articleVendu.etatVente == 1}">
					<p>Vendu !</p>
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
		</article>
	</c:forEach>
</section>