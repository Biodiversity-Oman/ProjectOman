//---------------------------------------------------------------------------------------------------------------------
// General form functions
//---------------------------------------------------------------------------------------------------------------------
$(document).ready(function () {

    //tab interface
    $('.tabs .tab-links a').on('click', function (e) {
	var currentAttrValue = $(this).attr('href');
	$('.tabs ' + currentAttrValue).show().siblings().hide();
	$(this).parent('li').addClass('active').siblings().removeClass('active');
	e.preventDefault();
    });
    
    // general close-button function to close pop-ups dashboard.jsp
    $(document).on('click', '.close-button', function(){
	$('.insert-box').hide();
	document.getElementById('fade').style.display = 'none';
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
    

//---------------------------------------------------------------------------------------------------------------------
// User management functions
//---------------------------------------------------------------------------------------------------------------------

    //userinfo.jsp change password button + form
    $('#change-password-form').submit(function (e) {
	
	var $message = $('#update-password-message');
	$message.show();
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
		    $message.append('<div class="alert alert-success" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Password is changed succesfully. This screen closes automatically</div>');
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
                    $('.insert-box').hide();
	document.getElementById('fade').style.display = 'none';
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


//---------------------------------------------------------------------------------------------------------------------
// Insert functions
//---------------------------------------------------------------------------------------------------------------------

// create user form usermanagement.jsp
    $('#create-user-form').submit(function (e) {

	var $message = $('#create-user-message');
	$message.show();
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
	    loadUsers();
	    setTimeout(function() {
		    $message.fadeOut('slow');
                    $('.insert-box').hide();
	document.getElementById('fade').style.display = 'none';
        $("#create-user-form")[0].reset();
	    }, 2800);
	});
	e.preventDefault();
    });

    // create season form usermanagement.jsp
    $('#create-season-form').submit(function (e) {

	var $message = $('#create-season-message');
	$message.show();
	$.ajax({
	    url: 'InsertSeason',
	    type: 'POST',
	    dataType: 'text',
	    data: $('#create-season-form').serialize(),
	    complete: function (data) {
		var jsontext = data.responseText;
		if (jsontext === 'succes') {
		    $message.append('<div class="alert alert-success" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Season succesfully created. This screen closes automatically</div>');
		} else if (jsontext === 'error') {
		    $message.append('<div class="alert alert-danger" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Fill in all required fields</div>');
		}
	    },
	    error: function (error) {
		console.log(error);
	    }
	}).done(function () {
	    loadSeasons();
	    setTimeout(function() {
		    $message.fadeOut('slow');
                    $('.insert-box').hide();
	document.getElementById('fade').style.display = 'none';
        $("#create-season-form")[0].reset();
	    }, 2800);
	});
	e.preventDefault();
    });

    // create habitat form usermanagement.jsp
    $('#create-habitat-form').submit(function (e) {

	var $message = $('#create-habitat-message');
	$message.show();
	$.ajax({
	    url: 'InsertHabitat',
	    type: 'POST',
	    dataType: 'text',
	    data: $('#create-habitat-form').serialize(),
	    complete: function (data) {
		var jsontext = data.responseText;
		if (jsontext === 'succes') {
		    $message.append('<div class="alert alert-success" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Habitat succesfully created. This screen closes automatically</div>');
		} else if (jsontext === 'error') {
		    $message.append('<div class="alert alert-danger" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Fill in all required fields</div>');
		}
	    },
	    error: function (error) {
		console.log(error);
	    }
	}).done(function () {
	    loadHabitats();
	    setTimeout(function() {
		    $message.fadeOut('slow');
                    $('.insert-box').hide();
	document.getElementById('fade').style.display = 'none';
        $("#create-habitat-form")[0].reset();
	    }, 2800);
	});
	e.preventDefault();
    });

    // functie inserten van world. dashboard.jsp
    $('#create-world-form').submit(function (e) {
	
	var $message = $('#create-world-message');
	$message.show();
	$.ajax({
	    url: 'InsertWorld',
	    type: 'POST',
	    dataType: 'text',
	    data: $('#create-world-form').serialize(),
	    complete: function (data) {
		var response = data.responseText;
		if (response === 'succes') {
		    $message.append('<div class="alert alert-success" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>World succesfully created. This screen closes automatically</div>');
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
	    loadWorlds();
	    setTimeout(function() {
		    $message.fadeOut('slow');
                    $('.insert-box').hide();
	document.getElementById('fade').style.display = 'none';
        $("#create-world-form")[0].reset();
	    }, 2800);
	});
	e.preventDefault();
    });

// functie inserten van family. dashboard.jsp
    $('#create-family-form').submit(function (e) {

	var $message = $('#create-family-message');
	$message.show();
	$.ajax({
	    url: 'InsertFamily',
	    type: 'POST',
	    dataType: 'text',
	    data: $('#create-family-form').serialize(),
	    complete: function (data) {
		var response = data.responseText;
		if (response === 'succes') {
		    $message.append('<div class="alert alert-success" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Family succesfully created. This screen closes automatically</div>');
		} else if (response === 'error2') {
		    $message.append('<div class="alert alert-danger" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Fill in all fields!</div>');
		}
	    },
	    error: function (error) {
		console.log(error);
	    }
	}).done(function () {
	    loadFamilies();
	    setTimeout(function() {
		    $message.fadeOut('slow');
                    $('.insert-box').hide();
	document.getElementById('fade').style.display = 'none';
        $("#create-family-form")[0].reset();
	    }, 2800);
	});
	e.preventDefault();
    });

    // functie inserten van subfamily. dashboard.jsp
    $('#create-subfamily-form').submit(function (e) {

	var $message = $('#create-subfamily-message');
	$message.show();
	$.ajax({
	    url: 'InsertSubFamily',
	    type: 'POST',
	    dataType: 'text',
	    data: $('#create-subfamily-form').serialize(),
	    complete: function (data) {
		var response = data.responseText;
		if (response === 'succes') {
		    $message.append('<div class="alert alert-success" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>SubFamily was succesfully created. This screen closes automatically</div>');
		} else if (response === 'error2') {
		    $message.append('<div class="alert alert-danger" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Fill in all fields!</div>');
		}
	    },
	    error: function (error) {
		console.log(error);
	    }
	}).done(function () {
	    loadSubFamilies();
	    setTimeout(function() {
		    $message.fadeOut('slow');
                    $('.insert-box').hide();
	document.getElementById('fade').style.display = 'none';
        $("#create-subfamily-form")[0].reset();
	    }, 2800);
	});
	e.preventDefault();
    });
    
    // functie inserten van geolocation. dashboard.jsp
    $('#create-geolocation-form').submit(function (e) {
	var $message = $('#create-geolocation-message');
	$message.show();
	$.ajax({
	    url: 'InsertGeolocation',
	    type: 'POST',
	    dataType: 'text',
	    data: $('#create-geolocation-form').serialize(),
	    complete: function (data) {
		var response = data.responseText;
		if (response === 'succes') {
		    $message.append('<div class="alert alert-success" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Area was succesfully created. This screen closes automatically</div>');
		} else if (response === 'error') {
		    $message.append('<div class="alert alert-danger" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Area already exists</div>');
		}
	    },
	    error: function (error) {
		console.log(error);
	    }
	}).done(function () {
	    loadGeolocations();
	    setTimeout(function() {
		    $message.fadeOut('slow');
                    $('.insert-box').hide();
	document.getElementById('fade').style.display = 'none';
        $("#create-geolocation-form")[0].reset();
	    }, 2800);
	});
	e.preventDefault();
    });
    
    // functie inserten van Organism. dashboard.jsp
    $('#create-organism-form').submit(function (e) {

	var $message = $('#create-organism-message');
	$message.show();
	var formData = new FormData($(this)[0]);
	$.ajax({
            url: 'InsertOrganism',
	    dataType: 'text',
	    processData: false,
	    contentType: false,
	    type: 'POST',
	    data: formData,
	    complete: function (data) {
		var response = data.responseText;
		if (response === 'succes') {
		    $message.append('<div class="alert alert-success" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Organism was added successfully. This screen closes automatically</div>');
		} else if (response === 'error1') {
		    $message.append('<div class="alert alert-danger" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Scientific name allready exists.</div>');
		} else if (response === 'error2') {
		    $message.append('<div class="alert alert-danger" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Service not available. Please contact an administrator if the problem persists.</div>');
		}
	    },
	    error: function (error) {
		console.log(error);
	    }
	}).done(function () {
            loadOrganisms();
            loadToValidateOrganisms();
	    setTimeout(function() {
		    $message.fadeOut('slow');
                    $('.insert-box').hide();
	document.getElementById('fade').style.display = 'none';
        $("#create-organism-form")[0].reset();
	    }, 2800);
	});
	e.preventDefault();
    });


//---------------------------------------------------------------------------------------------------------------------
// Update functions
//---------------------------------------------------------------------------------------------------------------------


//Update user in userinfo.jsp
    $('#update-user-form').submit(function (e) {
	
	var $message = $('#update-user-message');
	$message.show();
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
		    $message.append('<div class="alert alert-success" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Info updated succesfully. This screen closes automatically</div>');
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
                    $("#update-user-form")[0].reset();
	    }, 2800);
	});
	e.preventDefault();
    });

//function for update world
      $('#update-world-form').submit(function (e) {
	var $message = $('#update-world-message');
	$.ajax({
	    url: 'UpdateWorld',
	    type: 'POST',
	    dataType: 'text',
	    data: $('#update-world-form').serialize(),
	    complete: function (data) {
		var response = data.responseText;
		if (response === 'succes') {
		    $message.append('<div class="alert alert-success" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>World was updated successfully. This screen closes automatically</div>');
		} else if (response === 'error') {
		    $message.append('<div class="alert alert-danger" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>World not updated</div>');
		}
	    }, error: function (error) {
		console.log(error);
	    }
	}).done(function () {
	    loadWorlds();
	    setTimeout(function () {
		$message.fadeOut('slow');
                $('.insert-box').hide();
	document.getElementById('fade').style.display = 'none';
        $("#update-world-form")[0].reset();        
	    }, 2800);
	});
	e.preventDefault();
    });
    
 // function for update habitat
     $('#update-habitat-form').submit(function (e) {
	  
	var $message = $('#update-habitat-message');
	$.ajax({
	    url: 'UpdateHabitat',
	    type: 'POST',
	    dataType: 'text',
	    data: $('#update-habitat-form').serialize(),
	    complete: function (data) {
		var response = data.responseText;
		if (response === 'succes') {
		    $message.append('<div class="alert alert-success" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Habitat was updated successfully. This screen closes automatically</div>');
		} else if (response === 'error') {
		    $message.append('<div class="alert alert-danger" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Habitat not updated</div>');
		}
	    }, error: function (error) {
		console.log(error);
	    }
	}).done(function () {
	    loadHabitats();
	    setTimeout(function () {
		$message.fadeOut('slow');
                $('.insert-box').hide();
	document.getElementById('fade').style.display = 'none';
        $("#update-habitat-form")[0].reset();
	    }, 2800);
	});
	e.preventDefault();
    });
    
    // functie update van family
    $('#update-family-form').submit(function (e) {

	var $message = $('#update-family-message');
	$message.show();
	$.ajax({
	    url: 'UpdateFamily',
	    type: 'POST',
	    dataType: 'text',
	    data: $('#update-family-form').serialize(),
	    complete: function (data) {
		var response = data.responseText;
		if (response === 'succes') {
		    $message.append('<div class="alert alert-success" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Family was successfully updated. This screen closes automatically</div>');
		} else if (response === 'error') {
		    $message.append('<div class="alert alert-danger" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Family not updated</div>');
		}
	    },
	    error: function (error) {
		console.log(error);
	    }
	}).done(function () {
	    loadFamilies();
	    setTimeout(function() {
		    $message.fadeOut('slow');
                    $('.insert-box').hide();
	document.getElementById('fade').style.display = 'none';
        $("#update-family-form")[0].reset();
	    }, 2800);
	});
	e.preventDefault();
    });
    
    // functie update van subfamily
    $('#update-subfamily-form').submit(function (e) {

	var $message = $('#update-subfamily-message');
	$message.show();
	$.ajax({
	    url: 'UpdateSubfamily',
	    type: 'POST',
	    dataType: 'text',
	    data: $('#update-subfamily-form').serialize(),
	    complete: function (data) {
		var response = data.responseText;
		if (response === 'succes') {
		    $message.append('<div class="alert alert-success" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Subfamily was successfully updated. This screen closes automatically</div>');
		} else if (response === 'error') {
		    $message.append('<div class="alert alert-danger" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Subfamily not updated</div>');
		}
	    },
	    error: function (error) {
		console.log(error);
	    }
	}).done(function () {
	    loadSubFamilies();
	    setTimeout(function() {
		    $message.fadeOut('slow');
                    $('.insert-box').hide();
	document.getElementById('fade').style.display = 'none';
        $("#update-subfamily-form")[0].reset();
	    }, 2800);
	});
	e.preventDefault();
    });
    
    //function for update season
      $('#update-season-form').submit(function (e) {
	  
	var $message = $('#update-season-message');
        $message.show();
	$.ajax({
	    url: 'UpdateSeason',
	    type: 'POST',
	    dataType: 'text',
	    data: $('#update-season-form').serialize(),
	    complete: function (data) {
		var response = data.responseText;
		if (response === 'succes') {
		    $message.append('<div class="alert alert-success" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Season was updated successfully. This screen closes automatically</div>');
		} else if (response === 'error') {
		    $message.append('<div class="alert alert-danger" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Season not updated</div>');
		}
	    }, error: function (error) {
		console.log(error);
	    }
	}).done(function () {
	    loadSeasons();
	    setTimeout(function () {
		$message.fadeOut('slow');
                $('.insert-box').hide();
	document.getElementById('fade').style.display = 'none';
        $("#update-season-form")[0].reset();
	    }, 2800);
	});
	e.preventDefault();
    });
    
    // functie update van geolocation
    $('#update-geolocation-form').submit(function (e) {

	var $message = $('#update-geolocation-message');
	$message.show();
	$.ajax({
	    url: 'UpdateGeolocation',
	    type: 'POST',
	    dataType: 'text',
	    data: $('#update-geolocation-form').serialize(),
	    complete: function (data) {
		var response = data.responseText;
		if (response === 'succes') {
		    $message.append('<div class="alert alert-success" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Area was successfully updated. This screen closes automatically</div>');
		} else if (response === 'error') {
		    $message.append('<div class="alert alert-danger" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Area not updated</div>');
		}
	    },
	    error: function (error) {
		console.log(error);
	    }
	}).done(function () {
	    loadGeolocations();
	    setTimeout(function() {
		    $message.fadeOut('slow');
                    $('.insert-box').hide();
	document.getElementById('fade').style.display = 'none';
        $("#update-geolocation-form")[0].reset();
	    }, 2800);
	});
	e.preventDefault();
    });
    

   
     // function for update of Organism. in publish.jsp
    $('#update-organism-form').submit(function (e) {

	var $message = $('#update-organism-message');
        $message.show();
	var formData = new FormData($(this)[0]);
	$.ajax({
            url: 'UpdateOrganism',
	    dataType: 'text',
	    processData: false,
	    contentType: false,
	    type: 'POST',
	    data: formData,
	    complete: function (data) {
		var response = data.responseText;
                // See servOrganism for response messages
		if (response === 'succes') {
		    $message.append('<div class="alert alert-success" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>The organism was validated and updated successfully. This screen closes automatically</div>');
		} else if (response === 'error1') {
		    $message.append('<div class="alert alert-danger" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Scientific name allready exists.</div>');
		} else if (response === 'error2') {
		    $message.append('<div class="alert alert-danger" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Service not available. Please contact an administrator if the problem persists.</div>');
		}
	    },
	    error: function (error) {
		console.log(error);
	    }
	}).done(function () {
	    $("#update-organism-form")[0].reset();
	    setTimeout(function() {
		    $message.fadeOut('slow');
                    loadOrganisms();
                    loadPublishedOrganisms();
                    loadToValidateOrganisms();
                    $('.insert-box').hide();
	document.getElementById('fade').style.display = 'none';
        $("#update-organism-form")[0].reset();
	    }, 2800);
	});
	e.preventDefault();
    });


//---------------------------------------------------------------------------------------------------------------------
// SelectOne functions (buttons)
//---------------------------------------------------------------------------------------------------------------------


// update world-button dashboard.jsp - worlds tab
    $(document).on('click', 'table #update-world-btn', function() {
	document.getElementById('update-world').style.display = 'block';
	document.getElementById('fade').style.display = 'block';
	var id = ($(this).attr("value"));
	$.ajax({
	    url: 'SelectWorldById?id=' + id,
	    type: 'GET',
	    dataType: 'JSON',
	    cache: false,
	    async: true
	}).done(function (data) {
	     $('#world-id').val(id);
	     $('#world-name').val(data.worldName);
	     $('#world-description').val(data.description);
	});
    });
    
    // update geolocation-button dashboard.jsp - geolocations tab
    $(document).on('click', 'table #update-geolocation-btn', function() {
	document.getElementById('update-geolocation').style.display = 'block';
	document.getElementById('fade').style.display = 'block';
        $('#edit-map').show();
        $('#update-canvas').hide();
	var id = ($(this).attr("value"));
	$.ajax({
	    url: 'SelectGeolocationById?id=' + id,
	    type: 'GET',
	    dataType: 'JSON',
	    cache: false,
	    async: true
	}).done(function (data) {
	     $('#geolocation-id').val(id);
	     $('#area-name').val(data.areaName);
	     $('#area-description').val(data.areaDescription);
             $('#update-coordinates').val(data.coordinates);
	});
    });

    
     // update season-button dashboard.jsp - seasons tab
    $(document).on('click', 'table #update-season-btn', function() {
	document.getElementById('update-season').style.display = 'block';
	document.getElementById('fade').style.display = 'block';
	var id = ($(this).attr("value"));
	$.ajax({
	    url: 'SelectSeasonById?id=' + id,
	    type: 'GET',
	    dataType: 'JSON',
	    cache: false,
	    async: true
	}).done(function (data) {
	     $('#season-id').val(id);
	     $('#season-name').val(data.seasonName);
	     $('#season-description').val(data.seasonDescription);
	});
    });
    
    // update family-button dashboard.jsp - family tab
    $(document).on('click', 'table #update-family-btn', function() {
	document.getElementById('update-family').style.display = 'block';
	document.getElementById('fade').style.display = 'block';
	var id = ($(this).attr("value"));
	$.ajax({
	    url: 'SelectFamilyById?id=' + id,
	    type: 'GET',
	    dataType: 'JSON',
	    cache: false,
	    async: true
	}).done(function (data) {
	     $('#family-id').val(id);
	     $('#family-name').val(data.familyName);
	     $('#family-description').val(data.familyDescription);
             $('#world-ddl').val(data.worldId);
	});
    });
    
    // update subfamily-button dashboard.jsp - subfamily tab
    $(document).on('click', 'table #update-subfamily-btn', function() {
	document.getElementById('update-subfamily').style.display = 'block';
	document.getElementById('fade').style.display = 'block';
	var id = ($(this).attr("value"));
	$.ajax({
	    url: 'SelectSubFamilyById?id=' + id,
	    type: 'GET',
	    dataType: 'JSON',
	    cache: false,
	    async: true
	}).done(function (data) {
	     $('#subfamily-id').val(id);
	     $('#subfamily-name').val(data.subFamilyName);
	     $('#subfamily-description').val(data.subFamilyDescription);
             $('#family-ddl').val(data.subFamilyFamilyName);
	});
    });
    
    // update habitat-button dashboard.jsp - habitat tab
    $(document).on('click', 'table #update-habitat-btn', function() {
	document.getElementById('update-habitat').style.display = 'block';
	document.getElementById('fade').style.display = 'block';
	var id = ($(this).attr("value"));
	$.ajax({
	    url: 'SelectHabitatById?id=' + id,
	    type: 'GET',
	    dataType: 'JSON',
	    cache: false,
	    async: true
	}).done(function (data) {
	     $('#habitat-id').val(id);
	     $('#habitat-name').val(data.habitatName);
	     $('#habitat-description').val(data.habitatDescription);

	});
    });
    
    // update select-organism-button publish.jsp - queue tab
    $(document).on('click', 'table #select-organism-btn', function() {
	document.getElementById('update-organism').style.display = 'block';
	document.getElementById('fade').style.display = 'block';
	var id = ($(this).attr("value"));
	$.ajax({
	    url: 'SelectOneOrganismById?id=' + id,
	    type: 'GET',
	    dataType: 'JSON',
	    cache: false,
	    async: true
	}).done(function (data) {
	     $('#organism-id').val(id);
             $('#scientific-name').val(data.scientificName);
             $('#common-name').val(data.commonName);
             $('#local-name').val(data.localName);
             $('#description').val(data.description);
             $('#benefits').val(data.benefits);
             $('#dangerous').val(data.dangerous);
             $('#threats').val(data.threats);
             $('#opportunities').val(data.opportunities);
             $('#links').val(data.links);
             $('#food-name').val(data.foodName);
             $('#food-description').val(data.foodDescription);  
             
             $('#family-ddl1').val(data.family.familyName).focus();
             $('#subfamily-ddl1').val(data.subFamily.subFamilyName).focus();
             $('#habitat-ddl').val(data.habitat.habitatName).focus();
             $('#world-ddl').val(data.world.worldName).focus();  
	});
    });




//---------------------------------------------------------------------------------------------------------------------
// Delete functions
//---------------------------------------------------------------------------------------------------------------------


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
    
    // functie voor delete geolocation btn in dashboard.jsp
    $(document).on('click', '.table #delete-geolocation-btn', function () {

	var id = ($(this).attr("value"));
	$.ajax({
	    url: 'DeleteGeolocation?id=' + id,
	    type: 'POST',
	    dataType: 'text',
	    cache: false,
	    async: true
	}).done(function () {
	    loadGeolocations();
	});
    });
    
    // functie voor delete organism btn in dashboard.jsp
    $(document).on('click', '.table #delete-organism-btn', function () {

	var id = ($(this).attr("value"));
	$.ajax({
	    url: 'DeleteOrganism?id=' + id,
	    type: 'POST',
	    dataType: 'text',
	    cache: false,
	    async: true
	}).done(function () {
	    loadOrganisms();
	});
    });
    
    // functie voor delete organism btn in published.jsp
    $(document).on('click', '.table #delete-organism-tovalidate-btn', function () {

	var id = ($(this).attr("value"));
	$.ajax({
	    url: 'DeleteOrganism?id=' + id,
	    type: 'POST',
	    dataType: 'text',
	    cache: false,
	    async: true
	}).done(function () {
	    loadToValidateOrganisms();
	});
    });
 
});