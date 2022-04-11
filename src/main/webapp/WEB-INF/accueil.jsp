<%@ include file="head.jsp"%>
<body>

	<br>

	<section class="search-sec mt-4">
		<div class="container ">
			<h1>Filtres :</h1>
			<form action="#" method="post" novalidate="novalidate" name="myForm">
				<div class="row">
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
<div class="form-check">
  <input class="form-check-input" type="radio" name="exampleRadios" id="exampleRadios1" value="option1" checked>
  <label class="form-check-label" for="exampleRadios1">
    Achats
  </label>
  <div class="form-check">
	  <input class="form-check-input" type="checkbox" value="" id="defaultCheck1">
	  <label class="form-check-label" for="defaultCheck1">
	    enchéres ouvertes
	  </label>
	</div>
	<div class="form-check">
	  <input class="form-check-input" type="checkbox" value="" id="defaultCheck1">
	  <label class="form-check-label" for="defaultCheck1">
	    mes enchères en cours
	  </label>
	</div>
	<div class="form-check">
	  <input class="form-check-input" type="checkbox" value="" id="defaultCheck1">
	  <label class="form-check-label" for="defaultCheck1">
	    mes enchères remportées
	  </label>
	</div>
</div>

<!-- Mes ventes -->
<div class="form-check">
  <input class="form-check-input" type="radio" name="exampleRadios" id="exampleRadios2" value="option2">
  <label class="form-check-label" for="exampleRadios2">
    Mes ventes
  </label>
	  <div class="form-check">
	  <input class="form-check-input" type="checkbox" value="" id="defaultCheck1">
	  <label class="form-check-label" for="defaultCheck1">
	    mes ventes en cours
	  </label>
	</div>
	<div class="form-check">
	  <input class="form-check-input" type="checkbox" value="" id="defaultCheck1" name="myRadios">
	  <label class="form-check-label" for="defaultCheck1">
	    ventes non débutées
	  </label>
	</div>
	<div class="form-check">
	  <input class="form-check-input" type="checkbox" value="" id="defaultCheck1" name="myRadios" value="achat">
	  <label class="form-check-label" for="defaultCheck1">
	    ventes terminées
	  </label>
	</div>
	
</div>
			</form>

	</section>



</body>
 <script>
 var rad = document.myForm.myRadios;
 var prev = null;
 for (var i = 0; i < rad.length; i++) {
     rad[i].addEventListener('change', function() {
         (prev) ? console.log(prev.value): null;
         if (this !== prev) {
             prev = this;
         }
         console.log(this.value)
     });
 }

</script> 
</html>