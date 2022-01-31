<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<c:set var="title" value="Liste de véhicules" scope="request"/>
	<jsp:include page="head.jsp"/>
	<body>
	<body>
	
        <jsp:include page="barAndNav.jsp"></jsp:include>
	  
		<div class="corpo">

			<div class="visualizar">
				<div class="row">
					<h4 class="col-md-20" id="visualizar">La liste des véhicules </h4>
				</div>

				<br><br><br>
				<div class="over">
					<table class="table table-hover">
						<thead>
							<tr><th/>
							<th/>
							<th>Immatriculation</th>
							<th>Modéle</th>
							<th>kilométrage</th>
							<th>type</th>
							<th>Nombre de place</th>
							<th>carburant</th> 
							<th>date d'achat</th>
							</tr>
							
							
						</thead>
						<tbody>
							<c:forEach var="vehicule" items="${listeVehicules}">
								<tr>
									<td>
										<div class="f1">
									        <form action="ParcVehiculesServlet" style="padding -10px;" method="post">
										        <button name="modifierVehiculeBtn_goto" value="${vehicule.immatriculation }" 
										        style="background-color: transparent; border: none;">
										        	<img src="img/editblack.png" width="25px">
										        </button>
									        </form>
								        </div>
								       </td>
								       <td>
								        <div class="f2">
									        <form action="ParcVehiculesServlet" method="post">
										        <button name="supprimerVehiculeBtn" value="${vheicule.immatriculation }"
										        style="background-color: transparent; border: none;">
										        	<img src="img/excluirblack.png" width="25px">
										        </button>
									        </form>
								        </div>
									</td>
									<td> ${vehicule.immatriculation } </td>
									<td> ${vehicule.modele } </td>
									<td> ${vehicule.kilometrage } </td>
									<td> ${vehicule.type } </td>
									<td> ${vehicule.nbPlace } </td>
									<td> ${vehicule.typeCarburant } </td>
									<td> ${vehicule.dateAchat } </td>
								</tr>
					      	</c:forEach>
						</tbody>
					</table>
				</div>
				<br>
			</div>

			
						<!--  <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
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
			-->
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