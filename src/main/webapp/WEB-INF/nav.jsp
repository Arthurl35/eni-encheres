<header>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container-fluid">
  <a href="http://localhost:8080/eni-encheres"><img src="<%=request.getContextPath()%>/img/enchere.png"></a>
    <a class="navbar-brand" href="http://localhost:8080/eni-encheres">ENI Enchère</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
      	<c:if test="${sessionScope.user == null}">
	        <li class="nav-item">
	          <a class="nav-link" aria-current="page" href="RegisterServlet">Inscription</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" href="LoginServlet">Connexion</a>
	        </li>
	  	</c:if>
	  	<c:if test="${sessionScope.user != null}">
	  		<li class="nav-item">
	  			<a class="nav-link text-light" href="ProfilServlet">Bienvenue : ${sessionScope.user.pseudo}</a>
	  		</li>
		</c:if>
      </ul>
      <c:if test="${sessionScope.user.administrateur == true}">
	  	<li class="nav-item">
	  			<a class="btn btn-secondary me-3" href="AdminServlet">Configuration</a>
	  		</li>
	   </c:if>
	   
	  <c:if test="${sessionScope.user != null}">
	   	<li class="nav-item">
	  			<a class="btn btn-secondary me-3" href="ProfilServlet">Enchères</a>
	  		</li>
	   	<li class="nav-item">
	  			<a class="btn btn-secondary me-3" href="ArticlesServlet">Vendre un article</a>
	  		</li>
	  	<li class="nav-item">
	  			<a class="btn btn-secondary me-3" href="ProfilServlet">Mon profil</a>
	  		</li>
		<form class="nav-item" action="" method="post">
			<button type="submit" name="BT_LOGOUT" class="btn btn-secondary">Se déconnecter</button>
	  	</form>
	  
	  </c:if>
	  
    </div>
  </div>
</nav>
</header>