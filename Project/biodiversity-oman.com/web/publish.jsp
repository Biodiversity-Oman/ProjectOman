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
		  $(document).ready(function(){
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
						<div class="table-responsive">
                                                        <table class="table table-striped" id="published-table"></table>
                                                </div>
					</div>
					<div id="tab2" class="tab">
                                            <div id="update-organism" class="insert-box">
			    <label class="close-button">x</label>
                            <div class="content">
                                <div id="update-organism">
                                    <form class="form form-horizontal" id="update-organism-form" data-toggle="validator" enctype="multipart/form-data">
					<input type="hidden" id="organism-id" name="organism-id">
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
                                                    <input class="form-control" id="scientific-name" type="text" name="organism-scientific-name" maxlength="50" data-delay="1200" pattern="^([A-z\s]){1,}$" required/> 
                                                </div>    
                                                <span class="help-block with-errors">Up to 50 characters upper/lower case(no digits)</span>
                                            </div> 
                                            <div class="form-group">
                                                <label class="col-sm-2 control-label" for="organism-common-name">Common name</label>
                                                <div class="col-sm-4">
                                                    <input class="form-control" id="common-name" type="text" name="organism-common-name" maxlength="50" data-delay="1200" pattern="^([A-z\s]){1,}$" required/> 
                                                </div>
                                                <span class="help-block with-errors">Up to 50 characters upper/lower case(no digits)</span>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-2 control-label" for="organism-local-name">Local name</label>
                                                <div class="col-sm-4">
                                                    <input class="form-control" id="local-name" type="text" name="organism-local-name" maxlength="50" data-delay="1200" required/> 
                                                </div>
                                                <span class="help-block with-errors">Up to 50 characters upper/lower case(no digits)</span>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-2 control-label" for="organism-family">Family</label>
                                                <div class="col-sm-4">
                                                    <select class="form-control" id="family-ddl1" name="organism-family-id"></select>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-2 control-label" for="organism-subfamily">Breed</label>
                                                <div class="col-sm-4">
                                                    <select class="form-control" id="subfamily-ddl" name="organism-subfamily-id"></select>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-2 control-label" for="organism-population">Population</label>
                                                <div class="col-sm-4">
                                                    <input class="form-control" type="text" id="population" maxlength="50" data-delay="1200" name="organism-population" />
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-2 control-label" for="organism-description">Organism description</label>
                                                <div class="col-sm-4">
                                                    <textarea class="form-control" rows="3" id="description" name="organism-description"></textarea>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-2 control-label">Choose Habitat</label>
                                                <div class="col-sm-4">
                                                    <select class="chosen-select form-control" id="habitat-ddl" name="organism-habitat-id" multiple data-placeholder="Choose Habitat"></select>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-2 control-label">Choose World</label>
                                                <div class="col-sm-4">
                                                    <select class="form-control" id="world-ddl" name="organism-world-id" data-placeholder="Choose World"></select>
                                                </div>
                                           </div>
                                             <div class="form-group">
                                                <label class="col-sm-2 control-label" for="organism-photo">Add Photo</label>
                                                <div class="col-sm-4">
                                                    <input type="file" id="photo"  name="upfileOrganism" >
                                                </div>
                                             </div>
                                            
                                            <div class="form-group">
                                                <label class="col-sm-2 control-label" for="organism-indigenous">Indigenous</label>
                                                <div class="col-sm-4">
                                                    <input style="width: 1em;"   type="radio" id="organismIndigenousTrue"  name="organism-indigenous" value="true" required> <label>Yes</label><br>
                                                    <input style="width: 1em;"  type="radio" id="organismIndigenousFalse" name="organism-indigenous" value="false" required> <label>No</label>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-2 control-label" for="organism-cultivated">Cultivated</label>
                                                <div class="col-sm-4">
                                                    <input style="width: 1em;"   type="radio" id="organismCultivateTrue"  name="organism-cultivated" value="true" required> <label>Yes</label><br>
                                                    <input style="width: 1em;"  type="radio" id="organismCultivateFalse" name="organism-cultivated" value="false" required> <label>No</label>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-2 control-label" for="organism-endangered">Endangered</label>
                                                <div class="col-sm-4">
                                                    <input style="width: 1em;"   type="radio" id="organismEndangeredTrue"  name="organism-endangered" value="true" required> <label>Yes</label><br>
                                                    <input style="width: 1em;"  type="radio" id="organismEndangeredFalse" name="organism-endangered" value="false" required> <label>No</label>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-2 control-label" for="organism-medicinal">Medicinal</label>
                                                <div class="col-sm-4">
                                                    <input style="width: 1em;"   type="radio" id="organismMedicinalTrue"  name="organism-medicinal" value="true" required> <label>Yes</label><br>
                                                    <input style="width: 1em;"  type="radio" id="organismMedicinalFalse" name="organism-medicinal" value="false" required> <label>No</label>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-2 control-label" for="organism-benefits">Benefits</label>
                                                <div class="col-sm-4">
                                                    <textarea rows="3" class="form-control" id="benefits"  name="organism-benefits"></textarea>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-2 control-label" for="organism-dangerous">Dangers</label>
                                                <div class="col-sm-4">
                                                    <textarea rows="3" class="form-control" id="dangerous"  name="organism-dangerous"></textarea>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-2 control-label" for="organism-threats">Threats</label>
                                                <div class="col-sm-4">
                                                    <textarea rows="3" class="form-control" id="threats" name="organism-threats"></textarea>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-2 control-label" for="organism-opportunities">Opportunities</label>
                                                <div class="col-sm-4">
                                                    <textarea rows="3" class="form-control" id="opportunities" name="organism-opportunities"></textarea>
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <label class="col-sm-2 control-label" for="organism-links">Usefull links</label>
                                                <div class="col-sm-4">
                                                    <textarea rows="3" class="form-control" id="links" name="organism-links"></textarea>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-2 control-label" for="organism-food-name">Food name if this organism is not yet present</label>
                                                <div class="col-sm-4">
                                                    <input class="form-control" type="text" id="food-name" name="organism-food-name" maxlength="50" data-delay="1200" required/> 
                                                </div>
                                                <span class="help-block with-errors">Up to 50 characters upper/lower case(no digits)</span>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-2 control-label" for="organism-food-description">Food description if this organism is not yet present</label>
                                                <div class="col-sm-4">
                                                    <textarea rows="3" class="form-control" id="food-description" name="organism-food-description"></textarea>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-2 control-label">Choose season</label>
                                                <div class="col-sm-4">
                                                    <select class="chosen-select form-control" id="season-ddl" name="organism-season-id" multiple data-placeholder="Choose Season">

                                                    </select>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-2 control-label">Choose geolocations</label>
                                                <div class="col-sm-4">
                                                    <select class="chosen-select form-control" id="geolocation" name="organism-geolocation-id" multiple data-placeholder="Choose Geolocations">
                                                        <option value="1">geo</option>
                                                        <option value="2">geo</option>
                                                        <option value="3">geo</option>
                                                        <option value="4">geo</option>
                                                    </select>
                                                </div>
                                            </div>
					<div class="form-group">
                                            <label class="col-sm-2 control-label"></label>
                                            <div class="col-sm-4">
                                                <div class="message" id="validate-organism-message"></div>
                                            </div>
                                        </div>
                                            <div class="form-group">
                                                <label class="col-sm-2 control-label"></label>
                                                <div class="col-sm-2">
                                                    <button class="btn btn-default" id="organism-id" type="submit">Approve and submit</button>
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
