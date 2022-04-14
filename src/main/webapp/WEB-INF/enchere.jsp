<%@ include file="head.jsp" %>
	<body>
		<%@ include file="nav.jsp" %>
		
		<section>
				<div class="card text-white bg-dark m-5" style="max-width: 35rem;">
  				<div class="card-header m-auto">${model.article.nomArticle}</div>
  				<div class="card-body">
    			<h5 class="card-title"><span>Catégorie : </span>${model.article.categorie.libelle}</h5>
    			<p class="card-text"><p><span>Vendeur : </span>${model.article.utilisateur.pseudo}</p>
				<ul>
					<li><span>descripton : </span>${model.article.description}</li>
					<li><span>Mise à prix : </span>${model.article.miseAPrix}</li>
					<li><span>date début : </span>${model.article.dateDebutEncheres}</li>
					<li><span>date fin : </span>${model.article.dateFinEncheres}</li>
				</ul></p>
  				</div>
				</div>
		</section>
		<section>
		<form method="POST">
			<section class="search-sec">
		<div class="container ms-5">
			<h1>Proposer une offre :</h1>
			<c:if test="${model.message != true}">
				<p>${model.message}</p>
			</c:if>
			<form action="" method="post" novalidate="novalidate">
				<div class="row mb-5">
					<div>
						<div class="row ms-auto">
							<div class="col-lg-1 col-md-3 col-sm-12 p-0">
								<input type="number" name="montant" class="form-control search-slt"
									placeholder="Montant">
							</div>
									<div class="col-lg-1 col-md-3 col-sm-12 p-0">
								<button type="submit" class="btn btn-dark bg-dark" name ="BT_OFFRE">Enchérir</button>
							</div>
						</div>
					</div>
				</div>
		</form>
	</section>
		<section>
			<h4 class="ms-5 ">Historique Enchère</h4>
			<div class="row">
			<c:forEach items="${model.lstEncheres}" var="enchere">
				<div class="card text-white bg-dark m-5 col" style="max-width: 18rem;">
  				<div class="card-header m-auto">Enchères</div>
  				<div class="card-body">
    			<h5 class="card-title">${enchere.utilisateur.pseudo}</h5>
    			<p class="card-text"><p><span>Date : </span>${enchere.date_enchere}</p>
					<p><span>Montant : </span>${enchere.montant_enchere}</p>
  				</div>
				</div>				
			</c:forEach>
			</div>
		</section>
	</body>
</html>