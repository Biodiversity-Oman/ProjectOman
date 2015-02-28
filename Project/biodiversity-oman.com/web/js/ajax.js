//---------------------------------------------------------------------------------------------------------------------
// Insert functies etc...
// hier behoren de functies die data moeten laden wanneer document.ready is bijvoorbeeld inserets, updates, search etc..
// GEEEEEEEEEEN LOOAAAAAAAAAD FUNCTIES HIER!!!!!!!
//---------------------------------------------------------------------------------------------------------------------
$(document).ready(function () {

    //tab interface
    $('.tabs .tab-links a').on('click', function (e) {
	var currentAttrValue = $(this).attr('href');
	$('.tabs ' + currentAttrValue).show().siblings().hide();
	$(this).parent('li').addClass('active').siblings().removeClass('active');
	e.preventDefault();
    });
    
    //userinfo.jsp
    $('#update-user-form').submit(function (e) {
	var $message = $('#update-user-message');
	var updatebtn = $('#update');
	$.ajax({
	    url: 'UpdateUserAccount',
	    type: 'POST',
	    dataType: 'text',
	    cache: false,
	    async: true,
	    data: $('#update-user-form').serialize(),
	    beforeSend: function () {
		updatebtn.val('updating').attr('disabled', 'disabled');
	    },
	    complete: function (data) {
		var response = data.responseText;
		if (response === 'succes') {
		    $message.append('<div class="alert alert-success" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Info updated succesfully</div>');
		}
	    },
	    error: function (error) {
		console.log(error);
	    }
	}).done(function () {
	    loadUserInfo();
	    disableInput();
	    updatebtn.val('edit').removeAttr('disabled');
	    setTimeout(function() {
		    $message.fadeOut('slow');
	    }, 2800);
	});
	e.preventDefault();
    });

    //userinfo.jsp change password button + form
    $('#change-password-form').submit(function (e) {
	var $message = $('#update-password-message');
	var wijzigbtn = $('#wijzig');
	$.ajax({
	    url: 'UpdatePassword',
	    type: 'POST',
	    dataType: 'text',
	    cache: false,
	    async: true,
	    data: $('#change-password-form').serialize(),
	    beforeSend: function () {
		wijzigbtn.val('updating').attr('disabled', 'disabled');
	    },
	    complete: function (data) {
		var response = data.responseText;
		if (response === 'error1') {
		    $message.append('<div class="alert alert-danger" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Your password is not valid</div>');
		} else if (response === 'error2') {
		    $message.append('<div class="alert alert-danger" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Your passwords do not match</div>');
		} else if (response === 'succes') {
		    $message.append('<div class="alert alert-success" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Password is changed succesfully</div>');
		}
	    },
	    error: function (error) {
		console.log(error);
	    }
	}).done(function () {
	    loadUserInfo();
	    disableInput();
	    wijzigbtn.val('Wijzig').removeAttr('disabled');
	    setTimeout(function() {
		    $message.fadeOut('slow');
	    }, 2800);
	});
	e.preventDefault();
    });

    // create user form usermanagement.jsp
    $('#create-user-form').submit(function (e) {

	var $message = $('#create-user-message');
	$.ajax({
	    url: 'InsertUserAccount',
	    type: 'POST',
	    dataType: 'text',
	    data: $('#create-user-form').serialize(),
	    complete: function (data) {
		var jsontext = data.responseText;
		if (jsontext === 'succes') {
		    $message.append('<div class="alert alert-success" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>User succesfully created</div>');
		} else if (jsontext === 'error1') {
		    $message.append('<div class="alert alert-danger" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Username already exists</div>');
		} else if (jsontext === 'error2') {
		    $message.append('<div class="alert alert-danger" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Fill in all required fields</div>');
		} else if (jsontext === 'error3') {
		    $message.append('<div class="alert alert-danger" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Passwords do not match</div>');
		}
	    },
	    error: function (error) {
		console.log(error);
	    }
	}).done(function () {
	    $("#create-user-form")[0].reset();
	    loadUsers();
	    setTimeout(function() {
		    $message.fadeOut('slow');
	    }, 2800);
	});
	e.preventDefault();
    });

    // create season form usermanagement.jsp
    $('#create-season-form').submit(function (e) {

	var $message = $('#create-season-message');
	$.ajax({
	    url: 'InsertSeason',
	    type: 'POST',
	    dataType: 'text',
	    data: $('#create-season-form').serialize(),
	    complete: function (data) {
		var jsontext = data.responseText;
		if (jsontext === 'succes') {
		    $message.append('<div class="alert alert-success" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Season succesfully created</div>');
		} else if (jsontext === 'error') {
		    $message.append('<div class="alert alert-danger" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Fill in all required fields</div>');
		}
	    },
	    error: function (error) {
		console.log(error);
	    }
	}).done(function () {
	    $("#create-season-form")[0].reset();
	    loadSeasons();
	    setTimeout(function() {
		    $message.fadeOut('slow');
	    }, 2800);
	});
	e.preventDefault();
    });

    // create habitat form usermanagement.jsp
    $('#create-habitat-form').submit(function (e) {

	var $message = $('#create-habitat-message');
	$.ajax({
	    url: 'InsertHabitat',
	    type: 'POST',
	    dataType: 'text',
	    data: $('#create-habitat-form').serialize(),
	    complete: function (data) {
		var jsontext = data.responseText;
		if (jsontext === 'succes') {
		    $message.append('<div class="alert alert-success" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Habitat succesfully created</div>');
		} else if (jsontext === 'error') {
		    $message.append('<div class="alert alert-danger" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Fill in all required fields</div>');
		}
	    },
	    error: function (error) {
		console.log(error);
	    }
	}).done(function () {
	    $("#create-habitat-form")[0].reset();
	    loadHabitats();
	    setTimeout(function() {
		    $message.fadeOut('slow');
	    }, 2800);
	});
	e.preventDefault();
    });

    // functie inserten van world. dashboard.jsp
    $('#create-world-form').submit(function (e) {

	var $message = $('#create-world-message');
	$.ajax({
	    url: 'InsertWorld',
	    type: 'POST',
	    dataType: 'text',
	    data: $('#create-world-form').serialize(),
	    complete: function (data) {
		var response = data.responseText;
		if (response === 'succes') {
		    $message.append('<div class="alert alert-success" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>World succesfully created</div>');
		} else if (response === 'error1') {
		    $message.append('<div class="alert alert-danger" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>World already exists</div>');
		} else if (response === 'error2') {
		    $message.append('<div class="alert alert-danger" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Fill in all fields!</div>');
		}
	    },
	    error: function (error) {
		console.log(error);
	    }
	}).done(function () {
	    $("#create-world-form")[0].reset();
	    loadWorlds();
	    setTimeout(function() {
		    $message.fadeOut('slow');
	    }, 2800);
	});
	e.preventDefault();
    });

// functie inserten van family. dashboard.jsp
    $('#create-family-form').submit(function (e) {

	var $message = $('#create-family-message');
	$.ajax({
	    url: 'InsertFamily',
	    type: 'POST',
	    dataType: 'text',
	    data: $('#create-family-form').serialize(),
	    complete: function (data) {
		var response = data.responseText;
		if (response === 'succes') {
		    $message.append('<div class="alert alert-success" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Family succesfully created</div>');
		} else if (response === 'error2') {
		    $message.append('<div class="alert alert-danger" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Fill in all fields!</div>');
		}
	    },
	    error: function (error) {
		console.log(error);
	    }
	}).done(function () {
	    $("#create-family-form")[0].reset();
	    loadFamilies();
	    setTimeout(function() {
		    $message.fadeOut('slow');
	    }, 2800);
	});
	e.preventDefault();
    });

    // functie inserten van subfamily. dashboard.jsp
    $('#create-subfamily-form').submit(function (e) {

	var $message = $('#create-subfamily-message');
	$.ajax({
	    url: 'InsertSubFamily',
	    type: 'POST',
	    dataType: 'text',
	    data: $('#create-subfamily-form').serialize(),
	    complete: function (data) {
		var response = data.responseText;
		if (response === 'succes') {
		    $message.append('<div class="alert alert-success" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>SubFamily succesfully created</div>');
		} else if (response === 'error2') {
		    $message.append('<div class="alert alert-danger" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Fill in all fields!</div>');
		}
	    },
	    error: function (error) {
		console.log(error);
	    }
	}).done(function () {
	    $("#create-subfamily-form")[0].reset();
	    loadSubFamilies();
	    setTimeout(function() {
		    $message.fadeOut('slow');
	    }, 2800);
	});
	e.preventDefault();
    });
    
    // functie inserten van geolocation. dashboard.jsp
    $('#create-geolocation-form').submit(function (e) {

	var $message = $('#create-geolocation-message');
	$.ajax({
	    url: 'InsertGeolocation',
	    type: 'POST',
	    dataType: 'text',
	    data: $('#create-geolocation-form').serialize(),
	    complete: function (data) {
		var response = data.responseText;
		if (response === 'succes') {
		    $message.append('<div class="alert alert-success" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Area succesfully created</div>');
		} else if (response === 'error') {
		    $message.append('<div class="alert alert-danger" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Area already exists</div>');
		}
	    },
	    error: function (error) {
		console.log(error);
	    }
	}).done(function () {
	    $("#create-geolocation-form")[0].reset();
	    loadWorlds();
	    setTimeout(function() {
		    $message.fadeOut('slow');
	    }, 2800);
	});
	e.preventDefault();
    });

    // functie voor make-admin button in list users tabel in usermanagement.jsp
    $(document).on('click', '.table #delete-user-btn', function () {

	var username = ($(this).attr("value"));
	$.ajax({
	    url: 'DeleteUserAccount?username=' + username,
	    type: 'POST',
	    dataType: 'text',
	    cache: false,
	    async: true
	}).done(function () {
	    loadUsers();
	});
    });

    // functie voor delete button in list users tabel in usermanagement.jsp
    $(document).on('click', '.table #make-admin-btn', function () {

	var username = ($(this).attr("value"));
	$.ajax({
	    url: 'SetSuperUser?username=' + username,
	    type: 'POST',
	    dataType: 'text',
	    cache: false,
	    async: true
	}).done(function () {
	    loadUsers();
	});
    });

    // functie voor demoten van een user in usermanagement.jsp
    $(document).on('click', '.table #make-normal-btn', function () {

	var username = ($(this).attr("value"));
	$.ajax({
	    url: 'SetNormalUser?username=' + username,
	    type: 'POST',
	    dataType: 'text',
	    cache: false,
	    async: true
	}).done(function () {
	    loadUsers();
	});
    });

    // functie voor delete world btn in dashboard.jsp
    $(document).on('click', '.table #delete-world-btn', function () {

	var id = ($(this).attr("value"));
	$.ajax({
	    url: 'DeleteWorld?id=' + id,
	    type: 'POST',
	    dataType: 'text',
	    cache: false,
	    async: true
	}).done(function () {
	    loadWorlds();
	});
    });

    // functie voor delete season btn in dashboard.jsp
    $(document).on('click', '.table #delete-season-btn', function () {

	var id = ($(this).attr("value"));
	$.ajax({
	    url: 'DeleteSeason?id=' + id,
	    type: 'POST',
	    dataType: 'text',
	    cache: false,
	    async: true
	}).done(function () {
	    loadSeasons();
	});
    });

    // functie voor delete family btn in dashboard.jsp
    $(document).on('click', '.table #delete-family-btn', function () {

	var id = ($(this).attr("value"));
	$.ajax({
	    url: 'DeleteFamily?id=' + id,
	    type: 'POST',
	    dataType: 'text',
	    cache: false,
	    async: true
	}).done(function () {
	    loadFamilies();
	});
    });

    // functie voor delete habitat btn in dashboard.jsp
    $(document).on('click', '.table #delete-habitat-btn', function () {

	var id = ($(this).attr("value"));
	$.ajax({
	    url: 'DeleteHabitat?id=' + id,
	    type: 'POST',
	    dataType: 'text',
	    cache: false,
	    async: true
	}).done(function () {
	    loadHabitats();
	});
    });

    // functie voor delete subfamily btn in dashboard.jsp
    $(document).on('click', '.table #delete-subfamily-btn', function () {

	var id = ($(this).attr("value"));
	$.ajax({
	    url: 'DeleteSubFamily?id=' + id,
	    type: 'POST',
	    dataType: 'text',
	    cache: false,
	    async: true
	}).done(function () {
	    loadSubFamilies();
	});
    });

    //functie voor de zoekbalk in usermanagement.jsp
    $('#search-user-account').keyup(function (e) {

	var $userstable = $('#users-table');
	var keyword = $(this).val();
	if (keyword.length >= 3) {
	    $.ajax({
		url: 'SearchUserAccount',
		type: 'GET',
		dataType: 'json',
		cache: false,
		async: true,
		data: 'keyword=' + keyword,
		complete: function (data) {
		    var users = data.responseJSON;
		    $userstable.append('<tr>\n\
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
		    if (users.length === 0) {
			$userstable.append('<tr><td>User not found</td></tr>');
		    }
		    ;
		    users.forEach(function (user) {
			$userstable.append('<tr>\n\
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
	} else {
	    loadUsers();
	}
    });
});
