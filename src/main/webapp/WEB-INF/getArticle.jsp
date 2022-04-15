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
				
				<c:if test="${articleVendu.categorie.libelle == 'Informatique'}">
				<div class="row">
				<p class="col-6 me-3 w-100"><span>catégorie : </span>${articleVendu.categorie.libelle}</p>
				<div class="border border-dark col-6 ms-5 text-center"><svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-laptop" viewBox="0 0 16 16"><path d="M13.5 3a.5.5 0 0 1 .5.5V11H2V3.5a.5.5 0 0 1 .5-.5h11zm-11-1A1.5 1.5 0 0 0 1 3.5V12h14V3.5A1.5 1.5 0 0 0 13.5 2h-11zM0 12.5h16a1.5 1.5 0 0 1-1.5 1.5h-13A1.5 1.5 0 0 1 0 12.5z"/></svg></div>
				</div>
				</c:if>
				
				<c:if test="${articleVendu.categorie.libelle == 'Vêtement'}">
				<div class="row">
				<p class="col me-3 w-100"><span>catégorie : </span>${articleVendu.categorie.libelle}</p>
				<div class="border border-dark col ms-5 text-center"><svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-watch" viewBox="0 0 16 16"><path d="M8.5 5a.5.5 0 0 0-1 0v2.5H6a.5.5 0 0 0 0 1h2a.5.5 0 0 0 .5-.5V5z"/><path d="M5.667 16C4.747 16 4 15.254 4 14.333v-1.86A5.985 5.985 0 0 1 2 8c0-1.777.772-3.374 2-4.472V1.667C4 .747 4.746 0 5.667 0h4.666C11.253 0 12 .746 12 1.667v1.86a5.99 5.99 0 0 1 1.918 3.48.502.502 0 0 1 .582.493v1a.5.5 0 0 1-.582.493A5.99 5.99 0 0 1 12 12.473v1.86c0 .92-.746 1.667-1.667 1.667H5.667zM13 8A5 5 0 1 0 3 8a5 5 0 0 0 10 0z"/></svg></div>
				</div>
				</c:if>
				
				<c:if test="${articleVendu.categorie.libelle == 'Ameublement'}">
				<div class="row">
				<p class="col me-3 w-100"><span>catégorie : </span>${articleVendu.categorie.libelle}</p>
				<div class="border border-dark col ms-5 text-center"><svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-lamp" viewBox="0 0 16 16"><path fill-rule="evenodd" d="M5.04.303A.5.5 0 0 1 5.5 0h5c.2 0 .38.12.46.303l3 7a.5.5 0 0 1-.363.687h-.002c-.15.03-.3.056-.45.081a32.731 32.731 0 0 1-4.645.425V13.5a.5.5 0 1 1-1 0V8.495a32.753 32.753 0 0 1-4.645-.425c-.15-.025-.3-.05-.45-.08h-.003a.5.5 0 0 1-.362-.688l3-7ZM3.21 7.116A31.27 31.27 0 0 0 8 7.5a31.27 31.27 0 0 0 4.791-.384L10.171 1H5.83L3.209 7.116Z"/><path d="M6.493 12.574a.5.5 0 0 1-.411.575c-.712.118-1.28.295-1.655.493a1.319 1.319 0 0 0-.37.265.301.301 0 0 0-.052.075l-.001.004-.004.01V14l.002.008a.147.147 0 0 0 .016.033.62.62 0 0 0 .145.15c.165.13.435.27.813.395.751.25 1.82.414 3.024.414s2.273-.163 3.024-.414c.378-.126.648-.265.813-.395a.62.62 0 0 0 .146-.15.148.148 0 0 0 .015-.033L12 14v-.004a.301.301 0 0 0-.057-.09 1.318 1.318 0 0 0-.37-.264c-.376-.198-.943-.375-1.655-.493a.5.5 0 1 1 .164-.986c.77.127 1.452.328 1.957.594C12.5 13 13 13.4 13 14c0 .426-.26.752-.544.977-.29.228-.68.413-1.116.558-.878.293-2.059.465-3.34.465-1.281 0-2.462-.172-3.34-.465-.436-.145-.826-.33-1.116-.558C3.26 14.752 3 14.426 3 14c0-.599.5-1 .961-1.243.505-.266 1.187-.467 1.957-.594a.5.5 0 0 1 .575.411Z"/></svg></div>
				</div>
				</c:if>
				
				<c:if test="${articleVendu.categorie.libelle == 'Sport & Loisirs'}">
				<div class="row">
				<p class="col me-3 w-100"><span>catégorie : </span>${articleVendu.categorie.libelle}</p>
				<div class="border border-dark col ms-5 text-center"><svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-trophy" viewBox="0 0 16 16"><path d="M2.5.5A.5.5 0 0 1 3 0h10a.5.5 0 0 1 .5.5c0 .538-.012 1.05-.034 1.536a3 3 0 1 1-1.133 5.89c-.79 1.865-1.878 2.777-2.833 3.011v2.173l1.425.356c.194.048.377.135.537.255L13.3 15.1a.5.5 0 0 1-.3.9H3a.5.5 0 0 1-.3-.9l1.838-1.379c.16-.12.343-.207.537-.255L6.5 13.11v-2.173c-.955-.234-2.043-1.146-2.833-3.012a3 3 0 1 1-1.132-5.89A33.076 33.076 0 0 1 2.5.5zm.099 2.54a2 2 0 0 0 .72 3.935c-.333-1.05-.588-2.346-.72-3.935zm10.083 3.935a2 2 0 0 0 .72-3.935c-.133 1.59-.388 2.885-.72 3.935zM3.504 1c.007.517.026 1.006.056 1.469.13 2.028.457 3.546.87 4.667C5.294 9.48 6.484 10 7 10a.5.5 0 0 1 .5.5v2.61a1 1 0 0 1-.757.97l-1.426.356a.5.5 0 0 0-.179.085L4.5 15h7l-.638-.479a.501.501 0 0 0-.18-.085l-1.425-.356a1 1 0 0 1-.757-.97V10.5A.5.5 0 0 1 9 10c.516 0 1.706-.52 2.57-2.864.413-1.12.74-2.64.87-4.667.03-.463.049-.952.056-1.469H3.504z"/></svg></div>
				</div>
				</c:if>
				
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
					<p>VENDU pour : ${articleVendu.prixVente}</p>
					<p>A : ${articleVendu.utilisateurWin.pseudo}</p>
				</c:if>
					</div>
</div>
		
	</c:forEach>
</section>



	
		
