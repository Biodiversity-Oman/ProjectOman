<%-- 
    Document   : welcome
    Created on : Feb 17, 2015, 12:23:34 AM
    Author     : lennyasus
--%>
<%@include file="/adminheader.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="StyleSheet" type="text/css" href="css/chosen.css">
        <script src="js/ajax.js"></script>
        <script src="js/loaders.js"></script>
        <script src="js/maps.js"></script>
        <script src="js/validator.js"></script>
        <script src="js/chosen.jquery.min.js"></script>
        <script>
            <%if (us.getIsAdmin() == false) {%>
                $(document).ready(function (){
                    $(".no-button").each(function () {
                        $(this).hide();
                    });
                });
                    
            <%} else {%>
            <%}%>
            $(document).ready(function () {
                loadOrganisms();
                loadWorlds();
                loadSeasons();
                loadFamilies();
                loadSubFamilies();
                loadHabitats();
                loadGeolocations();
                loadPendingOrganisms();
                $(".chosen-select").chosen({width: "100%"});
                adminCheck();
            });
        </script>
    </head>
    <body>
        <div class="wrapper">
            <div id="fade" class="black_overlay"></div>
            <div class="tabs">
                <ul class="tab-links">
                    <li class="active"><a href="#tab1"><span class="icon-file-text"></span>Organisms</a></li>
                    <li><a href="#tab2"><span class="icon-file-text"></span>Worlds</a></li>
                    <li><a href="#tab3"><span class="icon-file-text"></span>Families</a></li>
                    <li><a href="#tab4"><span class="icon-file-text"></span>Breed</a></li>
                    <li><a href="#tab5"><span class="icon-file-text"></span>Seasons</a></li>
                    <li><a href="#tab6"><span class="icon-file-text"></span>Habitats</a></li>
                    <li><a href="#tab7"><span class="icon-file-text"></span>Geolocations</a></li>
                    <li><a href="#tab8"><span class="icon-file-text"></span>Pending for evaluation</a></li>
                </ul>
                <div class="tab-content">
                    <div id="tab1" class="tab active">
                        <a href = "javascript:void(0)" onclick = "document.getElementById('insert-organism').style.display = 'block';
                                document.getElementById('fade').style.display = 'block'"><button class="action-button"><span class="icon-plus"></span></button></a>
                        <div id="insert-organism" class="insert-box">
                            <label class="close-button">x</label>
                            <div class="content">
                                <div id="create-organism">
                                    <form class="form form-horizontal" id="create-organism-form" data-toggle="validator" enctype="multipart/form-data">
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label"></label>
                                            <div class="col-sm-4">
                                                <h2 class="h2">Create Organism</h2>
                                            </div>
                                        </div>
                                        <!--<form class="form-group"> -->                                           
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label" for="organism-scientific-name">Scientific name</label>
                                            <div class="col-sm-4">
                                                <input class="form-control" type="text" name="organism-scientific-name" maxlength="50" data-delay="1200" pattern="^([ A-z\s]){1,}$" required/> 
                                            </div>    
                                            <span class="help-block with-errors">Up to 50 characters upper/lower case(no digits)</span>
                                        </div> 
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label" for="organism-common-name">Common name</label>
                                            <div class="col-sm-4">
                                                <input class="form-control" type="text" name="organism-common-name" maxlength="50" data-delay="1200" pattern="^([ A-z\s]){1,}$" required/> 
                                            </div>
                                            <span class="help-block with-errors">Up to 50 characters upper/lower case(no digits)</span>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label" for="organism-local-name">Local name</label>
                                            <div class="col-sm-4">
                                                <input class="form-control" type="text" name="organism-local-name" maxlength="50" data-delay="1200" required/> 
                                            </div>
                                            <span class="help-block with-errors">Up to 50 characters upper/lower case(no digits)</span>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label" for="organism-family">Family</label>
                                            <div class="col-sm-4">
                                                <select class="form-control" id="family-ddl" name="organism-family-id"></select>
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
                                                <input class="form-control" type="text" id="organism-population" maxlength="50" data-delay="1200" name="organism-population" />
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label" for="organism-description">Organism description</label>
                                            <div class="col-sm-4">
                                                <textarea class="form-control" rows="3" name="organism-description"></textarea>
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
                                                <select class="form-control" id="world-ddl1" name="organism-world-id" data-placeholder="Choose World"></select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label" for="organism-opportunities">Add Photo</label>
                                            <div class="col-sm-4">
                                                <input type="file"  name="upfileOrganism" >
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
                                                <textarea rows="3" class="form-control"  name="organism-benefits"></textarea>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label" for="organism-dangerous">Dangers</label>
                                            <div class="col-sm-4">
                                                <textarea rows="3" class="form-control"  name="organism-dangerous"></textarea>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label" for="organism-threats">Threats</label>
                                            <div class="col-sm-4">
                                                <textarea rows="3" class="form-control" name="organism-threats"></textarea>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label" for="organism-opportunities">Opportunities</label>
                                            <div class="col-sm-4">
                                                <textarea rows="3" class="form-control" name="organism-opportunities"></textarea>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label class="col-sm-2 control-label" for="organism-links">Usefull links</label>
                                            <div class="col-sm-4">
                                                <textarea rows="3" class="form-control" name="organism-links"></textarea>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label" for="organism-food-name">Food name if this organism is not yet present</label>
                                            <div class="col-sm-4">
                                                <input class="form-control" type="text" name="organism-food-name" maxlength="50" data-delay="1200" required/> 
                                            </div>
                                            <span class="help-block with-errors">Up to 50 characters upper/lower case(no digits)</span>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label" for="organism-food-description">Food description if this organism is not yet present</label>
                                            <div class="col-sm-4">
                                                <textarea rows="3" class="form-control" name="organism-food-description"></textarea>
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
                                                <select class="chosen-select form-control" name="organism-geolocation-id" multiple data-placeholder="Choose Geolocations">
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
                                                <div class="message" id="create-organism-message"></div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label"></label>
                                            <div class="col-sm-2">
                                                <button class="btn btn-default" type="submit">Submit</button>
                                                <button class="btn btn-default" type="reset">Reset</button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <div class="table-responsive">
                            <table class="table table-striped" id="organisms-table"></table>
                        </div>
                    </div>
                    <div id="tab2" class="tab">
                        <a href = "javascript:void(0)" onclick = "document.getElementById('insert-world').style.display = 'block';
                                document.getElementById('fade').style.display = 'block'"><button class="action-button"><span class="icon-plus"></button></a>
                        <div id="insert-world" class="insert-box">
                            <label class="close-button">x</label>
                            <div class="content">
                                <div id="create-world">
                                    <form class="form form-horizontal" id="create-world-form" data-toggle="validator">
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label"></label>
                                            <div class="col-sm-4">
                                                <h2 class="h2">Create World</h2>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label" for="world-name">Name</label>
                                            <div class="col-sm-4">
                                                <input class="form-control" type="text" name="world-name" maxlength="50" data-delay="1200" pattern="^([A-z\s ]){1,}$" required/>
                                                <span class="help-block with-errors">Up to 50 characters upper/lower case(no digits)</span>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label" for="world-description">Description</label>
                                            <div class="col-sm-4">
                                                <textarea rows="3" class="form-control"  name="world-description"></textarea>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label"></label>
                                            <div class="col-sm-4">
                                                <div class="message" id="create-world-message"></div>
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
                        </div>
                        <div id="update-world" class="insert-box">
                            <label class="close-button">x</label>
                            <div class="content">
                                <div id="update-world">
                                    <form class="form form-horizontal" id="update-world-form" data-toggle="validator">
                                        <input type="hidden" id="world-id" name="world-id" />
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label"></label>
                                            <div class="col-sm-4">
                                                <h2 class="h2">Update World</h2>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label" for="world-name">Name</label>
                                            <div class="col-sm-4">
                                                <input class="form-control" type="text" name="world-name" id="world-name" maxlength="50" data-delay="1200" pattern="^([A-z\s ]){1,}$" required/>
                                                <span class="help-block with-errors">Up to 50 characters upper/lower case(no digits)</span>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label" for="world-description">Description</label>
                                            <div class="col-sm-4">
                                                <textarea rows="3" class="form-control" id="world-description" name="world-description"></textarea>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label"></label>
                                            <div class="col-sm-4">
                                                <div class="message" id="update-world-message"></div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label"></label>
                                            <div class="col-sm-2">
                                                <button class="btn btn-default" type="submit">Update</button>
                                                <button class="btn btn-default" type="reset">Reset</button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <div class="table-responsive">
                            <table class="table table-striped" id="worlds-table"></table>
                        </div>
                    </div>
                    <div id="tab3" class="tab">
                        <a href = "javascript:void(0)" onclick = "document.getElementById('insert-family').style.display = 'block';
                                document.getElementById('fade').style.display = 'block'"><button class="action-button"><span class="icon-plus"></button></a>
                        <div id="insert-family" class="insert-box">
                            <label class="close-button">x</label>
                            <div class="content">
                                <div id="create-family">
                                    <form class="form form-horizontal" id="create-family-form" data-toggle="validator">
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label"></label>
                                            <div class="col-sm-4">
                                                <h2 class="h2">Create Family</h2>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label" for="family-name">Name</label>
                                            <div class="col-sm-4">
                                                <input class="form-control" type="text" name="family-name" maxlength="50" data-delay="1200" pattern="^([A-z\s]){1,}$" required/>
                                                <span class="help-block with-errors">Up to 50 characters upper/lower case(no digits)</span>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label" for="family-description">Description</label>
                                            <div class="col-sm-4">
                                                <textarea rows="3" class="form-control" name="family-description"></textarea>
                                            </div>
                                        </div>                                                           
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">Choose World</label>
                                            <div class="col-sm-4">
                                                <select class="form-control" id="world-ddl2" name="world-id" required></select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label"></label>
                                            <div class="col-sm-4">
                                                <div id="create-family-message"></div>
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
                        </div>
                        <div id="update-family" class="insert-box">
                            <label class="close-button">x</label>
                            <div class="content">
                                <div id="update-family">
                                    <form class="form form-horizontal" id="update-family-form" data-toggle="validator">
                                        <input type="hidden" id="family-id" name="family-id" />
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label"></label>
                                            <div class="col-sm-4">
                                                <h2 class="h2">Update Family</h2>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label" for="family-name">Name</label>
                                            <div class="col-sm-4">
                                                <input class="form-control" type="text" name="family-name" id="family-name" maxlength="50" data-delay="1200" pattern="^([A-z\s]){1,}$" required/>
                                                <span class="help-block with-errors">Up to 50 characters upper/lower case(no digits)</span>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label" for="family-description">Description</label>
                                            <div class="col-sm-4">
                                                <textarea rows="3" class="form-control" name="family-description" id="family-description"></textarea>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label" for="family-world">World</label>
                                            <div class="col-sm-4">
                                                <select class="form-control" id="world-ddl4" name="update-world-id" required></select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label"></label>
                                            <div class="col-sm-4">
                                                <div class="message" id="update-family-message"></div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label"></label>
                                            <div class="col-sm-2">
                                                <button class="btn btn-default" type="submit">Update</button>
                                                <button class="btn btn-default" type="reset">Reset</button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <div class="table-responsive">
                            <table class="table table-striped" id="families-table"></table>
                        </div>
                    </div>
                    <div id="tab4" class="tab">
                        <a href = "javascript:void(0)" onclick = "document.getElementById('insert-subfamily').style.display = 'block';
                                document.getElementById('fade').style.display = 'block'"><button class="action-button"><span class="icon-plus"></button></a>
                        <div id="insert-subfamily" class="insert-box">
                            <label class="close-button">x</label>
                            <div class="content">
                                <div id="create-subfamily">
                                    <form class="form form-horizontal" id="create-subfamily-form" data-toggle="validator">
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label"></label>
                                            <div class="col-sm-4">
                                                <h2 class="h2">Create Breed</h2>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label" for="subfamily-name">Name</label>
                                            <div class="col-sm-4">
                                                <input class="form-control" type="text" name="subfamily-name" maxlength="50" data-delay="1200" pattern="^([A-z\s]){1,}$" required/>
                                                <span class="help-block with-errors">Up to 50 characters upper/lower case(no digits)</span>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label" for="submfamily-description">Description</label>
                                            <div class="col-sm-4">
                                                <textarea rows="3" class="form-control" name="subfamily-description"></textarea>
                                            </div>
                                        </div>                                                            
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label" for="subfamily-family">Family</label>
                                            <div class="col-sm-4">
                                                <select class="form-control" id="family-ddl3" name="family-id"></select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label"></label>
                                            <div class="col-sm-4">
                                                <div id="create-subfamily-message"></div>
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
                        </div>
                        <div id="update-subfamily" class="insert-box">
                            <label class="close-button">x</label>
                            <div class="content">
                                <div id="update-subfamily">
                                    <form class="form form-horizontal" id="update-subfamily-form" data-toggle="validator">
                                        <input type="hidden" id="subfamily-id" name="subfamily-id" />
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label"></label>
                                            <div class="col-sm-4">
                                                <h2 class="h2">Update Breed</h2>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label" for="subfamily-name">Name</label>
                                            <div class="col-sm-4">
                                                <input class="form-control" type="text" name="subfamily-name" id="subfamily-name" maxlength="50" data-delay="1200" pattern="^([A-z\s]){1,}$" required/>
                                                <span class="help-block with-errors">Up to 50 characters upper/lower case(no digits)</span>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label" for="subfamily-description">Description</label>
                                            <div class="col-sm-4">
                                                <textarea rows="3" class="form-control" name="subfamily-description" id="subfamily-description"></textarea>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label" for="family-id">Family</label>
                                            <div class="col-sm-4">
                                                <select class="form-control" id="family-ddl2" name="family-id" required></select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label"></label>
                                            <div class="col-sm-4">
                                                <div class="message" id="update-subfamily-message"></div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label"></label>
                                            <div class="col-sm-2">
                                                <button class="btn btn-default" type="submit">Update</button>
                                                <button class="btn btn-default" type="reset">Reset</button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>

                        <div class="table-responsive">
                            <table class="table table-striped" id="subfamilies-table"></table>
                        </div>
                    </div>
                    <div id="tab5" class="tab">
                        <a href = "javascript:void(0)" onclick = "document.getElementById('insert-season').style.display = 'block';
                                document.getElementById('fade').style.display = 'block'"><button class="action-button"><span class="icon-plus"></button></a>
                        <div id="insert-season" class="insert-box">
                            <label class="close-button">x</label>
                            <div class="content">
                                <div id="create-season">
                                    <form class="form form-horizontal" id="create-season-form" data-toggle="validator">
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label"></label>
                                            <div class="col-sm-4">
                                                <h2 class="h2">Create Season</h2>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label" for="season-name">Name</label>
                                            <div class="col-sm-4">
                                                <input class="form-control"type="text" name="season-name" maxlength="50" data-delay="1200" pattern="^([A-z\s]){1,}$" required/>
                                                <span class="help-block with-errors">Up to 50 characters upper/lower case(no digits)</span>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label" for="season-description">Description</label>
                                            <div class="col-sm-4">
                                                <textarea rows="3" class="form-control" name="season-description"></textarea>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label"></label>
                                            <div class="col-sm-4">
                                                <div id="create-season-message"></div>
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
                        </div>
                        <div id="update-season" class="insert-box">
                            <label class="close-button">x</label>
                            <div class="content">
                                <div id="update-season">
                                    <form class="form form-horizontal" id="update-season-form" data-toggle="validator">
                                        <input type="hidden" id="season-id" name="season-id" />
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label"></label>
                                            <div class="col-sm-4">
                                                <h2 class="h2">Update Season</h2>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label" for="season-name">Name</label>
                                            <div class="col-sm-4">
                                                <input class="form-control" type="text" name="season-name" id="season-name" maxlength="50" data-delay="1200" pattern="^([A-z\s ]){1,}$" required/>
                                                <span class="help-block with-errors">Up to 50 characters upper/lower case(no digits)</span>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label" for="season-description">Description</label>
                                            <div class="col-sm-4">
                                                <textarea rows="3" class="form-control" id="season-description" name="season-description"></textarea>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label"></label>
                                            <div class="col-sm-4">
                                                <div class="message" id="update-season-message"></div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label"></label>
                                            <div class="col-sm-2">
                                                <button class="btn btn-default" type="submit">Update</button>
                                                <button class="btn btn-default" type="reset">Reset</button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <div class="table-responsive">
                            <table class="table table-striped" id="seasons-table"></table>
                        </div>
                    </div>
                    <div id="tab6" class="tab">
                        <a href = "javascript:void(0)" onclick = "document.getElementById('insert-habitat').style.display = 'block';
                                document.getElementById('fade').style.display = 'block'"><button class="action-button"><span class="icon-plus"></button></a>
                        <div id="insert-habitat" class="insert-box"><label class="close-button">x</label>
                            <div class="content">
                                <div id="create-habitat">
                                    <form class="form form-horizontal" id="create-habitat-form" data-toggle="validator">
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label"></label>
                                            <div class="col-sm-4">
                                                <h2 class="h2">Create Habitat</h2>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label" for="habitat-name">Name</label>
                                            <div class="col-sm-4">
                                                <input class="form-control" type="text" name="habitat-name" maxlength="50" data-delay="1200" pattern="^([A-z\s]){1,}$" required/>
                                                <span class="help-block with-errors">Up to 50 characters upper/lower case(no digits)</span>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label" for="habitat-description">Description</label>
                                            <div class="col-sm-4">
                                                <textarea rows="3" class="form-control" name="habitat-description"></textarea>
                                            </div>
                                        </div>
                                        <div class="form-group">
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
                        </div>

                        <div id="update-habitat" class="insert-box">
                            <label class="close-button">x</label>
                            <div class="content">
                                <div id="update-habitat">
                                    <form class="form form-horizontal" id="update-habitat-form" data-toggle="validator">
                                        <input type="hidden" id="habitat-id" name="habitat-id" />
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label"></label>
                                            <div class="col-sm-4">
                                                <h2 class="h2">Update Habitat</h2>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label" for="habitat-name">Name</label>
                                            <div class="col-sm-4">
                                                <input class="form-control" type="text" name="habitat-name" id="habitat-name" maxlength="50" data-delay="1200" pattern="^([A-z\s]){1,}$" required/>
                                                <span class="help-block with-errors">Up to 50 characters upper/lower case(no digits)</span>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label" for="habitat-description">Description</label>
                                            <div class="col-sm-4">
                                                <textarea rows="3" class="form-control" id="habitat-description" name="habitat-description"></textarea>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label"></label>
                                            <div class="col-sm-4">
                                                <div id="update-habitat-message"></div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label"></label>
                                            <div class="col-sm-2">
                                                <button class="btn btn-default" type="submit">Update</button>
                                                <button class="btn btn-default" type="reset">Reset</button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <div class="table-responsive">
                            <table class="table table-striped" id="habitats-table"></table>
                        </div>
                    </div>
                    <div id="tab7" class="tab">
                        <a href = "javascript:void(0)" onclick = "document.getElementById('insert-geolocation').style.display = 'block';
                                document.getElementById('fade').style.display = 'block'; loadScript();"><button class="action-button" ><span class="icon-plus"></button></a>
                        <div id="insert-geolocation" class="insert-box">
                            <label id="geolocation-close1" class="close-button">x</label>
                            <div class="content">
                                <div id="create-geolocation">
                                    <form class="form form-horizontal" id="create-geolocation-form" data-toggle="validator">
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label"></label>
                                            <div class="col-sm-4">
                                                <h2 class="h2">Create Geolocation</h2>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label" for="area-name">Area name</label>
                                            <div class="col-sm-4">
                                                <input class="form-control" type="text" name="area-name" maxlength="50" data-delay="1200" pattern="^([A-z\s]){1,}$" required/>
                                                <span class="help-block with-errors">Up to 50 characters upper/lower case(no digits)</span>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label" for="area-description">Description</label>
                                            <div class="col-sm-4">
                                                <textarea rows="3" class="form-control" name="area-description"></textarea>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label" for="area-map">Make area</label>
                                            <div class="col-sm-4">
                                                <span class="help-block with-errors">Use 3 mouse clicks to make an area</span>
                                                <div id="map-canvas" class="map-canvas"></div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label"></label>
                                            <div class="col-sm-4">
                                                <input class="form-control" id="area-coordinates" type="hidden" name="area-coordinates" value="20.87,55.76"/>
                                                <div id="create-geolocation-message"></div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label"></label>
                                            <div class="col-sm-2">
                                                <button class="btn btn-default" type="submit">Insert</button>
                                                <button class="btn btn-default" type="reset" id="geolocation-reset1">Reset</button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <div id="update-geolocation" class="insert-box">
                            <label id="geolocation-close2" class="close-button">x</label>
                            <div class="content">
                                <div id="update-geolocation-test">
                                    <form class="form form-horizontal" id="update-geolocation-form" data-toggle="validator">
                                        <input type="hidden" id="geolocation-id" name="geolocation-id" />
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label"></label>
                                            <div class="col-sm-4">
                                                <h2 class="h2">Update Geolocation</h2>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label" for="area-name">Name</label>
                                            <div class="col-sm-4">
                                                <input class="form-control" type="text" name="area-name" id="area-name" maxlength="50" data-delay="1200" pattern="^([A-z\s ]){1,}$" required/>
                                                <span class="help-block with-errors">Up to 50 characters upper/lower case(no digits)</span>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label" for="area-description">Description</label>
                                            <div class="col-sm-4">
                                                <textarea rows="3" class="form-control" id="area-description" name="area-description"></textarea>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label" for="area-map">Area</label>
                                            <div class="col-sm-4">
                                                <button id="edit-map" class="btn btn-default" type="button">Edit map</button>
                                                <div id="update-canvas" class="map-canvas"></div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label"></label>
                                            <div class="col-sm-4">
                                                <input class="form-control" id="update-coordinates" type="hidden" name="update-coordinates" value="20.87,55.76"/>
                                                <div class="message" id="update-geolocation-message"></div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label"></label>
                                            <div class="col-sm-2">
                                                <button class="btn btn-default" type="submit">Update</button>
                                                <button class="btn btn-default" type="reset" id="geolocation-reset2">Reset</button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <div class="table-responsive">
                            <table class="table table-striped" id="geolocations-table"></table>
                        </div>
                    </div>
                    <div id="tab8" class="tab">
						<div id="update-pendingorganism" class="insert-box">
							<label class="close-button">x</label>
							<div class="content">
								<div id="update-pendingorganism">
									<form class="form form-horizontal" id="update-pendingorganism-form" data-toggle="validator" enctype="multipart/form-data">
										<input type="hidden" id="organism-id" name="organism-id">
										<div class="form-group">
											<label class="col-sm-2 control-label"></label>
											<div class="col-sm-4">
												<h2 class="h2">Update this organism before validation</h2>
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
												<select class="form-control" id="family-ddl2-pending" name="organism-family-id"></select>
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label" for="organism-subfamily">Breed</label>
											<div class="col-sm-4">
												<select class="form-control" id="subfamily-ddl-pending" name="organism-subfamily-id"></select>
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
												<select class="chosen-select form-control" id="habitat-ddl2-pending" name="organism-habitat-id" multiple data-placeholder="Choose Habitat"></select>
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label">Choose World</label>
											<div class="col-sm-4">
												<select class="form-control" id="world-ddl4-pending" name="organism-world-id" data-placeholder="Choose World"></select>
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
												<select class="chosen-select form-control" id="season-ddl2-pending" name="organism-season-id" multiple data-placeholder="Choose Season">

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
												<div id="update-pending-message"></div>
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
                                                        <table class="table table-striped" id="pending-table"></table>
                                                </div>
					</div>
                </div>
            </div>
        </div>
    </body>
</html>

