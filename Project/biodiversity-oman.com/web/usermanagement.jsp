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
		<script src="js/validator.js"></script>
		<script src="js/loaders.js"></script>
		<script>
		$(document).ready(function(){
		   loadUsers(); 
		});
		</script>
	</head>
	<body>
		<div class="wrapper">
			<div class="tabs">
				<ul class="tab-links">
					<li class="active"><a href="#tab1"><span class="icon-file-text"></span> Users </a></li>
					<li><a href="#tab2"><span class="icon-pencil2"></span>Create User</a></li>
				</ul>
				<div class="tab-content">
					<div id="tab1" class="tab active">
						<p>Press the <span class="icon-cross"></span> button to delete a user (Caution! no confirmation screen)</p>
						<p>Press the <span class="icon-plus"></span> button to promote a user to admin</p>
						<p>Press the <span class="icon-minus"></span> button to demote a user to normal</p>
						<div class="table-responsive">
							<div class="col-sm-4">
								<input class="form-control" id="search-user-account" type="text" name="keyword" placeholder="Search by username, name or email (minimal 3 characters)"><br>
							</div>
							<table class="table table-striped" id="users-table">
							</table>
						</div>
					</div>
					<div id="tab2" class="tab">
						<div class="create-user">
							<h3 class="h3" style="margin-left: 12em; margin-bottom: 1em;">Create User</h3>
							<form role="form" id="create-user-form" class="form-horizontal" data-toggle="validator">
								<div class="form-group">
									<label class="col-sm-2 control-label" for="firstname">Firstname</label>
									<div class="col-sm-4">
										<input class="form-control" type="text" name="firstname" maxlength="50" data-delay="1200" pattern="^([ A-z\s]){1,}$" 	   									<span class="help-block with-errors">Up to 50 characters upper/lower case(no digits)</span>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label" for="lastname">Lastname</label>
									<div class="col-sm-4">
										<input class="form-control" type="text" name="lastname" maxlength="50" data-delay="1200" pattern="^([ A-z\s]){1,}$" required>
										<span class="help-block with-errors">Up to 50 characters upper/lower case(no digits)</span>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label" for="Country">Country</label>
									<div class="col-sm-4">
										<input class="form-control" type="text" name="country" maxlength="50" data-delay="1200" pattern="^([ A-z\s]){1,}$"  required>
										<span class="help-block with-errors">Up to 50 characters upper/lower case(no digits)</span>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label" for="City">City</label>
									<div class="col-sm-4">
										<input class="form-control" type="text" name="city" data-delay="1200" maxlength="50" pattern="^([ A-z\s]){1,}$"  required>
										<span class="help-block with-errors">Up to 50 characters upper/lower case(no digits)</span>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label" for="phone">Phone</label>
									<div class="col-sm-4">
										<input class="form-control" type="tel" data-delay="1200" pattern="^[0-9./()-]+$" name="phone">
										<span class="help-block with-errors">Up to 20 digits between 0-9 and symbols "- / . ()"</span>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label" for="email">E-mail</label>
									<div class="col-sm-4">
										<input class="form-control" type="email" data-delay="1200" name="email" data-error="That email address is invalid" required>
										<span class="help-block with-errors">Valid e-mail address required</span>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label" for="username">Username</label>
									<div class="col-sm-4">
										<input class="form-control" type="text" name="username" data-delay="1200" pattern="^([-_A-z0-9]){1,}$" maxlength="20" data-minlength="5" required>
										<span class="help-block with-errors">Up to 20 characters and symbols "- _"  (min length 5 characters)</span>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label" for="password">Password</label>
									<div class="col-sm-4">
										<input class="form-control" id="inputPassword" data-delay="1200" type="password" name="password" data-minlength="6" maxlength="15" required>
										<span class="help-block">Minimum of 6 characters maximum 15 characters</span>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label" for="comfirm-password">Comfirm password</label>
									<div class="col-sm-4">
										<input class="form-control" type="password" data-delay="1200" data-minlength="6" maxlength="15" data-match="#inputPassword" data-match-error="Passwords dont match" name="check" required>
										<div class="help-block with-errors"></div>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label" for="admin?">Admin?*</label>
									<div class="col-sm-4">
										<input style="width: 1em;"   type="radio" id="admintrue"  name="isadmin" value="true" required> <label>Yes</label><br>
										<input style="width: 1em;"  type="radio" id="adminfalse" name="isadmin" value="false" required> <label>No</label>
									</div>
								</div>
								<div class="form-group"">
									<label class="col-sm-2 control-label"></label>
									<div class="col-sm-4">
										<div id="create-user-message"></div>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label"></label>
									<div class="col-sm-2">
										<button type="submit" class="button-grey">Create user</button>
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
