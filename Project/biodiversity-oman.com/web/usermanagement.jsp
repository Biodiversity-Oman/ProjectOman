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
						<table class="table table-striped" id="users-table">
						</table>
					</div>
					<div id="tab2" class="tab" style="background-color: #558EE6;">
						<div class="create-user-box">
							<form id="register" class="form">
								<div class="form-group">
									<label for="voornaam">Voornaam*</label>
									<input class="text-field" id="firstname" type="text" name="firstname" required/>
									<label for="achternaam">Achternaam*</label>
									<input class="text-field" id="lastname" type="text" name="lastname" required/>
								</div>
								<br>
								<div class="form-group">
									<label for="E-mail">E-mail*</label><br>
									<input class="text-field" id="email" type="email" name="email" required/>
								</div>
								<br>
								<div class="form-group">
									<label for="stad">Stad</label><br>
									<input  class="text-field" id="city" type="text" name="city" />
								</div>
								<br>
								<div class="form-group">
									<label for="land">Land</label><br>
									<input class="text-field" id="country" type="text" name="country" />
								</div>
								<br>
								<div class="form-group">
									<label for="adres">Adres</label><br>
									<input class="text-field" id="adress" type="text" name="adress" />
								</div>
								<br>
								<div class="form-group">
									<label for="wachtwoord">Wachtwoord*</label>
									<input class="text-field" id="password" type="password" name="password" required />
									<label for="bevestig">Bevestig wachtwoord*</label>
									<input class="text-field" id="check" type="password" name="check" required />
								</div>
								<br>
								<div class="form-group">
									<label for="gebruikersnaam">Gebruikersnaam*</label><br>
									<input class="text-field" id="username" type="text" name="username" />
								</div>
								<br>
								<div class="form-group">
									<label for="admin?">Admin?*</label><br>
									<input style="margin-left: 3%"  type="radio" id="admintrue"  name="admin" value="true"> <label>Ja</label><br>
									<input style="margin-left: 3%" type="radio" id="adminfalse" name="admin" value="false"> <label>Nee</label>
								</div>
								<br>
								<label id="register-message" class="error-message"></label>
								<div class="form-group">
									<input class="button" type="submit" value="opslaan" />
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>
