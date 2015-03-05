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
        <script src="js/validator.js"></script>
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
                        <p>Press the &nbsp;&nbsp;&nbsp;<span class="icon-pencil2"></span> &nbsp;&nbsp; To edit</p>
                        <p>Press the <span class="icon-cross"></span> To delete (Caution! no confirmation screen)</p>
                        <div class="table-responsive">
                            <div class="col-sm-4">
                                <input class="form-control" id="search-organism" type="text" name="organismkey" placeholder="Search on any name"><br>
                            </div>
                            <table class="table table-striped" id="organisms-table"></table>
                        </div>
                    </div>
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
                                                <input class="form-control" id="scientific-name-published" type="text" name="organism-scientific-name" maxlength="50" data-delay="1200" pattern="[^()[\]{}*&^%$<>#0-9@!]+$" required/> 
                                            </div>    
                                            <span class="help-block with-errors">Up to 50 characters upper/lower case(no digits)</span>
                                        </div> 
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label" for="organism-common-name">Common name</label>
                                            <div class="col-sm-4">
                                                <input class="form-control" id="common-name-published" type="text" name="organism-common-name" maxlength="50" data-delay="1200" pattern="[^()[\]{}*&^%$<>#0-9@!]+$" required/> 
                                            </div>
                                            <span class="help-block with-errors">Up to 50 characters upper/lower case(no digits)</span>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label" for="organism-local-name">Local name</label>
                                            <div class="col-sm-4">
                                                <input class="form-control" id="local-name-published" type="text" name="organism-local-name" maxlength="50" data-delay="1200" pattern="[^()[\]{}*&^%$<>#0-9@!]+$" required/> 
                                            </div>
                                            <span class="help-block with-errors">Up to 50 characters upper/lower case(no digits)</span>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label" for="family">Family</label>
                                            <div class="col-sm-4">
                                                <select class="form-control" id="family-ddl-published" name="organism-family-id"></select>
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
                                                <input class="form-control" type="text" id="population-published" maxlength="50" data-delay="1200" pattern="[^()[\]{}*^$<>#@]+$" name="organism-population" />
                                                <span class="help-block with-errors">Up to 50 characters. Use of < or > not allowed</span>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label" for="organism-description">Organism description</label>
                                            <div class="col-sm-4">
                                                <textarea class="form-control" rows="3" id="description-published" name="organism-description" pattern="[^()[\]{}*^%$<>#0-9@]+$"></textarea>
                                                <span class="help-block with-errors">Up to 9000 characters upper/lower case(no digits)</span>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">Choose Habitat</label>
                                            <div class="col-sm-4">
                                                <select class="chosen-select form-control" id="habitat-ddl-published" name="organism-habitat-id" multiple data-placeholder="Choose Habitat"></select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">Choose World</label>
                                            <div class="col-sm-4">
                                                <select class="form-control" id="world-ddl-published" name="organism-world-id" data-placeholder="Choose World"></select>
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
                                                <textarea rows="3" class="form-control" id="benefits-published"  name="organism-benefits" pattern="[^()[\]{}*^$<>#@]+$"></textarea>
                                                <span class="help-block with-errors">Up to 2000 characters upper/lower case</span>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label" for="organism-dangerous">Dangers</label>
                                            <div class="col-sm-4">
                                                <textarea rows="3" class="form-control" id="dangerous-published"  name="organism-dangerous" pattern="[^()[\]{}*&^%$<>#@]+$"></textarea>
                                                <span class="help-block with-errors">Up to 2000 characters upper/lower case</span>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label" for="organism-threats">Threats</label>
                                            <div class="col-sm-4">
                                                <textarea rows="3" class="form-control" id="threats-published" name="organism-threats" pattern="[^()[\]{}*^$<>#@]+$"></textarea>
                                                <span class="help-block with-errors">Up to 2000 characters upper/lower case</span>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label" for="organism-opportunities">Opportunities</label>
                                            <div class="col-sm-4">
                                                <textarea rows="3" class="form-control" id="opportunities-published" name="organism-opportunities" pattern="[^()[\]{}*^$<>#]+$"></textarea>
                                                <span class="help-block with-errors">Up to 2000 characters upper/lower case</span>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label" for="organism-links">Usefull links</label>
                                            <div class="col-sm-4">
                                                <textarea rows="3" class="form-control" id="links-published" name="organism-links" pattern="[^()[\]{}*^$<>#]+$" ></textarea>
                                                <span class="help-block with-errors">Up to 2000 characters upper/lower case</span>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label" for="organism-food-name">Food name if this organism is not yet present</label>
                                            <div class="col-sm-4">
                                                <input class="form-control" type="text" id="food-name-published" name="organism-food-name" maxlength="50" data-delay="1200" pattern="[^()[\]{}*^$<>#]+$" required/> 
                                            </div>
                                            <span class="help-block with-errors">Up to 50 characters upper/lower case(no digits)</span>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label" for="organism-food-description">Food description if this organism is not yet present</label>
                                            <div class="col-sm-4">
                                                <textarea rows="3" class="form-control" id="food-description-published" name="organism-food-description" pattern="[^()[\]{}*^$<>#]+$"></textarea>
                                                <span class="help-block with-errors">Up to 10000 characters upper/lower case</span>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">Choose season</label>
                                            <div class="col-sm-4">
                                                <select class="chosen-select form-control" id="season-ddl-published" name="organism-season-id" multiple data-placeholder="Choose Season"></select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">Choose geolocations</label>
                                            <div class="col-sm-4">
                                                <select class="chosen-select form-control" id="geolocation-ddl-published" name="organism-geolocation-id" multiple data-placeholder="Choose Geolocations"></select>
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
                                            <div class="col-sm-4">
                                                <button class="button-grey" id="organism-id" type="submit"><span class="icon-pencil2-button"></span>Update</button>
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
                        <p>Press the <span class="icon-plus"></span> To publish to the website </p>
                        <p>Press the &nbsp;&nbsp;&nbsp;<span class="icon-pencil2"></span> &nbsp;&nbsp; To edit</p>
                        <p>Press the <span class="icon-cross"></span> To delete (Caution! no confirmation screen)</p>					
                        <div id="update-queue-organism" class="insert-box">
                            <label class="close-button">x</label>
                            <div class="content">
                                <div id="update-queue-organism">
                                    <form class="form form-horizontal" id="update-queue-organism-form" data-toggle="validator" enctype="multipart/form-data">
                                        <input type="hidden" id="organism-id-queue" name="organism-id">
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
                                                <input class="form-control" id="scientific-name-queue" type="text" name="organism-scientific-name" maxlength="50" data-delay="1200" pattern="[^()[\]{}*&^%$<>#0-9@!]+$" required/> 
                                            </div>    
                                            <span class="help-block with-errors">Up to 50 characters upper/lower case(no digits)</span>
                                        </div> 
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label" for="organism-common-name">Common name</label>
                                            <div class="col-sm-4">
                                                <input class="form-control" id="common-name-queue" type="text" name="organism-common-name" maxlength="50" data-delay="1200" pattern="[^()[\]{}*&^%$<>#0-9@!]+$" required/> 
                                            </div>
                                            <span class="help-block with-errors">Up to 50 characters upper/lower case(no digits)</span>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label" for="organism-local-name">Local name</label>
                                            <div class="col-sm-4">
                                                <input class="form-control" id="local-name-queue" type="text" name="organism-local-name" maxlength="50" data-delay="1200" pattern="[^()[\]{}*&^%$<>#0-9@!]+$" required/> 
                                            </div>
                                            <span class="help-block with-errors">Up to 50 characters upper/lower case(no digits)</span>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label" for="family">Family</label>
                                            <div class="col-sm-4">
                                                <select class="form-control" id="family-ddl-queue" name="organism-family-id"></select>
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
                                                <input class="form-control" type="text" id="population-queue" maxlength="50" data-delay="1200" pattern="[^()[\]{}*^$<>#@]+$" name="organism-population" />
                                                <span class="help-block with-errors">Up to 50 characters. Use of < or > not allowed</span>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label" for="organism-description">Organism description</label>
                                            <div class="col-sm-4">
                                                <textarea class="form-control" rows="3" id="description-queue" name="organism-description" pattern="[^()[\]{}*^%$<>#0-9@]+$"></textarea>
                                                <span class="help-block with-errors">Up to 9000 characters upper/lower case(no digits)</span>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">Choose Habitat</label>
                                            <div class="col-sm-4">
                                                <select class="chosen-select form-control" id="habitat-ddl-queue" name="organism-habitat-id" multiple data-placeholder="Choose Habitat"></select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">Choose World</label>
                                            <div class="col-sm-4">
                                                <select class="form-control" id="world-ddl-queue" name="organism-world-id" data-placeholder="Choose World"></select>
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
                                                <textarea rows="3" class="form-control" id="benefits-queue"  name="organism-benefits" pattern="[^()[\]{}*^$<>#@]+$"></textarea>
                                                <span class="help-block with-errors">Up to 2000 characters upper/lower case</span>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label" for="organism-dangerous">Dangers</label>
                                            <div class="col-sm-4">
                                                <textarea rows="3" class="form-control" id="dangerous-queue"  name="organism-dangerous" pattern="[^()[\]{}*&^%$<>#@]+$"></textarea>
                                                <span class="help-block with-errors">Up to 2000 characters upper/lower case</span>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label" for="organism-threats">Threats</label>
                                            <div class="col-sm-4">
                                                <textarea rows="3" class="form-control" id="threats-queue" name="organism-threats" pattern="[^()[\]{}*^$<>#@]+$"></textarea>
                                                <span class="help-block with-errors">Up to 2000 characters upper/lower case</span>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label" for="organism-opportunities">Opportunities</label>
                                            <div class="col-sm-4">
                                                <textarea rows="3" class="form-control" id="opportunities-queue" name="organism-opportunities" pattern="[^()[\]{}*^$<>#]+$"></textarea>
                                                <span class="help-block with-errors">Up to 2000 characters upper/lower case</span>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label" for="organism-links">Usefull links</label>
                                            <div class="col-sm-4">
                                                <textarea rows="3" class="form-control" id="links-queue" name="organism-links" pattern="[^()[\]{}*^$<>#]+$" ></textarea>
                                                <span class="help-block with-errors">Up to 2000 characters upper/lower case</span>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label" for="organism-food-name">Food name if this organism is not yet present</label>
                                            <div class="col-sm-4">
                                                <input class="form-control" type="text" id="food-name-queue" name="organism-food-name" maxlength="50" data-delay="1200" pattern="[^()[\]{}*^$<>#]+$" required/> 
                                            </div>
                                            <span class="help-block with-errors">Up to 50 characters upper/lower case(no digits)</span>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label" for="organism-food-description">Food description if this organism is not yet present</label>
                                            <div class="col-sm-4">
                                                <textarea rows="3" class="form-control" id="food-description-queue" name="organism-food-description" pattern="[^()[\]{}*^$<>#]+$"></textarea>
                                                <span class="help-block with-errors">Up to 10000 characters upper/lower case</span>

                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">Choose season</label>
                                            <div class="col-sm-4">
                                                <select class="chosen-select form-control" id="season-ddl-queue" name="organism-season-id" multiple data-placeholder="Choose Season"></select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">Choose geolocations</label>
                                            <div class="col-sm-4">
                                                <select class="chosen-select form-control" id="geolocation-ddl-queue" name="organism-geolocation-id" multiple data-placeholder="Choose Geolocations"></select>
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
                                                <button class="button-grey" id="organism-id" type="submit"><span class="icon-pencil2-button"></span>Update</button>
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
                        <p>Press the <span class="icon-cross"></span> To delete (Caution! no confirmation screen)</p>
                        <div class="table-responsive">
                            <table class="table table-striped" id="posts-table"></table>
                        </div>
                    </div>
                    <div id="tab4" class="tab">
                        <p>Press the <span class="icon-cross"></span> To delete (Caution! no confirmation screen)</p>

                        <div class="table-responsive">
                            <table class="table table-striped" id="subscriber-table"></table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
