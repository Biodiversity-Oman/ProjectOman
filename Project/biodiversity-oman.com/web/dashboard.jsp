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
    </head>
    <body>
        <div class="wrapper">
            <div class="tabs">
                <ul class="tab-links">
                    <li class="active"><a href="#tab1"><span class="icon-file-text"></span>Organisms</a></li>
                    <li><a href="#tab2"><span class="icon-pencil2"></span>Create Organism</a></li>
                    <li><a href="#tab3"><span class="icon-pencil2"></span>World</a></li>
                    <li><a href="#tab4"><span class="icon-pencil2"></span>Family</a></li>
                    <li><a href="#tab5"><span class="icon-pencil2"></span>Subfamily</a></li>
                    <li><a href="#tab6"><span class="icon-pencil2"></span>Season</a></li>
                    <li><a href="#tab7"><span class="icon-pencil2"></span>Habitat</a></li>
                    <li><a href="#tab8"><span class="icon-pencil2"></span>Geolocation</a></li>
                </ul>
                <div class="tab-content">
                    <div id="tab1" class="tab active">
                        <p>content</p>
                    </div>
                    <div id="tab2" class="tab">
                        <p>content</p>
                    </div>

                    <div id="tab3" class="tab">
                        <div id="create-world">
                            <h1>Create World</h1>
                            <input type="text" name="world-name" id="world-name" />
                            <input type="text" name="world-description" id="world-description" />
                            <button type="submit" name="action" value="insert-world" >Insert</button>
                            <button type="reset" name="action" value="cancel-world" >Reset</button>
                        </div>
                        <div id="tab4" class="tab">
                            <p>content</p>
                        </div>
                        <div id="tab5" class="tab">
                            <p>content</p>
                        </div>
                        <div id="tab6" class="tab">
                            <div id="create-season">
                            <h1>Create Season</h1>
                            <form id="create-season-form">
                            <input type="text" name="season-name" id="season-name" />
                            <input type="text" name="season-description" id="season-description" />
                            <button type="submit" name="action" value="insert-season" >Insert</button>
                            <button type="reset" name="action" value="cancel-season" >Reset</button>
                       </form>
                            </div>
                        </div>
                        <div id="tab7" class="tab">
                            <div id="create-habitat">
                            <h1>Create Season</h1>
                            <form id="create-habitat-form">
                            <input type="text" name="habitat-name" id="habitat-name" />
                            <input type="text" name="habitat-description" id="habitat-description" />
                            <button type="submit" name="action" value="insert-habitat" >Insert</button>
                            <button type="reset" name="action" value="cancel-habitat" >Reset</button>
                       </form>
                            </div>
                        </div>
                        <div id="tab8" class="tab">
                            <p>content</p>
                        </div>
                    </div>
                </div>
            </div>
    </body>
</html>
