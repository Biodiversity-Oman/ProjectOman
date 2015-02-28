//---------------------------------------------------------------------------------------------------------------------
// LOAD FUNCTIES
// hier behoren de functies die data moeten laden voor document.ready is
// GEEEEEN IIINSEEEERT FUNCTIEEEES HIER!!!!!!!!!!!!!!!!!!!!!!
//---------------------------------------------------------------------------------------------------------------------

// functie om tabel te vullen met gebruikers info in de list users tab in usermanagement.jsp
function loadUsers() {

    var $table = $('#users-table');
    var $content = $('.content');
    $.ajax({
	url: 'SelectAllUserAccounts',
	type: 'GET',
	dataType: 'json',
	cache: false,
	async: true,
	beforesend: function () {
	    $content.append('<div class="spinner"></div>');
	},
	complete: function (data) {
	    var users = data.responseJSON;
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
	    users.forEach(function (user) {
		$table.append('<tr>\n\
                                        <td>' + user.userName + '</td>\n\
                                        <td>' + user.firstName + '</td>\n\
                                        <td>' + user.lastName + '</td>\n\
                                        <td>' + user.city + '</td>\n\
                                        <td>' + user.country + '</td>\n\
                                        <td>' + user.email + '</td>\n\
                                        <td>' + user.phone + '</td>\n\
                                        <td>' + user.isAdmin + '</td>\n\
                                        <td><button class="no-button" id="delete-user-btn" type="submit" value="' + user.userName + '"><span class="icon-cross"></span></button><button class="no-button" id="make-admin-btn" type="submit" value="' + user.userName + '"><span class="icon-plus"></span></button></span></button><button class="no-button" id="make-normal-btn" type="submit" value="' + user.userName + '"><span class="icon-minus"></span></button></td>\n\
                                    </tr>');
	    });
	}
    }).done(function () {
	$('#users-table').html('');
    });
};

// functie vult tabel in World tab in dashboard.jsp
function loadWorlds() {

    var $table = $('#worlds-table');
    var $content = $('.content');
    var $ddl = $('#world-ddl');
    $.ajax({
	url: 'SelectAllWorlds',
	type: 'GET',
	dataType: 'json',
	cache: false,
	async: true,
	beforesend: function () {
	    $content.append('<div class="spinner"></div>');
	},
	complete: function (data) {
	    var worlds = data.responseJSON;
	    $table.append('<tr>\n\
                                    <th>Name</th>\n\
                                    <th>Description</th>\n\\n\
                                    <th>Action</th>\n\
                                </tr>');
	    $ddl.append('<option value="" disabled selected>Select world</option>');
	    worlds.forEach(function (world) {
		$table.append('<tr id="parent">\n\
                                        <td>' + world.worldName + '</td>\n\
                                        <td>' + world.description + '</td>\n\
                                        <td id="test"><button class="no-button" id="delete-world-btn" type="submit" value="' + world.worldId + '"><span class="icon-cross"></span></button></td>\n\
                                    </tr>');
		$ddl.append('<option value="' + world.worldId + '">' + world.worldName + '</option>');
	    });
	}
    }).done(function () {
	$('#worlds-table').html('');
	$ddl.html('');
    });
};

// functie vult tabel in Season tab in dashboard.jsp
function loadSeasons() {

    var $table = $('#seasons-table');
    var $content = $('.content');
    var $ddl = $('#season-ddl');
    $.ajax({
	url: 'SelectAllSeasons',
	type: 'GET',
	dataType: 'json',
	cache: false,
	async: true,
	beforesend: function () {
	    $content.append('<div class="spinner"></div>');
	},
	complete: function (data) {
	    var seasons = data.responseJSON;
	    $table.append('<tr>\n\
                                    <th>Name</th>\n\
                                    <th>Description</th>\n\\n\
                                    <th>Action</th>\n\
                                </tr>');
	    seasons.forEach(function (season) {
		$table.append('<tr>\n\
                                        <td>' + season.seasonName + '</td>\n\
                                        <td>' + season.seasonDescription + '</td>\n\
                                        <td><button class="no-button" id="delete-season-btn" type="submit" value="' + season.seasonId + '"><span class="icon-cross"></span></button></td>\n\
                                    </tr>');
		$ddl.append('<option value="' + season.seasonId + '">' + season.seasonName + '</option>');
		$(".chosen-select").trigger("chosen:updated");
	    });
	}
    }).done(function () {
	$('#seasons-table').html('');
    });
};

// functie vult tabel in Habitat tab in dashboard.jsp
function loadHabitats() {

    var $table = $('#habitats-table');
    var $content = $('.content');
    var $ddl = $('#habitat-ddl');
    $.ajax({
	url: 'SelectAllHabitats',
	type: 'GET',
	dataType: 'json',
	cache: false,
	async: true,
	beforesend: function () {
	    $content.append('<div class="spinner"></div>');
	    $(".chosen-select").chosen({width: "100%"});
	},
	complete: function (data) {
	    var habitats = data.responseJSON;
	    $table.append('<tr>\n\
                                    <th>Name</th>\n\
                                    <th>Description</th>\n\\n\
                                    <th>Action</th>\n\
                                </tr>');
	    
	    habitats.forEach(function (habitat) {
		$table.append('<tr>\n\
                                        <td>' + habitat.habitatName + '</td>\n\
                                        <td>' + habitat.habitatDescription + '</td>\n\
                                        <td><button class="no-button" id="delete-habitat-btn" type="submit" value="' + habitat.habitatId + '"><span class="icon-cross"></span></button></td>\n\
                                    </tr>');
		$ddl.append('<option value="' + habitat.habitatId + '">' + habitat.habitatName + '</option>');
		$(".chosen-select").trigger("chosen:updated");
	    });
	    
	}
    }).done(function () {
	$('#habitats-table').html('');
	$ddl.html('');
	
	
    });
};

// functie vult tabel in Family tab in dashboard.jsp
function loadFamilies() {

    var $table = $('#families-table');
    var $content = $('.content');
    var $ddl = $('#family-ddl1, #family-ddl2 ');
    $.ajax({
	url: 'SelectAllFamilies',
	type: 'GET',
	dataType: 'json',
	cache: false,
	async: true,
	beforesend: function () {
	    $content.append('<div class="spinner"></div>');
	},
	complete: function (data) {
	    var families = data.responseJSON;
	    $table.append('<tr>\n\
                                    <th>Name</th>\n\
                                    <th>Description</th>\n\
                                    <th>World</th>\n\
                                    <th>Action</th>\n\
                                </tr>');
	    $ddl.append('<option value="" disabled selected>Select family</option>');
	    families.forEach(function (family) {
		$table.append('<tr>\n\
                                        <td>' + family.familyName + '</td>\n\
                                        <td>' + family.familyDescription + '</td>\n\
                                        <td>' + family.familyWorldName + '</td>\n\
                                        <td><button class="no-button" id="delete-family-btn" type="submit" value="' + family.familyId + '"><span class="icon-cross"></span></button></td>\n\
                                    </tr>');
		$ddl.append('<option value="' + family.familyId + '">' + family.familyName + '</option>');
	    });
	}
    }).done(function () {
	$('#families-table').html('');
    });
};

// functie vult tabel in SubFamily tab in dashboard.jsp
function loadSubFamilies() {

    var $table = $('#subfamilies-table');
    var $content = $('.content');
    var $ddl = $('#subfamily-ddl');
    $.ajax({
	url: 'SelectAllSubFamilies',
	type: 'GET',
	dataType: 'json',
	cache: false,
	async: true,
	beforesend: function () {
	    $content.append('<div class="spinner"></div>');
	},
	complete: function (data) {
	    var subfamilies = data.responseJSON;
	    $table.append('<tr>\n\
                                    <th>Name</th>\n\
                                    <th>Description</th>\n\
                                    <th>Family</th>\n\
                                    <th>Action</th>\n\
                                </tr>');
	    subfamilies.forEach(function (subfamily) {
		$table.append('<tr>\n\
                                        <td>' + subfamily.subFamilyName + '</td>\n\
                                        <td>' + subfamily.subFamilyDescription + '</td>\n\
                                        <td>' + subfamily.subFamilyFamilyName + '</td>\n\
                                        <td><button class="no-button" id="delete-subfamily-btn" type="submit" value="' + subfamily.subFamilyId + '"><span class="icon-cross"></span></button></td>\n\
                                    </tr>');
		$ddl.append('<option value="' + subfamily.subFamilyId + '">' + subfamily.subFamilyName + '</option>');
	    });
	}
    }).done(function () {
	$('#subfamilies-table').html('');
    });
};

// functie om tabel te vullen met gebruikers info in de list users tab in usermanagement.jsp
function loadGeolocations() {

    var $table = $('#geolocations-table');
    var $content = $('.content');
    $.ajax({
	url: 'SelectAllGeolocations',
	type: 'GET',
	dataType: 'json',
	cache: false,
	beforesend: function () {
	    $content.append('<div class="spinner"></div>');
	},
	complete: function (data) {
	    var geolocations = data.responseJSON;
	    $table.append('<tr>\n\
                                    <th>Area name</th>\n\
                                    <th>Description</th>\n\
                                </tr>');
	    geolocations.forEach(function (geolocation) {
		$table.append('<tr>\n\
                                        <td>' + geolocation.areaName + '</td>\n\
                                        <td>' + geolocation.areaDescription + '</td>\n\
                                        <td><button class="no-button" id="delete-user-btn" type="submit" value="' + user.userName + '"><span class="icon-cross"></span></button><button class="no-button" id="make-admin-btn" type="submit" value="' + user.userName + '"><span class="icon-plus"></span></button></span></button><button class="no-button" id="make-normal-btn" type="submit" value="' + user.userName + '"><span class="icon-minus"></span></button></td>\n\
                                    </tr>');
	    });
	}
    }).done(function () {
	$('#geolocations-table').html('');
    });
};

// functie vult tabel voor te valideren organisms tab in publish.jsp
function loadToValidateOrganisms() {

    var $table = $('#tovalidate-table');
    var $content = $('.content');
    $.ajax({
	url: 'SelectOrganismToValidate',
	type: 'GET',
	dataType: 'json',
	cache: false,
	async: true,
	beforesend: function () {
	    $content.append('<div class="spinner"></div>');
	},
	complete: function (data) {
	    var orgval = data.responseJSON;
	    $table.append('<tr>\n\
                                    <th>Common name</th>\n\
                                    <th>Scientific name</th>\n\\n\
                                    <th>Submitted on</th>\n\
                                    <th>Action</th>\n\
                                </tr>');
	    orgval.forEach(function (o) {
		$table.append('<tr>\n\
                                        <td>' + o.commonName + '</td>\n\\n\
                                        <td>' + o.scientificName + '</td>\n\
                                        <td>'+ o.insertedOn + '</td>\n\
                                        <td><button class="no-button" id="select-organism-btn" type="submit" value="' + o.organismId+ '"><span class="icon-pencil"></span></button></td>\n\
                                    </tr>');
	    });
	}
    }).done(function () {
	$('#tovalidate-table').html('');
    });
};

// functie vult tabel voor published organisms tab in publish.jsp
function loadPublishedOrganisms() {

    var $table = $('#published-table');
    var $content = $('.content');
    $.ajax({
	url: 'SelectAllPublishedOrganisms',
	type: 'GET',
	dataType: 'json',
	cache: false,
	async: true,
	beforesend: function () {
	    $content.append('<div class="spinner"></div>');
	},
	complete: function (data) {
	    var orgpub = data.responseJSON;
	    $table.append('<tr>\n\
                                    <th>Common name</th>\n\
                                    <th>Scientific name</th>\n\\n\
                                    <th>Last updated on</th>\n\
                                </tr>');
	    orgpub.forEach(function (o) {
		$table.append('<tr>\n\
                                        <td>' + o.commonName + '</td>\n\\n\
                                        <td>' + o.scientificName + '</td>\n\
                                        <td>'+ o.updatedOn + '</td>\n\
                                  </tr>');
	    });
	}
    }).done(function () {
	$('#published-table').html('');
    });
};


