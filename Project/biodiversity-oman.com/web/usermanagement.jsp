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
                            $.each(users, function(i, user){
				                        $userstable.append('<tr>\n\
						    <td>' + user.userName + '</td>\n\
						    <td>' + user.firstName + '</td>\n\
						    <td>' + user.lastName + '</td>\n\
						    <td>' + user.city + '</td>\n\
						    <td>' + user.country + '</td>\n\
						    <td>' + user.email + '</td>\n\
						    <td>' + user.phone + '</td>\n\
						    <td>' + user.isAdmin + '</td>\n\
						    <td><button class="no-button"  type="submit" onclick="deleteUser()"><span class="icon-cross"></span></button><button class="no-button" type="submit" onclick="setSuperUser()"><span class="icon-plus"></span></button></td>\n\
						   <td><input type="hidden" value="'+user.userName+'" name="username"></td></td>\n\
							</tr>');
			    });
				    
            
                           
                        }
                    }).done(function () {
                        $('#users-table').html('');
                    });
                    return false;
                }
                ;
               

                    function deleteUser(e) {
                        $('#user-table-form').submit(function (e) {

                            $.ajax({
                                url: 'DeleteUserAccount',
                                type: 'POST',
                                dataType: 'text',
                                cache: false,
                                async: false,
                                data: $('#user-table-form').serialize(),
                                complete: function (data) {
                                    $("#user-table-form")[0].reset();
                                },
                                error: function (error) {
                                    console.log(error);
                                }
                            }).done(function () {
                                loadUsers();
                            });
                            e.preventDefault();
                        });
                        return false;

                    };

                    function setSuperUser() {
                        $('#user-table-form').submit(function (e) {

                            $.ajax({
                                url: 'SetSuperUser',
                                type: 'POST',
                                dataType: 'text',
                                cache: false,
                                async: false,
                                data: $('#user-table-form').serialize(),
                                complete: function (data) {
                                    $("#user-table-form")[0].reset();
                                },
                                error: function (error) {
                                    console.log(error);
                                }
                            }).done(function () {
                                loadUsers();
                            });
                            e.preventDefault();
                        });
                        return false;
                    };
                


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
					<div id="tab1" class="tab active">
							<table class="table table-striped" id="users-table">
							</table>
							<div id="delete" class="whiteboxdialog"><a href = "javascript:void(0)" onclick = "document.getElementById('delete').style.display = 'none';
                                                document.getElementById('fade2').style.display = 'none'"><label class="close-button">x</label></a>
					<div class="content">
						<p>Are you sure you want to delete your account?</p>
						<a href="DeleteUserAccount?username=<%=username%>"><input class="button-blue" type="button" value="Yes" /></a>
						<a href = "javascript:void(0)" onclick = "document.getElementById('delete').style.display = 'none';
                                                                document.getElementById('fade2').style.display = 'none'"><button class="button-blue">No</button></a>
					</div>
				</div>
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
