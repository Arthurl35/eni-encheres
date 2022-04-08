<%@ include file="head.jsp" %>
	<body>
	<h1>Filtres :</h1>
	<br>
	
	<section class="search-sec">
    <div class="container">
        <form action="#" method="post" novalidate="novalidate">
            <div class="row">
                <div>
                    <div class="row">
                        <div class="col-lg-3 col-md-3 col-sm-12 p-0">
                            <input type="text" class="form-control search-slt" placeholder="Rechercher">
                        </div>
                        <div class="col-lg-3 col-md-3 col-sm-12 p-0">
                            <select class="form-control search-slt">
                                <option>Toutes</option>

                                <c:forEach items="${model2.lstCategories}" var="categorie">
    <option>${categorie.libelle} </option>
</c:forEach>
                            </select>
                        </div>
                        <div class="col-lg-3 col-md-3 col-sm-12 p-0">
                            <button type="button" class="btn btn-dark bg-dark">Rechercher</button>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </div>
</section>
  
  

</body>
</html>