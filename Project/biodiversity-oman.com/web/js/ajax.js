$(document).ready(function () {

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
        return false;
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
        return false;
    });

    function deleteUser() {
        $.ajax({
            url: 'DeleteUserAccount',
            type: 'POST',
            dataType: 'text',
            cache: false,
            async: true,
            data: $('#user-table-form').serialize(),
            complete: function (data) {

            },
            error: function (error) {
                console.log(error);
            }
        }).done(function () {
            loadUsers();
        });
        return false;
    }
    ;

    function setSuperUser() {

        $.ajax({
            url: 'SetSuperUser',
            type: 'POST',
            dataType: 'text',
            cache: false,
            async: true,
            data: $('#user-table-form').serialize(),
            complete: function (data) {

            },
            error: function (error) {
                console.log(error);
            }
        }).done(function () {
            loadUsers();
        });
        return false;
    }
    ;



    $('#delete-user, #make-admin').click(function (e) {
        if (this.id == 'delete-user') {
            deleteUser();
        }
        else if (this.id == 'make-admin') {
            setSuperUser();
        }
        e.preventDefault();
    });
    
//    $('#user-table-form').submit(function (e) {
//        
//        $.ajax({
//            url: 'UserManagement',
//            type: 'POST',
//            dataType: 'text',
//            cache: false,
//            async: true,
//            data: $('#user-table-form').serialize(),
//            complete: function (data) {
//
//            },
//            error: function (error) {
//                console.log(error);
//            }
//        }).done(function () {
//            loadUsers();
//        });
//        return false;
//    });

});


