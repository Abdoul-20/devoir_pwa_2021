
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
                                    <a href="Ajouter_véhicule.jsp"" class="dropdown-item">Ajouter Véhicule</a>
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
	  
		<div class="corpo">

			<div class="visualizar">
				<div class="row">
					<h4 class="col-md-20" id="visualizar">La liste des véhicules </h4>

			<!--   <div class="input-group  offset-md-1 col-md-7">
						<input type="search" class="form-control" placeholder="Faça sua busca">
						<div class="input-group-prepend" >
							<div class="input-group-text" style="background-color: transparent; border: none;"><img src="img/busca.png" width="20"></div>
						</div>
					</div> -->
				</div>

				<br><br><br>
				<div class="over">
					<table class="table table-hover">
						<thead>
							<tr><th>Immatriculation</th><th>Modéle</th><th>kilométrage</th><th>type</th><th>Nombre de place</th><th>carburant</th> <th>date d'achat</th></tr>
						</thead>
						<tbody>
							
					  
					        <td>
					        <div class="f1">
						        <form action="Modifier_véhecule.jsp" style="padding -10px;" method="get">
						        	<input type="text" value="1234" name="id" style="display: none;">
						        	<input type="text" value="aze" name="nascimento" style="display: none;">
						        	<input type="text" value="zer" name="nome" style="display: none;">
						        	<input type="text" value="zer" name="sobrenome" style="display: none;">
						        	<input type="text" value="ze" name="telefone" style="display: none;">
						        	<input type="text" value="zer" name="endereco" style="display: none;">
							        <button style="background-color: transparent; border: none;">
							        	<img src="img/editblack.png" width="25px">
							        </button>
						        </form>
					        </div>
					        <div class="f2">
						        <form action="excluir.jsp" method="post">
						        	<input type="text" value="" name="id" style="display: none;">
							        <button style="background-color: transparent; border: none;">
							        	<img src="img/excluirblack.png" width="25px">
							        </button>
						        </form>
					        </div>
					        </td> </tr>
					      
						</tbody>
					</table>
				</div>
				<br>
			</div>

			
						<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
						  <div class="modal-dialog" role="document">
						    <div class="modal-content">
						      <div class="modal-header">
						        <h5 class="modal-title" id="exampleModalLabel">Ajouter un véhecule</h5>
						        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
						          <span aria-hidden="true">&times;</span>
						        </button>
						      </div>
						      <div class="modal-body">
						        <p>Usuário cadastrado com sucesso.</p>
						      </div>
						      <div class="modal-footer">
						      	<form action="index.jsp">
						        	<button type="submit" class="btn btn-secondary">Fechar</button>
						        </form>
						      </div>
						    </div>
						  </div>
						</div>
						
						<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
						  <div class="modal-dialog" role="document">
						    <div class="modal-content">
						      <div class="modal-header">
						        <h5 class="modal-title" id="exampleModalLabel">Cadastro de usuário</h5>
						        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
						          <span aria-hidden="true">&times;</span>
						        </button>
						      </div>
						      <div class="modal-body">
						        <p>Não foi possível cadastrar o usuário, tente mais tarde.</p>
						      </div>
						      <div class="modal-footer">
						      	<form action="index.jsp">
						        	<button type="submit" class="btn btn-secondary">enregister</button>
						        </form>
						      </div>
						    </div>
						  </div>
						</div>
			
			</div>
		</div>
		
		  
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