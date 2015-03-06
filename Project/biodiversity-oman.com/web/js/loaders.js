//---------------------------------------------------------------------------------------------------------------------
// LOAD FUNCTIES
// hier behoren de functies die data moeten laden voor document.ready is
// GEEEEEN IIINSEEEERT FUNCTIEEEES HIER!!!!!!!!!!!!!!!!!!!!!!
//---------------------------------------------------------------------------------------------------------------------

// functie om tabel te vullen met gebruikers info in de list users tab in usermanagement.jsp
function loadUsers() {

    var $table = $('#users-table');
    $.ajax({
        url: 'SelectAllUserAccounts',
        type: 'GET',
        dataType: 'json',
        cache: false,
        async: true
    }).done(function (data) {
        $table.html('');
        $table.append('<tr>\n\
                       <th>Username</th>\n\
                       <th>Firstname</th>\n\
                       <th>Lastname</th>\n\
                       <th>City</th>\n\
                       <th>Country</th>\n\
                       <th>Email</th>\n\
                       <th>Phone</th>\n\
                       <th>Admin</th>\n\
                       <th>Action</th>\n\
                       </tr>');
        data.forEach(function (user) {
            $table.append('<tr>\n\
                           <td>' + user.userName + '</td>\n\
                           <td>' + user.firstName + '</td>\n\
                           <td>' + user.lastName + '</td>\n\
                           <td>' + user.city + '</td>\n\
                           <td>' + user.country + '</td>\n\
                           <td>' + user.email + '</td>\n\
                           <td>' + user.phone + '</td>\n\
                           <td>' + user.isAdmin + '</td>\n\
                           <td>\n\
                           <button class="no-button" id="delete-user-btn" type="submit" value="' + user.userName + '"><span class="icon-cross"></span></button>\n\
                           <button class="no-button" id="make-admin-btn" type="submit" value="' + user.userName + '"><span class="icon-plus"></span></button></span></button>\n\
                           <button class="no-button" id="make-normal-btn" type="submit" value="' + user.userName + '"><span class="icon-minus"></span></button>\n\
                           </td>\n\
                           </tr>');
        });
    });
};

// functie vult tabel in World tab in dashboard.jsp
function loadWorlds() {

    var $table = $('#worlds-table');
    var $ddl = $('#world-ddl-insert-organism, #world-ddl-insert-family, #world-ddl-update-family, #world-ddl-pending, #world-ddl-published, #world-ddl-queue');
    $.ajax({
        url: 'SelectAllWorlds',
        type: 'GET',
        dataType: 'json',
        cache: false,
        async: true
    }).done(function (data) {
        $table.html('');
        $ddl.html('');
        $ddl.append('<option value="" disabled selected>Select World</option>');
        $table.append('<tr>\n\
                       <th>Name</th>\n\
                       <th>Description</th>\n\
                       <th>Action</th>\n\
                       </tr>');
        data.forEach(function (world) {
            $ddl.append('<option value="' + world.worldId + '">' + world.worldName + '</option>');
            $table.append('<tr>\n\
                           <td>' + world.worldName + '</td>\n\
                           <td>' + world.description + '</td>\n\
                           <td>\n\
                           <button class="no-button" id="update-world-btn" type="submit" value="' + world.worldId + '"><span class="icon-pencil2"></span></button>\n\
                           <button class="no-button" id="delete-world-btn" type="submit" value="' + world.worldId + '"><span class="icon-cross"></span></button>\n\
                           </td>\n\
                           </tr>');
        });
        adminCheck();
    });
};

// functie vult tabel in Season tab in dashboard.jsp
function loadSeasons() {

    var $table = $('#seasons-table');
    var $ddl = $('#season-ddl-insert-organism, #season-ddl-published, #season-ddl-pending, #season-ddl-queue');
    $.ajax({
        url: 'SelectAllSeasons',
        type: 'GET',
        dataType: 'json',
        cache: false,
        async: true
    }).done(function (data) {
        $table.html('');
        $ddl.html('');
        $table.append('<tr>\n\
                       <th>Name</th>\n\
                       <th>Description</th>\n\
                       <th>Action</th>\n\
                       </tr>');
        data.forEach(function (season) {
            $ddl.append('<option value="' + season.seasonId + '">' + season.seasonName + '</option>');
            $table.append('<tr>\n\
                           <td>' + season.seasonName + '</td>\n\
                           <td>' + season.seasonDescription + '</td>\n\
                           <td>\n\
                           <button class="no-button" id="update-season-btn" type="submit" value="' + season.seasonId + '"><span class="icon-pencil2"></span></button>\n\
                           <button class="no-button" id="delete-season-btn" type="submit" value="' + season.seasonId + '"><span class="icon-cross"></span></button>\n\
                           </td>\n\
                           </tr>');
            $(".chosen-select").trigger("chosen:updated");
        });
        adminCheck();
    });
};

// functie vult tabel in Habitat tab in dashboard.jsp
function loadHabitats() {

    var $table = $('#habitats-table');
    var $ddl = $('#habitat-ddl-insert-organism, #habitat-ddl-published, #habitat-ddl-pending, #habitat-ddl-queue');
    $.ajax({
        url: 'SelectAllHabitats',
        type: 'GET',
        dataType: 'json',
        cache: false,
        async: true
    }).done(function (data) {
        $ddl.html('');
        $table.html('');
        $table.append('<tr>\n\
                       <th>Name</th>\n\
                       <th>Description</th>\n\\n\
                       <th>Action</th>\n\
                       </tr>');
        data.forEach(function (habitat) {
            $ddl.append('<option value="' + habitat.habitatId + '">' + habitat.habitatName + '</option>');
            $table.append('<tr>\n\
                           <td>' + habitat.habitatName + '</td>\n\
                           <td>' + habitat.habitatDescription + '</td>\n\
                           <td>\n\
                           <button class="no-button" id="update-habitat-btn" type="submit" value="' + habitat.habitatId + '"><span class="icon-pencil2"></span></button>\n\
                           <button class="no-button" id="delete-habitat-btn" type="submit" value="' + habitat.habitatId + '"><span class="icon-cross"></span></button>\n\
                           </td>\n\
                           </tr>');
            $(".chosen-select").trigger("chosen:updated");
        });
        adminCheck();
    });
};

// functie vult tabel in Family tab in dashboard.jsp
function loadFamilies() {

    var $table = $('#families-table');
    var $ddl = $('#family-ddl-insert-organism, #family-ddl-insert-breed, #family-ddl-update-breed, #family-ddl-pending, #family-ddl-published, #family-ddl-queue');
    $.ajax({
        url: 'SelectAllFamilies',
        type: 'GET',
        dataType: 'json',
        cache: false,
        async: true
    }).done(function (data) {
        $table.html('');
        $ddl.html('');
        $ddl.append('<option value="" disabled selected>Select family</option>');
        $table.append('<tr>\n\
                       <th>Name</th>\n\
                       <th>Description</th>\n\
                       <th>World</th>\n\
                       <th>Action</th>\n\
                       </tr>');
        data.forEach(function (family) {
            $ddl.append('<option value="' + family.familyId + '">' + family.familyName + '</option>');
            $table.append('<tr>\n\
                           <td>' + family.familyName + '</td>\n\
                           <td>' + family.familyDescription + '</td>\n\
                           <td>' + family.familyWorldName + '</td>\n\
                           <td>\n\
                           <button class="no-button" id="update-family-btn" type="submit" value="' + family.familyId + '"><span class="icon-pencil2">\n\
                           <button class="no-button" id="delete-family-btn" type="submit" value="' + family.familyId + '"><span class="icon-cross"></span></button>\n\
                           </td>\n\
                           </tr>');
        });
        adminCheck();
    });
};

// functie vult tabel in SubFamily tab in dashboard.jsp
function loadSubFamilies() {

    var $table = $('#subfamilies-table');
    var $ddl = $('#subfamily-ddl-insert-organism, #subfamily-ddl-pending, #subfamily-ddl-published, #subfamily-ddl-queue');
    $.ajax({
        url: 'SelectAllSubFamilies',
        type: 'GET',
        dataType: 'json',
        cache: false,
        async: true
    }).done(function (data) {
        $table.html('');
        $ddl.html('');
        $ddl.append('<option value="" disabled selected>Select breed</option>');
        $table.append('<tr>\n\
                       <th>Name</th>\n\
                       <th>Description</th>\n\
                       <th>Family</th>\n\
                       <th>Action</th>\n\
                       </tr>');
        data.forEach(function (subfamily) {
            $ddl.append('<option value="' + subfamily.subFamilyId + '">' + subfamily.subFamilyName + '</option>');
            $table.append('<tr>\n\
                           <td>' + subfamily.subFamilyName + '</td>\n\
                           <td>' + subfamily.subFamilyDescription + '</td>\n\
                           <td>' + subfamily.subFamilyFamilyName + '</td>\n\
                           <td>\n\
                           <button class="no-button" id="update-subfamily-btn" type="submit" value="' + subfamily.subFamilyId + '"><span class="icon-pencil2"></span></button>\n\
                           <button class="no-button" id="delete-subfamily-btn" type="submit" value="' + subfamily.subFamilyId + '"><span class="icon-cross"></span></button>\n\
                           </td>\n\
                           </tr>');
            
        });
        adminCheck();
    });
};

//functie om tabel te vullen met gebruikers info in de list users tab in usermanagement.jsp
function loadGeolocations() {

    var $table = $('#geolocations-table');
    var $ddl = $('#geolocation-ddl-insert-organism, #geolocation-ddl-published, #geolocation-ddl-pending, #geolocation-ddl-queue');
    $.ajax({
        url: 'SelectAllGeolocations',
        type: 'GET',
        dataType: 'json',
        cache: false
    }).done(function (data) {
        $table.html('');
        $ddl.html('');
        $table.append('<tr>\n\
                       <th>Area name</th>\n\
                       <th>Description</th>\n\
                       <th>Action</th>\n\
                       </tr>');
        data.forEach(function (geolocation) {
            $ddl.append('<option value="' + geolocation.geolocationId + '">' + geolocation.areaName + '</option>');
            $table.append('<tr>\n\
                           <td>' + geolocation.areaName + '</td>\n\
                           <td>' + geolocation.areaDescription + '</td>\n\
                           <td>\n\
                           <button class="no-button" id="update-geolocation-btn" type="submit" value="' + geolocation.geolocationId + '"><span class="icon-pencil2"></span></button>\n\
                           <button class="no-button" id="delete-geolocation-btn" type="submit" value="' + geolocation.geolocationId + '"><span class="icon-cross"></span></button>\n\
                           </td>\n\
                           </tr>');
            $(".chosen-select").trigger("chosen:updated");
        });
        adminCheck();
    });
};

// functie vult tabel voor te valideren organisms tab in publish.jsp
function loadToValidateOrganisms() {

    var $table = $('#tovalidate-table');
    $.ajax({
        url: 'SelectOrganismToValidate',
        type: 'GET',
        dataType: 'json',
        cache: false,
        async: true
    }).done(function (data) {
        $table.html('');
        $table.append('<tr>\n\
                       <th>Common name</th>\n\
                       <th>Scientific name</th>\n\
                       <th>Submitted on</th>\n\
                       <th>Updated on</th>\n\
                       <th>Action</th>\n\
                       </tr>');
        data.forEach(function (o) {
            $table.append('<tr>\n\
                           <td>' + o.commonName + '</td>\n\\n\
                           <td>' + o.scientificName + '</td>\n\
                           <td>' + o.insertedOn + '</td>\n\
                           <td>' + o.updatedOn + '</td>\n\
                           <td>\n\
                           <button class="no-button" id="queue-publish-btn" type="submit" value="' + o.organismId + '"><span class="icon-plus"></span></button></span></button>\n\
                           <button class="no-button" id="update-queue-organism-btn" type="submit" value="' + o.organismId + '"><span class="icon-pencil2"></span>\n\
                           <button class="no-button" id="delete-organism-tovalidate-btn" type="submit" value="' + o.organismId + '"><span class="icon-cross"></span></button>\n\
                           </td>\
                           </tr>');
        });
    });
};

// functie vult tabel voor pending organisms in pending tab in dashboard.jsp
function loadPendingOrganisms() {

    var $table = $('#pending-table');
    $.ajax({
        url: 'SelectOrganismToValidate',
        type: 'GET',
        dataType: 'json',
        cache: false,
        async: true
    }).done(function (data) {
        $table.html('');
        $table.append('<tr>\n\
                       <th>Common name</th>\n\
                       <th>Scientific name</th>\n\
                       <th>Submitted on</th>\n\
                       <th>Action</th>\n\
                       </tr>');
        data.forEach(function (o) {
            $table.append('<tr>\n\
                           <td>' + o.commonName + '</td>\n\
                           <td>' + o.scientificName + '</td>\n\
                           <td>' + o.insertedOn + '</td>\n\
                           <td>\n\
                           <button class="no-button-user" id="update-pending-organism-btn" type="submit" value="' + o.organismId + '"><span class="icon-pencil2"></span>\n\
                           </td>\n\
                           </tr>');
        });
    });
};

// functie vult tabel voor published organisms tab in publish.jsp
function loadPublishedOrganisms() {
    
    var $table = $('#published-table');
    $.ajax({
        url: 'SelectAllPublishedOrganisms',
        type: 'GET',
        dataType: 'json',
        cache: false,
        async: true
    }).done(function (data) {
        $table.html('');
        $table.append('<tr>\n\
                       <th>Common name</th>\n\
                       <th>Scientific name</th>\n\
                       <th>Inserted on</th>\n\
                       <th>Updated on</th>\n\
                       <th>Action</th>\n\
                       </tr>');
        data.forEach(function (org) {
            $table.append('<tr>\n\
                           <td>' + org.commonName + '</td>\n\
                           <td>' + org.scientificName + '</td>\n\
                           <td>'+ org.insertedOn +'</td>\n\
                           <td>' + org.updatedOn + '</td>\n\
                           <td>\n\
                           <button class="no-button" id="update-published-organism-btn" type="submit" value="' + org.organismId + '"><span class="icon-pencil2"></span></button>\n\
                           <button class="no-button" id="delete-organism-published-btn" type="submit" value="' + org.organismId + '"><span class="icon-cross"></span></button>\n\
                           </td>\n\
                           </tr>');
        });
    });
};

// functie vult tabel voor subscribers tab in publish.jsp
function loadSubscriber() {
    
    var $table = $('#subscriber-table');
    $.ajax({
        url: 'SelectAllSubscriber',
        type: 'GET',
        dataType: 'json',
        cache: false,
        async: true
    }).done(function (data) {
        $table.html('');
        $table.append('<tr>\n\
                       <th>First name</th>\n\
                       <th>Family name</th>\n\
                       <th>Email</th>\n\
                       <th>Action</th>\n\
                       </tr>');
        data.forEach(function (s) {
            $table.append('<tr>\n\
                           <td>' + s.subscriberFirstName + '</td>\n\
                           <td>' + s.subscriberLastName + '</td>\n\
                           <td>' + s.subscriberEmail + '</td>\n\
                           <td>\n\
                           <button class="no-button" id="delete-subscriber-btn" type="submit" value="' + s.subscriberId + '"><span class="icon-cross"></span></button>\n\
                           </td>\n\
                           </tr>');
        });
    });
};

//functie vult de tabel in organisms tab in dashboard.jsp
function loadOrganisms() {

    var $table = $('#organisms-table');
    $.ajax({
        url: 'SelectAllPublishedOrganisms',
        type: 'GET',
        dataType: 'json',
        cache: false
    }).done(function (data) {
        $table.html('');
        $table.append('<tr>\n\
                       <th>Common name</th>\n\
                       <th>Scientific name</th>\n\
                       <th>Inserted on</th>\n\
                       <th>Updated on</th>\n\
                       <th>Action</th>\n\
                       </tr>');
        data.forEach(function (organism) {
            $table.append('<tr>\n\
                           <td>' + organism.commonName + '</td>\n\\n\
                           <td>'+  organism.scientificName +'</td>\n\
                           <td>' + organism.insertedOn + '</td>\n\\n\
                           <td>' + organism.updatedOn + '</td>\n\\n\
                           <td><button class="no-button" id="detail-organism-btn" type="submit" value="' + organism.organismId + '"><span class="icon-search"></span></button></td>\n\
                           </tr>');
        });
        adminCheck();
    });
};

//functie vult de tabel in posts tab in publish.jsp
function loadPosts() {

    var $table = $('#posts-table');
    $.ajax({
        url: 'SelectAllPosts',
        type: 'GET',
        dataType: 'json',
        cache: false
    }).done(function (data) {
        $table.html('');
        $table.append('<tr>\n\
                       <th>Email</th>\n\
                       <th>Organism</th>\n\
                       <th>Action</th>\n\
                       </tr>');
        data.forEach(function (post) {
            $table.append('<tr>\n\
                           <td>' + post.postEmail + '</td>\n\
                           <td>' + post.organismName + '</td>\n\
                           <td>\n\
                           <button class="no-button" id="delete-post-btn" type="submit" value="' + post.postId + '"><span class="icon-cross"></span></button>\n\
                           </td>\n\
                           </tr>');
        });
    });
};

function loadEaten() {

    var $ddl = $('#eatenby-ddl, #geteatenby-ddl, #eatenby-ddl-published, #geteatenby-ddl-published, #eatenby-ddl-pending, #geteatenby-ddl-pending, #eatenby-ddl-queue, #geteatenby-ddl-queue');
    $.ajax({
        url: 'SelectEaten',
        type: 'GET',
        dataType: 'json',
        cache: false,
        async: true
    }).done(function (data) {
        data.forEach(function (organism) {
            $ddl.append('<option value="' + organism.organismId + '">' + organism.commonName + '</option>');
            $(".chosen-select").trigger("chosen:updated");
        });
    });
};