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
					<div id="tab2" class="tab">
						<p>create user form</p>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>
