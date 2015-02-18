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
			<div id="fade" class="black_overlay-boxed"></div>
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
						
						<h3 class="h3">Create User</h3>
						
						<div class="create-user">
							<form id="create-user-form" class="form-horizontal">
								<div class="form-group">
									<label class="col-sm-2 control-label" for="firstname">Firstname</label>
									<div class="col-sm-10">
										<input class="form-control" type="text" name="firstname">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label" for="lastname">Lastname</label>
									<div class="col-sm-10">
										<input class="form-control" type="text" name="lastname">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label" for="Country">Country</label>
									<div class="col-sm-10">
										<input class="form-control" type="text" name="Country">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label" for="City">City</label>
									<div class="col-sm-10">
										<input class="form-control" type="text" name="city">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label" for="phone">Phone</label>
									<div class="col-sm-10">
										<input class="form-control" type="text" name="phone">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label" for="email">E-mail</label>
									<div class="col-sm-10">
										<input class="form-control" type="email" name="email">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label" for="password">Password</label>
									<div class="col-sm-10">
										<input class="form-control" type="password" name="password">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label" for="comfirm-password">Comfirm password</label>
									<div class="col-sm-10">
										<input class="form-control" type="password" name="check">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label" for="admin?">Admin?*</label>
									<div class="col-sm-10">
										<input style="width: 1em;"   type="radio" id="admintrue"  name="isadmin" value="true"> <label>Ja</label><br>
										<input style="width: 1em;"  type="radio" id="adminfalse" name="isadmin" value="false"> <label>Nee</label>
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
