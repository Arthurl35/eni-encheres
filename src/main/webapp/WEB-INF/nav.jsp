<header>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="HomeServlet">ENI Enchère</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
      	<c:if test="${model.user == null}">
	        <li class="nav-item">
	          <a class="nav-link" aria-current="page" href="RegisterServlet">Inscription</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" href="LoginServlet">Connection</a>
	        </li>
	  	</c:if>
	  	<c:if test="${model.user != null}">
	  		<li class="nav-item">
	  			<a class="nav-link text-light" href="#">Bienvenue : ${model.pseudo}</a>
	  		</li>
		</c:if>
      </ul>
	  <c:if test="${model.user != null}">
		<form class="d-flex" action="" method="post">
			<button type="submit" name="BT_LOGOUT" class="btn btn-secondary">Se déconnecter</button>
	  	</form>
	  </c:if>
      <form class="d-flex">
        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-light" type="submit">Search</button>
      </form>
    </div>
  </div>
</nav>
</header>