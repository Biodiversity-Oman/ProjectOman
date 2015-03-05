//---------------------------------------------------------------------------------------------------------------------
// General form functions
//---------------------------------------------------------------------------------------------------------------------
$(document).ready(function () {
    adminCheck();
    //tab interface
    $('.tabs .tab-links a').on('click', function (e) {
        var currentAttrValue = $(this).attr('href');
        $('.tabs ' + currentAttrValue).show().siblings().hide();
        $(this).parent('li').addClass('active').siblings().removeClass('active');
        e.preventDefault();
    });

    // general close-button function to close pop-ups dashboard.jsp
    $(document).on('click', '.close-button', function () {
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
            setTimeout(function () {
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
            setTimeout(function () {
                $message.fadeOut('slow');
            }, 2800);
            $("#create-user-form")[0].reset();
            $message.empty();
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
                    $message.append('<div class="alert alert-success" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Season succesfully created.</div>');
                } else if (jsontext === 'error') {
                    $message.append('<div class="alert alert-danger" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Fill in all required fields</div>');
                }
            },
            error: function (error) {
                console.log(error);
            }
        }).done(function () {
            loadSeasons();
            setTimeout(function () {
                $message.fadeOut('slow');
            }, 2800);
            $message.empty();
            $("#create-season-form")[0].reset();
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
                    $message.append('<div class="alert alert-success" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Habitat succesfully created.</div>');
                } else if (jsontext === 'error') {
                    $message.append('<div class="alert alert-danger" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Fill in all required fields</div>');
                }
            },
            error: function (error) {
                console.log(error);
            }
        }).done(function () {
            loadHabitats();
            setTimeout(function () {
                $message.fadeOut('slow');
            }, 2800);
            $message.empty();
            $("#create-habitat-form")[0].reset();
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
                    $message.append('<div class="alert alert-success" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>World succesfully created.</div>');
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
            setTimeout(function () {
                $message.fadeOut('slow');
            }, 2800);
            $message.empty();
            $("#create-world-form")[0].reset();
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
                    $message.append('<div class="alert alert-success" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Family succesfully created.</div>');
                } else if (response === 'error2') {
                    $message.append('<div class="alert alert-danger" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Fill in all fields!</div>');
                }
            },
            error: function (error) {
                console.log(error);
            }
        }).done(function () {
            loadFamilies();
            setTimeout(function () {
                $message.fadeOut('slow');
            }, 2800);
            $message.empty();
            $("#create-family-form")[0].reset();
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
                    $message.append('<div class="alert alert-success" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>SubFamily was succesfully created.</div>');
                } else if (response === 'error2') {
                    $message.append('<div class="alert alert-danger" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Fill in all fields!</div>');
                }
            },
            error: function (error) {
                console.log(error);
            }
        }).done(function () {
            loadSubFamilies();
            setTimeout(function () {
                $message.fadeOut('slow');
            }, 2800);
            $message.empty();
            $("#create-subfamily-form")[0].reset();
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
                    $message.append('<div class="alert alert-success" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Area was succesfully created.</div>');
                } else if (response === 'error') {
                    $message.append('<div class="alert alert-danger" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Area already exists</div>');
                }
            },
            error: function (error) {
                console.log(error);
            }
        }).done(function () {
            loadGeolocations();
            setTimeout(function () {
                $message.fadeOut('slow');
            }, 2800);
            $message.empty();
            $("#create-geolocation-form")[0].reset();
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
                    $message.append('<div class="alert alert-success" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Organism was added successfully.</div>');
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
            loadPendingOrganisms();
            setTimeout(function () {
                $message.fadeOut('slow');
            }, 2800);
            $message.empty();
            $("#create-organism-form")[0].reset();
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
                    $message.append('<div class="alert alert-success" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Info updated succesfully.</div>');
                }
            },
            error: function (error) {
                console.log(error);
            }
        }).done(function () {
            loadUserInfo();
            disableInput();
            updatebtn.val('edit').removeAttr('disabled');
            setTimeout(function () {
                $message.fadeOut('slow');
            }, 2800);
            $message.empty();
        });
        e.preventDefault();
    });

//function for update world
    $('#update-world-form').submit(function (e) {

        var $message = $('#update-world-message');
        $message.show();
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
            $message.empty();
        });
        e.preventDefault();
    });

    // function for update habitat
    $('#update-habitat-form').submit(function (e) {

        var $message = $('#update-habitat-message');
        $message.show();
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
            $message.empty();
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
            setTimeout(function () {
                $message.fadeOut('slow');
                $('.insert-box').hide();
                document.getElementById('fade').style.display = 'none';
                $("#update-family-form")[0].reset();
            }, 2800);
            $message.empty();
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
            setTimeout(function () {
                $message.fadeOut('slow');
                $('.insert-box').hide();
                document.getElementById('fade').style.display = 'none';
                $("#update-subfamily-form")[0].reset();
            }, 2800);
            $message.empty();
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
            $message.empty();
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
            setTimeout(function () {
                $message.fadeOut('slow');
                $('.insert-box').hide();
                document.getElementById('fade').style.display = 'none';
                $("#update-geolocation-form")[0].reset();
            }, 2800);
            $message.empty();
        });
        e.preventDefault();
    });



    // function for update of Organism/published in publish.jsp
    $('#update-published-organism-form').submit(function (e) {

        var $message = $('#update-published-organism-message');
        $message.show();
        var formData = new FormData($(this)[0]);
        $.ajax({
            //FOR VALIDATION = TRUE
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
            loadOrganisms();
            loadPublishedOrganisms();
            loadToValidateOrganisms();
            loadPendingOrganisms();
            setTimeout(function () {
                $message.fadeOut('slow');
                $('.insert-box').hide();
                document.getElementById('fade').style.display = 'none';
                $("#update-published-organism-form")[0].reset();
            }, 2800);

            $message.empty();
        });
        e.preventDefault();
    });

    // function for update of Organism/pending. in dashboard.jsp
    $('#update-pending-organism-form').submit(function (e) {

        var $message = $('#update-pending-organism-message');
        $message.show();
        var formData = new FormData($(this)[0]);
        $.ajax({
            //FOR VALIDATION = FALSE
            url: 'UpdatePending',
            dataType: 'text',
            processData: false,
            contentType: false,
            type: 'POST',
            data: formData,
            complete: function (data) {
                var response = data.responseText;
                // See servOrganism for response messages
                if (response === 'succes') {
                    $message.append('<div class="alert alert-success" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>The organism updated successfully. This screen closes automatically</div>');
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
            loadPublishedOrganisms();
            loadToValidateOrganisms();
            loadPendingOrganisms();
            setTimeout(function () {
                $message.fadeOut('slow');
                $('.insert-box').hide();
                document.getElementById('fade').style.display = 'none';
                $("#update-pending-organism-form")[0].reset();
            }, 2800);

            $message.empty();
        });
        e.preventDefault();
    });

// function for update of Organism/queue. in publish.jsp
    $('#update-queue-organism-form').submit(function (e) {

        var $message = $('#update-queue-organism-message');
        $message.show();
        var formData = new FormData($(this)[0]);
        $.ajax({
            // FOR VALIDATION = TRUE
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
                    $message.append('<div class="alert alert-success" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>The organism updated successfully. This screen closes automatically</div>');
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
            loadPublishedOrganisms();
            loadToValidateOrganisms();
            loadPendingOrganisms();
            setTimeout(function () {
                $message.fadeOut('slow');
                $('.insert-box').hide();
                document.getElementById('fade').style.display = 'none';
                $("#update-queue-organism-form")[0].reset();
            }, 2800);

            $message.empty();
        });
        e.preventDefault();
    });


//---------------------------------------------------------------------------------------------------------------------
// SelectOne functions (buttons)
//---------------------------------------------------------------------------------------------------------------------


// update world-button dashboard.jsp - worlds tab
    $(document).on('click', 'table #update-world-btn', function () {
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
    $(document).on('click', 'table #update-geolocation-btn', function () {
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
    $(document).on('click', 'table #update-season-btn', function () {
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
    $(document).on('click', 'table #update-family-btn', function () {
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
            $("#world-ddl-update-family option[value='" + data.worldId + "']").attr("selected", "selected");
        });
    });

    // update subfamily-button dashboard.jsp - subfamily tab
    $(document).on('click', 'table #update-subfamily-btn', function () {
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
            $("#family-ddl-update-breed option[value='" + data.familyId + "']").attr("selected", "selected");
        });
    });

    // update habitat-button dashboard.jsp - habitat tab
    $(document).on('click', 'table #update-habitat-btn', function () {
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

    // update select-organism-button/validate publish.jsp - queue tab
    $(document).on('click', 'table #update-queue-organism-btn', function () {
        document.getElementById('update-queue-organism').style.display = 'block';
        document.getElementById('fade').style.display = 'block';
        var id = ($(this).attr("value"));
        $.ajax({
            url: 'SelectOneOrganismById?id=' + id,
            type: 'GET',
            dataType: 'JSON',
            cache: false,
            async: true
        }).done(function (data) {
            console.log(data);
            $('#organism-id-queue').val(id);
            $('#scientific-name-queue').val(data.scientificName);
            $('#common-name-queue').val(data.commonName);
            $('#local-name-queue').val(data.localName);
            $('#description-queue').val(data.description);
            $('#benefits-queue').val(data.benefits);
            $('#dangerous-queue').val(data.dangerous);
            $('#threats-queue').val(data.threats);
            $('#opportunities-queue').val(data.opportunities);
            $('#links-queue').val(data.links);
            $('#food-name-queue').val(data.foodName);
            $('#food-description-queue').val(data.foodDescription);
            $('#population-queue').val(data.population);
            $("#family-ddl-queue option[value='" + data.familyId + "']").attr("selected", "selected");
            $("#subfamily-ddl-queue option[value='" + data.subFamily.subFamilyId + "']").attr("selected", "selected");
            $("#habitat-ddl-queue option[value='" + data.habitat.habitatId + "']").attr("selected", "selected");
            $("#world-ddl-queue option[value='" + data.world.worldId + "']").attr("selected", "selected");
            $("input[name=organism-indigenous][value='" + data.indigenous + "']").attr('checked', 'checked');
            $("input[name=organism-cultivated][value='" + data.cultivated + "']").attr('checked', 'checked');
            $("input[name=organism-endangered][value='" + data.endangered + "']").attr('checked', 'checked');
            $("input[name=organism-medicinal][value='" + data.medicinal + "']").attr('checked', 'checked');
            data.habitat.forEach(function (habitat) {
                $('#habitat-ddl-queue option[value=' + habitat.habitatId + ']').prop('selected', true);
            });
            data.geolocations.forEach(function (geolocation) {
                $('#geolocation-ddl-queue option[value=' + geolocation.geolocationId + ']').prop('selected', true);
            });
            data.season.forEach(function (season) {
                $('#season-ddl- option[value=' + season.seasonId + ']').prop('selected', true);
            });
            $(".chosen-select").trigger("chosen:updated");
        });
    });

    // update select-organism-button/published publish.jsp - published tab
    $(document).on('click', 'table #update-published-organism-btn', function () {
        document.getElementById('update-published-organism').style.display = 'block';
        document.getElementById('fade').style.display = 'block';
        var id = ($(this).attr("value"));
        $.ajax({
            url: 'SelectOneOrganismById?id=' + id,
            type: 'GET',
            dataType: 'JSON',
            cache: false,
            async: true
        }).done(function (data) {
            console.log(data);
            $('#organism-id-published').val(id);
            $('#scientific-name-published').val(data.scientificName);
            $('#common-name-published').val(data.commonName);
            $('#local-name-published').val(data.localName);
            $('#description-published').val(data.description);
            $('#benefits-published').val(data.benefits);
            $('#dangerous-published').val(data.dangerous);
            $('#threats-published').val(data.threats);
            $('#opportunities-published').val(data.opportunities);
            $('#links-published').val(data.links);
            $('#food-name-published').val(data.foodName);
            $('#food-description-published').val(data.foodDescription);
            $('#population-published').val(data.population);
            $("#family-ddl-published option[value='" + data.family.familyId + "']").attr("selected", "selected");
            $("#subfamily-ddl-published option[value='" + data.subFamily.subFamilyId + "']").attr("selected", "selected");
            $("#world-ddl-published option[value='" + data.world.worldId + "']").attr("selected", "selected");
            $("input[name=organism-indigenous][value='" + data.indigenous + "']").attr('checked', 'checked');
            $("input[name=organism-cultivated][value='" + data.cultivated + "']").attr('checked', 'checked');
            $("input[name=organism-endangered][value='" + data.endangered + "']").attr('checked', 'checked');
            $("input[name=organism-medicinal][value='" + data.medicinal + "']").attr('checked', 'checked');
            data.habitat.forEach(function (habitat) {
                $('#habitat-ddl-published option[value=' + habitat.habitatId + ']').prop('selected', true);
            });
            data.geolocations.forEach(function (geolocation) {
                $('#geolocation-ddl-published option[value=' + geolocation.geolocationId + ']').prop('selected', true);
            });
            data.season.forEach(function (season) {
                $('#season-ddl-published option[value=' + season.seasonId + ']').prop('selected', true);
            });
            $(".chosen-select").trigger("chosen:updated");
        });
    });

    // update select-pending-button dashboard.jsp - pending tab
    $(document).on('click', 'table #update-pending-organism-btn', function () {
        document.getElementById('update-pending-organism').style.display = 'block';
        document.getElementById('fade').style.display = 'block';
        var id = ($(this).attr("value"));
        $.ajax({
            url: 'SelectOneOrganismById?id=' + id,
            type: 'GET',
            dataType: 'JSON',
            cache: false,
            async: true
        }).done(function (data) {
            console.log(data);
            $('#organism-id-pending').val(id);
            $('#scientific-name-pending').val(data.scientificName);
            $('#common-name-pending').val(data.commonName);
            $('#local-name-pending').val(data.localName);
            $('#description-pending').val(data.description);
            $('#benefits-pending').val(data.benefits);
            $('#dangerous-pending').val(data.dangerous);
            $('#threats-pending').val(data.threats);
            $('#opportunities-pending').val(data.opportunities);
            $('#links-pending').val(data.links);
            $('#food-name-pending').val(data.foodName);
            $('#food-description-pending').val(data.foodDescription);
            $('#population-pending').val(data.population);
            $("#family-ddl-pending option[value='" + data.family.familyId + "']").attr("selected", "selected");
            $("#subfamily-ddl-pending option[value='" + data.subFamily.subFamilyId + "']").attr("selected", "selected");
            $("#habitat-ddl-pending option[value='" + data.habitat.habitatId + "']").attr("selected", "selected");
            $("#world-ddl-pending option[value='" + data.world.worldId + "']").attr("selected", "selected");
            $("input[name=organism-indigenous][value='" + data.indigenous + "']").attr('checked', 'checked');
            $("input[name=organism-cultivated][value='" + data.cultivated + "']").attr('checked', 'checked');
            $("input[name=organism-endangered][value='" + data.endangered + "']").attr('checked', 'checked');
            $("input[name=organism-medicinal][value='" + data.medicinal + "']").attr('checked', 'checked');
            data.habitat.forEach(function (habitat) {
                $('#habitat-ddl-pending option[value=' + habitat.habitatId + ']').prop('selected', true);
            });
            data.geolocations.forEach(function (geolocation) {
                $('#geolocation-ddl-pending option[value=' + geolocation.geolocationId + ']').prop('selected', true);
            });
            data.season.forEach(function (season) {
                $('#season-ddl-pending option[value=' + season.seasonId + ']').prop('selected', true);
            });
            $(".chosen-select").trigger("chosen:updated");
            loadPhoto();

        });
    });

// update queue-publish-button published.jsp - queue tab
    $(document).on('click', 'table #queue-publish-btn', function () {
        var id = ($(this).attr("value"));
        $.ajax({
            url: 'QueueAddToPublished?id=' + id,
            type: 'POST',
            dataType: 'JSON',
            cache: false,
            async: true
        }).done(function () {
            loadOrganisms();
            loadPublishedOrganisms();
            loadToValidateOrganisms();
            loadPendingOrganisms();
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
            loadPendingOrganisms();
            loadPublishedOrganisms();
            loadToValidateOrganisms();
        });
    });

// functie voor delete organism/published btn in published.jsp
    $(document).on('click', '.table #delete-organism-published-btn', function () {

        var id = ($(this).attr("value"));
        $.ajax({
            url: 'DeleteOrganism?id=' + id,
            type: 'POST',
            dataType: 'text',
            cache: false,
            async: true
        }).done(function () {
            loadOrganisms();
            loadPendingOrganisms();
            loadPublishedOrganisms();
            loadToValidateOrganisms();
        });
    });

// functie voor delete organism/queue btn in published.jsp
    $(document).on('click', '.table #delete-organism-tovalidate-btn', function () {

        var id = ($(this).attr("value"));
        $.ajax({
            url: 'DeleteOrganism?id=' + id,
            type: 'POST',
            dataType: 'text',
            cache: false,
            async: true
        }).done(function () {
            loadPendingOrganisms();
            loadToValidateOrganisms();
        });
    });
});