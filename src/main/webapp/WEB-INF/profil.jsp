<%@ include file="head.jsp" %>
<%@ include file="nav.jsp"%>
	<body>
<c:if test="${sessionScope.user == null}">
			<a href="LoginServlet">Connection</a>
			<a href="RegisterServlet">Inscription</a>
	</c:if>
	<c:if test="${sessionScope.user != null}">
			<div class="container py-5 h-100" >
    <div class="row d-flex  h-100 justify-content-center align-items-center" >
      <div class="col-12 col-md-8 col-lg-6 col-xl-5"  style="width: 800px;">
        <div class="card bg-dark text-white" style="border-radius: 1rem;">
          <div class="card-body p-5 text-center">
            <div class="mb-md-5 mt-md-4 pb-5">
              <h2 class="fw-bold mb-2 text-uppercase mb-4">Profil</h2>
     


           	         <div class="form-outline form-white mb-4">
           	         Pseudo: ${sessionScope.user.pseudo}
           	         </div>
           	         
           	         <div class="form-outline form-white mb-4">
           	         Nom: ${sessionScope.user.nom}
           	         </div>
           	         
           	         <div class="form-outline form-white mb-4">
           	         Prenom: ${sessionScope.user.prenom}
           	         </div>
           	         
           	         <div class="form-outline form-white mb-4">
           	         Email: ${sessionScope.user.email}
           	         </div>
           	         
           	         <div class="form-outline form-white mb-4">
           	         Téléphone: ${sessionScope.user.telephone}
           	         </div>
           	         
           	         <div class="form-outline form-white mb-4">
           	         Rue: ${sessionScope.user.rue}
           	         </div>
           	         
           	         <div class="form-outline form-white mb-4">
           	         Code Postal: ${sessionScope.user.code_postal}
           	         </div>
           	         
           	         <div class="form-outline form-white mb-4">
           	         Ville: ${sessionScope.user.ville}
           	         </div>
       
               
              <a href="Profil_modelServlet" class="btn btn-outline-light btn-lg px-5">Modifier</a>
                <a href="LoginServlet" class="btn btn-outline-light btn-lg px-5">Annuler</a>
            
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
		</c:if>
		
	</body>
</html>