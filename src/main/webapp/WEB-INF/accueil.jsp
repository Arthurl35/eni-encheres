<%@ include file="head.jsp"%>
<body>

	<br>

	<section class="search-sec mt-4">
		<div class="container ">
			<h1>Filtres :</h1>
			<form action="#" method="post" novalidate="novalidate" name="myForm">
				<div class="row mb-5">
					<div>
						<div class="row">
							<div class="col-lg-3 col-md-3 col-sm-12 p-0">
								<input type="text" class="form-control search-slt"
									placeholder="Rechercher">
							</div>
							<div class="col-lg-3 col-md-3 col-sm-12 p-0">
								<select class="form-control search-slt">
									<option>Toutes</option>

									<c:forEach items="${model2.lstCategories}" var="categorie">
										<option>${categorie.libelle}</option>
									</c:forEach>
								</select>
							</div>
							<div class="col-lg-3 col-md-3 col-sm-12 p-0">
								<button type="button" class="btn btn-dark bg-dark">Rechercher</button>
							</div>
						</div>
					</div>
				</div>
				<!-- Achats -->		
<div class="form-check mb-3" id="achat">
  <input class="form-check-input inputradio" type="radio" name="exampleRadios" onclick="ShowHideDiv1()" id="exampleRadios1" value="option1" checked>
  <label class="form-check-label" for="exampleRadios1">
    Achats
  </label>
  <div class="form-check checkachat">
	  <input class="form-check-input check-achat" type="checkbox" value="" id="defaultCheck1" >
	  <label class="form-check-label" for="defaultCheck1">
	    ench�res ouvertes
	  </label>
	</div>
	<div class="form-check checkachat">
	  <input class="form-check-input check-achat" type="checkbox" value="" id="defaultCheck2" >
	  <label class="form-check-label" for="defaultCheck1">
	    mes ench�res en cours
	  </label>
	</div>
	<div class="form-check checkachat">
	  <input class="form-check-input check-achat" type="checkbox" value="" id="defaultCheck3" >
	  <label class="form-check-label" for="defaultCheck1">
	    mes ench�res remport�es
	  </label>
	</div>
</div>

<!-- Mes ventes -->
<div class="form-check check" id="vente">
  <input class="form-check-input inputradio" type="radio" name="exampleRadios" onclick="ShowHideDiv2()" id="exampleRadios2" value="option2">
  <label class="form-check-label" for="exampleRadios2">
    Mes ventes
  </label>
	  <div class="form-check checkvente">
	  <input class="form-check-input check-vente" type="checkbox" value="" id="defaultCheck4" disabled>
	  <label class="form-check-label" for="defaultCheck1">
	    mes ventes en cours
	  </label>
	</div>
	<div class="form-check checkvente">
	  <input class="form-check-input check-vente" type="checkbox" value="" id="defaultCheck5" name="myRadios" disabled>
	  <label class="form-check-label" for="defaultCheck1">
	    ventes non d�but�es
	  </label>
	</div>
	<div class="form-check checkvente">
	  <input class="form-check-input check-vente" type="checkbox" value="" id="defaultCheck6" name="myRadios" value="achat" disabled>
	  <label class="form-check-label" for="defaultCheck1">
	    ventes termin�es
	  </label>
	</div>
</div>
			</form>

	</section>
	
	<%@ include file="getArticle.jsp"%>
</body>
 <script>

const check1 = document.getElementById('defaultCheck1');
const check2 = document.getElementById('defaultCheck2');
const check3 = document.getElementById('defaultCheck3');
const check4 = document.getElementById('defaultCheck4');
const check5 = document.getElementById('defaultCheck5');
const check6 = document.getElementById('defaultCheck6');

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