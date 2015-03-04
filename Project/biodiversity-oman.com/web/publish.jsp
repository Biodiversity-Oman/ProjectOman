<%-- 
    Document   : welcome
    Created on : Feb 17, 2015, 12:23:34 AM
    Author     : lennyasus
--%>
<%@include file="/adminheader.jsp" %>
<%
	if (us.getIsAdmin() == false) {
		response.sendRedirect("notallowed.jsp");
	}
%>
<!DOCTYPE html>
<html>
	<head>
		<link rel="StyleSheet" type="text/css" href="css/chosen.css">
		<script src="js/ajax.js"></script>
		<script src="js/loaders.js"></script>
		<script src="js/chosen.jquery.min.js"></script>
		<script>
                        $(document).ready(function () {
                            loadToValidateOrganisms();
                            loadPublishedOrganisms();
                            loadPosts();
                            loadSubscriber();
                            loadOrganisms();
                            loadWorlds();
                            loadSeasons();
                            loadFamilies();
                            loadSubFamilies();
                            loadHabitats();
                            loadGeolocations();
                            $(".chosen-select").chosen({width: "100%"});
                        });
		</script>
	</head>
        <body>
		<div class="wrapper">
			<div id="fade" class="black_overlay"></div>
			<div class="tabs">
				<ul class="tab-links">
					<li class="active"><a href="#tab1"><span class="icon-file-text"></span>Published</a></li>
					<li><a href="#tab2"><span class="icon-list"></span>Queue</a></li>
					<li><a href="#tab3"><span class="icon-list"></span>Post</a></li>
					<li><a href="#tab4"><span class="icon-list"></span>Subscriber</a></li>
				</ul>
				<div class="tab-content">                                  
                                   <div id="tab1" class="tab active">
                                       <div id="update-published-organism" class="insert-box">
							<label class="close-button">x</label>
							<div class="content">
								<div id="update-published-organism">
									<form class="form form-horizontal" id="update-published-organism-form" data-toggle="validator" enctype="multipart/form-data">
										<input type="hidden" id="organism-id-published" name="organism-id">
										<div class="form-group">
											<label class="col-sm-2 control-label"></label>
											<div class="col-sm-4">
												<h2 class="h2">Update this organism</h2>
											</div>
										</div>
										<!--<form class="form-group"> -->                                           
										<div class="form-group">
											<label class="col-sm-2 control-label" for="organism-scientific-name">Scientific name</label>
											<div class="col-sm-4">
												<input class="form-control" id="scientific-name-published" type="text" name="organism-scientific-name" maxlength="50" data-delay="1200" pattern="^([A-z\s]){1,}$" required/> 
											</div>    
											<span class="help-block with-errors">Up to 50 characters upper/lower case(no digits)</span>
										</div> 
										<div class="form-group">
											<label class="col-sm-2 control-label" for="organism-common-name">Common name</label>
											<div class="col-sm-4">
												<input class="form-control" id="common-name-published" type="text" name="organism-common-name" maxlength="50" data-delay="1200" pattern="^([A-z\s]){1,}$" required/> 
											</div>
											<span class="help-block with-errors">Up to 50 characters upper/lower case(no digits)</span>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label" for="organism-local-name">Local name</label>
											<div class="col-sm-4">
												<input class="form-control" id="local-name-published" type="text" name="organism-local-name" maxlength="50" data-delay="1200" required/> 
											</div>
											<span class="help-block with-errors">Up to 50 characters upper/lower case(no digits)</span>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label" for="family">Family</label>
											<div class="col-sm-4">
												<select class="form-control" id="family-ddl2-published" name="organism-family-id"></select>
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label" for="organism-subfamily">Breed</label>
											<div class="col-sm-4">
												<select class="form-control" id="subfamily-ddl-published" name="organism-subfamily-id"></select>
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label" for="organism-population">Population</label>
											<div class="col-sm-4">
												<input class="form-control" type="text" id="population-published" maxlength="50" data-delay="1200" name="organism-population" />
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label" for="organism-description">Organism description</label>
											<div class="col-sm-4">
												<textarea class="form-control" rows="3" id="description-published" name="organism-description"></textarea>
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label">Choose Habitat</label>
											<div class="col-sm-4">
												<select class="chosen-select form-control" id="habitat-ddl2-published" name="organism-habitat-id" multiple data-placeholder="Choose Habitat"></select>
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label">Choose World</label>
											<div class="col-sm-4">
												<select class="form-control" id="world-ddl4-published" name="organism-world-id" data-placeholder="Choose World"></select>
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label" for="organism-photo">Add Photo</label>
											<div class="col-sm-4">
												<input type="file" id="photo-published"  name="upfileOrganism" >
											</div>
										</div>

										<div class="form-group">
											<label class="col-sm-2 control-label" for="organism-indigenous">Indigenous</label>
											<div class="col-sm-4">
												<input style="width: 1em;"   type="radio" id="organismIndigenousTrue-published"  name="organism-indigenous" value="true" required> <label>Yes</label><br>
												<input style="width: 1em;"  type="radio" id="organismIndigenousFalse-published" name="organism-indigenous" value="false" required> <label>No</label>
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label" for="organism-cultivated">Cultivated</label>
											<div class="col-sm-4">
												<input style="width: 1em;"   type="radio" id="organismCultivateTrue-published"  name="organism-cultivated" value="true" required> <label>Yes</label><br>
												<input style="width: 1em;"  type="radio" id="organismCultivateFalse-published" name="organism-cultivated" value="false" required> <label>No</label>
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label" for="organism-endangered">Endangered</label>
											<div class="col-sm-4">
												<input style="width: 1em;"   type="radio" id="organismEndangeredTrue-published"  name="organism-endangered" value="true" required> <label>Yes</label><br>
												<input style="width: 1em;"  type="radio" id="organismEndangeredFalse-published" name="organism-endangered" value="false" required> <label>No</label>
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label" for="organism-medicinal">Medicinal</label>
											<div class="col-sm-4">
												<input style="width: 1em;"   type="radio" id="organismMedicinalTrue-published"  name="organism-medicinal" value="true" required> <label>Yes</label><br>
												<input style="width: 1em;"  type="radio" id="organismMedicinalFalse-published" name="organism-medicinal" value="false" required> <label>No</label>
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label" for="organism-benefits">Benefits</label>
											<div class="col-sm-4">
												<textarea rows="3" class="form-control" id="benefits-published"  name="organism-benefits"></textarea>
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label" for="organism-dangerous">Dangers</label>
											<div class="col-sm-4">
												<textarea rows="3" class="form-control" id="dangerous-published"  name="organism-dangerous"></textarea>
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label" for="organism-threats">Threats</label>
											<div class="col-sm-4">
												<textarea rows="3" class="form-control" id="threats-published" name="organism-threats"></textarea>
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label" for="organism-opportunities">Opportunities</label>
											<div class="col-sm-4">
												<textarea rows="3" class="form-control" id="opportunities-published" name="organism-opportunities"></textarea>
											</div>
										</div>

										<div class="form-group">
											<label class="col-sm-2 control-label" for="organism-links">Usefull links</label>
											<div class="col-sm-4">
												<textarea rows="3" class="form-control" id="links-published" name="organism-links"></textarea>
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label" for="organism-food-name">Food name if this organism is not yet present</label>
											<div class="col-sm-4">
												<input class="form-control" type="text" id="food-name-published" name="organism-food-name" maxlength="50" data-delay="1200" required/> 
											</div>
											<span class="help-block with-errors">Up to 50 characters upper/lower case(no digits)</span>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label" for="organism-food-description">Food description if this organism is not yet present</label>
											<div class="col-sm-4">
												<textarea rows="3" class="form-control" id="food-description-published" name="organism-food-description"></textarea>
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label">Choose season</label>
											<div class="col-sm-4">
												<select class="chosen-select form-control" id="season-ddl2-published" name="organism-season-id" multiple data-placeholder="Choose Season">

												</select>
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label">Choose geolocations</label>
											<div class="col-sm-4">
												<select class="chosen-select form-control" id="geolocation-ddl2-published" name="organism-geolocation-id" multiple data-placeholder="Choose Geolocations">
												</select>
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label"></label>
											<div class="col-sm-4">
												<div id="update-published-organism-message"></div>
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label"></label>
											<div class="col-sm-2">
												<button class="btn btn-default" id="organism-id" type="submit">Update</button>
											</div>
										</div>
									</form>
								</div>
							</div>
						</div>
						<div class="table-responsive">
                                                        <table class="table table-striped" id="published-table"></table>
                                                </div>
					</div>
					<div id="tab2" class="tab">
						<div id="update-queue-organism" class="insert-box">
							<label class="close-button">x</label>
							<div class="content">
								<div id="update-queue-organism">
									<form class="form form-horizontal" id="update-queue-organism-form" data-toggle="validator" enctype="multipart/form-data">
										<input type="hidden" id="organism-id-queue" name="organism-id">
										<div class="form-group">
											<label class="col-sm-2 control-label"></label>
											<div class="col-sm-4">
												<h2 class="h2">Validate this organism before submission</h2>
											</div>
										</div>
										<!--<form class="form-group"> -->                                           
										<div class="form-group">
											<label class="col-sm-2 control-label" for="organism-scientific-name">Scientific name</label>
											<div class="col-sm-4">
												<input class="form-control" id="scientific-name-queue" type="text" name="organism-scientific-name" maxlength="50" data-delay="1200" pattern="^([A-z\s]){1,}$" required/> 
											</div>    
											<span class="help-block with-errors">Up to 50 characters upper/lower case(no digits)</span>
										</div> 
										<div class="form-group">
											<label class="col-sm-2 control-label" for="organism-common-name">Common name</label>
											<div class="col-sm-4">
												<input class="form-control" id="common-name-queue" type="text" name="organism-common-name" maxlength="50" data-delay="1200" pattern="^([A-z\s]){1,}$" required/> 
											</div>
											<span class="help-block with-errors">Up to 50 characters upper/lower case(no digits)</span>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label" for="organism-local-name">Local name</label>
											<div class="col-sm-4">
												<input class="form-control" id="local-name-queue" type="text" name="organism-local-name" maxlength="50" data-delay="1200" required/> 
											</div>
											<span class="help-block with-errors">Up to 50 characters upper/lower case(no digits)</span>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label" for="family">Family</label>
											<div class="col-sm-4">
												<select class="form-control" id="family-ddl2-queue" name="organism-family-id"></select>
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label" for="organism-subfamily">Breed</label>
											<div class="col-sm-4">
												<select class="form-control" id="subfamily-ddl-queue" name="organism-subfamily-id"></select>
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label" for="organism-population">Population</label>
											<div class="col-sm-4">
												<input class="form-control" type="text" id="population-queue" maxlength="50" data-delay="1200" name="organism-population" />
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label" for="organism-description">Organism description</label>
											<div class="col-sm-4">
												<textarea class="form-control" rows="3" id="description-queue" name="organism-description"></textarea>
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label">Choose Habitat</label>
											<div class="col-sm-4">
												<select class="chosen-select form-control" id="habitat-ddl2-queue" name="organism-habitat-id" multiple data-placeholder="Choose Habitat"></select>
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label">Choose World</label>
											<div class="col-sm-4">
												<select class="form-control" id="world-ddl4-queue" name="organism-world-id" data-placeholder="Choose World"></select>
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label" for="organism-photo">Add Photo</label>
											<div class="col-sm-4">
												<input type="file" id="photo-queue"  name="upfileOrganism" >
											</div>
										</div>

										<div class="form-group">
											<label class="col-sm-2 control-label" for="organism-indigenous">Indigenous</label>
											<div class="col-sm-4">
												<input style="width: 1em;"   type="radio" id="organismIndigenousTrue-queue"  name="organism-indigenous" value="true" required> <label>Yes</label><br>
												<input style="width: 1em;"  type="radio" id="organismIndigenousFalse-queue" name="organism-indigenous" value="false" required> <label>No</label>
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label" for="organism-cultivated">Cultivated</label>
											<div class="col-sm-4">
												<input style="width: 1em;"   type="radio" id="organismCultivateTrue-queue"  name="organism-cultivated" value="true" required> <label>Yes</label><br>
												<input style="width: 1em;"  type="radio" id="organismCultivateFalse-queue" name="organism-cultivated" value="false" required> <label>No</label>
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label" for="organism-endangered">Endangered</label>
											<div class="col-sm-4">
												<input style="width: 1em;"   type="radio" id="organismEndangeredTrue-queue"  name="organism-endangered" value="true" required> <label>Yes</label><br>
												<input style="width: 1em;"  type="radio" id="organismEndangeredFalse-queue" name="organism-endangered" value="false" required> <label>No</label>
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label" for="organism-medicinal">Medicinal</label>
											<div class="col-sm-4">
												<input style="width: 1em;"   type="radio" id="organismMedicinalTrue-queue"  name="organism-medicinal" value="true" required> <label>Yes</label><br>
												<input style="width: 1em;"  type="radio" id="organismMedicinalFalse-queue" name="organism-medicinal" value="false" required> <label>No</label>
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label" for="organism-benefits">Benefits</label>
											<div class="col-sm-4">
												<textarea rows="3" class="form-control" id="benefits-queue"  name="organism-benefits"></textarea>
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label" for="organism-dangerous">Dangers</label>
											<div class="col-sm-4">
												<textarea rows="3" class="form-control" id="dangerous-queue"  name="organism-dangerous"></textarea>
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label" for="organism-threats">Threats</label>
											<div class="col-sm-4">
												<textarea rows="3" class="form-control" id="threats-queue" name="organism-threats"></textarea>
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label" for="organism-opportunities">Opportunities</label>
											<div class="col-sm-4">
												<textarea rows="3" class="form-control" id="opportunities-queue" name="organism-opportunities"></textarea>
											</div>
										</div>

										<div class="form-group">
											<label class="col-sm-2 control-label" for="organism-links">Usefull links</label>
											<div class="col-sm-4">
												<textarea rows="3" class="form-control" id="links-queue" name="organism-links"></textarea>
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label" for="organism-food-name">Food name if this organism is not yet present</label>
											<div class="col-sm-4">
												<input class="form-control" type="text" id="food-name-queue" name="organism-food-name" maxlength="50" data-delay="1200" required/> 
											</div>
											<span class="help-block with-errors">Up to 50 characters upper/lower case(no digits)</span>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label" for="organism-food-description">Food description if this organism is not yet present</label>
											<div class="col-sm-4">
												<textarea rows="3" class="form-control" id="food-description-queue" name="organism-food-description"></textarea>
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label">Choose season</label>
											<div class="col-sm-4">
												<select class="chosen-select form-control" id="season-ddl2-queue" name="organism-season-id" multiple data-placeholder="Choose Season">

												</select>
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label">Choose geolocations</label>
											<div class="col-sm-4">
												<select class="chosen-select form-control" id="geolocation-ddl2-queue" name="organism-geolocation-id" multiple data-placeholder="Choose Geolocations">
												</select>
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label"></label>
											<div class="col-sm-4">
												<div id="update-queue-organism-message"></div>
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label"></label>
											<div class="col-sm-2">
												<button class="btn btn-default" type="submit">Approve and submit</button>
											</div>
										</div>
									</form>
								</div>
							</div>
						</div>
						<div class="table-responsive">
                                                        <table class="table table-striped" id="tovalidate-table"></table>
                                                </div>
					</div>
					<div id="tab3" class="tab">
						<div class="table-responsive">
							<table class="table table-striped" id="posts-table"></table>
						</div>
					</div>
					<div id="tab4" class="tab">
						<div class="table-responsive">
                                                        <table class="table table-striped" id="subscriber-table"></table>
                                                </div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>
