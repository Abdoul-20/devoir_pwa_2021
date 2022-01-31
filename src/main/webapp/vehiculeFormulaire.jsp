<div class="corpo">
    ${statusMsg }
	<div class="cadastrar" style="padding-bottom">
		<h4 class="" id="cadastrar"><b>${formulaireTitle } </b></h4>

		<form class="form col-md-10 offset-md-1" action="ParcVehiculesServlet" method="post">
			<div class="row ">
				<div class="col-md-5">
					<label for="immatriculation">immatriculation: </label>
					<input value="${immatriculation }" type="text" name="immatriculation" id="nome" class="form-control" required>
				</div>
				<div class="col-md-6 offset-md-1">
					<label for="modele">Modéle: </label>
					<input value="${modele }" type="text" name="modele" id="modele" class="form-control" required>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<label for="kilometrage">Kilométrage: </label>
					<input value="${kilometrage }" type="text" name="kilometrage" id="kilometrage" class="form-control"required>
				</div>
			</div>
			<div class="row">
				<div class="col-md-5">
					<label for="type">Type: </label>
					<select name="type" id="type" class="form-control" required>
						<option> 3 </option>
						<option> 5 </option>
					</select>
				</div>
				<br></br>
				<div class="col-md-6 offset-md-1">
					<label for="numero_places">N°de places: </label>
					<input value="${numero_places }" type="text" name="numero_places" id="numero_places" class="form-control"required>
				</div>
				<div class="col-md-12">
				
				   <label for="carburant"><span>Carburant</span></label>
				   <select name="carburant" class="form-control" required>
				  
                          <option> Electrique Essence </option>
                          <option> Hydrogène </option>
                          <option> Diesel ou GPL </option>
                         
                         </select>
				</div>
				<div class="col-md-12">
				<label for="date_service"><span>Date de première mise en service</span></label>
				<input value="${date_service }" type="date" class="form-control" name="date_service" value="" />
                </div>
                   <div class="col-md-12">
                     <label for="date_achat"><span>Date d'achat</span>
                     <input value="${date_achat }" type="date" class="form-control" name="date_achat" value="" /></label>
                   </div> 
                     <div class="col-md-12">
                     <label for="date_revision"><span>Date de de prochaine révision</span>
                     <input value="${date_revision }" type="date" class="form-control" name="date_revision" value="" /></label>
				   </div>
			</div>
			<br>
			<button name="${submitBtnName }" type="submit" class="btn btn-primary col-md-12" style="border-radius: 0px 20px 0px 20px; font-weight: bold;"> <img src="img/save.png" width="25px"></button>
		</form>
	</div>
</div>