
<!DOCTYPE html>
<html>
	<head>
		 <meta charset="utf-8">
        <title>AutoWash - Car Wash Website Template</title>
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="Free Website Template" name="keywords">
        <meta content="Free Website Template" name="description">

        <!-- Favicon -->
        <link href="img/favicon.ico" rel="icon">

        <!-- Google Font -->
        <link href="https://fonts.googleapis.com/css2?family=Barlow:wght@400;500;600;700;800;900&display=swap" rel="stylesheet"> 
        
        <!-- CSS Libraries -->
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
        <link href="lib/flaticon/font/flaticon.css" rel="stylesheet">
        <link href="lib/animate/animate.min.css" rel="stylesheet">
        <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

        <!-- Template Stylesheet -->
        <link href="css/style.css" rel="stylesheet">
		
		<link rel="stylesheet" href="css/estilo.css">
	</head>
	<body>

		 <!-- Top Bar Start -->
        <div class="top-bar">
            <div class="container">
                <div class="row align-items-center">
                    <div class="col-lg-4 col-md-12">
                        <div class="logo">
                            <a href="index.html">
                                <h1>Véhi<span>cule</span></h1>
                                <!-- <img src="img/logo.jpg" alt="Logo"> -->
                            </a>
                        </div>
                    </div>
                    <div class="col-lg-8 col-md-7 d-none d-lg-block">
                        <div class="row">
                            <div class="col-4">
                                <div class="top-bar-item">
                                    <div class="top-bar-icon">
                                        <img src="img/call.png" alt="Image">
                                    </div>
                                    <div class="top-bar-text">
                                        <h3>Téléphone</h3>
                                        <p>+0751481456</p>
                                    </div>
                                </div>
                            </div>
                            <div class="col-4">
                                <div class="top-bar-item">
                                    <div class="top-bar-icon">
                                        <img src="img/face.png" alt="Image">
                                    </div>
                                    <div class="top-bar-text">
                                        <h3>Facebook</h3>
                                     
                                    </div>
                                </div>
                            </div>
                            <div class="col-4">
                                <div class="top-bar-item">
                                    <div class="top-bar-icon">
                                         <img src="img/email.png" alt="Image">
                                    </div>
                                    <div class="top-bar-text">
                                        <h3>Email</h3>
                                        <p>info@example.com</p>
                                    </div>
                                </div>
                            </div>
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
                                    <a href="header.jsp" class="dropdown-item">listes des véhicules</a>
                                    <a href="Ajouter_véhecule.jsp"" class="dropdown-item">Ajouter Véhicule</a>
                                    <a href="Modifier_véhecule.jsp" class="dropdown-item">Modifier Véhicule</a>
                                    <a href="booking.html" class="dropdown-item">Consulter Véhicule</a>
                                </div>
                            </div>
                            <a href="contact.html" class="nav-item nav-link">Contact</a>
                        </div>
                        <div class="ml-auto">
                            <a class="btn btn-custom" href="#">Se connecter</a>
                        </div>
                    </div>
                </nav>
            </div>
        </div>
        <!-- Nav Bar End -->
	  
		</aside>
		<div class="corpo">
			<div class="cadastrar" style="padding-bottom">
				<h4 class="" id="cadastrar"><b>Ajouter un véhicule </b></h4>

				<form class="form col-md-10 offset-md-1" action="index.jsp" method="post">
					<div class="row ">
						<div class="col-md-5">
							<label for="nome">immatriculation: </label>
							<input type="text" name="nome" id="nome" class="form-control" required>
						</div>
						<div class="col-md-6 offset-md-1">
							<label for="sobrenome">Modéle: </label>
							<input type="text" name="sobrenome" id="sobrenome" class="form-control" required>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12">
							<label for="endereco">Kilométrage: </label>
							<input type="text" name="endereco" id="endereco" class="form-control"required>
						</div>
					</div>
					<div class="row">
						<div class="col-md-5">
							<label for="nascimento">Type: </label>
							<input type="text" name="nascimento" id="nascimento" class="form-control" required>
						</div>
						<br></br>
						<div class="col-md-6 offset-md-1">
							<label for="telefone">N°de places: </label>
							<input type="text" name="numero" id="telefonePessoa" class="form-control"required>
						</div>
						<div class="col-md-12">
						
						   <label for="field4"><span>Carburant</span><select name="field4" class="form-control""required>
						  
                           <option value="General Question">Electrique Essence</option>
                           <option value="Advertise">Hydrogène</option>
                           <option value="Partnership">Diesel ou GPL</option>
                           
                           </select></label>
						</div>
						<div class="col-md-12">
						<label for="field5"><span>Date de première mise en service</span><input type="date" class="form-control" name="field1" value="" /></label>
		                </div>
	                    <div class="col-md-12">
                       <label for="field5"><span>Date d'achat</span><input type="date" class="form-control" name="field1" value="" /></label>
                      	</div> 
                       <div class="col-md-12">
                       <label for="field5"><span>Date de de prochaine révision</span><input type="date" class="form-control" name="field1" value="" /></label>
						</div>
					</div>
					<br>
					<button type="submit" class="btn btn-primary col-md-12" style="border-radius: 0px 20px 0px 20px; font-weight: bold;"> <img src="img/save.png" width="25px"></button>
				</form>
			</div>
		</div>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
	
	<script>
		$(document).ready(function(){ $('#exampleModal').modal('show'); });
	</script>
	    <!-- Back to top button -->
        <a href="#" class="back-to-top"><i class="fa fa-chevron-up"></i></a>
        
        <!-- Pre Loader -->
        <div id="loader" class="show">
            <div class="loader"></div>
        </div>

        <!-- JavaScript Libraries -->
        <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
        <script src="lib/easing/easing.min.js"></script>
        <script src="lib/owlcarousel/owl.carousel.min.js"></script>
        <script src="lib/waypoints/waypoints.min.js"></script>
        <script src="lib/counterup/counterup.min.js"></script>
        
        <!-- Contact Javascript File -->
        <script src="mail/jqBootstrapValidation.min.js"></script>
        <script src="mail/contact.js"></script>

        <!-- Template Javascript -->
        <script src="js/main.js"></script>
	</body>
</html>