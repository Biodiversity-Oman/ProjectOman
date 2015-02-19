$(document).ready(function () {

    //tab interface
    jQuery('.tabs .tab-links a').on('click', function (e) {
        var currentAttrValue = jQuery(this).attr('href');
        jQuery('.tabs ' + currentAttrValue).show().siblings().hide();
        jQuery(this).parent('li').addClass('active').siblings().removeClass('active');
        e.preventDefault();
    });

    //userinfo.jsp
    $('#update-user-form').submit(function (e) {

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
                var jsontext = data.responseText;
                $('#update-message').html(jsontext);
                e.preventDefault();
            },
            error: function (error) {
                console.log(error);
            }
        }).done(function () {
            loadUserInfo();
            disableInput();
            updatebtn.val('edit').removeAttr('disabled');
        });
        e.preventDefault();
    });

    //userinfo.jsp change password button + form
    $('#change-password-form').submit(function (e) {

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
                var jsontext = data.responseText;
                $('#password-message').html(jsontext);
                e.preventDefault();
            },
            error: function (error) {
                console.log(error);
            }
        }).done(function () {
            loadUserInfo();
            disableInput();
            wijzigbtn.val('Wijzig').removeAttr('disabled');
        });
        e.preventDefault();
    });

    // create user form usermanagement.jsp
    $('#create-user-form').submit(function (e) {

        $.ajax({
            url: 'InsertUserAccount',
            type: 'POST',
            dataType: 'text',
            data: $('#create-user-form').serialize(),
            complete: function (data) {
                var jsontext = data.responseText;
                $('#register-message').html(jsontext);
            },
            error: function (error) {
                console.log(error);
            }
        }).done(function () {
            $("#create-user-form")[0].reset();
            loadUsers();
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
            async: true,
            complete: function (data) {

            },
            error: function (error) {
                console.log(error);
            }
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
            async: true,
            complete: function (data) {

            },
            error: function (error) {
                console.log(error);
            }
        }).done(function () {
            loadUsers();
        });
    });
    
    $(document).on('click', '.table #make-normal-btn', function () {

        var username = ($(this).attr("value"));
        $.ajax({
            url: 'SetNormalUser?username=' + username,
            type: 'POST',
            dataType: 'text',
            cache: false,
            async: true,
            complete: function (data) {

            },
            error: function (error) {
                console.log(error);
            }
        }).done(function () {
            loadUsers();
        });
    });
});

//---------------------------------------------------------------------------------------------------------------------
// load functies
// hier behoren de functies die data moeten laden voor document.ready is
//---------------------------------------------------------------------------------------------------------------------

// functie om tabel te vullen met gebruikers info in de list users tab in usermanagement.jsp
function loadUsers() {

    var $userstable = $('#users-table');

    $.ajax({
        url: 'SelectAllUserAccounts',
        type: 'GET',
        dataType: 'json',
        cache: false,
        async: true,
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
}
;





