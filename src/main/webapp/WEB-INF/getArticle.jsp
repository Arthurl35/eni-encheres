<section class="row m-5">
	<h2>Les Articles</h2>
	<c:forEach items="${model.lstArticles}" var="articleVendu">
		
		<div class="card text-white bg-dark mb-3 me-5" style="max-width: 18rem;">
			<div class="card-header m-auto"><h3>${articleVendu.nomArticle}</h3></div>
			<div class="card-body">
		<h5 class="card-title"><c:if test="${articleVendu.etatVente == 1}">
					<p class="text-success">OUVERT</p>
				</c:if>
				<c:if test="${articleVendu.etatVente == 2}">
					<p class="text-danger">FERMÉ</p>
				</c:if>
				<c:if test="${articleVendu.etatVente == 0}">
					<p class="text-warning">A VENIR</p>
				</c:if></h5>
				<p class="card-text"><div class="w-100 d-flex flex-column align-items-start">
				
				<p><span>catégorie : </span>${articleVendu.categorie.libelle}</p>
				<p><span>Vendeur : </span>${articleVendu.utilisateur.pseudo}</p>
				<ul>
					<li><span>descripton : </span>${articleVendu.description}</li>
					<li><span>Mise à prix : </span>${articleVendu.miseAPrix}</li>
					<li><span>date début : </span>${articleVendu.dateDebutEncheres}</li>
					<li><span>date fin : </span>${articleVendu.dateFinEncheres}</li>
				</ul>
			</div></p>
			
			<c:if test="${articleVendu.etatVente == 1}">
					<a href="EncheresServlet?idArticle=${articleVendu.noArticle}" class="btn btn-primary">Enchérir</a>
				</c:if>
				<c:if test="${articleVendu.etatVente == 2}">
					<p>VENDU pour : ${articleVendu.prixVente == 2}</p>
				</c:if>
					</div>
</div>
		
	</c:forEach>
</section>



	
		
