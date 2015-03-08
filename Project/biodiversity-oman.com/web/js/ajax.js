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
    $(document).on('click', '.close-button', function () {
        $('.pop-up, .pop-up-scroll').hide();
        document.getElementById('fade').style.display = 'none';
    });

//functie voor de zoekbalk in breed dashboard
    $('#search-subfamily').keyup(function (e) {

        var $table = $('#subfamilies-table');
        var keyword = $(this).val();
        if (keyword.length >= 3) {
            $.ajax({
                url: 'SearchSubFamily',
                type: 'GET',
                dataType: 'json',
                cache: false,
                async: true,
                data: 'subfamilykey=' + keyword
            }).done(function (data) {
                $table.html('');
                $table.append('<tr>\n\
                                    <th>Name</th>\n\
                                    <th>Description</th>\n\
                                    <th>Family</th>\n\
                                    <th></th>\n\
				    </tr>');
                if (data.length === 0) {
                    $table.append('<tr><td>Breed not found</td></tr>');
                }
                ;
                data.forEach(function (subfamily) {
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
        } else {
            loadSubFamilies();
        }
        ;
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
                data: 'keyword=' + keyword
            }).done(function (data) {
                $('#users-table').html('');
                $userstable.append('<tr>\n\
                                    <th>Username</th>\n\
                                    <th>Firstname</th>\n\
                                    <th>Lastname</th>\n\
                                    <th>City</th>\n\
                                    <th>Country</th>\n\
                                    <th>Email</th>\n\
                                    <th>Phone</th>\n\
                                    <th>Admin</th>\n\
                                    <th></th>\n\
				    </tr>');
                if (data.length === 0) {
                    $userstable.append('<tr><td>User not found</td></tr>');
                }
                ;
                data.forEach(function (user) {
                    $userstable.append('<tr>\n\
					    <td>' + user.userName + '</td>\n\
					    <td>' + user.firstName + '</td>\n\
					    <td>' + user.lastName + '</td>\n\
					    <td>' + user.city + '</td>\n\
					    <td>' + user.country + '</td>\n\
					    <td>' + user.email + '</td>\n\
					    <td>' + user.phone + '</td>\n\
					    <td>' + user.isAdmin + '</td>\n\
					    <td>\n\
                                            <button class="no-button" id="delete-user-btn" type="submit" value="' + user.userName + '"><span class="icon-cross"></span></button><button class="no-button" id="make-admin-btn" type="submit" value="' + user.userName + '"><span class="icon-plus"></span></button></span></button>\n\
                                            <button class="no-button" id="make-normal-btn" type="submit" value="' + user.userName + '"><span class="icon-minus"></span></button>\n\
                                            </td>\n\
					    </tr>');
                });
            });
        } else {
            loadUsers();
        }
        ;
    });

    //functie voor de zoekbalk in organism dashboard
    $('#search-organism').keyup(function (e) {

        var $table = $('#organisms-table');
        var keyword = $(this).val();
        if (keyword.length >= 3) {
            $.ajax({
                url: 'SearchOrganism',
                type: 'GET',
                dataType: 'json',
                cache: false,
                async: true,
                data: 'organismkey=' + keyword
            }).done(function (data) {
                $table.html('');
                $table.append('<tr>\n\
                                    <th>Common name</th>\n\
                                    <th>Scientific name</th>\n\
                                    <th>Inserted on</th>\n\
                                    <th>Last updated on</th>\n\\n\
                                    <th></th>\n\
				    </tr>');
                if (data.length === 0) {
                    $table.append('<tr><td>Organism not found</td></tr>');
                }
                ;
                data.forEach(function (organism) {
                    $table.append('<tr>\n\
					    <td>' + organism.commonName + '</td>\n\
					    <td>' + organism.scientificName + '</td>\n\
                                            <td>' + organism.insertedOn + '</td>\n\
					    <td>' + organism.updatedOn + '</td>\n\
                                            <td><button class="no-button-user" id="detail-organism-btn" type="submit" value="' + organism.organismId + '"><span class="icon-search"></span></button></td>\n\
					    </tr>');
                });
            });
        } else {
            loadOrganisms();
        }
        ;
    });

    //functie voor de zoekbalk in organism in published
    $('#search-organism-published').keyup(function (e) {

        var $table = $('#published-table');
        var keyword = $(this).val();
        if (keyword.length >= 3) {
            $.ajax({
                url: 'SearchOrganism',
                type: 'GET',
                dataType: 'json',
                cache: false,
                async: true,
                data: 'organismkey=' + keyword
            }).done(function (data) {
                $('#published-table').html('');
                $table.append('<tr>\n\
                                    <th>Common oooo name</th>\n\
                                    <th>Scientific name</th>\n\
                                    <th>Inserted on</th>\n\
                                    <th>Last updated on</th>\n\\n\
                                    <th></th>\n\
				    </tr>');
                if (data.length === 0) {
                    $table.append('<tr><td>Organism not found</td></tr>');
                }
                ;
                data.forEach(function (organism) {
                    $table.append('<tr>\n\
					    <td>' + organism.commonName + '</td>\n\
					    <td>' + organism.scientificName + '</td>\n\
                                            <td>' + organism.insertedOn + '</td>\n\
					    <td>' + organism.updatedOn + '</td>\n\\n\
                                            <td>\n\
                                            <button class="no-button" id="update-published-organism-btn" type="submit" value="' + organism.organismId + '"><span class="icon-pencil2"></span></button>\n\
                                            <button class="no-button" id="delete-organism-published-btn" type="submit" value="' + organism.organismId + '"><span class="icon-cross"></span></button>\n\
                                            </td>\n\
					    </tr>');
                });
            });
        } else {
            loadPublishedOrganisms();
        }
        ;
    });

    //functie voor de zoekbalk in queue published
    $('#search-organism-pending').keyup(function (e) {

        var $table = $('#tovalidate-table');
        var keyword = $(this).val();
        if (keyword.length >= 3) {
            $.ajax({
                url: 'SearchOrganismPending',
                type: 'GET',
                dataType: 'json',
                cache: false,
                async: true,
                data: 'organismkeypending=' + keyword
            }).done(function (data) {
                $('#tovalidate-table').html('');
                $table.append('<tr>\n\
                                    <th>Common name</th>\n\
                                    <th>Scientific name</th>\n\
                                    <th>Submitted on</th>\n\
                                    <th>Updated on</th>\n\
                                    <th></th>\n\
                                </tr>');
                if (data.length === 0) {
                    $table.append('<tr><td>Organism not found</td></tr>');
                }
                ;
                data.forEach(function (organism) {
                    $table.append('<tr>\n\
					<td>' + organism.commonName + '</td>\n\\n\
                           <td>' + organism.scientificName + '</td>\n\
                           <td>' + organism.insertedOn + '</td>\n\
                           <td>' + organism.updatedOn + '</td>\n\
                           <td>\n\
                           <button class="no-button" id="queue-publish-btn" type="submit" value="' + organism.organismId + '"><span class="icon-plus"></span></button></span></button>\n\
                           <button class="no-button" id="update-queue-organism-btn" type="submit" value="' + organism.organismId + '"><span class="icon-pencil2"></span>\n\
                           <button class="no-button" id="delete-organism-tovalidate-btn" type="submit" value="' + organism.organismId + '"><span class="icon-cross"></span></button>\n\
                           </td>\
                           </tr>');
                });
            });
        } else {
            loadToValidateOrganisms();
        }
        ;
    });

    //functie voor de zoekbalk in pending dashboard
    $('#search-organism-pending').keyup(function (e) {

        var $table = $('#pending-table');
        var keyword = $(this).val();
        if (keyword.length >= 3) {
            $.ajax({
                url: 'SearchOrganismPending',
                type: 'GET',
                dataType: 'json',
                cache: false,
                async: true,
                data: 'organismkeypending=' + keyword
            }).done(function (data) {
                $('#pending-table').html('');
                $table.append('<tr>\n\
                                    <th>Common name</th>\n\
                                    <th>Scientific name</th>\n\
                                    <th>Submitted on</th>\n\
                                    <th></th>\n\
                                </tr>');
                if (data.length === 0) {
                    $table.append('<tr><td>Organism not found</td></tr>');
                }
                ;
                data.forEach(function (organism) {
                    $table.append('<tr>\n\
					<td>' + organism.commonName + '</td>\n\
                                        <td>' + organism.scientificName + '</td>\n\
                                        <td>' + organism.insertedOn + '</td>\n\
                                        <td>\n\
                                        <button class="no-button-user" id="update-pending-organism-btn" type="submit" value="' + organism.organismId + '"><span class="icon-pencil2"></span>\n\
                                        </td>\n\
                                       </tr>');
                });
            });
        } else {
            loadPendingOrganisms();
        }
        ;
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
            }
        }).done(function (data) {
            if (data === 'succes') {
                $message.append('<div class="alert alert-success" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Password succesfully changed. This screen closes automatically</div>');
            } else if (data === 'incorrect') {
                $message.append('<div class="alert alert-danger" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Your password is not valid</div>');
            } else if (data === 'sql') {
                $message.append('<div class="alert alert-danger" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Service unavailable!</div>');
            }
            setTimeout(function () {
                $message.fadeOut('slow');
                $('.whitebox').hide();
                document.getElementById('fade').style.display = 'none';
                $message.empty();
            }, 2800);
        }).always(function () {
            loadUserInfo();
            disableInput();
            wijzigbtn.val('Wijzig').removeAttr('disabled');
        });
        e.preventDefault();
    });

    // functie voor delete user in list users tabel in usermanagement.jsp
    $(document).on('click', '.table #delete-user-btn', function () {
        var username = ($(this).attr("value"));
        bootbox.confirm("<center>Delete this user?", function (result) {
            if (result === true) {
                $.ajax({
                    url: 'DeleteUserAccount?username=' + username,
                    type: 'POST',
                    dataType: 'text',
                    cache: false,
                    async: true
                }).done(function () {
                    loadUsers();
                });
            }
        });
    });

    // functie voor demoten van een user in usermanagement.jsp
    $(document).on('click', '.table #make-normal-btn', function () {
        var username = ($(this).attr("value"));
        bootbox.confirm("Demote this admin to a normal user?", function (result) {
            if (result === true) {
                $.ajax({
                    url: 'SetNormalUser?username=' + username,
                    type: 'POST',
                    dataType: 'text',
                    cache: false,
                    async: true
                }).done(function () {
                    loadUsers();
                });
            }
        });
    });

    // functie voor make admin in list users tabel in usermanagement.jsp
    $(document).on('click', '.table #make-admin-btn', function () {
        var username = ($(this).attr("value"));
        bootbox.confirm("Make this user an admin?", function (result) {
            if (result === true) {
                $.ajax({
                    url: 'SetSuperUser?username=' + username,
                    type: 'POST',
                    dataType: 'text',
                    cache: false,
                    async: true
                }).done(function () {
                    loadUsers();
                });
            }
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
            data: $('#create-user-form').serialize()
        }).done(function (data) {
            if (data === 'succes') {
                $message.append('<div class="alert alert-success" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>User succesfully created</div>');
            } else if (data === 'exists') {
                $message.append('<div class="alert alert-danger" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Username already exists</div>');
            } else if (data === 'sql') {
                $message.append('<div class="alert alert-danger" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Service unavailable!</div>');
            }
            setTimeout(function () {
                $message.fadeOut('slow');
                $message.empty();
            }, 2800);
            $("#create-user-form")[0].reset();
        }).always(function () {
            loadUsers();
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
            data: $('#create-season-form').serialize()
        }).done(function (data) {
            if (data === 'succes') {
                $message.append('<div class="alert alert-success" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Season succesfully created.</div>');
            } else if (data === 'exists') {
                $message.append('<div class="alert alert-danger" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Season name already exists</div>');
            } else if (data === 'sql') {
                $message.append('<div class="alert alert-danger" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Service unavailable!</div>');
            }
            setTimeout(function () {
                $message.fadeOut('slow');
                $message.empty();
            }, 2800);
            $("#create-season-form")[0].reset();
        }).always(function () {
            loadSeasons();
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
            data: $('#create-habitat-form').serialize()
        }).done(function (data) {
            if (data === 'succes') {
                $message.append('<div class="alert alert-success" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Habitat succesfully created.</div>');
            } else if (data === 'exists') {
                $message.append('<div class="alert alert-danger" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Habitat name already exists</div>');
            } else if (data === 'sql') {
                $message.append('<div class="alert alert-danger" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Service unavailable!</div>');
            }
            setTimeout(function () {
                $message.fadeOut('slow');
                $message.empty();
            }, 2800);
            $("#create-habitat-form")[0].reset();
        }).always(function () {
            loadHabitats();
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
            data: $('#create-world-form').serialize()
        }).done(function (data) {
            console.log(data);
            if (data === 'succes') {
                $message.append('<div class="alert alert-success" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>World succesfully created.</div>');
            } else if (data === 'exists') {
                $message.append('<div class="alert alert-danger" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>World name already exists</div>');
            } else if (data === 'sql') {
                $message.append('<div class="alert alert-danger" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Service unavailable!</div>');
            }
            -setTimeout(function () {
                $message.fadeOut('slow');
                $message.empty();
            }, 2800);
            $("#create-world-form")[0].reset();
        }).always(function () {
            loadWorlds();
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
            data: $('#create-family-form').serialize()
        }).done(function (data) {
            console.log(data);
            if (data === 'succes') {
                $message.append('<div class="alert alert-success" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Family succesfully created.</div>');
            } else if (data === 'exists') {
                $message.append('<div class="alert alert-danger" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Family name already exist!</div>');
            } else if (data === 'sql') {
                $message.append('<div class="alert alert-danger" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Service unavailable!</div>');
            }
            setTimeout(function () {
                $message.fadeOut('slow');
                $message.empty();
            }, 2800);
            $("#create-family-form")[0].reset();
        }).always(function () {
            loadFamilies();
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
            data: $('#create-subfamily-form').serialize()
        }).done(function (data) {
            if (data === 'succes') {
                $message.append('<div class="alert alert-success" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Breed was succesfully created.</div>');
            } else if (data === 'exists') {
                $message.append('<div class="alert alert-danger" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Breed name already exist!</div>');
            } else if (data === 'sql') {
                $message.append('<div class="alert alert-danger" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Service unavailable!</div>');
            }
            setTimeout(function () {
                $message.fadeOut('slow');
                $message.empty();
            }, 2800);
            $("#create-subfamily-form")[0].reset();
        }).always(function () {
            loadSubFamilies();
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
            data: $('#create-geolocation-form').serialize()
        }).done(function (data) {
            if (data === 'succes') {
                $message.append('<div class="alert alert-success" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Area was succesfully created.</div>');
            } else if (data === 'exists') {
                $message.append('<div class="alert alert-danger" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Area name already exist!</div>');
            } else if (data === 'sql') {
                $message.append('<div class="alert alert-danger" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Service unavailable!</div>');
            }
            setTimeout(function () {
                $message.fadeOut('slow');
                $message.empty();
            }, 2800);
            $("#create-geolocation-form")[0].reset();
        }).always(function () {
            loadGeolocations();
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
            data: formData
        }).done(function (data) {
            if (data === 'succes') {
                $message.append('<div class="alert alert-success" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Organism was added successfully.</div>');
            } else if (data === 'exists') {
                $message.append('<div class="alert alert-danger" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Scientific name allready exists.</div>');
            } else if (data === 'sql') {
                $message.append('<div class="alert alert-danger" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Service unavailable!</div>');
            }
            setTimeout(function () {
                $message.fadeOut('slow');
                $message.empty();
            }, 2800);
            $("#create-organism-form")[0].reset();
        }).always(function () {
            loadOrganisms();
            loadToValidateOrganisms();
            loadPendingOrganisms();
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
            }
        }).done(function (data) {
            if (data === 'succes') {
                $message.append('<div class="alert alert-success" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Info updated succesfully.</div>');
            } else if (data === 'sql') {
                $message.append('<div class="alert alert-danger" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Service unavailable!</div>');
            }
            setTimeout(function () {
                $message.fadeOut('slow');
                $message.empty();
            }, 2800);
        }).always(function () {
            loadUserInfo();
            disableInput();
            updatebtn.val('edit').removeAttr('disabled');
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
            data: $('#update-world-form').serialize()
        }).done(function (data) {
            if (data === 'succes') {
                $message.append('<div class="alert alert-success" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>World was updated successfully. This screen closes automatically</div>');
            } else if (data === 'sql') {
                $message.append('<div class="alert alert-danger" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Service unavailable!</div>');
            }
            setTimeout(function () {
                $message.fadeOut('slow');
                $('.pop-up').hide();
                document.getElementById('fade').style.display = 'none';
                $("#update-world-form")[0].reset();
                $message.empty();
            }, 2800);
        }).always(function () {
            loadWorlds();
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
            data: $('#update-habitat-form').serialize()
        }).done(function (data) {
            if (data === 'succes') {
                $message.append('<div class="alert alert-success" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Habitat was updated successfully. This screen closes automatically</div>');
            } else if (data === 'sql') {
                $message.append('<div class="alert alert-danger" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Service unavailable!</div>');
            }
            setTimeout(function () {
                $message.fadeOut('slow');
                $('.pop-up').hide();
                document.getElementById('fade').style.display = 'none';
                $("#update-habitat-form")[0].reset();
                $message.empty();
            }, 2800);
        }).always(function () {
            loadHabitats();
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
            data: $('#update-family-form').serialize()
        }).done(function (data) {
            if (data === 'succes') {
                $message.append('<div class="alert alert-success" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Family was successfully updated. This screen closes automatically</div>');
            } else if (data === 'sql') {
                $message.append('<div class="alert alert-danger" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Service unavailable!</div>');
            }
            setTimeout(function () {
                $message.fadeOut('slow');
                $('.pop-up').hide();
                document.getElementById('fade').style.display = 'none';
                $("#update-family-form")[0].reset();
                $message.empty();
            }, 2800);
        }).always(function () {
            loadFamilies();
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
            data: $('#update-subfamily-form').serialize()
        }).done(function (data) {
            if (data === 'succes') {
                $message.append('<div class="alert alert-success" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Subfamily was successfully updated. This screen closes automatically</div>');
            } else if (data === 'sql') {
                $message.append('<div class="alert alert-danger" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Service unavailable!/div>');
            }
            setTimeout(function () {
                $message.fadeOut('slow');
                $('.pop-up').hide();
                document.getElementById('fade').style.display = 'none';
                $("#update-subfamily-form")[0].reset();
                $message.empty();
            }, 2800);
        }).always(function () {
            loadSubFamilies();
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
            data: $('#update-season-form').serialize()
        })
                .done(function (data) {
                    if (data === 'succes') {
                        $message.append('<div class="alert alert-success" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Season was updated successfully. This screen closes automatically</div>');
                    } else if (data === 'sql') {
                        $message.append('<div class="alert alert-danger" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Service unavailable!</div>');
                    }
                    setTimeout(function () {
                        $message.fadeOut('slow');
                        $('.pop-up').hide();
                        document.getElementById('fade').style.display = 'none';
                        $("#update-season-form")[0].reset();
                        $message.empty();
                    }, 2800);
                })
                .always(function () {
                    loadSeasons();
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
            data: $('#update-geolocation-form').serialize()
        }).done(function (data) {
            if (data === 'succes') {
                $message.append('<div class="alert alert-success" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Area was successfully updated. This screen closes automatically</div>');
            } else if (data === 'sql') {
                $message.append('<div class="alert alert-danger" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Service unavailable!</div>');
            }
            setTimeout(function () {
                $message.fadeOut('slow');
                $('.pop-up').hide();
                document.getElementById('fade').style.display = 'none';
                $("#update-geolocation-form")[0].reset();
                $message.empty();
            }, 2800);
        }).always(function () {
            loadGeolocations();
        });
        e.preventDefault();
    });

    // function for update of Organism/published in publish.jsp
    $('#update-published-organism-form').submit(function (e) {

        var $message = $('#update-published-organism-message');
        $message.show();
        var formData = new FormData($(this)[0]);
        $.ajax({
            url: 'UpdateOrganism',
            dataType: 'text',
            processData: false,
            contentType: false,
            type: 'POST',
            data: formData
        }).done(function (data) {
            if (data === 'succes') {
                $message.append('<div class="alert alert-success" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>The organism was validated and updated successfully. This screen closes automatically</div>');
            } else if (data === 'exists') {
                $message.append('<div class="alert alert-danger" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Scientific name allready exists.</div>');
            } else if (data === 'sql') {
                $message.append('<div class="alert alert-danger" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Service unavailable!</div>');
            }
            setTimeout(function () {
                $message.fadeOut('slow');
                $('.pop-up-scroll').hide();
                document.getElementById('fade').style.display = 'none';
                $("#update-published-organism-form")[0].reset();
                $message.empty();
            }, 2800);
        }).always(function () {
            loadOrganisms();
            loadPublishedOrganisms();
            loadToValidateOrganisms();
            loadPendingOrganisms();
        });
        e.preventDefault();
    });

    // function for update of Organism/pending. in dashboard.jsp
    $('#update-pending-organism-form').submit(function (e) {

        var $message = $('#update-pending-organism-message');
        $message.show();
        var formData = new FormData($(this)[0]);
        $.ajax({
            url: 'UpdatePending',
            dataType: 'text',
            processData: false,
            contentType: false,
            type: 'POST',
            data: formData
        }).done(function (data) {
            if (data === 'succes') {
                $message.append('<div class="alert alert-success" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>The organism updated successfully. This screen closes automatically</div>');
            } else if (data === 'exists') {
                $message.append('<div class="alert alert-danger" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Scientific name allready exists.</div>');
            } else if (data === 'sql') {
                $message.append('<div class="alert alert-danger" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Service unavailable!</div>');
            }
            setTimeout(function () {
                $message.fadeOut('slow');
                $('.pop-up-scroll').hide();
                document.getElementById('fade').style.display = 'none';
                $("#update-pending-organism-form")[0].reset();
                $message.empty();
            }, 2800);
        }).always(function () {
            loadOrganisms();
            loadPublishedOrganisms();
            loadToValidateOrganisms();
            loadPendingOrganisms();
        });
        e.preventDefault();
    });

    // function for update of Organism/queue. in publish.jsp
    $('#update-queue-organism-form').submit(function (e) {

        var $message = $('#update-queue-organism-message');
        $message.show();
        var formData = new FormData($(this)[0]);
        $.ajax({
            url: 'UpdateOrganism',
            dataType: 'text',
            processData: false,
            contentType: false,
            type: 'POST',
            data: formData
        }).done(function (data) {
            if (data === 'succes') {
                $message.append('<div class="alert alert-success" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>The organism updated successfully. This screen closes automatically</div>');
            } else if (data === 'exists') {
                $message.append('<div class="alert alert-danger" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Scientific name allready exists.</div>');
            } else if (data === 'sql') {
                $message.append('<div class="alert alert-danger" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Service not unavailable!</div>');
            }
            setTimeout(function () {
                $message.fadeOut('slow');
                $('.pop-up-scroll').hide();
                document.getElementById('fade').style.display = 'none';
                $("#update-queue-organism-form")[0].reset();
                $message.empty();
            }, 2800);
        }).always(function () {
            loadOrganisms();
            loadPublishedOrganisms();
            loadToValidateOrganisms();
            loadPendingOrganisms();
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
            $('#organism-id-queue').val(id);
            $('#img-queue').html('<img class="img-responsive img-thumbnail" src="SelectPhotoById?id=' + id + '" height="100px" width="100px">');
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
            $("#family-ddl-queue option[value='" + data.family.familyId + "']").attr("selected", "selected");
            $("#subfamily-ddl-queue option[value='" + data.subFamily.subFamilyId + "']").attr("selected", "selected");
            $("#habitat-ddl-queue option[value='" + data.habitat.habitatId + "']").attr("selected", "selected");
            $("#world-ddl-queue option[value='" + data.world.worldId + "']").attr("selected", "selected");
            $("input[name=organism-indigenous][value='" + data.indigenous + "']").attr('checked', 'checked');
            $("input[name=organism-cultivated][value='" + data.cultivated + "']").attr('checked', 'checked');
            $("input[name=organism-endangered][value='" + data.endangered + "']").attr('checked', 'checked');
            $("input[name=organism-medicinal][value='" + data.medicinal + "']").attr('checked', 'checked');
            data.eatenByOrganism.forEach(function (organism) {
                $('#eatenby-ddl-queue option[value=' + organism.organismId + ']').prop('selected', true);
            });
            data.eatingOrganisms.forEach(function (organism) {
                $('#geteatenby-ddl-queue option[value=' + organism.organismId + ']').prop('selected', true);
            });
            data.habitat.forEach(function (habitat) {
                $('#habitat-ddl-queue option[value=' + habitat.habitatId + ']').prop('selected', true);
            });
            data.geolocations.forEach(function (geolocation) {
                $('#geolocation-ddl-queue option[value=' + geolocation.geolocationId + ']').prop('selected', true);
            });
            data.season.forEach(function (season) {
                $('#season-ddl-queue option[value=' + season.seasonId + ']').prop('selected', true);
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
            $('#organism-id-published').val(id);
            $('#img-published').html('<img class="img-responsive img-thumbnail" src="SelectPhotoById?id=' + id + '" height="100px" width="100px">');
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
            data.eatenByOrganism.forEach(function (organism) {
                $('#eatenby-ddl-published option[value=' + organism.organismId + ']').prop('selected', true);
            });
            data.eatingOrganisms.forEach(function (organism) {
                $('#geteatenby-ddl-published option[value=' + organism.organismId + ']').prop('selected', true);
            });
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
            $('#organism-id-pending').val(id);
            $('#img-pending').html('<img class="img-responsive img-thumbnail" src="SelectPhotoById?id=' + id + '" height="100px" width="100px">');
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
            data.eatenByOrganism.forEach(function (organism) {
                $('#eatenby-ddl-pending option[value=' + organism.organismId + ']').prop('selected', true);
            });
            data.eatingOrganisms.forEach(function (organism) {
                console.log(organism.organismId);
                $('#geteatenby-ddl-pending option[value=' + organism.organismId + ']').prop('selected', true);
            });
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
        });
    });

    // select detail from organism
    $(document).on('click', 'table #detail-organism-btn', function () {
        document.getElementById('detail-organism').style.display = 'block';
        document.getElementById('fade').style.display = 'block';

        var id = ($(this).attr("value"));
        $.ajax({
            url: 'SelectOneOrganismById?id=' + id,
            type: 'GET',
            dataType: 'JSON',
            cache: false,
            async: true,
            beforesend: function () {
                $('#detail-organism').html('');
            }
        }).done(function (data) {
            $('#img-detail').html('<img class="img-responsive img-thumbnail" src="SelectPhotoById?id=' + id + '" height="200px" width="200px">');
            $('#scientific-name-detail').html(data.scientificName);
            $('#common-name-detail').html(data.commonName);
            $('#local-name-detail').html(data.localName);
            $('#description-detail').html(data.description);
            $('#benefits-detail').html(data.benefits);
            $('#dangerous-detail').html(data.dangerous);
            $('#threats-detail').html(data.threats);
            $('#opportunities-detail').html(data.opportunities);
            $('#links-detail').html(data.links);
            $('#food-name-detail').html(data.foodName);
            $('#food-description-detail').html(data.foodDescription);
            $('#population-detail').html(data.population);
            $("#family-detail").html(data.family.familyName);
            $("#subfamily-detail").html(data.subFamily.subFamilyName);
            $("#world-detail").html(data.world.worldName);

            if (data.indigenous === true) {
                $("#indigenous-detail").html('Yes');
            } else {
                $("#indigenous-detail").html('No');
            }
            if (data.cultivated === true) {
                $("#cultivated-detail").html('Yes');
            } else {
                $("#cultivated-detail").html('No');
            }
            if (data.endangered === true) {
                $("#endangered-detail").html('Yes');
            } else {
                $("#endangered-detail").html('No');
            }
            if (data.medicinal === true) {
                $("#medicinal-detail").html('Yes');
            } else {
                $("#medicinal-detail").html('No');
            }
            data.habitat.forEach(function (habitat) {
                $('#habitat-detail').html(habitat.habitatName + ', ');
            });
            data.geolocations.forEach(function (geolocation) {
                $('#geolocation-detail').html(geolocation.areaName + ', ');
            });
            data.season.forEach(function (season) {
                $('#season-detail').html(season.seasonName + ', ');
            });
            data.eatenByOrganism.forEach(function (organism) {
                $('#eatenby-detail').html(organism.commonName + ', ');
            });
            data.eatingOrganisms.forEach(function (organism) {
                $('#eats-detail').html(organism.commonName + ', ');
            });
        });

    });

    // update queue-publish-button published.jsp - queue tab
    $(document).on('click', 'table #queue-publish-btn', function () {
        var id = ($(this).attr("value"));
        $.ajax({
            url: 'QueueAddToPublished?id=' + id,
            type: 'POST',
            dataType: 'text',
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

    // functie voor delete world btn in dashboard.jsp
    $(document).on('click', '.table #delete-world-btn', function () {
        var id = ($(this).attr("value"));
        bootbox.confirm("<center>This will delete all references to this world in families & linked organisms. <br><br> <b>Are you sure?</b></center>", function (result) {
            if (result === true) {
                $.ajax({
                    url: 'DeleteWorld?id=' + id,
                    type: 'POST',
                    dataType: 'text',
                    cache: false,
                    async: true
                }).done(function () {
                    loadWorlds();
                    loadFamilies();
                });
            }
        });
    });


    // functie voor delete season btn in dashboard.jsp
    $(document).on('click', '.table #delete-season-btn', function () {
        var id = ($(this).attr("value"));
        bootbox.confirm("<center>This will delete all references to this season in linked organisms.<br><br> <b>Are you sure?</b></center>", function (result) {
            if (result === true) {
                $.ajax({
                    url: 'DeleteSeason?id=' + id,
                    type: 'POST',
                    dataType: 'text',
                    cache: false,
                    async: true
                }).done(function () {
                    loadSeasons();
                });
            }
        });
    });

    // functie voor delete family btn in dashboard.jsp
    $(document).on('click', '.table #delete-family-btn', function () {
        var id = ($(this).attr("value"));
        bootbox.confirm("<center>This will delete all references to this family in breeds & linked organisms.<br><br> <b>Are you sure?</b></center>", function (result) {
            if (result === true) {
                $.ajax({
                    url: 'DeleteFamily?id=' + id,
                    type: 'POST',
                    dataType: 'text',
                    cache: false,
                    async: true
                }).done(function () {
                    loadFamilies();
                    loadSubFamilies();
                });
            }
        });
    });
    // functie voor delete habitat btn in dashboard.jsp
    $(document).on('click', '.table #delete-habitat-btn', function () {
        var id = ($(this).attr("value"));
        bootbox.confirm("<center>This will delete all references to this habitat in linked organisms.<br><br> <b>Are you sure?</b></center>", function (result) {
            if (result === true) {
                $.ajax({
                    url: 'DeleteHabitat?id=' + id,
                    type: 'POST',
                    dataType: 'text',
                    cache: false,
                    async: true
                }).done(function () {
                    loadHabitats();
                });
            }
        });
    });

    // functie voor delete subfamily btn in dashboard.jsp
    $(document).on('click', '.table #delete-subfamily-btn', function () {
        var id = ($(this).attr("value"));
        bootbox.confirm("<center>This will delete all references to this breed in linked organisms.<br><br> <b>Are you sure?</b></center>", function (result) {
            if (result === true) {
                $.ajax({
                    url: 'DeleteSubFamily?id=' + id,
                    type: 'POST',
                    dataType: 'text',
                    cache: false,
                    async: true
                }).done(function () {
                    loadSubFamilies();
                });
            }
        });
    });

    // functie voor delete geolocation btn in dashboard.jsp
    $(document).on('click', '.table #delete-geolocation-btn', function () {
        var id = ($(this).attr("value"));
        bootbox.confirm("<center>This will delete all references to this geolocation in linked organisms.<br><br> <b>Are you sure?</b></center>  ", function (result) {
            if (result === true) {
                $.ajax({
                    url: 'DeleteGeolocation?id=' + id,
                    type: 'POST',
                    dataType: 'text',
                    cache: false,
                    async: true
                }).done(function () {
                    loadGeolocations();
                });
            }
        });
    });

    // functie voor delete organism btn in dashboard.jsp
    $(document).on('click', '.table #delete-organism-btn', function () {
        var id = ($(this).attr("value"));
        bootbox.confirm("<center>This will delete the organism and remove all its references.<br><br> <b>Are you sure?</b></center>  ", function (result) {
            if (result === true) {
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
            }
        });
    });

    // functie voor delete organism/published btn in published.jsp
    $(document).on('click', '.table #delete-organism-published-btn', function () {
        var id = ($(this).attr("value"));
        bootbox.confirm("<center>This will delete the selected organisms and remove all their references.<br><br> <b>Are you sure?</b></center>  ", function (result) {
            if (result === true) {
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
                    loadToValidateOrganisms();
                });
            }
        });
    });

    // functie voor delete organism/queue btn in published.jsp
    $(document).on('click', '.table #delete-organism-tovalidate-btn', function () {
        var id = ($(this).attr("value"));
        bootbox.confirm("<center>This will delete the selected organisms and remove all their references.<br><br> <b>Are you sure?</b></center>  ", function (result) {
            if (result === true) {
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
            }
        });
    });


    // functie voor delete subscriber btn in published.jsp
    $(document).on('click', '.table #delete-subscriber-btn', function () {
        var id = ($(this).attr("value"));
        bootbox.confirm("<center>This will delete the selected subscriber.<br><br> <b>Are you sure?</b></center>", function (result) {
            if (result === true) {
                $.ajax({
                    url: 'DeleteSubscriber?id=' + id,
                    type: 'POST',
                    dataType: 'text',
                    cache: false,
                    async: true
                }).done(function () {
                    loadSubscriber();
                });
            }
        });
    });

    // functie voor delete post btn in published.jsp
    $(document).on('click', '.table #delete-post-btn', function () {
        var id = ($(this).attr("value"));
        bootbox.confirm("<center>This will delete the selected post.<br><br> <b>Are you sure?</b></center>  ", function (result) {
            if (result === true) {
                $.ajax({
                    url: 'DeletePost?id=' + id,
                    type: 'POST',
                    dataType: 'text',
                    cache: false,
                    async: true
                }).done(function () {
                    loadPosts();
                });
            }
        });
    });
});