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
	<body onload="loadUsers()">
		<div class="wrapper">
			<div class="tabs">
				<ul class="tab-links">
					<li class="active"><a href="#tab1">List Users </a></li>
					<li><a href="#tab2">Create User</a></li>
				</ul>
				<div class="tab-content">
					<div id="tab1" class="tab active">
						<p>Press the <span class="icon-cross"></span> button to delete a user</p>
						<p>Press the <span class="icon-plus"></span> button to make a user admin</p>
						<div class="table-responsive">
							<table class="table table-striped" id="users-table">
							</table>
						</div>
					</div>
					<div id="tab2" class="tab">
						<div class="create-user">
							<h3 class="h3" style="margin-left: 12em; margin-bottom: 1em;">Create User</h3>
							<form id="create-user-form" class="form-horizontal" data-toggle="validator">
								<div class="form-group">
									<label class="col-sm-2 control-label" for="firstname">Firstname</label>
									<div class="col-sm-10">
										<input class="form-control" type="text" name="firstname" required>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label" for="lastname">Lastname</label>
									<div class="col-sm-10">
										<input class="form-control" type="text" name="lastname" required>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label" for="Country">Country</label>
									<div class="col-sm-10">
										<input class="form-control" type="text" name="country" required>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label" for="City">City</label>
									<div class="col-sm-10">
										<input class="form-control" type="text" name="city" required>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label" for="phone">Phone</label>
									<div class="col-sm-10">
										<input class="form-control" type="tel" name="phone">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label" for="email">E-mail</label>
									<div class="col-sm-10">
										<input class="form-control" type="email" name="email" required>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label" for="username">Username</label>
									<div class="col-sm-10">
										<input class="form-control" type="text" name="username" required>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label" for="password">Password</label>
									<div class="col-sm-10">
										<input class="form-control" type="password" name="password" required>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label" for="comfirm-password">Comfirm password</label>
									<div class="col-sm-10">
										<input class="form-control" type="password" name="check" required>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label" for="admin?">Admin?*</label>
									<div class="col-sm-10">
										<input style="width: 1em;"   type="radio" id="admintrue"  name="isadmin" value="true"> <label>Ja</label><br>
										<input style="width: 1em;"  type="radio" id="adminfalse" name="isadmin" value="false"> <label>Nee</label>
									</div>
								</div>
								<label style="margin-left: 12em;" id="register-message" class="error-message"></label>
								<div class="form-group">
									<div class="col-sm-offset-2 col-sm-10">
										<button type="submit" class="btn btn-default">Create</button>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>
