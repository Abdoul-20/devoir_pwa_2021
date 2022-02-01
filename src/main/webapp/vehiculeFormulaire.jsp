<%@page import="devoir.partie2.Approvision"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="corpo">
    ${errorMsg }
	<div class="cadastrar" style="padding-bottom">
		<h4 class="" id="cadastrar"><b>${formulaireTitle } </b></h4>
		<form action="ParcVehiculesServlet" method="post" name="ajouterApprovision"></form>
		
		
		<form class="form col-md-10 offset-md-1" action="ParcVehiculesServlet" method="post">
			<div class="row ">
				<div class="col-md-5">
					<label for="immatriculation">immatriculation: </label>
					<input value="${immatriculation }" type="text" name="immatriculation" id="nome" class="form-control">
					<input value="${immatriculation }" name="hiddenImmatriculation" type="hidden">
				</div>
				<div class="col-md-6 offset-md-1">
					<label for="modele">Modéle: </label>
					<input value="${modele }" type="text" name="modele" id="modele" class="form-control">
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<label for="kilometrage">Kilométrage: </label>
					<input value="${kilometrage }" type="text" name="kilometrage" id="kilometrage" class="form-control">
				</div>
			</div>
			<div class="row">
				<div class="col-md-5">
					<label for="type">Type: </label>
					<select name="type" id="type" class="form-control">
						<option> 3 </option>
						<option> 5 </option>
					</select>
				</div>
				<br></br>
				<div class="col-md-6 offset-md-1">
					<label for="numero_places">N°de places: </label>
					<input value="${nbPlaces }" type="text" name="numero_places" id="numero_places" class="form-control">
				</div>
				<div class="col-md-12">
				
				   <label for="carburant"><span>Carburant</span></label>
				   <select name="carburant" class="form-control">
				  
                          <option> Electrique Essence </option>
                          <option> Hydrogène </option>
                          <option> Diesel ou GPL </option>
                         
                         </select>
				</div>
				<div class="col-md-12">
				<label for="date_service"><span>Date de première mise en service</span></label>
				<input value="${dateService }" type="date" class="form-control" name="date_service" />
                </div>
                   <div class="col-md-12">
                     <label for="date_achat"><span>Date d'achat</span>
                     <input value="${dateAchat }" type="date" class="form-control" name="date_achat" /></label>
                   </div> 
                     <div class="col-md-12">
                     <label for="date_revision"><span>Date de de prochaine révision</span>
                     <input value="${dateProchainRevision }" type="date" class="form-control" name="date_revision" /></label>
				   </div>
			</div>
			<button name="${ajouterApprovisionBtn}" type="submit" class="btn btn-primary" style="border-radius: 0px 20px 0px 20px; font-weight: bold;">
				Ajouter approvision
			</button>
			<br>
			<c:if test="${not empty nbApprovisions }">
			<table class="table">
				<thead>
					<tr>
					<th>Date approvision </th>
					<th>Quantité </th>
					<th>Prix unitaire </th>
					<th>Montant </th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="i" begin="0" end="${nbApprovisions }">
				<tr>
					<td><input value="${approvisions[i].dateapprov }" type="date" name="dateapprov_${i }"></td>
					<td><input value="${approvisions[i].quantite }" type="number" name="quantiteapprov_${i }" step="0.01"></td>
					<td><input value="${approvisions[i].prixUnitaire }" type="number" name="prixunitaireapprov_${i }" step="0.01"></td>
					<td>${approvisions[i].montant }</td>
				</tr>
				</c:forEach>
				</tbody>
			</table>
			</c:if>
			<br>
			<button name="${submitBtnName }" type="submit" class="btn btn-primary col-md-12" style="border-radius: 0px 20px 0px 20px; font-weight: bold;"> <img src="img/save.png" width="25px"></button>
		</form>
	</div>
</div>