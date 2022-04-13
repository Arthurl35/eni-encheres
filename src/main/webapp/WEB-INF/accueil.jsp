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
<div class="form-check mb-3">
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
<div class="form-check check">
  <input class="form-check-input inputradio" type="radio" name="exampleRadios" onclick="ShowHideDiv2()" id="exampleRadios2" value="option2">
  <label class="form-check-label" for="exampleRadios2">
    Mes ventes
  </label>
	  <div class="form-check checkvente">
	  <input class="form-check-input check-vente" type="checkbox" value="" id="defaultCheck4" >
	  <label class="form-check-label" for="defaultCheck1">
	    mes ventes en cours
	  </label>
	</div>
	<div class="form-check checkvente">
	  <input class="form-check-input check-vente" type="checkbox" value="" id="defaultCheck5" name="myRadios" >
	  <label class="form-check-label" for="defaultCheck1">
	    ventes non d�but�es
	  </label>
	</div>
	<div class="form-check checkvente">
	  <input class="form-check-input check-vente" type="checkbox" value="" id="defaultCheck6" name="myRadios" value="achat">
	  <label class="form-check-label" for="defaultCheck1">
	    ventes termin�es
	  </label>
	</div>
</div>
			</form>

	</section>
</body>
 <script>
var elts = document.querySelectorAll('.inputradio');
const check1 = document.getElementById('defaultCheck1');
const check2 = document.getElementById('defaultCheck2');
const check3 = document.getElementById('defaultCheck3');
const check4 = document.getElementById('defaultCheck4');
const check5 = document.getElementById('defaultCheck5');
const check6 = document.getElementById('defaultCheck6');

for (var i = 0; i < elts.length; i++) {
	if ( elts[i].checked === true )
		
	break;
}
console.log('value => '+elts[i].value);
function ShowHideDiv1(){
		check1.setAttribute("id", 'flexRadioDisabled');
		check2.setAttribute("id", 'flexRadioDisabled');
		check3.setAttribute("id", 'flexRadioDisabled');
		

	
		console.log('je passe par la');
	}
function ShowHideDiv2(){	
	check1.setAttribute("id", 'flexRadioDisabled');
	check2.setAttribute("id", 'flexRadioDisabled');
	check3.setAttribute("id", 'flexRadioDisabled');
	
		console.log('je passe ici');
	}




</script> 
</html>