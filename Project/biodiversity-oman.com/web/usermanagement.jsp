<%-- 
    Document   : welcome
    Created on : Feb 17, 2015, 12:23:34 AM
    Author     : lennyasus
--%>
<%@include file="/adminheader.jsp" %>
<%
	if (us.getIsAdmin() == false) {
		response.sendRedirect("notallowed.jsp");
	}
%>
<!DOCTYPE html>
<html>
	<head>
		<script src="js/ajax.js"></script>
	</head>
	<script>
                jQuery(document).ready(function () {
                    jQuery('.tabs .tab-links a').on('click', function (e) {
                        var currentAttrValue = jQuery(this).attr('href');
                        // Show/Hide Tabs
                        jQuery('.tabs ' + currentAttrValue).show().siblings().hide();
                        // Change/remove current tab to active
                        jQuery(this).parent('li').addClass('active').siblings().removeClass('active');
                        e.preventDefault();
                    });
                });

                function loadUsers() {
                    var $userstable = $('#users-table');
                    var $usersinfo = $('#users-info');
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
						<th></th>\n\
						</tr>');
                            $.each(users, function (i, user) {
                                $userstable.append('<tr>\n\
						    <td>' + user.userName + '</td>\n\
						    <td>' + user.firstName + '</td>\n\
						    <td>' + user.lastName + '</td>\n\
						    <td>' + user.city + '</td>\n\
						    <td>' + user.country + '</td>\n\
						    <td>' + user.email + '</td>\n\
						    <td>' + user.phone + '</td>\n\
						    <td>' + user.isAdmin + '</td>\n\
						    <td><button class="no-button" id="delete-user-btn" type="submit" value="'+ user.userName +'"><span class="icon-cross"></span></button><button class="no-button" id="make-admin-btn" type="submit" value="'+ user.userName +'"><span class="icon-plus"></span></button></td>\n\
							</tr>');
                            });



                        }
                    }).done(function () {
                        $('#users-table').html('');
                    });
                    return false;
                }
                ;

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








	</script>
	<body onload="loadUsers()">
		<div class="wrapper">
			<div id="fade" class="black_overlay-boxed"></div>
			<div class="tabs">
				<ul class="tab-links">
					<li class="active"><a href="#tab1">List Users </a></li>
					<li><a href="#tab2">Create User</a></li>
				</ul>
				<div class="tab-content">
					<p>Press the <span class="icon-cross"></span> button to delete a user</p>
					<p>Press the <span class="icon-plus"></span> button to make a user admin</p>
					<div id="tab1" class="tab active">
						<table class="table table-striped" id="users-table">
						</table>
					</div>
					<div id="tab2" class="tab">
						<p>create user form</p>
					</div>
				</div>
			</div>
		</div>
		<script>

		</script>
	</body>
	<script>

	</script>
</html>
