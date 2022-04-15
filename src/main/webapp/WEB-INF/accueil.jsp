<%@ include file="head.jsp"%>
<body>

	<br>

	<section class="search-sec mt-4">
		<div class="container ">
			<h1>Filtres :</h1>
			<form action="" method="post" novalidate="novalidate">
				<div class="row mb-5">
					<div>
						<div class="row">
							<div class="col-lg-3 col-md-3 col-sm-12 p-0">
								<input name="search" type="text" class="form-control search-slt"
									placeholder="Rechercher">
							</div>
							<div class="col-lg-3 col-md-3 col-sm-12 p-0">
								<select class="form-control search-slt" name="choixCategorie">
									<option value="0" selected>Toutes</option>

									<c:forEach items="${model2.lstCategories}" var="categorie">
										<option value="${categorie.id}">${categorie.libelle}</option>
									</c:forEach>
								</select>
							</div>
							<div class="col-lg-3 col-md-3 col-sm-12 p-0">
								<button type="submit" name="BTN_SEARCH" class="btn btn-dark bg-dark">Rechercher</button>
							</div>
						</div>
					</div>
				</div>
<c:if test="${sessionScope.user != null}">
				<!-- Achats -->		
<div class="form-check mb-3" id="achat">
  <input class="form-check-input inputradio" type="radio" name="radios" onclick="ShowHideDiv1()" id="radiosAchat" value="achat" checked>
  <label class="form-check-label" for="exampleRadios1">
    Achats
  </label>
  <div class="form-check checkachat">
	  <input class="form-check-input check-achat" type="checkbox" name="boxAchatOuvert" value="ouvert" id="boxAchatOuvert" >
	  <label class="form-check-label" for="defaultCheck1">
	    enchères ouvertes
	  </label>
	</div>
	<div class="form-check checkachat">
	  <input class="form-check-input check-achat" type="checkbox" name="boxAchatEncours" value="encours" id="boxAchatEncours" >
	  <label class="form-check-label" for="defaultCheck1">
	    mes enchères en cours
	  </label>
	</div>
	<div class="form-check checkachat">
	  <input class="form-check-input check-achat" type="checkbox" name="boxAchatRemporte" value="remporte" id="boxAchatRemporte" >
	  <label class="form-check-label" for="defaultCheck1">
	    mes enchères remportées
	  </label>
	</div>
</div>

<!-- Mes ventes -->
<div class="form-check check" id="vente">
  <input class="form-check-input inputradio" type="radio" name="radios" onclick="ShowHideDiv2()" id="radiosVente" value="vente">
  <label class="form-check-label" for="exampleRadios2">
    Mes ventes
  </label>
	  <div class="form-check checkvente">
	  <input class="form-check-input check-vente" type="checkbox" name="boxVenteEncours" value="encours" id="boxVenteEncours" disabled>
	  <label class="form-check-label" for="defaultCheck1">
	    mes ventes en cours
	  </label>
	</div>
	<div class="form-check checkvente">
	  <input class="form-check-input check-vente" type="checkbox" name="boxVenteNondebute" value="nondebute" id="boxVenteNondebute" name="myRadios" disabled>
	  <label class="form-check-label" for="defaultCheck1">
	    ventes non débutées
	  </label>
	</div>
	<div class="form-check checkvente">
	  <input class="form-check-input check-vente" type="checkbox" name="boxVenteTermine" value="termine" id="boxVenteTermine" name="myRadios" value="achat" disabled>
	  <label class="form-check-label" for="defaultCheck1">
	    ventes terminées
	  </label>
	</div>
</div>
<button type="submit" name="filtrer" class="btn btn-primary">Filtrer</button>	
</c:if>
	
</form>

	</section>
	
</body>
 <script>

const check1 = document.getElementById('boxAchatOuvert');
const check2 = document.getElementById('boxAchatEncours');
const check3 = document.getElementById('boxAchatRemporte');
const check4 = document.getElementById('boxVenteEncours');
const check5 = document.getElementById('boxVenteNondebute');
const check6 = document.getElementById('boxVenteTermine');

function ShowHideDiv1(){

	check4.setAttribute('disabled', '');
	check5.setAttribute('disabled', '');
	check6.setAttribute('disabled', '');

	
	check1.removeAttribute('disabled');
	check2.removeAttribute('disabled');
	check3.removeAttribute('disabled');
	}
function ShowHideDiv2(){	

	check1.setAttribute('disabled', '');
	check2.setAttribute('disabled', '');
	check3.setAttribute('disabled', '');

	check4.removeAttribute('disabled');
	check5.removeAttribute('disabled');
	check6.removeAttribute('disabled');
	}




</script> 
</html>