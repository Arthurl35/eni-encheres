<%@ include file="head.jsp" %>

<body>
<%@ include file="nav.jsp" %>	
<section>
<form action="RegisterServlet" method="post">
 <div class="container py-5 h-100" >
    <div class="row d-flex  h-100 justify-content-center align-items-center" >
      <div class="col-12 col-md-8 col-lg-6 col-xl-5"  style="width: 800px;">
        <div class="card bg-dark text-white" style="border-radius: 1rem;">
          <div class="card-body p-5 text-center">
            <div class="mb-md-5 mt-md-4 pb-5">
              <h2 class="fw-bold mb-2 text-uppercase mb-4">Inscription</h2>
     			<c:if test="${model.message != null}">
					<p>${model.message}</p>
				</c:if>
              <div class="form-outline form-white mb-4">
               <label class="form-label" for="pseudo">Pseudo</label>
               <input type="text" name="pseudo" class="form-control form-control-lg" value="${model.pseudo}"/>
              </div>
              
              <div class="row justify-content-md-center">
              <div class="form-outline form-white mb-4 col">
               <label class="form-label" for="name">Name</label>
               <input type="text" name="name" class="form-control form-control-lg" value="${model.nom}"/>
              </div>
              <div class="form-outline form-white mb-4 col">
               <label class="form-label" for="surname">Prénom</label>
               <input type="text" name="surname" class="form-control form-control-lg" value="${model.prenom}"/>
              </div>
              </div>
               <div class="form-outline form-white mb-4">
               <label class="form-label" for="mail">Email</label>
              	<input type="email" name="mail" class="form-control form-control-lg" value="${model.email}"/>
              </div>
               <div class="form-outline form-white mb-4">
               <label class="form-label" for="tel">Téléphone</label>
               <input type="tel" name="tel" class="form-control form-control-lg" value="${model.telephone}"/>
              </div>
              <div class="row">
               <div class="form-outline form-white mb-4 col">
               <label class="form-label" for="street">Rue</label>
               <input type="text" name="street" class="form-control form-control-lg" value="${model.rue}"/>
              </div>
             <div class="form-outline form-white mb-4 col">
               <label class="form-label" for="cp">Code postal</label>
               <input type="text" name="cp" class="form-control form-control-lg" value="${model.code_postal}"/>
              </div>
              </div>
             <div class="form-outline form-white mb-4">
               <label class="form-label" for="city">Ville</label>
               <input type="text" name="city" class="form-control form-control-lg" value="${model.ville}"/>
              </div>
             

              <div class="form-outline form-white mb-4">
                <label class="form-label" for="pass">Mot de passe</label>
               <input type="password" name="pass" class="form-control form-control-lg" class="form-control form-control-lg" value="${model.mot_de_passe}"/>
              </div>
              <div class="form-outline form-white mb-4">
                <label class="form-label" for="pass-confirm">Mot de passe</label>
               <input type="password" name="pass-confirm" class="form-control form-control-lg" class="form-control form-control-lg" value="${model.mot_de_passe_confirm}"/>
              </div>
              
              <button class="btn btn-outline-light btn-lg px-5" type="submit" name="BT_VALID">Créer</button>
               <button class="btn btn-outline-light btn-lg px-5" type="submit" name="BT_ANNUL">Annuler</button>
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