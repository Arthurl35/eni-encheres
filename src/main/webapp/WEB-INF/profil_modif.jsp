<%@ include file="head.jsp" %>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
	<body>

<c:if test="${sessionScope.user == null}">
			<a href="LoginServlet">Connection</a>
			<a href="RegisterServlet">Inscription</a>
		</c:if>
		<c:if test="${sessionScope.user != null}">
 <form action="Profil_modelServlet" method="post">
 <div class="container py-5 h-100" >
    <div class="row d-flex  h-100 justify-content-center align-items-center" >
      <div class="col-12 col-md-8 col-lg-6 col-xl-5"  style="width: 800px;">
        <div class="card bg-dark text-white" style="border-radius: 1rem;">
          <div class="card-body p-5 text-center">
            <div class="mb-md-5 mt-md-4 pb-5">
              <h2 class="fw-bold mb-2 text-uppercase mb-4">Modifier mon profil</h2>
     
              <div class="form-outline form-white mb-4">
               <label class="form-label" for="pseudo">Pseudo</label>
               <input type="text" name="pseudo" class="form-control form-control-lg" value="${user.pseudo}"/>
              </div>
              
              <div class="row justify-content-md-center">
              <div class="form-outline form-white mb-4 col">
               <label class="form-label" for="name">Name</label>
               <input type="text" name="name" class="form-control form-control-lg" value="${user.nom}"/>
              </div>
              <div class="form-outline form-white mb-4 col">
               <label class="form-label" for="surname">Prénom</label>
               <input type="text" name="surname" class="form-control form-control-lg" value="${user.prenom}"/>
              </div>
              </div>
               <div class="form-outline form-white mb-4">
               <label class="form-label" for="mail">Email</label>
              	<input type="email" name="mail" class="form-control form-control-lg" value="${user.email}"/>
              </div>
               <div class="form-outline form-white mb-4">
               <label class="form-label" for="tel">Téléphone</label>
               <input type="tel" name="tel" class="form-control form-control-lg" value="${user.telephone}"/>
              </div>
              <div class="row">
               <div class="form-outline form-white mb-4 col">
               <label class="form-label" for="street">Rue</label>
               <input type="text" name="street" class="form-control form-control-lg" value="${user.rue}"/>
              </div>
             <div class="form-outline form-white mb-4 col">
               <label class="form-label" for="cp">Code postal</label>
               <input type="text" name="cp" class="form-control form-control-lg" value="${user.code_postal}"/>
              </div>
              </div>
             <div class="form-outline form-white mb-4">
               <label class="form-label" for="city">Ville</label>
               <input type="text" name="city" class="form-control form-control-lg" value="${user.ville}"/>
              </div>
             
             <div class="form-outline form-white mb-4">
                <label class="form-label" for="pass_actuel">Mot de passe actuel</label>
               <input type="password" name="pass_actuel" class="form-control form-control-lg" class="form-control form-control-lg"  placeholder="mot de passe actuel"/>
              </div>

              <div class="form-outline form-white mb-4">
                <label class="form-label" for="pass_new">Nouveau mot de passe</label>
               <input type="password" name="pass_new" class="form-control form-control-lg" class="form-control form-control-lg" placeholder="nouveau mot de passe"/>
              </div>
              <div class="form-outline form-white mb-4">
                <label class="form-label" for="pass-confirm">Confirmation</label>
               <input type="password" name="pass-confirm" class="form-control form-control-lg" class="form-control form-control-lg" placeholder="confirmation"/>
              </div>
              
              <button class="btn btn-outline-light btn-lg px-5" type="submit" name="BT_ENREGISTRER">Enregistrer</button>
               <button class="btn btn-outline-light btn-lg px-5" type="submit" name="BT_SUPP">Supprimer le compte</button>
               <a class="btn btn-outline-light btn-lg px-5" href="<%=request.getContextPath()%>">Annuler</a>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</form>	
</c:if>
</body>
</html>