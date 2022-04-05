<jsp:include page="head.jsp" />
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
<form action="LoginServlet" method="post">
  <div class="container py-5 h-100">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col-12 col-md-8 col-lg-6 col-xl-5">
        <div class="card bg-dark text-white" style="border-radius: 1rem;">
          <div class="card-body p-5 text-center">
            <div class="mb-md-5 mt-md-4 pb-5">
              <h2 class="fw-bold mb-2 text-uppercase">Connexion</h2>
              <p class="text-white-50 mb-5">Entrez votre pseudo et votre mot de passe!</p>
              <div class="form-outline form-white mb-4">
               <label class="form-label" for="typeEmailX">Pseudo</label>
                <input type="text" id="typeEmailX" name="pseudo" class="form-control form-control-lg" /> 
              </div>

              <div class="form-outline form-white mb-4">
                <label class="form-label" for="typePasswordX">Mot de passe</label>
                <input type="password" id="typePasswordX" name="pass" class="form-control form-control-lg" />
              </div>
              <button class="btn btn-outline-light btn-lg px-5" type="submit" name="BT_VALID">Se connecter</button>
            </div>
            <div>
              <p class="mb-0">Avez-vous un compte ? <a href="#!" class="text-white-50 fw-bold">S'enregistrer</a>
              </p>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  </form>
	</body>
</html>