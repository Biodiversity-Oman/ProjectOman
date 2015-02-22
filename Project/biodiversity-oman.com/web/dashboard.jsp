<%-- 
    Document   : welcome
    Created on : Feb 17, 2015, 12:23:34 AM
    Author     : lennyasus
--%>
<%@include file="/adminheader.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<script src="js/ajax.js"></script>
		<script src="js/validator.js"></script>
		
	</head>
	<script>
                function adminCheck() {
		<%if (us.getIsAdmin() == false) {%>
                    $(".no-button").each(function () {
                        $(this).hide();
                    });
		<%} else {%>
		<%}%>
                }
                ;
	</script>
	<body onload="loadWorlds();
                    loadSeasons();
                    loadHabitats();">
		<div class="wrapper">
			<div class="tabs">
				<ul class="tab-links">
					<li class="active"><a href="#tab1"><span class="icon-file-text"></span>Organisms</a></li>
					<li><a href="#tab2"><span class="icon-pencil2"></span>Organism</a></li>
					<li><a href="#tab3" onclick="adminCheck();"><span class="icon-file-text"></span>Worlds</a></li>
					<li><a href="#tab4"><span class="icon-pencil2"></span>World</a></li>
					<li><a href="#tab5" ><span class="icon-file-text"></span>Families</a></li>
					<li><a href="#tab6"><span class="icon-pencil2"></span>Family</a></li>
					<li><a href="#tab7"><span class="icon-file-text"></span>Subfamilies</a></li>
					<li><a href="#tab8"><span class="icon-pencil2"></span>Subfamily</a></li>
					<li><a href="#tab9" onclick="adminCheck();"><span class="icon-file-text"></span>Seasons</a></li>
					<li><a href="#tab10"><span class="icon-pencil2"></span>Season</a></li>
					<li><a href="#tab11" onclick="adminCheck();"><span class="icon-file-text"></span>Habitats</a></li>
					<li><a href="#tab12"><span class="icon-pencil2"></span>Habitat</a></li>
					<li><a href="#tab13"><span class="icon-file-text"></span>Geolocations</a></li>
					<li><a href="#tab14"><span class="icon-pencil2"></span>Geolocation</a></li>
				</ul>
				<div class="tab-content">
					<div id="tab1" class="tab active">
						<div class="spinner"></div>
					</div>
					<div id="tab2" class="tab">
						<div class="spinner"></div>
					</div>
					<div id="tab3" class="tab">
						<div class="table-responsive">
							<div class="col-sm-10">
								<table class="table table-striped" id="worlds-table"></table>
							</div>
						</div>
					</div>
					<div id="tab4" class="tab">
						<div id="create-world">
							<form class="form form-horizontal" id="create-world-form" data-toggle="validator">
								<div class="form-group">
									<label class="col-sm-2 control-label"></label>
									<div class="col-sm-2">
										<h2 class="h2">Create World</h2>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label" for="world-name">Name</label>
									<div class="col-sm-4">
										<input class="form-control" type="text" name="world-name" maxlength="50" data-delay="1200" pattern="^([A-z]){1,}$" required/>
										<span class="help-block with-errors">Up to 50 characters upper/lower case(no digits)</span>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label" for="world-description">Description</label>
									<div class="col-sm-4">
										<textarea rows="3" class="form-control" type="text" name="world-description"></textarea>
									</div>
								</div>
								<div class="form-group"">
									<label class="col-sm-2 control-label"></label>
									<div class="col-sm-4">
										<div id="create-world-message"></div>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label"></label>
									<div class="col-sm-2">
										<button class="btn btn-default" type="submit">Insert</button>
										<button class="btn btn-default" type="reset">Reset</button>
									</div>
								</div>
							</form>
						</div>
					</div>
					<div id="tab5" class="tab">
						<div class="spinner"></div>
					</div>
					<div id="tab6" class="tab">
						<div class="spinner"></div>
					</div>
					<div id="tab7" class="tab">
						<div class="spinner"></div>
					</div>
					<div id="tab8" class="tab">
						<div class="spinner"></div>
					</div>
					<div id="tab9" class="tab">
						<div class="table-responsive">
							<div class="col-sm-10">
								<table class="table table-striped" id="seasons-table"></table>
							</div>
						</div>
					</div>
					<div id="tab10" class="tab">
						<div id="create-season">
							<form class="form form-horizontal" id="create-season-form" data-toggle="validator">
								<div class="form-group">
									<div class="form-group">
										<label class="col-sm-2 control-label"></label>
										<div class="col-sm-2">
											<h2 class="h2">Create Season</h2>
										</div>
									</div>
									<label class="col-sm-2 control-label" for="season-name">Name</label>
									<div class="col-sm-4">
										<input class="form-control" type="text" name="season-name" maxlength="50" data-delay="1200" pattern="^([A-z]){1,}$" required/>
										<span class="help-block with-errors">Up to 50 characters upper/lower case(no digits)</span>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label" for="season-description">Description</label>
									<div class="col-sm-4">
										<textarea rows="3" class="form-control" type="text" name="season-description"></textarea>
									</div>
								</div>
								<div class="form-group"">
									<label class="col-sm-2 control-label"></label>
									<div class="col-sm-4">
										<div id="create-season-message"></div>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label"></label>
									<div class="col-sm-2">
										<button class="btn btn-default" type="submit" >Insert</button>
										<button class="btn btn-default" type="reset">Reset</button>
									</div>
								</div>
							</form>
						</div>
					</div>
					<div id="tab11" class="tab">
						<div class="table-responsive">
							<div class="col-sm-10">
								<table class="table table-striped" id="habitats-table"></table>
							</div>
						</div>
					</div>
					<div id="tab12" class="tab">
						<div id="create-habitat">
							<form class="form form-horizontal" id="create-habitat-form" data-toggle="validator">
								<div class="form-group">
									<label class="col-sm-2 control-label"></label>
									<div class="col-sm-2">
										<h2 class="h2">Create Habitat</h2>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label" for="habitat-name">Name</label>
									<div class="col-sm-4">
										<input class="form-control" type="text" name="habitat-name" maxlength="50" data-delay="1200" pattern="^([A-z]){1,}$" required/>
										<span class="help-block with-errors">Up to 50 characters upper/lower case(no digits)</span>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label" for="habitat-description">Description</label>
									<div class="col-sm-4">
										<textarea rows="3" class="form-control" type="text" name="habitat-description"></textarea>
									</div>
								</div>
								<div class="form-group"">
									<label class="col-sm-2 control-label"></label>
									<div class="col-sm-4">
										<div id="create-habitat-message"></div>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label"></label>
									<div class="col-sm-2">
										<button class="btn btn-default" type="submit">Insert</button>
										<button class="btn btn-default" type="reset">Reset</button>
									</div>
								</div>
							</form>
						</div>
					</div>
					<div id="tab13" class="tab">
						<div class="spinner"></div>
					</div>
					<div id="tab14" class="tab">
						<div class="spinner"></div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>

