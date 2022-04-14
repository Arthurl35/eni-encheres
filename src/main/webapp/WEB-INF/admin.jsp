<%@ include file="head.jsp"%>

<body>
	<%@ include file="nav.jsp"%>





	<table class="table table-borderless">

		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">Pseudo</th>
				<th scope="col">Nom</th>
				<th scope="col">Prenom</th>
				<th scope="col">Email</th>
				<th scope="col">Téléphone</th>
				<th scope="col">Rue</th>
				<th scope="col">Code Postal</th>
				<th scope="col">Ville</th>
				<th scope="col">Supprimer</th>
				<th scope="col">Désactiver</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${model.lstUtilisateurs}" var="utilisateur">


				<tr class="table-active">
					<td>${utilisateur.id}</td>
					<td>${utilisateur.pseudo}</td>
					<td>${utilisateur.nom}</td>
					<td>${utilisateur.prenom}</td>
					<td>${utilisateur.email}</td>
					<td>${utilisateur.telephone}</td>
					<td>${utilisateur.rue}</td>
					<td>${utilisateur.code_postal}</td>
					<td>${utilisateur.ville}</td>
					<td>
						<form action="AdminServlet" method="post" name="formSaisie">
							<input type="hidden" name="id_utilisateur"
								value="${utilisateur.id}">
							<button class="btn btn-outline-danger" type="submit" name="BT_SUPP_admin">
						 <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
							fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
  <path
								d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z" />
  <path fill-rule="evenodd"
								d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z" />
</svg>
						</button></form>
					</td>

					<td><div class="form-check form-switch">
							<form action="AdminServlet" method="post">
								<input type="hidden" name="id_utilisateur"
									value="${utilisateur.id}"> 
									
								<input type="checkbox"
									class="make-switch" id="price_check_${utilisateur.id}" name="pricing"
									data-on-color="primary" data-off-color="info"
									onclick="switchUtilisateur('${utilisateur.id}')">
							</form>
						</div>
					</td>
				</tr>

			</c:forEach>
		</tbody>

	</table>
	<c:if test="${model.message != null}">
		<p>${model.message}</p>
	</c:if>



	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-switch/3.3.4/js/bootstrap-switch.min.js"></script>
	<script type="text/javascript">
		function switchUtilisateur(idUtilisateur) {
		   
		alert(idUtilisateur);
			console.log("switchUtilisateur=".idUtilisateur);
// 		$('.make-switch').bootstrapSwitch('state');
// 		$('.make-switch').on('switchChange.bootstrapSwitch', function() {
// 			var check = $('.bootstrap-switch-on');

// 			var $status;

// 			if (check.length > 0) {

// 				$status = "ON";
// 				console.log($status)
// 			} else {
// 				$status = "OFF";
// 				console.log($status)
// 			}

// 			$('#price_check'.idUtilisateur).val($status);
// 		});

// 		console.log("test");
		}
	</script>



</body>
</html>