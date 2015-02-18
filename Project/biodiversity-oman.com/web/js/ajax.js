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
    
    $('#delete-user-form').submit(function (e) {
        
        $.ajax({
            url: 'DeleteUserAccount',
            type: 'POST',
            dataType: 'text',
            cache: false,
            async: true,
            data: $('#delete-user-form').serialize(),
            complete: function (data) {

            },
            error: function (error) {
                console.log(error);
            }
        }).done(function () {
            loadUsers();
        });
        
        e.preventDefault();
    });
    
    $('.no-button').click(function() {
            alert($(this).attr("value"));
    });
    
     $('.no-button').on('click', function(){
            alert('triggered');
      });    

});


