<%-- 
    Document   : welcome
    Created on : Feb 17, 2015, 12:23:34 AM
    Author     : lennyasus
--%>
<%@include file="/adminheader.jsp" %>
<!DOCTYPE html>
<html>
	<header>
		<script src="js/ajax.js"></script>
	</header>
	<script>
                // deze javascript functie zorgt ervoor dat de edit button naar update veranderd en dat de velden hun input enabled worden.
                function enableInput() {
                    if (document.getElementById("update").type === "submit") {
                        document.getElementById("update").type = "button";
                        document.getElementById("update").value = "Update";
                        document.getElementById("firstname").disabled = false;
                        document.getElementById("lastname").disabled = false;
                        document.getElementById("city").disabled = false;
                        document.getElementById("country").disabled = false;
                        document.getElementById("phone").disabled = false;
                        document.getElementById("email").disabled = false;
                    } else if (document.getElementById("update").type === "button") {
                        document.getElementById("update").type = "submit";
                    }
                }
                ;

                // deze functie zorgt ervoor dat deze na de update terug disabled worden.
                function disableInput() {
                    document.getElementById("firstname").disabled = true;
                    document.getElementById("lastname").disabled = true;
                    document.getElementById("city").disabled = true;
                    document.getElementById("country").disabled = true;
                    document.getElementById("email").disabled = true;
                    document.getElementById("phone").disabled = true;
                }
                ;

                // ajax functie om userinfo uit de controller getUserInfo te halen. deze word in de <body> tag opgeroepen.
                function loadUserInfo() {

                    $.ajax({
                        url: 'GetUserAccount?user=<%=username%>',
                        type: 'GET',
                        dataType: 'json',
                        cache: false,
                        async: true,
                        complete: function (data) {
                            var user = data.responseJSON;
                            $('#firstname').val(user.firstName);
                            $('#lastname').val(user.lastName);
                            $('#city').val(user.city);
                            $('#country').val(user.country);
                            $('#phone').val(user.phone);
                            $('#email').val(user.email);
                            $('#isadmin').val(user.isAdmin);
                        }
                    }).done(function () {
                        $("#change-password-form")[0].reset();
                    });
                    return false;
                }
	</script>
	<body onload="loadUserInfo()">
		<div class="wrapper">
			<h1 class="field-title">User Information:</h1>
			<div class="bluebox">
				<form role="form" id="update-user-form" class="form-horizontal">
					<input type="hidden" value="<%=username%>" name="username">
					<div class="form-group">
						<label class="col-sm-2 control-label" for="username">Username</label>
						<div class="col-sm-4">
							<input class="form-control" id="username" type="text" value="<%=username%>" disabled >
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label" for="firstname">Firstname</label>
						<div class="col-sm-4">
							<input class="form-control" id="firstname" name="firstname" disabled  >
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label" for="lastname">Lastname</label>
						<div class="col-sm-4">
							<input class="form-control" id="lastname" name="lastname" disabled >
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label" for="city">City</label>
						<div class="col-sm-4">
							<input class="form-control" id="city" name="city" disabled >
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label" for="country">Country</label>
						<div class="col-sm-4">
							<input class="form-control" id="country" name="country" disabled >
						</div>
					</div>
					<div class="form-group" >
						<label class="col-sm-2 control-label"  for="phone">Phone</label>
						<div class="col-sm-4">
							<input class="form-control" id="phone" name="phone" disabled >
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label" for="email">E-mail</label>
						<div class="col-sm-4">
							<input class="form-control" type="email" id="email" name="email" disabled >
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label" for="admin">Admin</label>
						<div class="col-sm-4">
							<input class="form-control" id="isadmin" name="isadmin" disabled >
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label"></label>
						<div class="col-sm-2">
							<input class="btn btn-default" id="update" type="submit" value="Edit" onClick="enableInput()" />
						</div>


					</div>
					<label id="update-message" class="error-message"></label>
				</form>
				<div id="fade" class="black_overlay-boxed"></div>
				<div id="fade2" class="black_overlay-boxed"></div>
				<div class="form-group">
					<label class="col-sm-2 control-label"></label>
					<a href = "javascript:void(0)" onclick = "document.getElementById('delete').style.display = 'block';
                                                    document.getElementById('fade2').style.display = 'block'"><button class="btn btn-default">Delete Account</button></a>
					<div id="delete" class="whiteboxdialog"><a href = "javascript:void(0)" onclick = "document.getElementById('delete').style.display = 'none';
                                                    document.getElementById('fade2').style.display = 'none'"><label class="close-button">x</label></a>
						<div class="content">
							<p>Are you sure you want to delete your account?</p>
							<a href="DeleteUserAccount?username=<%=username%>"><input class="button-blue" type="button" value="Yes" /></a>
							<a href = "javascript:void(0)" onclick = "document.getElementById('delete').style.display = 'none';
                                                                    document.getElementById('fade2').style.display = 'none'"><button class="button-blue">No</button></a>
						</div>
					</div>
					<a href = "javascript:void(0)" onclick = "document.getElementById('changepassword').style.display = 'block';
                                                    document.getElementById('fade').style.display = 'block'"><button class="btn btn-default">Change password</button></a>
					<div id="changepassword" class="whitebox"><a href = "javascript:void(0)" onclick = "document.getElementById('changepassword').style.display = 'none';
                                                    document.getElementById('fade').style.display = 'none'"><label class="close-button">x</label></a>
						<div class="content">
							<form class="form" id="change-password-form">
								<input type="hidden" value="<%=username%>" name="username">
								<div class="form-group">
									<label for="oldpassword">Old password</label><br>
									<input class="text-field" type="password" name="oldpassword" required>
								</div>
								<div class="form-group">
									<label for="newpassword">New password</label><br>
									<input class="text-field" type="password" name="newpassword" required>
								</div>
								<div class="form-group">
									<label for="comfirmnewpassword">Comfirm new password</label><br>
									<input class="text-field" type="password" name="check" required>
								</div>
								<label id="password-message" class="error-message"></label>
								<a href = "javascript:void(0)" onclick = "document.getElementById('changepassword').style.display = 'block';
                                                                            document.getElementById('fade').style.display = 'block'"><input id="wijzig" class="button" type="submit" value="Change" ></a>
								<a href = "javascript:void(0)" onclick = "document.getElementById('changepassword').style.display = 'none';
                                                                            document.getElementById('fade').style.display = 'none'"><input class="button" type="reset" value="Cancel" ></a>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>
