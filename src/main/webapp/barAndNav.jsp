<!-- Top Bar Start -->
<div class="top-bar">
    <div class="container">
        <div class="row align-items-center">
            <div class="col-lg-4 col-md-12">
                <div class="logo">
                <h1>
                    <a href="index.jsp">
                        Véhi<span>cule</span>
                        <!-- <img src="img/logo.jpg" alt="Logo"> -->
                    </a>
                 </h1>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Top Bar End -->


<!-- Nav Bar Start -->
<div class="nav-bar">
    <div class="container">
        <nav class="navbar navbar-expand-lg bg-dark navbar-dark">
            <a href="#" class="navbar-brand">MENU</a>
            <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse justify-content-between" id="navbarCollapse">
                <div class="navbar-nav mr-auto">
                    <a href="Acceuil.jsp" class="nav-item nav-link active">Home</a>
                    <a href="about.html" class="nav-item nav-link">About</a>
                   
                    <div class="nav-item dropdown">
	                        <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">service</a>
	                        <div class="dropdown-menu">
	                        	<form action="ParcVehiculesServlet" method="post">
	                        		<button class="dropdown-item" name="listeVehicules" type="submit">
	                        			liste de véhicules
	                        		</button>
	                        		
	                        		<button class="dropdown-item" name="ajouterVehiculeEntry" type="submit">
	                        			Ajouter Véhicule
	                        		</button>
	                        	</form>
	                        </div>
                    </div>
                </div>
            </div>
        </nav>
    </div>
</div>
<!-- Nav Bar End -->