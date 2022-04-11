<%@ include file="head.jsp"%>

<body>
	<%@ include file="nav.jsp"%>
	<section>
		<form action="ArticlesServlet" method="post">
			<div class="container py-5 h-100">
				<div
					class="row d-flex  h-100 justify-content-center align-items-center">
					<div class="col-12 col-md-8 col-lg-6 col-xl-5"
						style="width: 800px;">
						<div class="card bg-dark text-white" style="border-radius: 1rem;">
							<div class="card-body p-5 text-center">
								<div class="mb-md-5 mt-md-4 pb-5">
									<h2 class="fw-bold mb-2 text-uppercase mb-4">Nouvelle
										vente</h2>

									<div class="form-outline form-white mb-4">
										<label class="form-label" for="article">Article :</label> <input
											type="text" name="article"
											class="form-control form-control-lg"
											value="${model2.nomArticle}" />
									</div>

									<div class="row justify-content-md-center">
										<div class="form-outline form-white mb-4 col">
											<label class="form-label" for="description">Description
												:</label> <input type="text" name="description"
												class="form-control form-control-lg"
												value="${model2.description}" />
										</div>
									</div>

									<div class="form-outline form-white mb-4">
									<label class="form-label">Catégories :</label>
										<select class="form-control search-slt">
											<option>--Choisissez votre catégorie--</option>

											<c:forEach items="${model3.lstCategories}" var="categorie">
												<option value="${categorie.libelle}">${categorie.libelle}</option>
											</c:forEach>
										</select>
									</div>


									<div class="form-outline form-white mb-4">
										<label class="form-label" for="miseAPrix">Mise à prix</label>
										<input type="number" name="miseAPrix"
											class="form-control form-control-lg"
											value="${model2.miseAPrix}" />
									</div>
									<div class="row">
										<div class="form-outline form-white mb-4 col">
											<label class="form-label" for="dateDebutEncheres">Début
												de l'enchère</label> <input type="date" name="dateDebutEncheres"
												class="form-control form-control-lg"
												value="${model2.dateDebutEncheres}" />
										</div>
										<div class="form-outline form-white mb-4 col">
											<label class="form-label" for="dateFinEncheres">Fin
												de l'enchère :</label> <input type="date" name="dateFinEncheres"
												class="form-control form-control-lg"
												value="${model2.dateFinEncheres}" />
										</div>
									</div>
									<div class="form-outline form-white mb-4">
										<label class="form-label" for="street">Rue :</label> <input
											type="text" name="street"
											class="form-control form-control-lg"
											value="${user.rue}" />
									</div>
									<div class="form-outline form-white mb-4 col">
										<label class="form-label" for="cp">Code Postal :</label> <input
											type="text" name="cp" class="form-control form-control-lg"
											value="${user.code_postal}" />
									</div>
									<div class="form-outline form-white mb-4 col">
										<label class="form-label" for="city">Ville :</label> <input
											type="text" name="city" class="form-control form-control-lg"
											value="${user.ville}" />
									</div>

									<button class="btn btn-outline-light btn-lg px-5" type="submit"
										name="BT_VALID">CrÃ©er</button>
									<a href="HomeServlet" class="btn btn-outline-light btn-lg px-5">Annuler</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>
	</section>
</body>
</html>