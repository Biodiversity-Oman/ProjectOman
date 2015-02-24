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
    </script>
    <body onload="loadWorlds();
            loadSeasons();
            loadHabitats();
            loadFamilies();
            loadSubFamilies()">;">
        <div class="wrapper">
            <div class="tabs">
                <ul class="tab-links">
                    <li class="active"><a href="#tab1"><span class="icon-file-text"></span>Organisms</a></li>
                    <li><a href="#tab2" onclick="adminCheck();"><span class="icon-file-text"></span>Worlds</a></li>
                    <li><a href="#tab3" onclick="adminCheck();"><span class="icon-pencil2"></span>Families</a></li>
                    <li><a href="#tab4" onclick="adminCheck();"><span class="icon-file-text"></span>Subfamilies</a></li>
                    <li><a href="#tab5" onclick="adminCheck();"><span class="icon-file-text"></span>Seasons</a></li>
                    <li><a href="#tab6" onclick="adminCheck();"><span class="icon-file-text"></span>Habitats</a></li>
                    <li><a href="#tab7" onclick="adminCheck();"><span class="icon-file-text"></span>Geolocations</a></li>
                </ul>
                <div class="tab-content">
                    <div id="tab1" class="tab active">
                        <div id="fade" class="black_overlay-boxed"></div>
                        <a href = "javascript:void(0)" onclick = "document.getElementById('insert-organism').style.display = 'block';
                                document.getElementById('fade').style.display = 'block'"><button class="action-button"><span class="icon-plus"></span></button></a>
                        <div id="insert-organism" class="insert-box-worlds"><a href = "javascript:void(0)" onclick = "document.getElementById('insert-organism').style.display = 'none';
                                document.getElementById('fade').style.display = 'none'"><label class="close-button">x</label></a>
                            <div class="content">
                                <div id="create-organism">
                                    <p> FORM HERE </p>
                                </div>
                            </div>
                        </div>
                        <div class="table-responsive">
                            <div class="col-sm-10">
                                <table class="table table-striped" id="organisms-table"></table>
                            </div>
                        </div>
                    </div>
                    <div id="tab2" class="tab">
                        <div id="fade2" class="black_overlay-boxed"></div>
                        <a href = "javascript:void(0)" onclick = "document.getElementById('insert-world').style.display = 'block';
                                document.getElementById('fade2').style.display = 'block'"><button class="action-button"><span class="icon-plus"></button></a>
                        <div id="insert-world" class="insert-box-worlds"><a href = "javascript:void(0)" onclick = "document.getElementById('insert-world').style.display = 'none';
                                document.getElementById('fade2').style.display = 'none'"><label class="close-button">x</label></a>
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
                                        <div class="form-group">
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
                        </div>
                        <div class="table-responsive">
                            <div class="col-sm-10">
                                <table class="table table-striped" id="worlds-table"></table>
                            </div>
                        </div>
                    </div>
                    <div id="tab3" class="tab">
                        <div id="fade5" class="black_overlay-boxed"></div>
                        <a href = "javascript:void(0)" onclick = "document.getElementById('insert-family').style.display = 'block';
                                document.getElementById('fade5').style.display = 'block'"><button class="action-button"><span class="icon-plus"></button></a>
                        <div id="insert-family" class="insert-box-worlds"><a href = "javascript:void(0)" onclick = "document.getElementById('insert-family').style.display = 'none';
                                document.getElementById('fade5').style.display = 'none'"><label class="close-button">x</label></a>
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
                                                <input class="form-control" type="text" name="family-name" maxlength="50" data-delay="1200" pattern="^([A-z]){1,}$" required/>
                                                <span class="help-block with-errors">Up to 50 characters upper/lower case(no digits)</span>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label" for="family-description">Description</label>
                                            <div class="col-sm-4">
                                                <textarea rows="3" class="form-control" type="text" name="family-description"></textarea>
                                            </div>
                                        </div>                                                            
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label" for="family-world">World</label>
                                            <div class="col-sm-4">
                                                <textarea rows="1" class="form-control" type="text" name="world-id"></textarea>
                                            </div>
                                        </div>
                                        <div class="form-group"">
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
                        <div class="table-responsive">
                            <div class="col-sm-10">
                                <table class="table table-striped" id="families-table"></table>
                            </div>
                        </div>
                    </div>
                    <div id="tab4" class="tab">
                        <div id="fade6" class="black_overlay-boxed"></div>
                        <a href = "javascript:void(0)" onclick = "document.getElementById('insert-subfamily').style.display = 'block';
                                document.getElementById('fade6').style.display = 'block'"><button class="action-button"><span class="icon-plus"></button></a>
                        <div id="insert-subfamily" class="insert-box-worlds"><a href = "javascript:void(0)" onclick = "document.getElementById('insert-subfamily').style.display = 'none';
                                document.getElementById('fade6').style.display = 'none'"><label class="close-button">x</label></a>
                            <div class="content">
                                <div id="create-subfamily">
                                    <form class="form form-horizontal" id="create-family-form" data-toggle="validator">
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label"></label>
                                            <div class="col-sm-4">
                                                <h2 class="h2">Create Subfamily</h2>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label" for="subfamily-name">Name</label>
                                            <div class="col-sm-4">
                                                <input class="form-control" type="text" name="subfamily-name" maxlength="50" data-delay="1200" pattern="^([A-z]){1,}$" required/>
                                                <span class="help-block with-errors">Up to 50 characters upper/lower case(no digits)</span>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label" for="submfamily-description">Description</label>
                                            <div class="col-sm-4">
                                                <textarea rows="3" class="form-control" type="text" name="subfamily-description"></textarea>
                                            </div>
                                        </div>                                                            
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label" for="subfamily-world">World</label>
                                            <div class="col-sm-4">
                                                <textarea rows="1" class="form-control" type="text" name="world-id"></textarea>
                                            </div>
                                        </div>
                                        <div class="form-group"">
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
                        <div class="table-responsive">
                            <div class="col-sm-10">
                                <table class="table table-striped" id="subfamilies-table"></table>
                            </div>
                        </div>
                    </div>
                    <div id="tab5" class="tab">
                        <div id="fade3" class="black_overlay-boxed"></div>
                        <a href = "javascript:void(0)" onclick = "document.getElementById('insert-season').style.display = 'block';
                                document.getElementById('fade3').style.display = 'block'"><button class="action-button"><span class="icon-plus"></button></a>
                        <div id="insert-season" class="insert-box-worlds"><a href = "javascript:void(0)" onclick = "document.getElementById('insert-season').style.display = 'none';
                                document.getElementById('fade3').style.display = 'none'"><label class="close-button">x</label></a>
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
                                        <div class="form-group">
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
                        </div>
                        <div class="table-responsive">
                            <div class="col-sm-10">
                                <table class="table table-striped" id="seasons-table"></table>
                            </div>
                        </div>
                    </div>
                    <div id="tab6" class="tab">
                        <div id="fade4" class="black_overlay-boxed"></div>
                        <a href = "javascript:void(0)" onclick = "document.getElementById('insert-habitat').style.display = 'block';
                                document.getElementById('fade4').style.display = 'block'"><button class="action-button"><span class="icon-plus"></button></a>
                        <div id="insert-habitat" class="insert-box-worlds"><a href = "javascript:void(0)" onclick = "document.getElementById('insert-habitat').style.display = 'none';
                                document.getElementById('fade4').style.display = 'none'"><label class="close-button">x</label></a>
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
                        <div class="table-responsive">
                            <div class="col-sm-10">
                                <table class="table table-striped" id="habitats-table"></table>
                            </div>
                        </div>
                    </div>
                    <div id="tab7" class="tab">
                        <div id="fade8" class="black_overlay-boxed"></div>
                        <a href = "javascript:void(0)" onclick = "document.getElementById('insert-geolocation').style.display = 'block';
                                document.getElementById('fade8').style.display = 'block'"><button class="action-button"><span class="icon-plus"></button></a>
                        <div id="insert-geolocation" class="insert-box-worlds"><a href = "javascript:void(0)" onclick = "document.getElementById('insert-geolocation').style.display = 'none';
                                document.getElementById('fade8').style.display = 'none'"><label class="close-button">x</label></a>
                            <div class="content">
                                <div id="create-geolocation">
                                    <p> FORM HERE </p>
                                </div>
                            </div>
                        </div>
                        <div class="table-responsive">
                            <div class="col-sm-10">
                                <table class="table table-striped" id="geolocations-table"></table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>

